package dev.scarcekoi.hotbarsidescroll.mixin;

import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public class MouseMixin {
	@Inject(method = "onMouseScroll", at = @At("HEAD"))
	private void onMouseScroll(long window, double xOffset, double yOffset, CallbackInfo ci) {
	}
}