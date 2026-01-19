package com.example.sandbox

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokemonDao: PokemonDao
) : ViewModel() {

    // データベースの全ユーザーを監視するFlow
    // これを定義することで、Roomの変更が自動的に画面へ通知されます
    val allPokemons = pokemonDao.getAllPokemons()

    fun insertPokemon(
        pNumber: Int,
        pName: String,
        pTypeName1: String,
        pTypeName2: String,
        pResourceID: Int,
        pContext: Context
    ) {
        viewModelScope.launch {
            // 1. res/drawable の画像を Bitmap に変換
            val bitmap = BitmapFactory.decodeResource(pContext.resources, pResourceID)

            // 2. 以前作成した関数で内部ストレージに保存し、パスを取得
            val imageUtility = ImageUtility()
            val imagePath = imageUtility.saveImageToInternalStorage(pContext, bitmap)

            val newPokemon = Pokemon(
                number = pNumber,
                name = pName,
                typeName1 = pTypeName1,
                typeName2 = pTypeName2,
                imagePath = imagePath,
            )
            pokemonDao.insert(newPokemon)
        }
    }

    fun clearAllPokemons() {
        viewModelScope.launch {
            pokemonDao.deleteAllPokemons()
        }
    }

    fun insert(
        pNumber: Int,
        pContext: Context
    ) {
        var name = ""
        var typeName1 = ""
        var typeName2 = ""
        var resourceID = 0

        when (pNumber) {
            1 -> {
                name = "フシギダネ"
                typeName1 = "くさ"
                typeName2 = "どく"
                resourceID = R.drawable.pokemon_0001_1
            }
            2 -> {
                name = "フシギソウ"
                typeName1 = "くさ"
                typeName2 = "どく"
                resourceID = R.drawable.pokemon_0002_1
            }
            3 -> {
                name = "フシギバナ"
                typeName1 = "くさ"
                typeName2 = "どく"
                resourceID = R.drawable.pokemon_0003_1
            }
            4 -> {
                name = "ヒトカゲ"
                typeName1 = "ほのお"
                typeName2 = "-"
                resourceID = R.drawable.pokemon_0004_1
            }
            5 -> {
                name = "リザード"
                typeName1 = "ほのお"
                typeName2 = "-"
                resourceID = R.drawable.pokemon_0005_1
            }
            6 -> {
                name = "リザードン"
                typeName1 = "ほのお"
                typeName2 = "ひこう"
                resourceID = R.drawable.pokemon_0006_1
            }
            7 -> {
                name = "ゼニガメ"
                typeName1 = "みず"
                typeName2 = "-"
                resourceID = R.drawable.pokemon_0007_1
            }
            8 -> {
                name = "カメール"
                typeName1 = "みず"
                typeName2 = "-"
                resourceID = R.drawable.pokemon_0008_1
            }
            9 -> {
                name = "カメックス"
                typeName1 = "みず"
                typeName2 = "-"
                resourceID = R.drawable.pokemon_0009_1
            }
            25 -> {
                name = "ピカチュウ"
                typeName1 = "でんき"
                typeName2 = "-"
                resourceID = R.drawable.pokemon_0025_1
            }
            26 -> {
                name = "ライチュウ"
                typeName1 = "でんき"
                typeName2 = "-"
                resourceID = R.drawable.pokemon_0026_1
            }
            else -> {
                return
            }
        }

        insertPokemon(
            pNumber = pNumber,
            pName = name,
            pTypeName1 = typeName1,
            pTypeName2 = typeName2,
            pResourceID = resourceID,
            pContext = pContext
        )
    }
}