package com.example.sandbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sandbox.ui.theme.SandboxTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "top app bar"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.tertiary
            ) {
                Text(
                    text = "bottom app bar"
                )
            }
        },
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        ListScreenContents(
            onBack = onBack,
            modifier = Modifier
                .padding(paddingValues = innerPadding)
        )
    }
}

@Composable
fun ListScreenContents(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.padding(all = 4.dp))

        ListScreenHeader()

        Spacer(modifier = Modifier.padding(all = 4.dp))

        ListScreenBody()

        Spacer(modifier = Modifier.padding(all = 4.dp))

        ListScreenFooter(
            onBack = onBack
        )

        Spacer(modifier = Modifier.padding(all = 4.dp))
    }
}

@Composable
fun ListScreenHeader() {
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
            text = "リスト",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Black,
            modifier = Modifier
                .padding(all = 16.dp)
        )
    }
}

@Composable
fun ListScreenBody() {
    Column(
        modifier = Modifier
    ) {
        Text(
            text = "リスト",
        )
    }
}

@Composable
fun ListScreenFooter(
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier
    ) {
        Button(
            onClick = onBack
        ) {
            Text(
                text = "戻る",
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    SandboxTheme {
        ListScreen(
            onBack = { }
        )
    }
}
