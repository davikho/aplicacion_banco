package app.example.pruebagit.appBanco

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import app.example.pruebagit.R
import app.example.pruebagit.appBanco.data.Banco
import app.example.pruebagit.appBanco.data.Usuario
import app.example.pruebagit.databinding.ActivityCuentaUsuarioBinding
import com.bumptech.glide.Glide

class CuentaUsuario : AppCompatActivity() { // Clase CuentaUsuario que hereda de AppCompatActivity
    private lateinit var binding: ActivityCuentaUsuarioBinding // Declaración de una variable de enlace de vista
    private var usuarioActual: Usuario? = null // Variable para almacenar el usuario actual
    private val data by lazy { Banco(this) } // Instancia de la clase Banco
    private var user: Usuario? = null // Variable para almacenar un usuario
    private var isTransferSectionVisible = false // Controla la visibilidad de la sección

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) { // Metodo onCreate que se llama al crear la actividad
        super.onCreate(savedInstanceState) // Llama al metodo onCreate de la clase padre
        binding = ActivityCuentaUsuarioBinding.inflate(layoutInflater) // Infla el diseño de la actividad
        setContentView(binding.root)// Establece el diseño de la actividad

        getInformationUser()   // Obtiene información del usuario actual
        setupListeners()
    }

    private fun setupListeners() { // Configuración de los listeners de los botones
        // Manejar botón de búsqueda de usuario
        binding.btnBuscarUsuario.setOnClickListener { // Listener para el botón de búsqueda de usuario
            searchUser() // Llama a la función searchUser para realizar la búsqueda
        }

        // Manejar botón de transferir dinero
        binding.btnTranfesrir.setOnClickListener { // Listener para el botón de transferir dinero
            transferirDinero() // Llama a la función transferirDinero para realizar la transferencia
        }

        // Botón de "Retirar" con mensaje informativo
        binding.cardRetirar.setOnClickListener { // Listener para el botón de retirar dinero
            Toast.makeText(this, "Función próximamente habilitada", Toast.LENGTH_SHORT).show() // Muestra un mensaje informativo
        }

        // Manejar botón de transferir (mostrar/ocultar sección)
        binding.cardTransferir.setOnClickListener { // Listener para el botón de transferir dinero
            toggleTransferSection() // Llama a la función toggleTransferSection para mostrar/ocultar la sección de transferencia
        }

        // Botón salir
        binding.imageSalir.setOnClickListener { // Listener para el botón de salir
            startActivity(Intent(this, IniciarSesion::class.java)) // Inicia la actividad IniciarSesion
            finish() // Finaliza la actividad actual
        }
    }

    private fun toggleTransferSection() { // Función para mostrar/ocultar la sección de transferencia
        isTransferSectionVisible = !isTransferSectionVisible // Cambia el estado de visibilidad
        binding.layoutTransferir.visibility = if (isTransferSectionVisible) View.VISIBLE else View.GONE // Muestra/oculta la sección de transferencia
    }

    private fun transferirDinero() { // Función para realizar la transferencia de dinero
        val dinero = binding.etCantidadDepositar.text.toString().trim() // Obtiene el monto a depositar
        if (dinero.isNotEmpty()) {    // Verifica si el monto no está vacío
            usuarioActual = data.retirar(dinero.toFloat(), usuarioActual!!) // Realiza la operación de retiro
            binding.tvSaldoUsuario.text = usuarioActual?.saldo.toString() // Actualiza el saldo en la interfaz de usuario
            data.transferir(dinero.toFloat(), user!!) // Realiza la operación de transferencia
        } else {    // Si el monto está vacío, muestra un mensaje de error
            Toast.makeText(this, "Por favor ingresa un monto válido", Toast.LENGTH_SHORT).show() // Muestra un mensaje de error
        }
    }

    private fun searchUser() { // Función para buscar un usuario
        val cedula = binding.etUsuarioEncontrado.text.toString().trim() // Obtiene el número de cédula a buscar
        if (cedula.isNotEmpty()) { // Verifica si el número de cédula no está vacío
            user = data.buscarUsuario(cedula) // Realiza la búsqueda del usuario
            if (user != null) { // Si se encuentra un usuario, muestra sus detalles en la interfaz de usuario
                Glide.with(this).load(user!!.imagen.toUri()).into(binding.imagenUsuarioBuscado) // Carga la imagen del usuario
                binding.tvNombreUsuarioB.text = user!!.nombre // Muestra el nombre del usuario
            } else { // Si no se encuentra un usuario, muestra un mensaje de error
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show() // Muestra un mensaje de error
            }
        } else { // Si el número de cédula está vacío, muestra un mensaje de error
            Toast.makeText(this, "Por favor ingresa un número de cuenta", Toast.LENGTH_SHORT).show() // Muestra un mensaje de error
        }
    }

    private fun getInformationUser() { // Función para obtener la información del usuario actual
        usuarioActual = intent.getParcelableExtra("user") // Obtiene el usuario actual de la actividad anterior
        usuarioActual?.let { newUser -> // Si el usuario actual no es nulo, muestra sus detalles en la interfaz de usuario
            binding.title.text = "Hola ${newUser.nombre}" // Muestra el saludo con el nombre del usuario
            binding.tvSaldoUsuario.text = "Tu saldo es: ${newUser.saldo}" // Muestra el saldo del usuario
            Glide.with(this).load(newUser.imagen.toUri()).into(binding.imageViewC) // Carga la imagen del usuario
        }
    }
}
