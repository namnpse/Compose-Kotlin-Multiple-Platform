package network

import kotlinx.serialization.Serializable

@Serializable
data class CensoredWord(
    val result: String
)