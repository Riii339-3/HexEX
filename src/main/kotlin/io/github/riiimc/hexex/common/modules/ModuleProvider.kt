package io.github.riiimc.hexex.common.modules

import io.github.riiimc.hexex.HexEX
import io.github.riiimc.hexex.common.modules.endinglib.EndingLibModule
import io.github.riiimc.hexex.common.modules.hexex.MainModule
import io.github.riiimc.hexex.common.modules.psi.PsiModule
import io.github.riiimc.hexex.common.modules.tconstruct.TConstructModule
import moffy.addonapi.AddonModule
import moffy.addonapi.AddonModuleProvider
import net.minecraft.resources.ResourceLocation
import org.apache.commons.codec.binary.Hex

class ModuleProvider: AddonModuleProvider() {
    override fun registerRawModules() {
        addRawModule(
            ResourceLocation(HexEX.MODID, "hexex_module"),
            "Default Module",
            MainModule::class.java,
            arrayOf("hexcasting"),
            true
        )
        addRawModule(
            ResourceLocation(HexEX.MODID, "endinglibrary_module"),
            "EndingLibrary Module",
            EndingLibModule::class.java,
            arrayOf("hexcasting", "ending_library"),
            true
        )
        addRawModule(
            ResourceLocation(HexEX.MODID, "tconstruct_module"),
            "Tinkers Construct Module",
            TConstructModule::class.java,
            arrayOf("hexcasting","tconstruct"),
            true
        )
        addRawModule(
            ResourceLocation(HexEX.MODID, "psi_module"),
            "Psi Module",
            PsiModule::class.java,
            arrayOf("psi", "hexcasting"),
            true
        )
    }

    override fun getModId(): String {
        return HexEX.MODID
    }
}