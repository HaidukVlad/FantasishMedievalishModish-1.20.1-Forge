package com.example.examplemod.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.Random;
import java.util.UUID;

public class PalacheItem extends SwordItem {
    private float hitCombo = 0;

    public PalacheItem() {
        super(Tiers.IRON, 3, -2.4F, new Item.Properties());
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Сплэш-урон по ближайшим врагам
        if (!attacker.level().isClientSide && attacker instanceof Player player) {
            double splashRadius = 2.0; // Радиус действия

            for (LivingEntity nearby : attacker.level().getEntitiesOfClass(LivingEntity.class,
                    attacker.getBoundingBox().inflate(splashRadius))) {
                if (nearby != target && nearby != attacker) {
                    nearby.hurt(attacker.damageSources().playerAttack(player), 2.0f); // Сплэш урон
                }
            }

            // 20% шанс наложить эффект замедления
            if (new Random().nextFloat() < 0.2f) {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1)); // 3 секунды
            }

            // Увеличивающийся урон при сериях попаданий
            hitCombo += 0.5F;
            target.hurt(attacker.damageSources().playerAttack(player), hitCombo); // дополнительный урон
        }

        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, net.minecraft.world.entity.Entity entity, int slot, boolean selected) {
        if (!selected) hitCombo = 0; // если меч не в руке — сброс серии
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        // Сброс комбо при промахе
        if (entity instanceof Player player && !(player.getAttackStrengthScale(0.5f) > 0.9f)) {
            hitCombo = 0;
        }
        return super.onEntitySwing(stack, entity);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        Multimap<Attribute, AttributeModifier> modifiers = super.getDefaultAttributeModifiers(slot);
        if (slot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.putAll(modifiers);

            // Снижение скорости атаки
            builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Attack speed modifier", -3.0, AttributeModifier.Operation.ADDITION));

            // Снижение скорости передвижения
            builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(UUID.fromString("e8d8cc74-2c9e-4c01-86dd-111111111111"), "Pallasch move slow", -0.2, AttributeModifier.Operation.MULTIPLY_TOTAL));

            return builder.build();
        }
        return modifiers;
    }

}
