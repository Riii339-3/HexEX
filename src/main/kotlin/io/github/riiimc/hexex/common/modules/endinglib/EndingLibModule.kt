package io.github.riiimc.hexex.common.modules.endinglib

import at.petrak.hexcasting.api.casting.ActionRegistryEntry
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern
import at.petrak.hexcasting.common.casting.actions.spells.OpBlink
import at.petrak.hexcasting.common.lib.hex.HexActions.make
import com.google.common.base.Supplier
import io.github.riiimc.hexex.HexEX
import io.github.riiimc.hexex.common.iotas.actions.TimeStop
import io.github.riiimc.hexex.common.modules.hexex.HexEXRegistries
import moffy.addonapi.AddonModule
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

class EndingLibModule: AddonModule() {
    init {
        HexEXRegistries.ENDINGLIB_TEST_ITEM = HexEXRegistries.ITEM.register("endinglib_module_loaded", Supplier {
            Item(Item.Properties())
        })
        HexEXRegistries.SPELL_TIME_STOP = make(
            "time_stop",
            ActionRegistryEntry(HexPattern.fromAngles("wwwqwwwqwwwqwwwqwwwqwwwawwwewww", HexDir.SOUTH_WEST), TimeStop())
        )

    }
}