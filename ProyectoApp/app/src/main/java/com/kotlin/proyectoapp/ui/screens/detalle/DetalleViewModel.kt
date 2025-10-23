package com.kotlin.proyectoapp.ui.screens.detalle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.proyectoapp.data.repository.CandidatoRepository
import com.kotlin.proyectoapp.domain.model.Candidato
import com.kotlin.proyectoapp.domain.model.Denuncia
import com.kotlin.proyectoapp.domain.model.Proyecto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class DetalleUiState(
    val candidato: Candidato? = null,
    val proyectos: List<Proyecto> = emptyList(),
    val denuncias: List<Denuncia> = emptyList(),
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
                repository.getCandidatoById(candidatoId)?.collect { candidato ->
                    _uiState.value = _uiState.value.copy(
                        candidato = candidato,
                        proyectos = candidato.proyectos,
                        denuncias = candidato.denuncias,
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