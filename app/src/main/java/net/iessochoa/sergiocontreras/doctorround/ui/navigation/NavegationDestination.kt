package net.iessochoa.sergiocontreras.doctorround.ui.navigation

interface NavigationDestination {
    // TODO: TAREA 3 - Define las propiedades de la interfaz
    // Consulta el "NAVIGATION HELPER" (si no te acuerdas) para saber qué propiedades necesitas
    // para gestionar la ruta de navegación y el título de la pantalla.
    val route: String
    val titleRes: Int
}