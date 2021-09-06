package org.AlerHughes

import io.ktor.client.features.*
import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.console.data.AutoSavePluginData
import net.mamoe.mirai.console.data.value
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.utils.info
import org.AlerHughes.Model.TarotModel
import java.time.LocalDate
import kotlin.random.Random

object PluginVoodoo : KotlinPlugin(
    JvmPluginDescription(
        id = "org.AlerHughes.plugin-voodoo",
        name = "PluginVoodoo",
        version = "1.1.0",
    ) {
        author("AlerHughes")
    }
) {
    override fun onEnable() {
        logger.info { "VoodooPlugin loaded" }

        val list: ArrayList<TarotModel> = ArrayList<TarotModel>()
        list.add(TarotModel(0,"愚者(The Fool)","1","2"))
        list.add(TarotModel(1,"魔术师(The Magician)","1","2"))
        list.add(TarotModel(2,"女祭司(The High Priestess)","1","2"))
        list.add(TarotModel(3,"皇后(The Empress)","1","2"))
        list.add(TarotModel(4,"皇帝(The Emperor)","1","2"))
        list.add(TarotModel(5,"教皇(The Hierophant，or the Pope)","1","2"))
        list.add(TarotModel(6,"恋人(The Lovers)","1","2"))
        list.add(TarotModel(7,"战车(The Chariot)","1","2"))
        list.add(TarotModel(8,"力量(Strength)","1","2"))
        list.add(TarotModel(9,"隐士(The Hermit)","1","2"))
        list.add(TarotModel(10,"命运之轮(The Wheel of Fate)","1","2"))
        list.add(TarotModel(11,"正义(Justice)","1","2"))
        list.add(TarotModel(12,"倒吊人(The Hanged Man)","1","2"))
        list.add(TarotModel(13,"死亡(Death)","1","2"))
        list.add(TarotModel(14,"节欲(Temperance)","1","2"))
        list.add(TarotModel(15,"恶鬼(The Devil)","1","2"))
        list.add(TarotModel(16,"塔(The Tower)","1","2"))
        list.add(TarotModel(17,"星辰(The Star)","1","2"))
        list.add(TarotModel(18,"月亮(The Moon)","1","2"))
        list.add(TarotModel(19,"太阳(The Sun)","1","2"))
        list.add(TarotModel(20,"审判(Judgement)","1","2"))
        list.add(TarotModel(21,"世界(The World)","1","2"))

        TarotData.tarotList = list

        dataFolder.resolve("TarotData/Tarots.json")

        CommandManager.registerCommand(everydayLuckCommand)
    }

    override fun onDisable() {
        logger.info { "VoodooPlugin unloaded" }
        CommandManager.unregisterCommand(everydayLuckCommand)
    }
}

object everydayLuckCommand : SimpleCommand(
    PluginVoodoo, "vdLuck",
    description = "今日运势"
){
    @Handler
    suspend fun CommandSender.handle() {
        val localDate = LocalDate.now()
        var luck = Math.abs(Random(user!!.id + localDate.year + localDate.monthValue + localDate.dayOfMonth).nextInt()) % 100
        sendMessage(At(user!!) + PlainText("的今日运势为:" + luck))
    }
}

object TarotData : AutoSavePluginData("TarotData")
{
    var tarotList: ArrayList<TarotModel> by value()
}

