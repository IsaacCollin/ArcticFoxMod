package net.iswak.winterupdate.entity.client;

import net.iswak.winterupdate.WinterUpdate;
import net.iswak.winterupdate.entity.custom.ArcticFoxEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ArcticFoxModel extends AnimatedGeoModel<ArcticFoxEntity> {

    @Override
    public Identifier getModelResource(ArcticFoxEntity object) {
        return new Identifier(WinterUpdate.MOD_ID, "geo/arctic_fox.geo.json");
    }

    @Override
    public Identifier getTextureResource(ArcticFoxEntity object) {
        return new Identifier(WinterUpdate.MOD_ID, "textures/entity/arctic_fox/arctic_fox_model.png");
    }

    @Override
    public Identifier getAnimationResource(ArcticFoxEntity animatable) {
        return new Identifier(WinterUpdate.MOD_ID, "animations/arctic_fox_model.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(ArcticFoxEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
