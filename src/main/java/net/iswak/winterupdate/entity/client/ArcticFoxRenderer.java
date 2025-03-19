package net.iswak.winterupdate.entity.client;

import net.iswak.winterupdate.entity.custom.ArcticFoxEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ArcticFoxRenderer extends GeoEntityRenderer<ArcticFoxEntity> {
    public ArcticFoxRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new ArcticFoxModel());
    }

}