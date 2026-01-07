package io.github.riiimc.hexex.common.modules.hexex

import com.google.common.base.Supplier
import io.github.riiimc.hexex.HexEX
import moffy.addonapi.AddonModule
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

class MainModule: AddonModule(){
    init {
        HexEXRegistries.HEXEX_TEST_ITEM = HexEXRegistries.ITEM.register("main_module_loaded", Supplier {
            Item(Item.Properties())
        })
    }
}