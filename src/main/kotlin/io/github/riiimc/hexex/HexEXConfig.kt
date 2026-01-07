package io.github.riiimc.hexex

import io.github.riiimc.hexex.common.modules.ModuleProvider
import moffy.addonapi.AddonModule
import moffy.addonapi.AddonModuleRegistry
import net.minecraftforge.common.ForgeConfigSpec
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.config.ModConfig.Type

object HexExConfig {
    val COMMON: ForgeConfigSpec.Builder = ForgeConfigSpec.Builder()
    val CLIENT: ForgeConfigSpec.Builder = ForgeConfigSpec.Builder()
    val MORE_CONFIG: ForgeConfigSpec.Builder = ForgeConfigSpec.Builder()

    fun registerConfig() {
        AddonModuleRegistry.INSTANCE.LoadModule(ModuleProvider(), COMMON)

        ModLoadingContext.get().registerConfig(Type.COMMON, COMMON.build())
    }

}