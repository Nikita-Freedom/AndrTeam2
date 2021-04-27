package com.hackaton.andrteam.alcoholdiary.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hackaton.andrteam.alcoholdiary.di.UseCaseProvider

class MainViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                UseCaseProvider.provideGetUserUseCase()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}