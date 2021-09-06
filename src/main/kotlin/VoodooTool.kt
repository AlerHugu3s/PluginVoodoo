package org.AlerHughes

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import org.AlerHughes.Model.TarotModel
import kotlinx.serialization.json.Json

typealias TarotTable = Map<String, TarotModel>
internal val CustomJson = Json {
    prettyPrint = true
    ignoreUnknownKeys = true
    isLenient = true
    allowStructuredMapKeys = true
}
val tarotsCache: MutableMap<Int,TarotTable> =  mutableMapOf()


fun GetRandomTarot(index : Int) : TarotModel
{
    if (!tarotsCache.containsKey(index))
    {
        val l:TarotTable = CustomJson.decodeFromString(PluginVoodoo.dataFolder.resolve("TarotData/Tarots.json").readText())
        tarotsCache[index] = l
    }
    return tarotsCache[index]!!.values.random()
}
