package app.example.pruebagit.animaciones

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.example.pruebagit.R
import app.example.pruebagit.appBanco.CuentaUsuario
import app.example.pruebagit.appBanco.IniciarSesion
import app.example.pruebagit.appBanco.RegistrarUsuario

class SegundaAnimacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda_animacion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navegarPantalla()
    }
    fun navegarPantalla(){
        val handler= android.os.Handler().postDelayed({
            startActivity(Intent(this,IniciarSesion::class.java))
            finish()
        },2500)
    }
    /*

    App Calculadora
    ui
    tiempo : 1semana
    1.-Edit Text para la entrada de datos
    2.-BOTONES
    3.-Diseño de la ui

LÓGICA
tiempo 1 semana
1.-Edit Text para la entrada de datos -> Recupera información del usuario
  validar la información obtenida
  tiempo 1 semana
2.- 2.-BOTONES  una vez que presione el boton va a sumar otro restar otro multiplicar



     */

    /*
    proyecto personal -> examen tiempo un mes
    repositorio con las aplicaciones
    android apk
    python .exe
    java .apk
     */
}