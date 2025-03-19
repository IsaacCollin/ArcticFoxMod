package net.iswak.winterupdate.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.iswak.winterupdate.WinterUpdate;
import net.iswak.winterupdate.entity.custom.ArcticFoxEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<ArcticFoxEntity> ARCTIC_FOX_ENTITY = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(WinterUpdate.MOD_ID, "arctic_fox_entity"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ArcticFoxEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.5f)).build());
}
