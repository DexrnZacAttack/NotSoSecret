package me.dexrn.notsosecret.mixin;

import net.minecraft.client.gui.inventory.AbstractContainerScreen;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractContainerScreen.class)
public class AbstractContainerScreenMixin {
    @Inject(method = "keyPressed", at = @At("HEAD"))
    public void notSoSecret$keyPressed(char key, int keycode, CallbackInfo ci) {
        if (keycode == Keyboard.KEY_ESCAPE || keycode == Keyboard.KEY_E) {//re-add inventory escape bind
            AbstractContainerScreen self = (AbstractContainerScreen)(Object)this;

            self.minecraft.player.closeContainer();
        }
    }
}
