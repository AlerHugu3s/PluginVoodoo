package org.AlerHughes

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.AlerHughes.Model.Tarot

typealias tarotTable = Map<Int, Tarot>
internal val CustomJson = Json {
    prettyPrint = true
    ignoreUnknownKeys = true
    isLenient = true
    allowStructuredMapKeys = true
}
var tarotsCache: tarotTable =  mapOf()

fun InitTarot()
{
    tarotsCache = CustomJson.decodeFromString(PluginVoodoo.dataFolder.resolve("TarotData/Tarots.json").readText())
}

fun GetRandomTarot() : Tarot
{
    return tarotsCache.values.random()
}

// 获取塔罗牌正逆位文本
fun GetInfoByTarot(tarot: Tarot): String
{
    val randomNum = (0..1).random()
    val des :String
    if (randomNum == 0)
    {
        des = "\n#逆位\n#" + tarot.info.reverseDescription
    }
    else
    {
        des = "\n#正位\n#" + tarot.info.description
    }
    return """
        #${tarot.name} $des
        """.trimMargin("#")
}
