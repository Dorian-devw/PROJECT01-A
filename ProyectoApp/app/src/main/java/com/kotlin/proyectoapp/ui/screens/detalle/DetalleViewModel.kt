package com.kotlin.proyectoapp.ui.screens.detalle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.proyectoapp.data.repository.CandidatoRepository
import com.kotlin.proyectoapp.domain.model.Candidato
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// 1. Simplificamos el UiState
data class DetalleUiState(
    val candidato: Candidato? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

class DetalleViewModel(
    private val repository: CandidatoRepository,
    private val candidatoId: Int
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetalleUiState())
    val uiState: StateFlow<DetalleUiState> = _uiState.asStateFlow()

    init {
        loadCandidatoDetalle()
    }

    private fun loadCandidatoDetalle() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                // 2. La lógica ahora es más simple
                repository.getCandidatoById(candidatoId)?.collect { candidato ->
                    _uiState.value = _uiState.value.copy(
                        candidato = candidato, // El candidato ya tiene los proyectos y denuncias
                        isLoading = false,
                        error = null
                    )
                } ?: run {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = "Candidato no encontrado"
                    )
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = "Error al cargar detalles: ${e.message}"
                )
            }
        }
    }
}