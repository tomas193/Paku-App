package tse.paku.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun templateScreen(
    onNavigate: (Screen) -> Unit,
    topBarContent: @Composable () -> Unit = {}, // Contenido de la barra superior
    bodyContent: @Composable (PaddingValues) -> Unit // Contenido principal
){
    val screens= listOf(Screen.Home,Screen.Details,Screen.Movies,Screen.Form)
    val screenDetails = listOf("Home", "Details", "Movies", "Form")
    Scaffold(
        topBar = {
            TopAppBar(
                title = { topBarContent()},
                colors =  TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF091C47) // Usa containerColor en Material3
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White
            ) {
                //elementos de bottom navbar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center, // Centra los elementos horizontalmente
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in screens.indices){
                        Button(onClick = { onNavigate(screens[i]) },modifier = Modifier.weight(1f), //esto cambia. necesito saber pantalla
                            colors = ButtonDefaults.buttonColors(                                   // actual y disponibles
                                containerColor = Color(0xFF091C47), // Color de fondo del botón
                                contentColor = Color.White // Color del texto
                            )) {
                            Text(screenDetails[i])
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        // El contenedor de en medio
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Para que el contenido no quede tapado por las barras
        ) {
            bodyContent(paddingValues)
        }
    }
}