package com.example.semana3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.*

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
    NavHost(navController = navController, startDestination = "login") {
        composable("home") { Home(navController) }
        composable("login") { Login(navController) }
    }
}

class Comida(val tipo: String, val platos: List<String>)
class DiaComidas(val dia: String, val comidas: List<Comida>)


fun crearMenuSemanal(): List<DiaComidas> {
    return listOf(
        DiaComidas(
            "Lunes",
            listOf(
                Comida("Desayuno", listOf("Tostadas", "Leche", "Jugo Naranja")),
                Comida("Almuerzo", listOf("Verduras al horno", "Arroz")),
                Comida("Cena", listOf("Ensalada con nueces", "Sandwich de pavo"))
            )
        ),
        DiaComidas(
            "Martes",
            listOf(
                Comida("Desayuno", listOf("Smoothie verde", "Tostada integral con aguacate")),
                Comida("Almuerzo", listOf("Filete de salmon", "Verduras salteadas")),
                Comida("Cena", listOf("Sopa de lentejas", "Ensalada de lechuga y tomate"))
            )
        ),
        DiaComidas(
            "Miércoles",
            listOf(
                Comida("Desayuno", listOf("Yogurt griego natural", "Granola sin azúcar", "Frutos rojos")),
                Comida("Almuerzo", listOf("Pechuga de pollo a la plancha", "Brócoli al vapor", "Arroz integral")),
                Comida("Cena", listOf("Wrap integral de hummus y vegetales", "Infusión de manzanilla"))
            )
        ),
        DiaComidas(
            "Jueves",
            listOf(
                Comida("Desayuno", listOf("Pan integral con crema de almendras", "Plátano", "Café sin azúcar")),
                Comida("Almuerzo", listOf("Merluza al horno con hierbas", "Puré de coliflor")),
                Comida("Cena", listOf("Gazpacho de tomate", "Bastones de zanahoria y apio"))
            )
        ),
        DiaComidas(
            "Viernes",
            listOf(
                Comida("Desayuno", listOf("Chía hidratada con leche vegetal", "Mango", "Té rooibos")),
                Comida("Almuerzo", listOf("Ensalada mediterránea", "Pan pita integral")),
                Comida("Cena", listOf("Crema de espinacas", "Tostada integral"))
            )
        ),
        DiaComidas(
            "Sábado",
            listOf(
                Comida("Desayuno", listOf("Avena y plátano", "Miel natural", "Café con leche de avena")),
                Comida("Almuerzo", listOf("Bowl de arroz, tofu, aguacate y semillas de sésamo")),
                Comida("Cena", listOf("Puré de zanahoria", "Pechuga de pollo al horno", "Té verde"))
            )
        ),
        DiaComidas(
            "Domingo",
            listOf(
                Comida("Desayuno", listOf("Tostadas de pan integral con aguacate y tomate", "Zumo de naranja natural")),
                Comida("Almuerzo", listOf("Asado de verduras", "Quinoa")),
                Comida("Cena", listOf("Omelette de claras con espinacas", "Infusión de hierbas"))
            )
        )
    )
}


@Composable
fun Home(navController: NavHostController) {
    val menuSemanal = crearMenuSemanal()
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

        for (i in menuSemanal.indices){
            item {
                ComidaDiaria(dia = menuSemanal[i].dia, comidas = menuSemanal[i].comidas)
            }
        }

    }
}

@Composable
fun Login(navController: NavHostController) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.alimentos))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val usuarios = listOf(
        Pair("test1@test.com", "123456")
    )

    LaunchedEffect(Unit) {
        Toast.makeText(
            context,
            "USER PRUEBA test1@test.com 123456",
            Toast.LENGTH_SHORT
        ).show()
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )

    Column(
        modifier = Modifier
            .padding(50.dp)
            .fillMaxSize(),
        horizontalAlignment  = Alignment.CenterHorizontally,
        verticalArrangement  = Arrangement.Center
    ){
        LottieAnimation(
            composition = composition,
            progress = {progress },
            modifier = Modifier.size(200.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
                .semantics {
                    contentDescription = "Campo para ingresar el email de su cuenta"
                },
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
                .semantics {
                    contentDescription = "Campo para ingresar la contraseña de su cuenta"
                },
        )

        Button(
            onClick = {
                //navController.navigate("dashboard")
                val usuarioValido = usuarios.any { it.first == email && it.second == password }
                //test1@test.com
                //123456
                if (email == "test1@test.com" && password == "123456") {
                    navController.navigate("home")
                } else {
                    Toast.makeText(
                        context,
                        "Correo o contraseña incorrecta",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
        ) {
            Text("Ingresar")
        }

        Text(
            modifier = Modifier.clickable {
                navController.navigate("registro")
            },
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 18.sp,
            text = "Registrarse",
            maxLines = 1
        )


    }
}

@Composable
fun ComidaDiaria(dia: String, comidas: List<Comida>) {

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = dia,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.elevatedCardElevation(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ){
        //class Comida(val tipo: String, val platos: List<String>)
        Column(modifier = Modifier.padding(16.dp)) {

            comidas.forEach { comida ->
                Text(
                    text = "${comida.tipo}",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                comida.platos.forEach { plato ->
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
                            text = "${plato}",
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 18.sp,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

            }
        }
    }

}

@Composable
fun Dashboard(navController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
}