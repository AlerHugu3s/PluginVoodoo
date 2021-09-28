package org.AlerHughes

import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info
import org.AlerHughes.Command.*


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
        InitDivinatorySymbol()

        CommandManager.registerCommand(EverydayLuckCommand)
        CommandManager.registerCommand(TarotCommand)
        CommandManager.registerCommand(DivinatorySymbolCommand)
        CommandManager.registerCommand(BanCommand)
        CommandManager.registerCommand(RandomBanCommand)
        CommandManager.registerCommand(AllReleaseCommand)
    }

    override fun onDisable() {
        logger.info { "VoodooPlugin unloaded" }
        CommandManager.unregisterCommand(EverydayLuckCommand)
    }
}
