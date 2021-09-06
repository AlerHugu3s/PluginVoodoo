package org.AlerHughes.Command

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.console.command.getGroupOrNull
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.contact.User
import net.mamoe.mirai.message.data.At
import org.AlerHughes.GetInfoByTarot
import org.AlerHughes.GetRandomTarot
import org.AlerHughes.Model.Tarot
import org.AlerHughes.PluginVoodoo


object TarotCommand : SimpleCommand(
    PluginVoodoo, "vdTarot",
    description = "塔罗牌占卜"
){
    @Handler
    suspend fun CommandSender.handle() {
        val tarot: Tarot = GetRandomTarot()
        val info: String = GetInfoByTarot(tarot)

        sendMessage(At(user!!) + PlainText("\n" + info))
        getGroupOrNull()?.sendImage(PluginVoodoo.dataFolder.resolve(tarot.info.imgUrl))
    }
}