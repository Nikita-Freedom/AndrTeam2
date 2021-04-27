package com.hackaton.andrteam.alcoholdiary.view.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackaton.andrteam.alcoholdiary.domain.model.User
import com.hackaton.andrteam.alcoholdiary.domain.usecase.GetUserUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val userUseCase: GetUserUseCase) : ViewModel() {

    val userLiveData: MutableLiveData<User> by lazy { MutableLiveData() }

    fun getUser() {
        viewModelScope.launch {
            userLiveData.postValue(userUseCase.getUser())
        }
    }
}