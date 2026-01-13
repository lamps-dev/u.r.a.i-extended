package org.lampyt.urai.extension;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.lampyt.urai.extension.config.URAIExtensionConfig;

public class URAIExtension implements ModInitializer {
    public static URAIExtensionConfig CONFIG;

    @Override
    public void onInitialize() {
        AutoConfig.register(URAIExtensionConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(URAIExtensionConfig.class).getConfig();
    }
}