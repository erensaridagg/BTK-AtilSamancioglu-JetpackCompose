package com.erensaridag.yemektariflericompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.erensaridag.yemektariflericompose.model.Yemek
import com.erensaridag.yemektariflericompose.ui.theme.YemekTarifleriComposeTheme

class MainActivity : ComponentActivity() {

    private val yemekListesi = ArrayList<Yemek>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            YemekTarifleriComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        NavHost(navController = navController, startDestination = "liste_ekrani") {
                            composable("liste_ekrani") {
                                YemekListesi(yemekler = yemekListesi)
                            }
                            composable("detay_ekrani") {
                                DetayEkrani(yemek = yemekListesi[0])
                            }
                        }
                    }
                }
            }
        }
    }
    private fun verileriOlustur(){

    }
}

