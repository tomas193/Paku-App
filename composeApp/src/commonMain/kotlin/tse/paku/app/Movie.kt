package tse.paku.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

data class Movie(
    val id: Int,
    val title: String,
    val poster: String
)

val movies = (1..100).map { it:Int ->
    Movie(
        id=it,
        title= "Movie $it",
        poster="https://picsum.photos/200/300?id=$it"
    )
}
//LazyHorizontalGrid: scroll horizontal. elementos se acomodan de izquierda a derecha.
//LazyVerticalGrid: scroll vertical. elementos se acomodan de arriba hacia abajo.

@Composable
fun MovieScreen(onNavigate: (Screen) -> Unit) {//aqui se manda a llamar la funcion template screen y se le pasan argumentos del contenido
    templateScreen( //para mas informacion abrir templateScreen.kt
        onNavigate,
        topBarContent = {
            Text("Movies", color = Color.White)
        },
        bodyContent = { paddingValues ->
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                MovieContent()
            }
        }
    )
}

@Composable
fun MovieContent(){
    MaterialTheme {
        Surface(/*modifier = Modifier.fillMaxSize()*/){ //Surface gestiona colores de la UI dependiendo del tema seleccionado
            LazyVerticalGrid( //listado que contiene filas y columnas
                columns = GridCells.Adaptive(120.dp), //cada columna ocupa minimo 120 dp pero utiliza todas las columnas necesarias para ocupar todo el espacio disponible
                contentPadding = PaddingValues(4.dp), //padding al contenido
                horizontalArrangement = Arrangement.spacedBy(4.dp), //separacion horizontal entre elementos
                verticalArrangement = Arrangement.spacedBy(4.dp) //separacion vertical entre elementos
            ){
                items(movies, key={it.id}){//toma la lista de objetos movies y toms el id como la llave de cada item
                    MovieItem(movie=it)//los items seran los contenedores de la clase MovieItem
                }
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie){//parametro y tipo de dato, en este caso la clase Movie
    Column{
        AsyncImage(
            model=movie.poster, //fuente de la imagen
            contentDescription=movie.title, //descripcion de la imagen
            contentScale= ContentScale.Crop, //cortar imagen si es necesario para llenar el contenedor
            modifier= Modifier
                .fillMaxWidth()
                .aspectRatio(1f)//relacion entre ancho y largo
                .clip(MaterialTheme.shapes.small)//pequeño redondeo de las esquinas del contenedor

        )
        Text( //contenedor de texto
            text=movie.title,//contenido del texto
            style= MaterialTheme.typography.bodySmall,//tipografia del texto
            maxLines = 1,//texto se representa en 1 sola linea, se trunca si excede el ancho
            textAlign = TextAlign.Center, //alineacion del texto
            modifier = Modifier
                .fillMaxWidth() //llenar el contenedor con todo el ancho posible
                .padding(8.dp) //margen interno del contenedor
        )
    }
}
