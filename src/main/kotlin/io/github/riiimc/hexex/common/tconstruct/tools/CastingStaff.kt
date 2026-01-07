package io.github.riiimc.hexex.common.tconstruct.tools

import at.petrak.hexcasting.common.items.ItemStaff
import at.petrak.hexcasting.common.lib.HexItems
import io.github.riiimc.hexex.HexEX
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import slimeknights.tconstruct.library.tools.definition.ToolDefinition
import slimeknights.tconstruct.library.tools.item.IModifiableDisplay
import slimeknights.tconstruct.library.tools.item.ModifiableItem

class CastingStaff(
    properties: Properties,
    private val toolDefinition: ToolDefinition
) : ItemStaff(properties),IModifiableDisplay {
    private val STAFF_STACK = ItemStack(HexItems.STAFF_OAK)
    override fun getRenderTool(): ItemStack {
        return ItemStack(HexItems.STAFF_OAK)
    }

    override fun getToolDefinition(): ToolDefinition {
        return this.toolDefinition
    }
}