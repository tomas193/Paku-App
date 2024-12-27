package tse.paku.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

sealed class Screen {
    object Home : Screen()
    object Details : Screen()
    object Movies : Screen()
    object Form : Screen()

}
//cuando se agreguen mas pantallas, agregar las nuevas pantallas a las listas screens y screenDetails del archivo templateScreen.kt
@Composable
fun AppNavigator(currentScreen: MutableState<Screen>) {
    when (val screen = currentScreen.value) {
        is Screen.Home -> HomeScreen(onNavigate = { currentScreen.value = it })
        is Screen.Details -> DetailsScreen(onNavigate = { currentScreen.value = it })
        is Screen.Movies -> MovieScreen(onNavigate = { currentScreen.value = it })
        is Screen.Form -> FormScreen(onNavigate = { currentScreen.value = it })

    }
}
