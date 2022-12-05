package ru.msokolov.cryptocurrencyapp.di

import dagger.Module
import dagger.Provides
import ru.msokolov.cryptocurrencyapp.mvp.presenter.CurrenciesPresenter
import ru.msokolov.cryptocurrencyapp.mvp.presenter.LatestChartPresenter
import javax.inject.Singleton

@Module
class MvpModule {

    @Provides
    @Singleton
    fun provideCurrenciesPresenter(): CurrenciesPresenter = CurrenciesPresenter()

    @Provides
    @Singleton
    fun provideLatestChartPresenter(): LatestChartPresenter = LatestChartPresenter()
}