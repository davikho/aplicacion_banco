package app.example.pruebagit.appBanco

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.example.pruebagit.R
import app.example.pruebagit.appBanco.data.Data
import app.example.pruebagit.appBanco.data.Usuario
import app.example.pruebagit.databinding.ActivityRegistrarUsuarioBinding
import com.bumptech.glide.Glide

class RegistrarUsuario : AppCompatActivity() { // Clase RegistrarUsuario que hereda de AppCompatActivity
    /*
    me permite enlazar las vistas directamente
     */
    var id = 0
    var imagen=""
    private lateinit var binding: ActivityRegistrarUsuarioBinding // Declaración de una variable de enlace de vista

    override fun onCreate(savedInstanceState: Bundle?) { // Metodo onCreate que se llama al crear la actividad
        super.onCreate(savedInstanceState) // Llama al metodo onCreate de la clase padre
        enableEdgeToEdge() // Habilita el modo de borde para la actividad
        binding = ActivityRegistrarUsuarioBinding.inflate(layoutInflater) // Infla el diseño de la actividad
        setContentView(binding.root) // Establece el diseño de la actividad
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets -> // Configura el listener de insets para la vista
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom) // Establece el padding de la vista
            insets
        }
        binding.btnRegistrar.setOnClickListener { // Listener para el botón de registro de usuario
            registarUsuario()   // Llama a la función registarUsuario para realizar el registro
        }
        binding.imageCambiar.setOnClickListener { selectImage() } // Listener para el botón de cambio de imagen
    }

    private fun registarUsuario() { // Función para realizar el registro de un usuario
        val nombre = binding.nombreUsuario.text.toString().trim() // Obtiene el nombre del usuario
        val pass = binding.passwordUsuario.text.toString().trim() // Obtiene la contraseña del usuario
        val saldo = binding.saldoUsuario.text.toString().trim() // Obtiene el saldo del usuario
        val cedula = binding.numeroCedula.text.toString().trim() // Obtiene la cédula del usuario


        val newUser = Usuario(id++, cedula, nombre, saldo.toFloat(), "", pass, imagen)  // Crea un nuevo usuario con los datos ingresados
        irNuevaPantalla(newUser) // Llama a la función irNuevaPantalla para ir a la pantalla de usuario
        val data = Data(this) // Instancia de la clase Data para guardar el usuario
        data.saveUser(newUser) // Guarda el usuario en la base de datos


        Toast.makeText(this, "usuario registrado", Toast.LENGTH_SHORT).show() // Muestra un mensaje de éxito

    }

    private fun irNuevaPantalla(usuario: Usuario) { // Función para ir a la pantalla de usuario
        val intent = Intent(this, CuentaUsuario::class.java) // Crea un intent para ir a la pantalla de usuario
        intent.putExtra("user", usuario) // Pasa el usuario como extra en el intent
        startActivity(intent) // Inicia la actividad CuentaUsuario
    }


    private fun selectImage() { // Función para seleccionar una imagen
        val intent = Intent(Intent.ACTION_GET_CONTENT) // Crea un intent para seleccionar una imagen
        intent.type = "image/*" // Establece el tipo de contenido a imagen
        register.launch(intent) // Inicia la actividad de selección de imagen
    }

    val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { // Registra el resultado de la actividad de selección de imagen
        if (it.resultCode == Activity.RESULT_OK) { // Verifica si el resultado es OK
            val intent = it.data // Obtiene los datos del intent
            val uri = intent?.data // Obtiene la URI de la imagen seleccionada
            imagen=uri.toString() // Guarda la URI en la variable imagen
            Glide.with(this).load(uri).into(binding.image) // Carga la imagen en la vista
        }
    }
    val data by lazy { Data(this) }

}