package br.com.fiap.challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.challenge.activitys.CaixaEntrada
import br.com.fiap.challenge.activitys.CalendarActivity
import br.com.fiap.challenge.activitys.CalendarView
import br.com.fiap.challenge.activitys.NovoEmail
import br.com.fiap.challenge.ui.theme.ChallengeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChallengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home"){
                        composable(route = "home"){
                            CaixaEntrada(navController)
                        }
                        composable(route = "novo-email"){
                            NovoEmail(navController)
                        }
                        composable(route = "calendario"){
                            CalendarView()
                        }
                        composable(route = "email"){
                            CaixaEntrada(navController)
                        }

                    }
                }

            }

        }

    }
}


