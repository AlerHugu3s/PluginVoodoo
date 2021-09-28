package org.AlerHughes.Command

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.console.command.getGroupOrNull
import net.mamoe.mirai.contact.getMember
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.PlainText
import org.AlerHughes.PluginVoodoo
import kotlin.random.Random

object BanCommand : SimpleCommand (
    PluginVoodoo, "SB",
    description = "自虐禁言"
    ){
        @Handler
        suspend fun CommandSender.handle() {
            val seed = Random.nextInt(1, 5)
            var time: Int = 60
            var text: String = ""
            if (seed == 1) {
                time = 60
                text = "60秒！ 太可惜了"
            } else if (seed == 2) {
                time = 600
                text = "十分钟！ 啧啧啧"
            } else if (seed == 3) {
                time = 3600
                text = "一小时！ 嘻嘻"
            }
            else if(seed == 4){
                time = 86400
                text = "天呐 一整天！ 你可真倒霉"
            }

            else if(seed == 5) {
                time = 2592000
                text = "下个月见"
            }

            sendMessage(At(user!!) + PlainText(text))
            user?.id?.let { getGroupOrNull()?.getMember(it)?.mute(time) }
        }
    }