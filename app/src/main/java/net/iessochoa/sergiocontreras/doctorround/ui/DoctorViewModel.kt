package net.iessochoa.sergiocontreras.doctorround.ui

import androidx.compose.runtime.currentComposer
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.iessochoa.sergiocontreras.doctorround.data.PatientRepository
import net.iessochoa.sergiocontreras.doctorround.model.Patient

class DoctorViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DoctorUiState())
    val uiState: StateFlow<DoctorUiState> = _uiState.asStateFlow()

    // Bloque de inicialización para cargar los pacientes
    init {
        _uiState.update { currentState ->
            currentState.copy(
                patients = PatientRepository.getPatients()
            )
        }
    }

    fun onBackToMenu() {
        _uiState.update { it.copy(selectedPatient = null) }
    }

    fun onPatientSelected(patient: Patient) {
        // TODO: Actualiza el estado con el paciente seleccionado
        _uiState.update { currentState ->
            currentState.copy(
                selectedPatient = patient
            )
        }
    }

    fun onNoteChanged(newNote: String) {
     // TODO: Actualiza la nota en el estado
        _uiState.update { currentState ->
            currentState.copy(
                selectedPatient = currentState.selectedPatient?.copy(visitNote = newNote)
            )
        }
    }

    fun onPainLevelChanged(newLevel: Float) {
        // TODO: Actualiza el nivel de dolor
        _uiState.update { currentState ->
            currentState.copy(
                selectedPatient = currentState.selectedPatient?.copy(painLevel = newLevel)
            )
        }
    }

    fun onVisitSaved() {
        // TODO (Opcional): Simula la persistencia de datos llamando a PatientRepository.updatePatient() con los nuevos valores de dolor y nota de visita para el paciente seleccionado _uiState.update { currentState ->
        val patient = _uiState.value.selectedPatient
        if(patient != null){
            PatientRepository.updatePatient(patient)
            _uiState.update { currentState ->
                currentState.copy(
                    patients = PatientRepository.getPatients().toList()
                )
            }
        }
    }
}

