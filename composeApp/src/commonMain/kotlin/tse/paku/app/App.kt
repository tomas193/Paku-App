package tse.paku.app

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.Button
import androidx.compose.runtime.remember
import androidx.compose.material3.*
import io.ktor.client.HttpClient
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.client.statement.*

@Composable
@Preview
fun App() {
    val currentScreen = remember { mutableStateOf<Screen>(Screen.Home) }
    AppNavigator(currentScreen = currentScreen)
}
expect fun httpClient(): HttpClient

@Serializable
data class MyResponse(val message: String)

class ApiClient {
    private val client = httpClient()

    suspend fun fetchMessage(): MyResponse {
        val response: MyResponse = client.get("http://18.222.114.64/api/message") {
            // Puedes agregar headers aquí si es necesario
        }.body()
        return response
    }
}

