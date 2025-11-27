package net.iessochoa.sergiocontreras.doctorround.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// Añade aquí tus imports necesarios (NavHost, composable, tus screens, tu ViewModel...)

/**
 * Grafo de navegación de la aplicación.
 * Aquí se define qué pantalla se muestra para cada ruta.
 */
@Composable
fun DoctorRoundNavHost(
    // TODO: TAREA 3 - Añade los parámetros necesarios:
    // 1. navController (NavHostController)
    // 2. viewModel (DoctorViewModel) - Para compartir el estado entre pantallas
    modifier: Modifier = Modifier
) {
    // TODO: TAREA 3 - Implementa el NavHost
    // - Define el startDestination usando tu objeto PatientListDestination
    // - Define los dos composables:
    //      1. PatientListDestination.route -> Muestra PatientListScreen
    //      2. PatientDetailDestination.route -> Muestra PatientDetailScreen

    /* PISTA: Recuerda usar el Navigation Helper si te atascas */
}