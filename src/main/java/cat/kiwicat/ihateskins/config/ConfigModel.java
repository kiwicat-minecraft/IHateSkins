package cat.kiwicat.ihateskins.config;

import cat.kiwicat.ihateskins.IHateSkins;
import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.SectionHeader;

import java.util.ArrayList;

@Modmenu(modId = IHateSkins.MOD_ID)
@Config(name = "i-hate-skins-config", wrapperName = "IHSConfig")
public class ConfigModel {
    public boolean activate = true;

    @SectionHeader("Whitelist")
    public boolean useWhitelist = false;
    public String Whitelist = "";

    @SectionHeader("Blacklist")
    public boolean useBlacklist = false;
    public String Blacklist = "";


}
