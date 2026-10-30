package me.dexrn.notsosecret.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gamemode.secret.SecretMode;
import net.minecraft.client.gui.Button;
import net.minecraft.client.gui.Screen;
import net.minecraft.client.gui.SelectWorldScreen;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;

@Mixin(SelectWorldScreen.class)
public abstract class SelectWorldScreenMixin {
    @Inject(method = "postInit", at = @At(value = "TAIL"))
    public void notSoSecret$postInit(CallbackInfo ci) {
        SelectWorldScreen self = (SelectWorldScreen)(Object)this;

        self.buttons.add(new Button(7, self.width - 90, self.height / 6 + 168, 80, 20, "Secret Mode"));//add button to join secret level
    }

    @Inject(method = "buttonClicked", at = @At(value = "HEAD"))
	public void loadZone$buttonClicked(Button widget, CallbackInfo ci) {
        SelectWorldScreen self = (SelectWorldScreen)(Object)this;

        if (widget.active) {
			if (widget.id == 7) {
                self.minecraft.gameMode = new SecretMode(self.minecraft);
                Level.deleteLevel(Minecraft.getWorkingDirectory(), "secretLevel");
                Level var5 = new Level(new File(Minecraft.getWorkingDirectory(), "saves"), "secretLevel", 4656295L);
                self.minecraft.setLevel(var5);
                self.minecraft.setScreen(null);
			}
		}
	}
}
