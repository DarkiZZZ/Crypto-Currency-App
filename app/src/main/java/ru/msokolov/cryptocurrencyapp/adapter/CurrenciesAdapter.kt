package ru.msokolov.cryptocurrencyapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import ru.msokolov.cryptocurrencyapp.R
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import ru.msokolov.cryptocurrencyapp.activities.ChartActivity
import ru.msokolov.cryptocurrencyapp.activities.ChartActivity.Companion.CRYPTO_ATH
import ru.msokolov.cryptocurrencyapp.activities.ChartActivity.Companion.CRYPTO_ATH_CHANGE_PERC
import ru.msokolov.cryptocurrencyapp.activities.ChartActivity.Companion.CRYPTO_CIRCULATING_SUPPLY
import ru.msokolov.cryptocurrencyapp.activities.ChartActivity.Companion.CRYPTO_ID
import ru.msokolov.cryptocurrencyapp.activities.ChartActivity.Companion.CRYPTO_IMAGE
import ru.msokolov.cryptocurrencyapp.activities.ChartActivity.Companion.CRYPTO_MARKET_CAP
import ru.msokolov.cryptocurrencyapp.activities.ChartActivity.Companion.CRYPTO_MARKET_CAP_CHANGE_PERC_24_H
import ru.msokolov.cryptocurrencyapp.activities.ChartActivity.Companion.CRYPTO_MARKET_CAP_RANK
import ru.msokolov.cryptocurrencyapp.activities.ChartActivity.Companion.CRYPTO_NAME
import ru.msokolov.cryptocurrencyapp.activities.ChartActivity.Companion.CRYPTO_PRICE_CHANGE_PERC_24_H
import ru.msokolov.cryptocurrencyapp.activities.ChartActivity.Companion.CRYPTO_SYMBOL
import ru.msokolov.cryptocurrencyapp.activities.ChartActivity.Companion.CRYPTO_TOTAL_SUPPLY
import ru.msokolov.cryptocurrencyapp.activities.ChartActivity.Companion.CRYPTO_TOTAL_VOLUME
import ru.msokolov.cryptocurrencyapp.adapter.entities.Currency

class CurrenciesAdapter : BaseAdapter<CurrenciesAdapter.CurrencyViewHolder>() {


    //создает ViewHolder и инициализирует views для списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return CurrencyViewHolder(v)

    }

    //реализация вьюхолдера
    class CurrencyViewHolder(view: View) : BaseAdapter.BaseViewHolder(view) {

        var id: String = ""
        var symbol: String = ""
        var name: String = ""
        var image: String = ""
        var marketCap: String = ""
        var marketCapRank: Int = 0
        var marketCapChangePercentage24h: Float = 0.0f
        var priceChangePercentage24h: Float = 0.0f
        var totalVolume: Float = 0.0f
        var ath: Float = 0.0f
        var athChangePercentage: Float = 0.0f
        var circulatingSupply: Double = 0.0
        var totalSupply: Float = 0.0f

        init {
            //слушатель клика по элементам списка
            itemView.setOnClickListener {
                var intent = Intent(itemView.context, ChartActivity::class.java)
                intent.putExtra(CRYPTO_ID, id)
                    .putExtra(CRYPTO_NAME, name)
                    .putExtra(CRYPTO_SYMBOL, symbol)
                    .putExtra(CRYPTO_IMAGE, image)
                    .putExtra(CRYPTO_MARKET_CAP_RANK, marketCapRank)
                    .putExtra(CRYPTO_MARKET_CAP, marketCap)
                    .putExtra(CRYPTO_MARKET_CAP_CHANGE_PERC_24_H, marketCapChangePercentage24h)
                    .putExtra(CRYPTO_PRICE_CHANGE_PERC_24_H, priceChangePercentage24h)
                    .putExtra(CRYPTO_TOTAL_VOLUME, totalVolume)
                    .putExtra(CRYPTO_ATH, ath)
                    .putExtra(CRYPTO_ATH_CHANGE_PERC, athChangePercentage)
                    .putExtra(CRYPTO_CIRCULATING_SUPPLY, circulatingSupply)
                    .putExtra(CRYPTO_TOTAL_SUPPLY, totalSupply)
                itemView.context.startActivity(intent)
            }
        }


        //привязываем элементы представления списка к RecyclerView и заполняем данными
        override fun bind(item: Any) {
            let {
                item as Currency
                Glide.with(view.context).load(item.image).into(view.ivCurrencyIcon)
                view.tvCurrencySym.text = item.symbol
                view.tvCurrencyName.text = item.name
                view.tvCurrencyMarketCap.text = item.marketCap
                view.tvCurrencyPrice.text = item.price.toString()
                id = item.id
                symbol = item.symbol
                name = item.name
                image = item.image
                marketCapRank = item.marketCapRank
                marketCapChangePercentage24h = item.marketCapChangePercentage24h
                priceChangePercentage24h = item.priceChangePercentage24h
                totalVolume = item.totalVolume
                ath = item.ath
                athChangePercentage = item.athChangePercentage
                circulatingSupply = item.circulatingSupply
                totalSupply = item.totalSupply
            }
        }
    }

}