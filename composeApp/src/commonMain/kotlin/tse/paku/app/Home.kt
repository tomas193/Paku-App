package tse.paku.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HomeScreen(onNavigate: (Screen) -> Unit) {
    templateScreen( //para mas informacion abrir templateScreen.kt
        onNavigate,
        topBarContent = {
            Text("Home Screen", color = Color.White)
        },
        bodyContent = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Text("Welcome to Home", style = MaterialTheme.typography.bodySmall)
            }
        }
    )
}