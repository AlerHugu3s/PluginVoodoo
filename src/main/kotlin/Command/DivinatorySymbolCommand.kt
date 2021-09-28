package org.AlerHughes.Command

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.At
import org.AlerHughes.GetInfoByDivinatorySymbol
import org.AlerHughes.GetRandomDivinatorySymbol
import org.AlerHughes.Model.DivinatorySymbol
import org.AlerHughes.PluginVoodoo


object DivinatorySymbolCommand : SimpleCommand(
    PluginVoodoo, "vdDS","卦象",
    description = "易经卦象"
){
    @Handler
    suspend fun CommandSender.handle() {
        val divinatorySymbol: DivinatorySymbol = GetRandomDivinatorySymbol()
        val info: String = GetInfoByDivinatorySymbol(divinatorySymbol)

        sendMessage(At(user!!) + PlainText("\n" + info))
    }
}