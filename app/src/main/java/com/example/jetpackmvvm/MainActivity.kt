package com.example.jetpackmvvm

import android.os.Bundle
import androidx.compose.material.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackmvvm.presentation.Screen
import com.example.jetpackmvvm.presentation.modules.coin_detail.components.CoinDetailScreen
import com.example.jetpackmvvm.presentation.modules.coin_list.components.CoinListScreen
import com.example.jetpackmvvm.presentation.ui.theme.JetPackMVVMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackMVVMTheme {
               Surface(color = MaterialTheme.colors.background) {
                   val navController= rememberNavController()
                   NavHost(
                       navController = navController,
                       startDestination = Screen.CoinListScreen.route
                   ){
                       composable(
                           route = Screen.CoinListScreen.route
                       ){
                           CoinListScreen(navController)
                       }
                       composable(
                           route = Screen.CoinDetailScreen.route+"/{coinId}"
                       ){
                           CoinDetailScreen()
                       }
                   }

               }
            }
        }
    }
}
