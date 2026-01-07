package io.github.riiimc.hexex.common.modules.hexex

import at.petrak.hexcasting.api.casting.ActionRegistryEntry
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern
import at.petrak.hexcasting.common.casting.actions.spells.OpBlink
import at.petrak.hexcasting.common.lib.hex.HexActions.make
import io.github.riiimc.hexex.HexEX
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject


class HexEXRegistries {
    companion object {
        val ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, HexEX.MODID)
        lateinit var ENDINGLIB_TEST_ITEM: RegistryObject<Item>
        lateinit var HEXEX_TEST_ITEM: RegistryObject<Item>
        lateinit var SPELL_TIME_STOP: ActionRegistryEntry
        lateinit var CASTING_SFAFF: RegistryObject<Item>
    }
}