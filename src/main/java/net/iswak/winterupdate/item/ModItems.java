package net.iswak.winterupdate.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.iswak.winterupdate.WinterUpdate;
import net.iswak.winterupdate.entity.ModEntities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;




public class ModItems {

    public static final Item ARCTIC_FOX_SPAWN_EGG = registerItem(("arctic_fox_spawn_egg"),
            new SpawnEggItem(ModEntities.ARCTIC_FOX_ENTITY, 0xffffff, 0xa8a8a8,
                    new FabricItemSettings().group(ItemGroup.MATERIALS).maxCount(64)));

    
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(WinterUpdate.MOD_ID, name), item);
    }
    public static void registerModItems() {
        WinterUpdate.LOGGER.info("Registering Mod Items for " + WinterUpdate.MOD_ID);
    }
}