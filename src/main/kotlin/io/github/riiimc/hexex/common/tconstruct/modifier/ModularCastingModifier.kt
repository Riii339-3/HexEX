package io.github.riiimc.hexex.common.tconstruct.modifier

import at.petrak.hexcasting.common.lib.HexAttributes
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.ai.attributes.Attribute
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import slimeknights.tconstruct.library.json.predicate.material.MaterialTierPredicate
import slimeknights.tconstruct.library.modifiers.ModifierEntry
import slimeknights.tconstruct.library.modifiers.hook.behavior.AttributesModifierHook
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier
import slimeknights.tconstruct.library.tools.nbt.IToolStackView
import java.util.UUID
import java.util.function.BiConsumer

class ModularCastingModifier: NoLevelsModifier(), AttributesModifierHook {
    override fun addAttributes(
        tool: IToolStackView?,
        entry: ModifierEntry?,
        slot: EquipmentSlot?,
        consumer: BiConsumer<Attribute?, AttributeModifier?>?
    ) {
        val tier = this.priority // ← 締め具のTier
        val bonus = tier * 0.5
        consumer?.accept(
            HexAttributes.GRID_ZOOM,
            AttributeModifier(
                "hex_staff_grid_zoom",
                bonus,
                AttributeModifier.Operation.ADDITION
            )
        )

    }


}