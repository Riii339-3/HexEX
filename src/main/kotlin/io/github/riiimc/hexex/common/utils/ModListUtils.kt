package io.github.riiimc.hexex.common.utils

import net.minecraftforge.fml.ModList


object ModListUtil {
    //from Sakura Tinker
    var TinkerLoaded: Boolean = ModList.get().isLoaded(modName.Tinker)

    object modName {
        var Tinker: String = "tconstruct"
    }
}