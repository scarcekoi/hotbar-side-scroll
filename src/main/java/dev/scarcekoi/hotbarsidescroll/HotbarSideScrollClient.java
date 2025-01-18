package dev.scarcekoi.hotbarsidescroll;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class HotbarSideScrollClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyBinding hotbarScrollLeft = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.fabric-key-binding-api-v1-hotbarsidedscroll.hotbar_scroll_left", InputUtil.Type.KEYSYM, GLFW.GLFW_MOUSE_BUTTON_5, "key.categories.misc"));
        KeyBinding hotbarScrollRight = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.fabric-key-binding-api-v1-hotbarsidedscroll.hotbar_scroll_right", InputUtil.Type.KEYSYM, GLFW.GLFW_MOUSE_BUTTON_6, "key.categories.misc"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (hotbarScrollLeft.wasPressed()) {
                MinecraftClient.getInstance().player.getInventory().scrollInHotbar(-1);
            }
            if (hotbarScrollRight.wasPressed()) {
                MinecraftClient.getInstance().player.getInventory().scrollInHotbar(1);
            }
        });
    }
}
