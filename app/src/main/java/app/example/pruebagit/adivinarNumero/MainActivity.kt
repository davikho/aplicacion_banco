package app.example.pruebagit.adivinarNumero

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.example.pruebagit.calculadorApp.MainActivity2
import app.example.pruebagit.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {//llave de incio de la clase

    private lateinit var etGuess: EditText
    private lateinit var btnGuess: Button
    private lateinit var tvFeedback: TextView
    private lateinit var tvAttempts: TextView
    private lateinit var btnReset: Button

    private var randomNumber = 0
    private var attemptsRemaining = 10


    override fun onCreate(savedInstanceState: Bundle?) {//llave de inicio deml metodo onCreste
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        etGuess = findViewById(R.id.etGuess)
        btnGuess = findViewById(R.id.btnGuess)
        tvFeedback = findViewById(R.id.tvFeedback)
        tvAttempts = findViewById(R.id.tvAttempts)
        btnReset = findViewById(R.id.btnReset)
        //variable de tipo local que se utiliza para navegar hacia otra pantalla
        val nuevaPantalla=findViewById<Button>(R.id.btnIrNuevaPantalla)
        nuevaPantalla.setOnClickListener {
            val intent=Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        startGame()

        btnGuess.setOnClickListener {
            checkGuess()
        }

        btnReset.setOnClickListener {
            startGame()
        }


    }//llave de cierre del metodo oncreate

    private fun startGame() {
        randomNumber = Random.nextInt(1, 101)
        attemptsRemaining = 10
        tvFeedback.text = "¡Adivina el número!"
        tvAttempts.text = "Intentos restantes: $attemptsRemaining"
        etGuess.text.clear()
    }

    private fun checkGuess() {
        val guessString = etGuess.text.toString()

        if (guessString.isEmpty()) {
            tvFeedback.text = "Ingresa un número"
            return
        }

        val guess = guessString.toInt()

        if (guess < 1 || guess > 100) {
            tvFeedback.text = "Ingresa un número entre 1 y 100"
            return
        }

        attemptsRemaining--
        tvAttempts.text = "Intentos restantes: $attemptsRemaining"

        when {
            guess == randomNumber -> {
                tvFeedback.text = "¡Correcto! Has adivinado el número."
                disableButtons()
            }
            guess < randomNumber -> tvFeedback.text = "Demasiado bajo. Intenta con un número más alto."
            else -> tvFeedback.text = "Demasiado alto. Intenta con un número más bajo."
        }

        if (attemptsRemaining == 0 && guess != randomNumber) {
            tvFeedback.text = "Has perdido. El número era $randomNumber"
            disableButtons()
        }
    }

    private fun disableButtons() {
        btnGuess.isEnabled = false
        // You might want to disable the EditText as well
        etGuess.isEnabled = false
    }


}//llave de cierre de la clase