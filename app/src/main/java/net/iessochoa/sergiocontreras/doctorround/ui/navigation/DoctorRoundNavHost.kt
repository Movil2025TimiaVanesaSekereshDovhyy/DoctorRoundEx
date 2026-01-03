package net.iessochoa.sergiocontreras.doctorround.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.iessochoa.sergiocontreras.doctorround.ui.DoctorViewModel
import net.iessochoa.sergiocontreras.doctorround.ui.screens.PatientDetailScreen
import net.iessochoa.sergiocontreras.doctorround.ui.screens.PatientListScreen

// Añade aquí tus imports necesarios (NavHost, composable, tus screens, tu ViewModel...)

/**
 * Grafo de navegación de la aplicación.
 * Aquí se define qué pantalla se muestra para cada ruta.
 */
@Composable
fun DoctorRoundNavHost(
    // TODO: TAREA 3 - Añade los parámetros necesarios:
    // 1. navController (NavHostController)
    navController: NavHostController,
    // 2. viewModel (DoctorViewModel) - Para compartir el estado entre pantallas
    viewModel: DoctorViewModel,
    modifier: Modifier = Modifier
) {
    // TODO: TAREA 3 - Implementa el NavHost
    // - Define el startDestination usando tu objeto PatientListDestination
    // - Define los dos composables:
    //      1. PatientListDestination.route -> Muestra PatientListScreen
    //      2. PatientDetailDestination.route -> Muestra PatientDetailScreen

    NavHost(
        navController = navController,
        startDestination = PatientListDestination.route, // 1. ¿Dónde empieza la app?
        modifier = modifier
    ) {
        // --- PANTALLA 1: LISTA ---
        composable(route = PatientListDestination.route) {
            PatientListScreen(
                // Pasamos el ViewModel o el estado necesario
                viewModel = viewModel,
                // Evento de navegación: Al hacer click en una receta...
                onPatientClick = { paciente ->
                    // 1. Guardamos la selección en el ViewModel (Shared State)
                    viewModel.onPatientSelected(paciente)

                    // 2. Navegamos al detalle (sin pasar argumentos complejos, el VM ya sabe cuál es)
                    navController.navigate(PatientDetailDestination.route)
                }
            )
        }

        // --- PANTALLA 2: DETALLE ---
        composable(route = PatientDetailDestination.route) {
            PatientDetailScreen(
                // Al usar el MISMO viewModel, esta pantalla ya sabe qué receta se seleccionó
                viewModel = viewModel,
                // Evento para volver atrás
                onBack = { navController.popBackStack() }
            )
        }
    }
}


    /* PISTA: Recuerda usar el Navigation Helper si te atascas */
