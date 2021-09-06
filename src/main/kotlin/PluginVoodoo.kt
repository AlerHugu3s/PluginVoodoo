package org.AlerHughes

import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info
import org.AlerHughes.Command.EverydayLuckCommand
import org.AlerHughes.Command.TarotCommand


object PluginVoodoo : KotlinPlugin(
    JvmPluginDescription(
        id = "org.AlerHughes.plugin-voodoo",
        name = "PluginVoodoo",
        version = "1.2.0",
    ) {
        author("AlerHughes")
    }
) {
    override fun onEnable() {
        logger.info { "VoodooPlugin loaded" }

        InitTarot()

        CommandManager.registerCommand(EverydayLuckCommand)
        CommandManager.registerCommand(TarotCommand)
    }

    override fun onDisable() {
        logger.info { "VoodooPlugin unloaded" }
        CommandManager.unregisterCommand(EverydayLuckCommand)
    }
}
