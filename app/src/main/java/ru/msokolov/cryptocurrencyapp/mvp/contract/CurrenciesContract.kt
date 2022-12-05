package ru.msokolov.cryptocurrencyapp.mvp.contract

import ru.msokolov.cryptocurrencyapp.adapter.entities.Currency

class CurrenciesContract {

    interface View: BaseContract.View{
        fun addCurrency(currenciesContract: Currency)
        fun notifyAdapter()
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(error: String?)
        fun refresh()
    }

    abstract class Presenter: BaseContract.Presenter<View>() {
        abstract fun makeList()
        abstract fun refreshList()
    }
}