package cat.kiwicat.ihateskins.client.mixins;

import cat.kiwicat.ihateskins.IHateSkins;
import cat.kiwicat.ihateskins.config.IHSConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.List;

@Mixin(AbstractClientPlayerEntity.class)
public class PlayerRenderMixin {

    @Inject(method = "getSkinTextures", at = @At("HEAD"), cancellable = true)
    private void replaceSkin(CallbackInfoReturnable<SkinTextures> cir) {
        List<String> Whitelist = Arrays.asList(IHateSkins.CONFIG.Whitelist().split(",", -1));
        List<String> Blacklist = Arrays.asList(IHateSkins.CONFIG.Blacklist().split(",", -1));

        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player == null) return;

        AbstractClientPlayerEntity self = (AbstractClientPlayerEntity)(Object)this;

        if (self == client.player) return;
        if(!IHateSkins.CONFIG.activate()) return;

        if(IHateSkins.CONFIG.useWhitelist()){
            if(Whitelist.contains(self.getName().getString())){
                cir.setReturnValue(client.player.getSkinTextures());
            }else return;
        }
        else if(IHateSkins.CONFIG.useBlacklist()){
            if(Blacklist.contains(self.getName().getString())){
                return;
            }else cir.setReturnValue(client.player.getSkinTextures());
        }else{
            cir.setReturnValue(client.player.getSkinTextures());
        }


    }
}

