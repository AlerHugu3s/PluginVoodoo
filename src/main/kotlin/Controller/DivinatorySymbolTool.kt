package org.AlerHughes

import kotlinx.serialization.decodeFromString
import org.AlerHughes.Controller.CustomJson
import org.AlerHughes.Model.DivinatorySymbol

typealias divinatorySymbolTable = Map<Int, DivinatorySymbol>

var divinatorySymbolsCache: divinatorySymbolTable =  mapOf()

fun InitDivinatorySymbol()
{
    divinatorySymbolsCache = CustomJson.decodeFromString(PluginVoodoo.dataFolder.resolve("DivinatorySymbolData/DivinatorySymbols.json").readText())
}

fun GetRandomDivinatorySymbol() : DivinatorySymbol
{
    return divinatorySymbolsCache.values.random()
}

// 获取塔罗牌正逆位文本
fun GetInfoByDivinatorySymbol(divinatorySymbol: DivinatorySymbol): String
{
    return """
        #${divinatorySymbol.name}  ${divinatorySymbol.info.level}
        #${divinatorySymbol.info.description}
        """.trimMargin("#")
}
