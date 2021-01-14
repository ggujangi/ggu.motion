package com.ggu.motion.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ggu.motion.data.Repository

class RegisterViewModel(private val repository: Repository) : ViewModel() {

    private val name = MutableLiveData<String>()

    fun getName(): LiveData<String> = name

    fun isRegister(): Boolean = repository.isRegister()

    fun register(name: String) {
        repository.register(name)
    }
}