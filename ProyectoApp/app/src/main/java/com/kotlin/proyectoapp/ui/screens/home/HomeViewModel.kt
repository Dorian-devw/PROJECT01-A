package com.kotlin.proyectoapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.proyectoapp.data.repository.CandidatoRepository
import com.kotlin.proyectoapp.domain.model.Candidato
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class HomeUiState(
    val candidatos: List<Candidato> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val searchQuery: String = "",
    val filterCargo: String = "Todos",
    val filterPartido: String = "Todos"
)

class HomeViewModel(
    private val repository: CandidatoRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadCandidatos()
    }

    fun loadCandidatos() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                repository.getAllCandidatos().collect { candidatos ->
                    _uiState.value = _uiState.value.copy(
                        candidatos = candidatos,
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

    fun searchCandidatos(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)

        if (query.isEmpty()) {
            loadCandidatos()
            return
        }

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                repository.searchCandidatos(query).collect { candidatos ->
                    _uiState.value = _uiState.value.copy(
                        candidatos = candidatos,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = "Error en búsqueda: ${e.message}"
                )
            }
        }
    }

    fun filterByCargo(cargo: String) {
        _uiState.value = _uiState.value.copy(filterCargo = cargo)

        if (cargo == "Todos") {
            loadCandidatos()
            return
        }

        viewModelScope.launch {
            repository.getCandidatosByCargo(cargo).collect { candidatos ->
                _uiState.value = _uiState.value.copy(candidatos = candidatos)
            }
        }
    }

    fun filterByPartido(partido: String) {
        _uiState.value = _uiState.value.copy(filterPartido = partido)

        if (partido == "Todos") {
            loadCandidatos()
            return
        }

        viewModelScope.launch {
            repository.getCandidatosByPartido(partido).collect { candidatos ->
                _uiState.value = _uiState.value.copy(candidatos = candidatos)
            }
        }
    }
}