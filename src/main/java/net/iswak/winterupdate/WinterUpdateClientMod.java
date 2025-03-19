package net.iswak.winterupdate;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.iswak.winterupdate.entity.ModEntities;
import net.iswak.winterupdate.entity.client.ArcticFoxRenderer;

public class WinterUpdateClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.ARCTIC_FOX_ENTITY, ArcticFoxRenderer::new);

    }
}

