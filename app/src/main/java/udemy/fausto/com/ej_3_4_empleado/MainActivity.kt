package udemy.fausto.com.ej_3_4_empleado

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var plantilla = arrayListOf<Empleado>()
    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButtonID.setOnClickListener {
            it.hideKeyboard()
            crearEmpleado()

        }

    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    fun crearEmpleado() {
        val name = nombreEditTextID.text.toString()
        val age = edadEditTextID.text.toString().toInt()
        val wage = sueldoEditTextID.text.toString().toInt()

        val employee = Empleado(name, age, wage)

        plantilla.add(employee)
        num = plantilla.size

        numTextViewID.text = num.toString()


        plantilla.forEach {
            println("------------>")
            println(it.nombre)
            println(it.sueldo)
            it.debePagarImpuestos()
            it.mostrarEdad()
        }
    }

}


open class Persona(nombre: String, edad: Int) {
    open var nombre: String = ""
        get() = "($field)"

    var edad: Int = 0


    init {
        this.nombre = nombre.capitalize()
        if (edad < 0) this.edad = 0 else this.edad = edad
    }

    fun printProperties() {
        println("nombre: $nombre, edad: $edad")
    }

    fun mostrarSiMayor() {
        if (edad >= 18) {
            println("$nombre es mayor de edad")

        } else {
            println("$nombre es menor de edad")
        }

    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }


}

class Empleado(nombre: String, edad: Int, var sueldo: Int) : Persona(nombre, edad) {

    fun debePagarImpuestos(): Boolean {
        var bool = false
        if (sueldo > 3000) {
            println("$nombre debe pagar impuestos")
            bool = true
        } else {
            println("$nombre NO debe pagar impuestos")
            bool = false
        }
        return bool
    }

    override var nombre: String = ""

    init {
        this.nombre = nombre
    }

    fun mostrarEdad() {
        println("$nombre tiene $edad años de edad")
    }
}


