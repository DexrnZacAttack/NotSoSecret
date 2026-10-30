package me.dexrn.notsosecret;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class NotSoSecret implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("NotSoSecret");
	public static final String VERSION = "1.0.0";
	@Override
	public void onInitialize() {
		LOGGER.info("Not so secret now is it...?");
	}
}
