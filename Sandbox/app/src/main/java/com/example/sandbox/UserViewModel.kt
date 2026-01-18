package com.example.sandbox

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userDao: UserDao
) : ViewModel() {

    // データベースの全ユーザーを監視するFlow
    // これを定義することで、Roomの変更が自動的に画面へ通知されます
    val allUsers = userDao.getAllUsers()

    fun insertUser() {
        viewModelScope.launch {
            val newUser = User(name = "User ${System.currentTimeMillis()}")
            userDao.insert(newUser)
        }
    }

    fun clearAllUsers() {
        viewModelScope.launch {
            userDao.deleteAllUsers()
        }
    }
}