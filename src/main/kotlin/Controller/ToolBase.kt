package org.AlerHughes.Controller
import kotlinx.serialization.json.Json

internal val CustomJson = Json {
    prettyPrint = true
    ignoreUnknownKeys = true
    isLenient = true
    allowStructuredMapKeys = true
}