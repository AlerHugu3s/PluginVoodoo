package org.AlerHughes.Model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DivinatorySymbol(
    @SerialName("name") val name: String,
    @SerialName("info") val info: DivinatorySymbolInfo,) {
    override fun toString(): String {
        return name + "\n" + info.description + "\n" + info.level
    }
}

@Serializable
data class DivinatorySymbolInfo(
    @SerialName("description") val description: String,
    @SerialName("level") val level: String,
    )


val defaultDivinatorySymbol: DivinatorySymbol = DivinatorySymbol("愚者(The Fool)", DivinatorySymbolInfo("test1","test2"))