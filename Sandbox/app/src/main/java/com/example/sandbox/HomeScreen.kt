package com.example.sandbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sandbox.ui.theme.SandboxTheme

@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        HomeScreenContents(
            modifier = Modifier
                .padding(paddingValues = innerPadding)
        )
    }
}

@Composable
fun HomeScreenContents(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.padding(all = 4.dp))

        Header()

        Spacer(modifier = Modifier.padding(all = 4.dp))

        Body()

        Spacer(modifier = Modifier.padding(all = 4.dp))

        Footer()

        Spacer(modifier = Modifier.padding(all = 4.dp))
    }
}

@Composable
fun Header() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(all = 16.dp)
            .background(
                color = Color.LightGray,
                shape = MaterialTheme.shapes.medium
            )
            .fillMaxWidth()
    ) {
        Text(
            text = "ポケモン図鑑",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Black,
            modifier = Modifier
                .padding(all = 16.dp)
        )
    }
}

@Composable
fun Body() {
    Column(
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
        ) {
            Button(
                onClick = {
                    println("tap 1")
                },
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxWidth()
            ) {
               Text(
                   text = "Button 1"
               )
            }
        }

        Box(
            modifier = Modifier
        ) {
            Button(
                onClick = {
                    println("tap 1")
                },
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Button 2"
                )
            }
        }
    }
}

@Composable
fun Footer() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
        ) {
            Text(
                text = "version : 0.1",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray,
                modifier = Modifier
            )
        }

        Box(
            modifier = Modifier
        ) {
            Text(
                text = "copyright : Mitsuhiko Hashiguchi",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray,
                modifier = Modifier
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun HomeScreenPreview() {
    SandboxTheme {
        HomeScreen()
    }
}
