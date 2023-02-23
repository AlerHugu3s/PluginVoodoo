package org.AlerHughes

import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.EventPriority
import net.mamoe.mirai.event.subscribeGroupMessages
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.utils.info
import org.AlerHughes.Command.*
import org.AlerHughes.Model.Tarot
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.utils.ExternalResource.Companion.uploadAsImage
import org.AlerHughes.Model.DivinatorySymbol
import java.time.LocalDate
import kotlin.math.abs
import kotlin.random.Random


object PluginVoodoo : KotlinPlugin(
    JvmPluginDescription(
        id = "org.AlerHughes.plugin-voodoo",
        name = "PluginVoodoo",
        version = "1.6.1",
    ) {
        author("AlerHughes")
    }
) {
    override fun onEnable() {
        logger.info { "VoodooPlugin loaded" }

        InitTarot()
        InitDivinatorySymbol()

        CommandManager.registerCommand(EverydayLuckCommand)
        CommandManager.registerCommand(TarotCommand)
        CommandManager.registerCommand(DivinatorySymbolCommand)
        CommandManager.registerCommand(BanCommand)
        CommandManager.registerCommand(RandomBanCommand)
        CommandManager.registerCommand(AllReleaseCommand)

        pluginVoodooEventChannel.subscribeGroupMessages (priority = EventPriority.NORMAL)
        {
            "塔罗牌" {
                val tarot: Tarot = GetRandomTarot()
                val info: String = GetInfoByTarot(tarot)
                val imgFile = resolveDataFile(tarot.info.imgUrl).uploadAsImage(subject)
                if (JudgeSendTarotImg(tarot))
                    subject.sendMessage(At(sender) + PlainText("\n" + info) + imgFile)
                else
                    subject.sendMessage(At(sender) + PlainText("\n" + info))
            }

            "求签" {
                val divinatorySymbol: DivinatorySymbol = GetRandomDivinatorySymbol()
                val info: String = GetInfoByDivinatorySymbol(divinatorySymbol)
                subject.sendMessage(At(sender) + PlainText("\n" + info))
            }

            "今日运势" {
                val localDate = LocalDate.now()
                val luck = abs(Random(sender.id + localDate.year + localDate.monthValue + localDate.dayOfMonth).nextInt()) % 100
                subject.sendMessage(At(sender) + PlainText("的今日运势为:$luck"))
            }
        }
    }

    override fun onDisable() {
        logger.info { "VoodooPlugin unloaded" }
        CommandManager.unregisterCommand(EverydayLuckCommand)
    }
}
