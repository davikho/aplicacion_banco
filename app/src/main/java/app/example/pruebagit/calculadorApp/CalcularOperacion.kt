package app.example.pruebagit.calculadorApp

class CalcularOperacion(var num1:Int=0,var num2:Int=0): Operacion {

    //¿Qué es una interfaz consultar?

    override fun sumar()=num1+ num2


    override fun restar():Int{
        return num1-num2
    }

}