package net.iessochoa.sergiocontreras.doctorround.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import net.iessochoa.sergiocontreras.doctorround.R
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import net.iessochoa.sergiocontreras.doctorround.ui.navigation.DoctorRoundNavHost
import net.iessochoa.sergiocontreras.doctorround.ui.navigation.PatientDetailDestination
import net.iessochoa.sergiocontreras.doctorround.ui.navigation.PatientListDestination
import net.iessochoa.sergiocontreras.doctorround.ui.screens.PatientListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
/* TODO: Modifica esta clase para terminar de implementar la navegación */
fun DoctorRoundApp(
    viewModel: DoctorViewModel = viewModel(), // Inyectamos/Creamos el VM aquí
    navController: NavHostController = rememberNavController() // Creamos el Controller
) {

    // Trucazo 🤙: Observamos la ruta actual para cambiar el título de la TopBar
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    // Lógica para decidir qué título mostrar según la ruta donde estemos
    val currentScreenTitle = when (currentRoute) {
        PatientListDestination.route -> stringResource(PatientListDestination.titleRes)
        PatientDetailDestination.route -> stringResource(PatientDetailDestination.titleRes)
        else -> stringResource(PatientListDestination.titleRes)
    }

    // Lógica para saber si podemos volver atrás (para mostrar la flechita)
    val canNavigateBack = navController.previousBackStackEntry != null

    Scaffold(
        topBar = {
            //Primero crear lo de abajo y luego llamar
            DoctorTopAppBar(
                title = currentScreenTitle,
                canNavigateBack = canNavigateBack,
                navigateUp = { navController.navigateUp() }
                )
        }
    ) { innerPadding ->
        // Aquí es donde el alumno implementará más tarde el NavHost
        // De momento, mostramos la lista directamente para que tengan algo visual
        DoctorRoundNavHost(
            navController = navController,
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}


