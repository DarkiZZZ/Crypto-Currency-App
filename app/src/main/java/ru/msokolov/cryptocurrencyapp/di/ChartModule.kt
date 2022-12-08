package ru.msokolov.cryptocurrencyapp.di

import dagger.Module
import dagger.Provides
import ru.msokolov.cryptocurrencyapp.chart.LatestChart
import ru.msokolov.cryptocurrencyapp.formatters.YearValueFormatter
import javax.inject.Singleton

@Module
class ChartModule {

    @Provides
    @Singleton
    fun provideLatestChart() = LatestChart()



    @Provides
    @Singleton
    fun provideYearFormatter() = YearValueFormatter()
}