package net.iswak.winterupdate.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Arrays;


public class ArcticFoxEntity extends AnimalEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    public ArcticFoxEntity(EntityType<? extends AnimalEntity> entityType, World worldIn) {
        super(entityType, worldIn);
        this.ignoreCameraFrustum = true;
    }

    @Override
    public PassiveEntity createChild(ServerWorld var1, PassiveEntity var2) {
        return null;
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.8f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D);
    }

    protected void initGoals() {

        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(0, new PowderSnowJumpGoal(this, this.world));

        this.goalSelector.add(1, new EscapeDangerGoal(this, 0.6));

        this.goalSelector.add(2, new WanderAroundPointOfInterestGoal(this, 0.75f, false));

        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(3, new LookAroundGoal(this));

        for (FleeEntityGoal fleeEntityGoal : Arrays.asList(
                new FleeEntityGoal(this, PlayerEntity.class, 16.0f, 1.8, 1.6),
                new FleeEntityGoal(this, WolfEntity.class, 8.0f, 1.8, 1.6),
                new FleeEntityGoal(this, PolarBearEntity.class, 8.0f, 1.8, 1.6))) {
            this.goalSelector.add(4, fleeEntityGoal);
        }
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (limbDistance < -0.5F || limbDistance > 0.5F) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.arcticfox.run", true));
        } else if (limbDistance < -0.1F || limbDistance > 0.1F) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.arcticfox.walk", true));
        } else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.arcticfox.idle", true));
        }
        return PlayState.CONTINUE;
    }

    @Override
        public void registerControllers(AnimationData data) {
            data.addAnimationController(new AnimationController<ArcticFoxEntity>(this,
                    "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_FOX_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_FOX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_FOX_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15f, 1.0f);
    }


}
