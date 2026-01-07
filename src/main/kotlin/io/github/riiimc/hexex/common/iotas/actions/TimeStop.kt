package io.github.riiimc.hexex.common.iotas.actions

import at.petrak.hexcasting.api.casting.ParticleSpray
import at.petrak.hexcasting.api.casting.RenderedSpell
import at.petrak.hexcasting.api.casting.castables.SpellAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.getDouble
import at.petrak.hexcasting.api.casting.getEntity
import at.petrak.hexcasting.api.casting.getInt
import at.petrak.hexcasting.api.casting.getIntBetween
import at.petrak.hexcasting.api.casting.getLivingEntityButNotArmorStand
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.mishaps.MishapImmuneEntity
import at.petrak.hexcasting.api.misc.MediaConstants
import at.petrak.hexcasting.api.mod.HexConfig
import at.petrak.hexcasting.api.mod.HexTags
import at.petrak.hexcasting.common.casting.actions.spells.great.OpTeleport
import com.mega.endinglib.api.time.TimeStopAPI
import com.mega.endinglib.util.time.TimeStopUtils
import com.samsthenerd.inline.tooltips.CustomTooltipManager
import io.github.riiimc.hexex.common.utils.exception.TimeStopException
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.LivingEntity
import kotlin.math.absoluteValue
import kotlin.math.roundToLong

class TimeStop: SpellAction {
    override val argc: Int
        get() = 2

    override fun execute(
        args: List<Iota>,
        env: CastingEnvironment
    ): SpellAction.Result {
        val target = args.getLivingEntityButNotArmorStand(0, argc)
        val time = args.getIntBetween(1, 1,Int.MAX_VALUE, argc)
        env.assertEntityInRange(target)

        val targetMiddlePos = target.position().add(0.0, target.eyeHeight / 2.0, 0.0)

        if (TimeStopUtils.isTimeStop) {
            throw TimeStopException("Time has been stopped.")
        }

        if (time < 1) {
            throw NumberFormatException("Time must be a positive value: $time.")
        }

        return SpellAction.Result(
            Spell(target, time),
            (MediaConstants.SHARD_UNIT * time.absoluteValue * 0.5).roundToLong(),
            listOf(
                ParticleSpray.cloud(targetMiddlePos, 2.0, 50),
            )
        )
    }

    private data class Spell(val target: LivingEntity, val time: Int) : RenderedSpell {
        override fun cast(env: CastingEnvironment) {
            if (!HexConfig.server().canTeleportInThisDimension(env.world.dimension()))
                return

            TimeStopAPI.use(true,target,true, time * 20)
        }
    }
}