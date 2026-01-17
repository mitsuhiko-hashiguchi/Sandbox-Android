package com.example.sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sandbox.ui.theme.SandboxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SandboxTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home" // 最初に表示する画面の名前
    ) {
        // ホーム画面
        composable(
            route = "home"
        ) {
            HomeScreen(
                onNavigateToList = {
                    // ボタンが押されたら "list" へ遷移
                    navController.navigate(route = "list")
                }
            )
        }

        // リスト画面
        composable(
            route = "list"
        ) {
            ListScreen(
                onBack = {
                    // 戻る操作
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SandboxTheme {
        Greeting(
            name = "Android"
        )
    }
}