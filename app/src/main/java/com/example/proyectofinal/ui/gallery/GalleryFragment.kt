package com.example.proyectofinal.ui.gallery

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.ViewModelProviders
import com.example.proyectofinal.ComidaViewModel
import com.example.proyectofinal.ComidaViewModelFactory
import com.example.proyectofinal.R
import com.example.proyectofinal.data.ComidaDatabase
import com.example.proyectofinal.data.ComidaRepository
import com.google.android.material.snackbar.Snackbar

class GalleryFragment : Fragment() {

  //  private lateinit var galleryViewModel: GalleryViewModel

    private val comidaViewModel: ComidaViewModel by viewModels {
        ComidaViewModelFactory(
            ComidaRepository(ComidaDatabase.getDatabase(requireContext()).comidaDao()))

    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.row, container, false)

        val tvNombre = root.findViewById<TextView>(R.id.t)
        val tvPrecio = root.findViewById<TextView>(R.id.description)

         comidaViewModel.comida.observe(viewLifecycleOwner, Observer { comida ->
            tvNombre.text = comida.nombre
            tvPrecio.text = comida.precio.toString()
         //   tvDetalle.text = comida.detalle
        })
        //  val textView: TextView = root.findViewById(R.id.text_gallery)


        return root
    }

    fun onSNACK(view: View){
        //Snackbar(view)
        val snackbar = Snackbar.make(view, "Seleccion un tipo de producto",
            Snackbar.LENGTH_LONG).setAction("Action", null)
        snackbar.setActionTextColor(Color.BLUE)
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor(Color.LTGRAY)
        val textView =
            snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        textView.setTextColor(Color.BLUE)
        textView.textSize = 28f
        snackbar.show()
    }
}
