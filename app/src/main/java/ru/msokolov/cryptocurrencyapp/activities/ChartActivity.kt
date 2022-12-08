package ru.msokolov.cryptocurrencyapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import kotlinx.android.synthetic.main.activity_chart.*
import ru.msokolov.cryptocurrencyapp.R
import ru.msokolov.cryptocurrencyapp.chart.LatestChart
import ru.msokolov.cryptocurrencyapp.di.App
import ru.msokolov.cryptocurrencyapp.mvp.contract.LatestChartContract
import ru.msokolov.cryptocurrencyapp.mvp.presenter.LatestChartPresenter
import java.text.DecimalFormat
import javax.inject.Inject

class ChartActivity : AppCompatActivity(), OnChartValueSelectedListener, LatestChartContract.View{

    @Inject
    lateinit var latestChart: LatestChart

    @Inject
    lateinit var presenter: LatestChartPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)

        App.appComponent.inject(this)
        presenter.attach(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val name = intent.getStringExtra(CRYPTO_NAME)
        val marketCapRank = intent.getIntExtra(CRYPTO_MARKET_CAP_RANK, 0)
        //val symbol = intent.getStringExtra(CRYPTO_SYMBOL)
        //val marketCap = intent.getStringExtra(CRYPTO_MARKET_CAP)
        val marketCapChangePercentage24h =
            intent?.getFloatExtra(CRYPTO_MARKET_CAP_CHANGE_PERC_24_H, 0.0f)
        //val priceChangePercentage24h = intent?.getFloatExtra(
        //    CRYPTO_PRICE_CHANGE_PERC_24_H,
         //   0.0f)
        //val totalVolume = intent?.getFloatExtra(CRYPTO_TOTAL_VOLUME, 0.0f)
        val ath = intent?.getFloatExtra(CRYPTO_ATH, 0.0f)
        val athChangePercentage = intent?.getFloatExtra(CRYPTO_ATH_CHANGE_PERC, 0.0f)
        val circulatingSupply = intent?.getDoubleExtra(CRYPTO_CIRCULATING_SUPPLY, 0.0)
        val totalSupply = intent?.getFloatExtra(CRYPTO_TOTAL_SUPPLY, 0.0f)
        val image = intent.getStringExtra(CRYPTO_IMAGE)

        Glide.with(this).load(image).into(ivCurrencyDetailIcon)

        supportActionBar?.title = name
        val df = DecimalFormat("#")
        df.maximumFractionDigits = 2
        tvDetailMarketCapRank.text = marketCapRank.toString()
        tvMarketCapChange.text = marketCapChangePercentage24h.toString()
        tvATH.text = ath.toString()
        tvAthChange.text = df.format(athChangePercentage)
        tvCirculatingSupply.text = df.format(circulatingSupply)
        tvTotalSupply.text = totalSupply.toString()
        val currencyId: String = intent.getStringExtra("CRYPTO_ID") as String
        tvCurrencyId.text = currencyId
        presenter.makeChart(currencyId) // NEED TO CHECK FOR NULL SAFETY
        latestChart.initChart(chartCurrency)
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected() {
        TODO("Not yet implemented")
    }

    override fun addEntryToChart(value: Float, date: String) {
        TODO("Not yet implemented")
    }

    override fun addEntryToChart(value: Float, date: Float) {
        latestChart.addEntry(value, date)
    }

    override fun showProgress() {
        progressChart.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressChart.visibility = View.GONE
    }

    override fun showErrorMessage(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun refresh() {
        TODO("Not yet implemented")
    }

    companion object{
        const val CRYPTO_NAME = "CRYPTO_NAME"
        const val CRYPTO_ID = "CRYPTO_ID"
        const val CRYPTO_SYMBOL = "CRYPTO_SYMBOL"
        const val CRYPTO_IMAGE = "CRYPTO_IMAGE"
        const val CRYPTO_MARKET_CAP_RANK = "CRYPTO_MARKET_CAP_RANK"
        const val CRYPTO_MARKET_CAP = "CRYPTO_MARKET_CAP"
        const val CRYPTO_MARKET_CAP_CHANGE_PERC_24_H = "CRYPTO_MARKET_CAP_CHANGE_PERC_24_H"
        const val CRYPTO_PRICE_CHANGE_PERC_24_H = "CRYPTO_PRICE_CHANGE_PERC_24_H"
        const val CRYPTO_TOTAL_VOLUME = "CRYPTO_TOTAL_VOLUME"
        const val CRYPTO_ATH = "CRYPTO_ATH"
        const val CRYPTO_ATH_CHANGE_PERC = "CRYPTO_ATH_CHANGE_PERC"
        const val CRYPTO_CIRCULATING_SUPPLY = "CRYPTO_CIRCULATING_SUPPLY"
        const val CRYPTO_TOTAL_SUPPLY = "CRYPTO_TOTAL_SUPPLY"
    }

}

