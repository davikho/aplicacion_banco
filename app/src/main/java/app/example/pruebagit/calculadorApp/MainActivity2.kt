package app.example.pruebagit.calculadorApp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.example.pruebagit.R

class MainActivity2 : AppCompatActivity() { //llave de incio de la clase
    //declarando variables globales
    private lateinit var numero1: EditText
    private lateinit var numero2: EditText
    private lateinit var sumar: Button
    private lateinit var restar: Button
    private lateinit var tvMostrar: TextView
    private lateinit var operacion: CalcularOperacion

//consular que es el viewBinding
    override fun onCreate(savedInstanceState: Bundle?) {//llave de inicio del metodo onCreate
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //inicializando variables globales
        numero1 = findViewById<EditText>(R.id.etNum1)
        numero2 = findViewById(R.id.etNum2)
        sumar = findViewById(R.id.btnSumar)
        restar = findViewById(R.id.btnRestar)
        tvMostrar = findViewById(R.id.tvMostrarRespuesta)
        operacion = CalcularOperacion()

        //onClick para sumar
        sumar.setOnClickListener { sumar() }

        //onClick para restar
        restar.setOnClickListener { restar() }


    }//llave de cierre del metodo onCreate

    //función para sumar dos números
    private fun sumar() {
        val valor=validarDatos()
        if (valor) {
            //creando objeto de la clase CalcularOperacion
            tvMostrar.setText("la suma es= ${operacion.sumar()}")
        } else {
            Toast.makeText(this, "completa los datos", Toast.LENGTH_SHORT).show()
        }

    }
    //función para restar

    private fun restar() {
        if (validarDatos()) {
            //creando objeto de la clase CalcularOperacion

            tvMostrar.setText("la resta es= ${operacion.restar()}")
        } else {
            Toast.makeText(this, "completa los datos", Toast.LENGTH_SHORT).show()
        }

    }

    //función para validar la entrada de datos
    private fun validarDatos(): Boolean {
        //recuperamos lo que el usuario ha ingresado en el editText
        val num1 = numero1.text.toString() //89
        val num2 = numero2.text.toString()
        //isNullOrEmpty() devuelve true si esta vacio o es nulo

        //                                  num2= " " true = false
        // num1=3   false =true             num2= 4 false =true
        if (!num1.isNullOrEmpty() && !num2.isNullOrEmpty()) {
            operacion.num1=num1.toInt()
            operacion.num2=num2.toInt()
            return true
        }
        return false
    }

}//llave de cierre de la clase