package org.AlerHughes.Model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TarotModel(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
    @SerialName("reverseDescription") val reverseDescription: String,
    @SerialName("imgUrl") val imgUrl:String = "")
{
    fun GetId() : Int {return id}
    fun GetName(): String {return name}
    fun GetDescription(): String {return description}
    fun GetReverseDescription(): String {return reverseDescription}
    fun GetImgUrl(): String{return imgUrl}
}