package org.lampyt.urai.extension.config;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "uraiextension")
public class URAIExtensionConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public boolean modEnabled = true;

    @ConfigEntry.Category("autoMessage")
    @ConfigEntry.Gui.Tooltip
    public boolean autoMessageEnabled = true;

    @ConfigEntry.Category("autoMessage")
    @ConfigEntry.Gui.Tooltip
    public int autoMessageDelay = 2000;

    @ConfigEntry.Category("autoMessage")
    @ConfigEntry.Gui.Tooltip
    public String serverJoinIntroMessage = "Hey! I'm your AI assistant. Start messages with \"Hey Gemini\" to chat. Rate limit: 1 reply per 3 seconds. Note: I may occasionally provide inaccurate info.";

    @ConfigEntry.Category("llm")
    @ConfigEntry.Gui.Tooltip
    public String selectedProvider = "Gemini";
}