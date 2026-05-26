package cat.kiwicat.ihateskins;

import cat.kiwicat.ihateskins.config.IHSConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class IHateSkins implements ModInitializer {
    public static final IHSConfig CONFIG = IHSConfig.createAndLoad();

    public static final String MOD_ID = "ihateskins";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {

    }
}
