package com.kotlin.proyectoapp.ui.screens.detalle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlin.proyectoapp.data.repository.CandidatoRepository

class DetalleViewModelFactory(
    private val repository: CandidatoRepository,
    private val candidatoId: Int
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetalleViewModel::class.java)) {
            return DetalleViewModel(repository, candidatoId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}