package org.lampyt.urai.extension.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.client.MinecraftClient;
import org.lampyt.urai.extension.URAIExtension;
import org.lampyt.urai.extension.config.URAIExtensionConfig;


public class URAIExtensionClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            URAIExtensionConfig config = URAIExtension.CONFIG;
            System.out.println("Joined server!");
            if (!config.autoMessageEnabled) return;
            new Thread(() -> {
                try {
                    Thread.sleep(config.autoMessageDelay);
                    MinecraftClient client = MinecraftClient.getInstance();
                    // Execute on main thread to avoid network protocol errors
                    client.execute(() -> {
                        if (client.player != null && client.player.networkHandler != null) {
                            client.player.networkHandler.sendChatMessage(config.serverJoinIntroMessage);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        });
    }
}
