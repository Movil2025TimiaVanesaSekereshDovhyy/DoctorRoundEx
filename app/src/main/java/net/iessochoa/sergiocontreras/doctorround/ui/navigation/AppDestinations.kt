package net.iessochoa.sergiocontreras.doctorround.ui.navigation
import net.iessochoa.sergiocontreras.doctorround.R

/**
 * Contrato que deben cumplir todos los destinos de navegación de la App.
 */

// Destino 1: La pantalla principal (Lista de Pacientes)
object PatientListDestination : NavigationDestination {
    // TODO: Implementa las propiedades de la interfaz para la pantalla de lista
    // Pista: La ruta puede ser "patient_list"

    override val route = "patient_list"
    override val titleRes = R.string.app_name
}

// Destino 2: La pantalla secundaria (Detalle del Paciente)
object PatientDetailDestination : NavigationDestination {
    // TODO: Implementa las propiedades de la interfaz para la pantalla de detalle
    // Pista: La ruta puede ser "patient_detail"
    override val route = "patient_detail"
    override val titleRes = R.string.title_patient_detail

}