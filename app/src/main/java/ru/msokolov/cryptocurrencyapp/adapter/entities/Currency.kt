package ru.msokolov.cryptocurrencyapp.adapter.entities

data class Currency(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val price: Float,
    val marketCap: String,
    val marketCapRank: Int,
    val totalVolume: Float,
    val priceChangePercentage24h: Float,
    val marketCapChangePercentage24h: Float,
    val circulatingSupply: Double,
    val totalSupply: Float,
    val ath: Float,
    val athChangePercentage: Float
)
