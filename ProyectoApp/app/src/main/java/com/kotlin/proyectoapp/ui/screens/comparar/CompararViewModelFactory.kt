package com.kotlin.proyectoapp.ui.screens.comparar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlin.proyectoapp.data.repository.CandidatoRepository

class CompararViewModelFactory(
    private val repository: CandidatoRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompararViewModel::class.java)) {
            return CompararViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}