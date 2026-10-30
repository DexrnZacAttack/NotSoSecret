package me.dexrn.notsosecret.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.Screen;
import net.minecraft.client.gui.inventory.InventoryScreen;
import net.minecraft.client.player.LocalPlayer;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {
    @Shadow public abstract void setScreen(Screen screen);

    @Shadow public LocalPlayer player;

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lorg/lwjgl/input/Keyboard;getEventKey()I", shift = At.Shift.BEFORE), slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;reloadSound()V")))
    public void notSoSecret$tick(CallbackInfo ci) {
        if (Keyboard.getEventKey() == Keyboard.KEY_E) {//re-add inventory bind
            this.setScreen(new InventoryScreen(this.player));
        }
    }
}
