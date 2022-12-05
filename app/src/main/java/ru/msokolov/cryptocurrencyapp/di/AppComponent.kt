package ru.msokolov.cryptocurrencyapp.di

import dagger.Component
import ru.msokolov.cryptocurrencyapp.MainActivity
import ru.msokolov.cryptocurrencyapp.mvp.contract.CurrenciesContract
import ru.msokolov.cryptocurrencyapp.mvp.presenter.CurrenciesPresenter
import ru.msokolov.cryptocurrencyapp.mvp.presenter.LatestChartPresenter
import javax.inject.Singleton


@Component(modules = arrayOf(AppModule::class, RestModule::class,
    MvpModule::class, ChartModule::class))
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(presenter: CurrenciesPresenter)
    fun inject(presenter: LatestChartPresenter)
}