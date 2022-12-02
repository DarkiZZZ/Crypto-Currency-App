package ru.msokolov.cryptocurrencyapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.msokolov.cryptocurrencyapp.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}