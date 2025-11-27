package net.iessochoa.sergiocontreras.doctorround.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.iessochoa.sergiocontreras.doctorround.ui.screens.PatientListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
/* TODO: Modifica esta clase para terminar de implementar la navegación */
fun DoctorRoundApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ronda Médica - Temeria") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        // Aquí es donde el alumno implementará más tarde el NavHost
        // De momento, mostramos la lista directamente para que tengan algo visual
        PatientListScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

