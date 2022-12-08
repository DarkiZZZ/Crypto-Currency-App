package ru.msokolov.cryptocurrencyapp.di

import dagger.Component
import ru.msokolov.cryptocurrencyapp.activities.ChartActivity
import ru.msokolov.cryptocurrencyapp.activities.MainActivity
import ru.msokolov.cryptocurrencyapp.chart.LatestChart
import ru.msokolov.cryptocurrencyapp.fragments.CurrenciesListFragment
import ru.msokolov.cryptocurrencyapp.mvp.presenter.CurrenciesPresenter
import ru.msokolov.cryptocurrencyapp.mvp.presenter.LatestChartPresenter
import javax.inject.Singleton


@Component(modules = arrayOf(AppModule::class, RestModule::class,
    MvpModule::class, ChartModule::class))
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(chartActivity: ChartActivity)
    fun inject(presenter: CurrenciesPresenter)
    fun inject(presenter: LatestChartPresenter)
    fun inject(fragment: CurrenciesListFragment)
    fun inject(chart: LatestChart)
}