package net.iswak.winterupdate.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.iswak.winterupdate.entity.ModEntities;
import net.iswak.winterupdate.entity.custom.ArcticFoxEntity;

public class ModRegistries {

    public static void registerModStuffs() {
        registerAttributes();
    }

    private static void registerAttributes() {

        FabricDefaultAttributeRegistry.register(ModEntities.ARCTIC_FOX_ENTITY, ArcticFoxEntity.setAttributes());
    }
}
