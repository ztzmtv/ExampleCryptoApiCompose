package com.example.jetpackcrypto

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcrypto.ui.theme.JetPackCryptoTheme
import com.example.mycryptoapp.CoinViewModel
import com.example.mycryptoapp.pojo.CoinPriceInfo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetPackCryptoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Function(
                        lcowner = this,
                        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
                    )
                }
            }
        }
    }
}

@Composable
fun Function(viewModel: CoinViewModel, lcowner: ComponentActivity) {
    var listOfCoinPriceInfo: List<CoinPriceInfo> = listOfNotNull()
    viewModel.priceList.observe(lcowner, Observer {
        listOfCoinPriceInfo = it
    })
    Log.d("COMPOSABLE_Function", listOfCoinPriceInfo.toString())
    Scaffold(
        content = {
            CryptoContent(listOfCoinPriceInfo)
        })
}

@Composable
fun CryptoContent(listOfCoinPriceInfo: List<CoinPriceInfo>) {
    val coinPriceInfoList = remember { listOfCoinPriceInfo }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = coinPriceInfoList,
            itemContent = {
                CryptoListItem(coinPriceInfo = it)
            })
    }
}

@Composable
fun CryptoListItem(coinPriceInfo: CoinPriceInfo) {
    Row {
        Column {
            Text(text = coinPriceInfo.fromsymbol, style = typography.h6)
            Text(text = "VIEW DETAIL", style = typography.caption)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    JetPackCryptoTheme {
//        Function("Android")
//    }
//}