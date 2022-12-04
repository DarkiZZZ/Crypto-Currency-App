package ru.msokolov.cryptocurrencyapp.di

import dagger.Component
import ru.msokolov.cryptocurrencyapp.MainActivity
import javax.inject.Singleton


@Component(modules = arrayOf(AppModule::class, RestModule::class,
    MvpModule::class, ChartModule::class))
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}