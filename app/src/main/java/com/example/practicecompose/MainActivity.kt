package com.example.practicecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicecompose.model.Quote
import com.example.practicecompose.screens.QuoteDetailsScreen
import com.example.practicecompose.screens.QuoteListScreen
import com.example.practicecompose.ui.theme.PracticeComposeTheme
import com.example.practicecompose.viewmodel.QuoteViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel: QuoteViewModel by viewModels()
        setContent {
            PracticeComposeTheme {
                MainNavigation(viewModel)
            }
        }
    }
}


@Composable
fun MainNavigation(viewModel: QuoteViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "QuoteList") {
        composable(route = "QuoteList") {
            QuoteListScreen(viewModel, navController)
        }
        composable(route = "QuoteDetail/{quote}", arguments = listOf(navArgument("quote") {
            type = NavType.StringType
        })) { navBackStackEntry->
            val quoteJson = navBackStackEntry.arguments?.getString("quote")
            val quote = Gson().fromJson(quoteJson, Quote::class.java)
            if (quote != null) {
                QuoteDetailsScreen(quote,navController)
            }
        }
    }
}

@Composable
fun App(viewModel: QuoteViewModel) {


}