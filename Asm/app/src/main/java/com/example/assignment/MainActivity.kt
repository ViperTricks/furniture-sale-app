package com.example.assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
            ) {
                Navigation()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Splash") {
        composable("Splash") { Splash(navController) }
        composable("Login") { Login(navController) }
        composable("Register") { Register(navController) }
        composable("Notification") { Notification(navController) }
        composable("HomeScreen") { HomeScreen(navController) }
        composable(
            "detail/{idProduct}",
            arguments = listOf(navArgument("idProduct") {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            DetailProduct(
                idProduct = navBackStackEntry.arguments?.getString("idProduct"),
                navController = navController
            )
        }
        composable("MyCart") { MyCart(navController) }
        composable("CheckOut") { CheckOut(navController) }
    }
}