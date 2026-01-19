package com.example.sandbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.sandbox.ui.theme.SandboxTheme
import coil.compose.AsyncImage

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
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
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
        },
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        ListScreenContents(
            modifier = Modifier
                .padding(paddingValues = innerPadding)
        )
    }
}

@Composable
fun ListScreenContents(
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

        ListScreenFooter()

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
                color = Color.DarkGray,
                shape = MaterialTheme.shapes.medium
            )
            .fillMaxWidth()
    ) {
        Text(
            text = "リスト",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            fontWeight = FontWeight.Black,
            modifier = Modifier
                .padding(all = 16.dp)
        )
    }
}

@Composable
fun ListScreenBody(
    userViewModel: UserViewModel = hiltViewModel(),
    pokemonViewModel: PokemonViewModel = hiltViewModel(),
) {
    val userList by userViewModel.allUsers.collectAsState(initial = emptyList())
    val pokemonList by pokemonViewModel.allPokemons.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
    ) {
        // 保存されたデータのリストを表示
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(
                items = pokemonList
            ) { pokemon ->
                Box(
                    modifier = Modifier
                        .padding(all = 16.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color.LightGray,
                            shape = MaterialTheme.shapes.medium
                        )
                ) {
                    Row(
                        modifier = Modifier
                    ) {
                        AsyncImage(
                            model = pokemon.imagePath,
                            contentDescription = null,
                            modifier = Modifier
                                .size(size = 128.dp)
                        )

                        Column(
                            modifier = Modifier
                                .padding(all = 16.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "No. ${String.format("%04d", pokemon.number)}"
                            )

                            Text(
                                text = pokemon.name,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Black
                            )

                            Text(
                                text = "${pokemon.typeName1} / ${pokemon.typeName2}"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ListScreenFooter() {
    Box(
        modifier = Modifier
    ) {
        Text(
            text = "Footer",
            modifier = Modifier
        )
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
