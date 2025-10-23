package com.kotlin.proyectoapp.ui.screens.comparar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.proyectoapp.data.repository.CandidatoRepository
import com.kotlin.proyectoapp.domain.model.Candidato
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class CompararUiState(
    val candidatosDisponibles: List<Candidato> = emptyList(),
    val candidatosSeleccionados: List<Candidato> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

class CompararViewModel(
    private val repository: CandidatoRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CompararUiState())
    val uiState: StateFlow<CompararUiState> = _uiState.asStateFlow()

    init {
        loadCandidatos()
    }

    private fun loadCandidatos() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                repository.getAllCandidatos().collect { candidatos ->
                    _uiState.value = _uiState.value.copy(
                        candidatosDisponibles = candidatos,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = "Error al cargar candidatos: ${e.message}"
                )
            }
        }
    }

    fun toggleCandidatoSelection(candidato: Candidato) {
        val currentSelection = _uiState.value.candidatosSeleccionados

        val newSelection = if (currentSelection.contains(candidato)) {
            currentSelection - candidato
        } else {
            if (currentSelection.size < 3) {
                currentSelection + candidato
            } else {
                currentSelection
            }
        }

        _uiState.value = _uiState.value.copy(candidatosSeleccionados = newSelection)
    }

    fun clearSelection() {
        _uiState.value = _uiState.value.copy(candidatosSeleccionados = emptyList())
    }
}