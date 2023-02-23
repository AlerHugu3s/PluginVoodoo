package org.AlerHughes.Command

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.utils.ExternalResource.Companion.uploadAsImage
import org.AlerHughes.GetInfoByTarot
import org.AlerHughes.GetRandomTarot
import org.AlerHughes.JudgeSendTarotImg
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
        val imgFile = PluginVoodoo.resolveDataFile(tarot.info.imgUrl).uploadAsImage(user!!)

        if (JudgeSendTarotImg(tarot))
            sendMessage(At(user!!) + PlainText("\n" + info) + imgFile)
        else
            sendMessage(At(user!!) + PlainText("\n" + info))

    }
}