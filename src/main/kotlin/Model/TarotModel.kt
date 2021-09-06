package org.AlerHughes.Model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tarot(
    @SerialName("name") val name: String,
    @SerialName("info") val info: Info,) {
    override fun toString(): String {
        return name + "\n" + info.description + "\n" + info.reverseDescription + "\n" + info.imgUrl
    }
}

@Serializable
data class Info(
    @SerialName("description") val description: String,
    @SerialName("reverseDescription") val reverseDescription: String,
    @SerialName("imgUrl") val imgUrl:String
    )


val defaultTarot: Tarot = Tarot("愚者(The Fool)", Info("test1","test2","test3"))