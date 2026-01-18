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
import kotlin.Unit
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToList: () -> Unit,
) {
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
        HomeScreenContents(
            onNavigateToList = onNavigateToList,
            modifier = Modifier
                .padding(paddingValues = innerPadding)
        )
    }
}

@Composable
fun HomeScreenContents(
    onNavigateToList: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.padding(all = 4.dp))

        HomeScreenHeader()

        Spacer(modifier = Modifier.padding(all = 4.dp))

        HomeScreenBody(
            onNavigateToList = onNavigateToList
        )

        Spacer(modifier = Modifier.padding(all = 4.dp))

        HomeScreenFooter()

        Spacer(modifier = Modifier.padding(all = 4.dp))
    }
}

@Composable
fun HomeScreenHeader() {
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
fun HomeScreenBody(
    onNavigateToList: () -> Unit,
    viewModel: UserViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
        ) {
            Button(
                onClick = {
                    onNavigateToList()
                },
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxWidth()
            ) {
               Text(
                   text = "リストの表示"
               )
            }
        }

        Box(
            modifier = Modifier
        ) {
            Button(
                onClick = {
                    viewModel.insertUser()
                },
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "データの追加"
                )
            }
        }

        Box(
            modifier = Modifier
        ) {
            Button(
                onClick = {
                    viewModel.clearAllUsers()
                },
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "データの削除"
                )
            }
        }
    }
}

@Composable
fun HomeScreenFooter() {
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

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    SandboxTheme {
        HomeScreen(
            onNavigateToList = { }
        )
    }
}
