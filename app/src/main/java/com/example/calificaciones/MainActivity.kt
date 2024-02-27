package com.example.calificaciones

import android.os.Bundle
import android.text.TextUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calificaciones.ui.theme.CalificacionesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalificacionesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}
@Preview(showBackground=true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calificaciones(){
    var materiaUno:Double by remember{
        mutableStateOf(0.0)
    }
    var materiaDos:Double by remember{
        mutableStateOf(0.0)
    }
    var materiaTres:Double by remember{
        mutableStateOf(0.0)
    }
    var promedio:String by remember{
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            //.fillMaxSize()
            .height(3000.dp)
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text="Calificaciones")
        OutlinedTextField(value = materiaUno.toString(), onValueChange ={
            materiaUno = checkWroteNumber(it)
        }, label = {
            Text(text = "Primera Calificacion")
        }, placeholder = {
            Text(text = "Por Favor escriba su calificacion")
        }, leadingIcon = {
            Icon(imageVector = Icons.Default.Star, contentDescription = "Icono de Estrella")
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = materiaDos.toString(), onValueChange ={
            materiaDos = checkWroteNumber(it)
        }, label = {
            Text(text = "Segunda Materia")
        }, placeholder = {
            Text(text = "Por Favor escriba su Calificación")
        }, leadingIcon = {
            Icon(imageVector = Icons.Default.Star, contentDescription = "Icono de Estrella")
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = materiaTres.toString(), onValueChange ={
            materiaTres = checkWroteNumber(it)
        }, label = {
            Text(text = "Tercera Materia")
        }, placeholder = {
            Text(text = "Por Favor escriba su Calificación")
        }, leadingIcon = {
            Icon(imageVector = Icons.Default.Star, contentDescription = "Icono de Estrella")
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick={
            promedio = ((materiaUno + materiaDos + materiaTres)/3).toString()

        }){
            Text(text = "Sumar")
        }
        Text(text = promedio)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
    fun checkWroteNumber(text: String):Double{
        if (text.toDoubleOrNull() != null) {
            return text.toDouble()
        }else if (TextUtils.isEmpty(text)){
            return 0.0
        }
        return 1.0
    }

fun frase(promedio: Double): String {
    if (promedio < 7.0) {
        return "El alumno repetirá el semestre"
    } else if (promedio < 8.5) {
        return "Has perdido 5% de beca"
    } else {
        return "Felicidades eres un estudiante de honor"
    }
    return ""
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalificacionesTheme {
        Calificaciones()
    }
}