package me.dexrn.notsosecret.mixin;

import net.minecraft.client.title.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @Inject(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gamemode/secret/SecretMode;<init>(Lnet/minecraft/client/Minecraft;)V", shift = At.Shift.BEFORE), cancellable = true)
    public void notSoSecret$init(CallbackInfo ci) {
        ci.cancel();//dont load into secretmode by default
    }
}
