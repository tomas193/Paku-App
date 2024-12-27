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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar

@Composable
fun DetailsScreen(onNavigate: (Screen) -> Unit) {
    templateScreen( //para mas informacion abrir templateScreen.kt
        onNavigate,
        topBarContent = {
            Text("Details", color = Color.White)
        },
        bodyContent = { paddingValues ->
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
               Text("Welcome to details")
            }
        }
    )
}
