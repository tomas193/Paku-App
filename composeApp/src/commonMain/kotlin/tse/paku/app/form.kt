package tse.paku.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import io.ktor.http.HttpMessage

@Composable
fun FormScreen(onNavigate: (Screen) -> Unit) {
    templateScreen( //para mas informacion abrir templateScreen.kt
        onNavigate,
        topBarContent = {
            Text("Form", color = Color.White)
        },
        bodyContent = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentAlignment = Alignment.Center,
            ) {
                TextFieldExample()
            }
        }
    )
}

@Composable
fun TextFieldExample() {
    // Variable que almacena el texto ingresado
    val inputLabels = listOf("Name", "Email")
    val inputValues = remember { mutableStateListOf("","") }
    val (clicked, setClicked) = remember { mutableStateOf(false) }

    // Contenedor con un TextField
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Entrada de texto
        for (i in inputLabels.indices){
            TextField(
                value = inputValues[i],
                onValueChange = { newText -> inputValues[i] = newText }, // Actualiza el valor cuando el texto cambia
                label = { Text(inputLabels[i]) }, // Etiqueta del TextField
                modifier = Modifier.fillMaxWidth(), // Hace que el TextField ocupe todo el ancho disponible
                singleLine = true // Para que el TextField sea de una sola línea
            )
        }
        Button(onClick = { setClicked(true) }) {
            Text("Send")
        }
        if (clicked) {
            sendData(inputLabels,inputValues)
        }
    }
}

@Composable
fun sendData(labels: List<String>,values: List<String>){
    for (i in values.indices){
        var value = values[i]
        var label = labels[i]
        Text("$label: $value")
    }
}



