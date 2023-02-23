package org.AlerHughes

import kotlinx.serialization.decodeFromString
import org.AlerHughes.Controller.CustomJson
import org.AlerHughes.Model.Tarot
import java.time.LocalDate

typealias tarotTable = Map<Int, Tarot>
typealias usedImgTarotList = MutableMap<String,Boolean>

var tarotsCache: tarotTable =  mapOf()
var usedImgTarotCache: usedImgTarotList = mutableMapOf()

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
    val des :String = if (randomNum == 0)
        "\n#逆位\n#" + tarot.info.reverseDescription
    else
        "\n#正位\n#" + tarot.info.description
    return """
        #${tarot.name} $des
        """.trimMargin("#")
}

fun JudgeSendTarotImg(tarot: Tarot) : Boolean
{
    val localDate = LocalDate.now()
    val id = tarot.name + localDate.year + localDate.monthValue + localDate.dayOfMonth
    if (!usedImgTarotCache.containsKey(id) || usedImgTarotCache[id] == false)
    {
        usedImgTarotCache[id] = true
        return true
    }
    else if(usedImgTarotCache[id] == true)
    {
        return false
    }
    return false
}
