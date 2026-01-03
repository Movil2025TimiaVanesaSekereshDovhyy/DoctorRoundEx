package net.iessochoa.sergiocontreras.doctorround.ui.screens

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import net.iessochoa.sergiocontreras.doctorround.data.PatientRepository
import net.iessochoa.sergiocontreras.doctorround.model.Patient
import net.iessochoa.sergiocontreras.doctorround.ui.DoctorViewModel
import net.iessochoa.sergiocontreras.doctorround.ui.components.PatientDiagnosis
import net.iessochoa.sergiocontreras.doctorround.ui.components.PatientSummaryCard
import net.iessochoa.sergiocontreras.doctorround.ui.components.PatientSymptomatology
import net.iessochoa.sergiocontreras.doctorround.ui.theme.DoctorRoundTheme

@Composable
fun PatientDetailScreen(
    // TODO: TAREA 2 y 3 - Modificar Argumentos para MVVM y Navegación
    // 1. Elimina 'patient'. La pantalla debe obtener los datos del ViewModel.
    // 2. Añade 'doctorViewModel: DoctorViewModel'.
    // 3. Añade 'onBack: () -> Unit' para la navegación.

    //patient: Patient, //BORRAR

    modifier: Modifier = Modifier,
    viewModel: DoctorViewModel,
    onBack: () -> Unit
) {

    // TODO: TAREA 1 y 4 - Estado y Eventos con MVVM
    // 1. Obtén el 'uiState' del ViewModel.
    // 2. Define el paciente a mostrar: uiState.value.selectedPatient (o uno por defecto si es null).
    // 3. Define las lambdas para los eventos:


    val scrollState = rememberScrollState()
    val context = LocalContext.current


    val uiState = viewModel.uiState.collectAsState()
    val patient = uiState.value.selectedPatient ?: PatientRepository.getPatients().first()


    //    - onPainValueChange: llama a viewModel.onPainLevelChanged
    //    - onNoteValueChange: llama a viewModel.onNoteChanged
    val onPainValueChange = { newValue: Float ->
        viewModel.onPainLevelChanged(newValue)
    }

    val onNoteValueChange = {newNote: String ->
        viewModel.onNoteChanged(newNote)
    }

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(16.dp)
    )  {

        // TODO 1: Mejora el estilo de este texto (usa MaterialTheme o un componente personalizado como DetailSectionTitle)
        Text(
            text = "Datos Identificativos",
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold
        )


        // TODO 1: Implementa correctamente este componente
        PatientSummaryCard(patient)

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        // TODO 1: Mejora el estilo de este texto (usa MaterialTheme o un componente personalizado como DetailSectionTitle)
        Text(
            text = "Sintomatología",
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Normal
        )

        PatientSummaryCard(patient)

        PatientSymptomatology(
            patient,
            patient.painLevel,
            onPainValueChange) //En vez de crearla arriba se puede poner { viewModel.onPainLevelChanged(it) }

        // TODO 1: Mejora el estilo de este texto (usa MaterialTheme o un componente personalizado como DetailSectionTitle)
        Text(
            text = "Diagnóstico",
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Normal
        )



        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        // TODO: Este componente se entrega ya implementado, solo tienes que llamarlo con los parámetros adecuados.
        PatientDiagnosis(patient = patient, onValueChange = {onNoteValueChange})

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))


        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /* TODO: Actualizar los datos */
                viewModel.onVisitSaved()
                Toast.makeText(context, "Cambios guardados", Toast.LENGTH_SHORT).show()

                //Volver a la lista
                onBack()
            }
        ) {
            Text("Actualizar")
        }


        
    }

}

/*
@Preview(showBackground = true)
@Composable
fun PatientDetailScreenPreview(){

    val patientPreview = PatientRepository.getPatients().first()

    DoctorRoundTheme() {
        PatientDetailScreen(
            modifier = Modifier.fillMaxSize(),
            patientPreview,

        )
    }
}
*/