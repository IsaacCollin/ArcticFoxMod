package net.iswak.winterupdate;

import net.fabricmc.api.ModInitializer;
import net.iswak.winterupdate.item.ModItems;
import net.iswak.winterupdate.util.ModRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

public class WinterUpdate implements ModInitializer {
	public static final String MOD_ID = "winterupdate";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.registerModItems();

		ModRegistries.registerModStuffs();
		GeckoLib.initialize();

	}
}
