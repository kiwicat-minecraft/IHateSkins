package cat.kiwicat.ihateskins.client.mixins;

import cat.kiwicat.ihateskins.IHateSkins;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityRenderer.class)
abstract class PlayerRenderMixin {
    private static AbstractClientPlayerEntity player;



    @Inject(method = "getTexture(Lnet/minecraft/client/network/AbstractClientPlayerEntity;)Lnet/minecraft/util/Identifier;", at = @At(value = "HEAD"), cancellable = true)
    private void changePlayerTexture(AbstractClientPlayerEntity abstractClientPlayerEntity, CallbackInfoReturnable<Identifier> cir) {
        if(true) {
            cir.setReturnValue(MinecraftClient.getInstance().player.getSkinTextures().texture());
        }
    }

    @ModifyVariable(
            method = "<init>",
            at = @At("HEAD"),
            ordinal = 0,
            argsOnly = true
    )
    private static boolean forceSlim(boolean slim) {

        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player != null) {
            return client.player.getSkinTextures().model() == SkinTextures.Model.SLIM;
        }

        return slim;
    }
}
