package ru.msokolov.cryptocurrencyapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import ru.msokolov.cryptocurrencyapp.R
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import ru.msokolov.cryptocurrencyapp.adapter.entities.Currency

class CurrenciesAdapter : BaseAdapter<CurrenciesAdapter.CurrencyViewHolder>() {


    //создает ViewHolder и инициализирует views для списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return CurrencyViewHolder(v)

    }

    //реализация вьюхолдера
    class CurrencyViewHolder(view: View) : BaseAdapter.BaseViewHolder(view) {



        init {
            //слушатель клика по элементам списка
            itemView.setOnClickListener {

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

            }


        }
    }

}