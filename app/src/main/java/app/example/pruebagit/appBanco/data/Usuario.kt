package app.example.pruebagit.appBanco.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
 data class Usuario (
     val id:Int,
     val numeroCedula:String,
     val nombre:String,
     val saldo:Float,
     val tipoCuenta:String,
     val password:String,
     val imagen:String
 ):Parcelable


