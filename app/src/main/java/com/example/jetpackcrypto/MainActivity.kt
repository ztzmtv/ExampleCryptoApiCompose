package com.example.jetpackcrypto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcrypto.ui.theme.JetPackCryptoTheme
import com.example.mycryptoapp.CoinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetPackCryptoTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Function(
                        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
                    )
                }
            }
        }
    }
}

@Composable
fun Function(viewModel: CoinViewModel) {
    viewModel.priceList.observeAsState().value?.let {
        Text(text = it[1].fromsymbol)
    }

//    listCoinPriceInfo?.let {
//        for (i in it) {
//            Text(text = i.fromsymbol)
//        }
//    }

//    viewModel.priceList.observeAsState().value?.forEach {
//        Text(text = it.fromsymbol)
}


//@Composable
//fun CryptoContent(listOfCoinPriceInfo: List<CoinPriceInfo>) {
//    val coinPriceInfoList = remember { listOfCoinPriceInfo }
//    LazyColumn(
//        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
//    ) {
//        items(
//            items = coinPriceInfoList,
//            itemContent = {
//                CryptoListItem(coinPriceInfo = it)
//            })
//    }
//}
//
//@Composable
//fun CryptoListItem(coinPriceInfo: CoinPriceInfo) {
//    Row {
//        Column {
//            Text(text = "1231231231")
//            //Text(text = coinPriceInfo.fromsymbol, style = typography.h6)
//            Text(text = "VIEW DETAIL", style = typography.caption)
//        }
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    JetPackCryptoTheme {
//        Function("Android")
//    }
//}