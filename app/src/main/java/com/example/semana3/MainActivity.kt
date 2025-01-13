package com.example.semana3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semana3.ui.theme.Semana3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainApp()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MainApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { Home(navController) }
    }
}

val comidasLunes = listOf(
    "Desayuno" to listOf("Tostadas", "Leche", "Jugo Naranja"),
    "Almuerzo" to listOf("Verduras al horno", "Arroz"),
    "Cena" to listOf("Ensalada con nueces", "Sandwich de pavo")
)

val comidasMartes = listOf(
    "Desayuno" to listOf("Smoothie verde", "Tostada integral con aguacate"),
    "Almuerzo" to listOf("Filete de salmon", "Verduras salteadas"),
    "Cena" to listOf("Sopa de lentejas", "Ensalada de lechuga y tomate")
)

val comidasMiercoles = listOf(
    "Desayuno" to listOf("Yogurt griego natural", "Granola sin azúcar", "Frutos rojos"),
    "Almuerzo" to listOf("Pechuga de pollo a la plancha", "Brócoli al vapor", "Arroz integral"),
    "Cena" to listOf("Wrap integral de hummus y vegetales", "Infusión de manzanilla")
)

val comidasJueves = listOf(
    "Desayuno" to listOf("Pan integral con crema de almendras", "Plátano", "Café sin azúcar"),
    "Almuerzo" to listOf("Merluza al horno con hierbas", "Puré de coliflor"),
    "Cena" to listOf("Gazpacho de tomate", "Bastones de zanahoria y apio")
)

val comidasViernes = listOf(
    "Desayuno" to listOf("Chía hidratada con leche vegetal", "Mango", "Té rooibos"),
    "Almuerzo" to listOf("Ensalada mediterránea ", "Pan pita integral"),
    "Cena" to listOf("Crema de espinacas", "Tostada integral")
)

val comidasSabado = listOf(
    "Desayuno" to listOf("Avena y plátano", "Miel natural", "Cafe con leche de avena"),
    "Almuerzo" to listOf("Bowl de arroz, tofu, aguacate y semillas de sésamo"),
    "Cena" to listOf("Puré de zanahoria", "Pechuga de pollo al horno", "Té verde")
)

val comidasDomingo = listOf(
    "Desayuno" to listOf("Tostadas de pan integral con aguacate y tomate", "Zumo de naranja natural"),
    "Almuerzo" to listOf("Asado de verduras ", "Quinoa"),
    "Cena" to listOf("Omelette de claras con espinacas", "Infusión de hierbas")
)


@Composable
fun Home(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment  = Alignment.CenterHorizontally,
        verticalArrangement  = Arrangement.Top
    ){
        item {
            ComidaDiaria(dia = "Lunes", comidas = comidasLunes)

        }
        item {
            ComidaDiaria(dia = "Martes", comidas = comidasMartes)

        }
        item {
            ComidaDiaria(dia = "Miercoles", comidas = comidasMiercoles)

        }

        item {
            ComidaDiaria(dia = "Jueves", comidas = comidasJueves)

        }

        item {
            ComidaDiaria(dia = "Viernes", comidas = comidasViernes)

        }

        item {
            ComidaDiaria(dia = "Sabado", comidas = comidasSabado)

        }

        item {
            ComidaDiaria(dia = "Domingo", comidas = comidasDomingo)

        }

    }
}
@Composable
fun ComidaDiaria(dia: String, comidas: List<Pair<String, List<String>>>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = dia,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 16.dp)

            )
        }

        comidas.forEach { comida ->
            CardComidas(hora = comida.first, items = comida.second)
        }
    }
}

@Composable
fun CardComidas(
    hora: String,
    items: List<String>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.elevatedCardElevation(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = hora,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            items.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Text(
                        text = "•",
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = item,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}