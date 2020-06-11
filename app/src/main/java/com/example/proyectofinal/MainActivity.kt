package com.example.proyectofinal

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.preference.PreferenceManager
import com.example.proyectofinal.data.Comida
import com.example.proyectofinal.data.ComidaDatabase
import com.example.proyectofinal.data.ComidaRepository
import com.example.proyectofinal.ui.gallery.ComidaAdapter
import com.example.proyectofinal.ui.gallery.Model
import kotlinx.android.synthetic.main.inner.*
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration


    private val comidaViewModel: ComidaViewModel by viewModels {
        ComidaViewModelFactory(ComidaRepository(ComidaDatabase.getDatabase(applicationContext).comidaDao()))

    }
       // ComidaViewModelFactory(ComidaRepository(ComidaDatabase.getDatabase(applicationContext).comidaDao()))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)



        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
          //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //  .setAction("Action", null).show()

           val comida = Comida(id = 1, nombre = "Hamburguesa", precio = 50, detalle = "Carne, Queso, jamon")
            val comida1 = Comida(id = 2, nombre = "Papas a la Francesa", precio = 25, detalle = "Paesas")
            val comida2 = Comida(id = 3, nombre = "Burrito", precio = 40, detalle = "Paesas")
            val comida3 = Comida(id = 4, nombre = "Tacos", precio = 35, detalle = "Paesas")
            val comida4 = Comida(id = 5, nombre = "Nachos", precio = 30, detalle = "Paesas")
            val comida5 = Comida(id = 6, nombre = "Nieve", precio = 15, detalle = "Paesas")
            val comida6 = Comida(id = 7, nombre = "Nachos con carne", precio = 45, detalle = "Paesas")
            val comida7 = Comida(id = 8, nombre = "Papa asada", precio = 40, detalle = "Paesas")
            val comida8 = Comida(id = 9, nombre = "Hamburguesa de pollo", precio = 15, detalle = "Pollo, Queso, jamon")



            comidaViewModel.agregarComida(comida)
            comidaViewModel.agregarComida(comida1)
            comidaViewModel.agregarComida(comida2)
            comidaViewModel.agregarComida(comida3)
            comidaViewModel.agregarComida(comida4)
            comidaViewModel.agregarComida(comida5)
            comidaViewModel.agregarComida(comida6)
            comidaViewModel.agregarComida(comida7)
            comidaViewModel.agregarComida(comida8)


           // val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this /* Activity context */)
         //   val name = sharedPreferences.getString("signature", "")

              Snackbar.make(view, "Helo!" , Snackbar.LENGTH_LONG)
             .setAction("Action", null).show()
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_settings -> {
                AbrirSettings()
                true
            }
            R.id.guardarInterni -> {
                GuardarInt()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun AbrirSettings() {
        startActivity(Intent(this, SettingsActivity::class.java))
    }



    private fun GuardarInt() {



        val file:String = "Archivo.txt"


        AsyncTask.execute {
         /*   var ksd: Array<Comida> =  comidaViewModel.comida1

            for (item in ksd) {
                val d = item
                Log.e("Data", "${item.nombre}, ${item.precio}, ${item.detalle}")
                val fileOutputStream:FileOutputStream
             //   val filedd:FileInputStream
                try {
                    fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
                    val directory = applicationContext.filesDir
                    //val file = File(directory, "Archivo.txt")
                    File(directory, "Archivo.txt")
                    //File("/files/Archivo.txt").forEachLine { println(it) }
                    val stream = File("/Archivo.txt").inputStream()
                    val bytes = ByteArray(16)
                   val con = stream.read(bytes)
                    stream.close()
                    fileOutputStream.write("${con}, ${d}".toByteArray())

                    Log.e("Funciona?","Si")
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }

            //Log.e("dswd", ksd.)*/

        }



    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
