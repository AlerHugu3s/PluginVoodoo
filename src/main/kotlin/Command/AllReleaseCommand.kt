package org.AlerHughes.Command

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.console.command.getGroupOrNull
import net.mamoe.mirai.contact.NormalMember
import net.mamoe.mirai.contact.User
import net.mamoe.mirai.contact.getMember
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.PlainText
import org.AlerHughes.PluginVoodoo
import kotlin.random.Random

object AllReleaseCommand : SimpleCommand (
    PluginVoodoo, "大赦天下",
    description = "大赦天下"
    ){
        @Handler
        suspend fun CommandSender.handle() {

            if (getGroupOrNull()!![user!!.id]!!.permission.level == 0)
                return

            for (member in getGroupOrNull()?.members!!)
            {
                if (member.isMuted == true)
                    member.unmute()
            }

            sendMessage(PlainText("大赦天下！！！"))
        }
    }