package com.example.proyectofinal.ui.gallery

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
        //galleryViewModel =
          //      ViewModelProvider(this).get(GalleryViewModel::class.java)

        val root = inflater.inflate(R.layout.row, container, false)

        val tvNombre = root.findViewById<TextView>(R.id.t)
        val tvPrecio = root.findViewById<TextView>(R.id.description)
       // val tvDetalle = root.findViewById<TextView>(R.id.tvDetalle)

        comidaViewModel.comida.observe(viewLifecycleOwner, Observer { comida ->
            tvNombre.text = comida.nombre
            tvPrecio.text = comida.precio.toString()
         //   tvDetalle.text = comida.detalle
        })
        //  val textView: TextView = root.findViewById(R.id.text_gallery)


      //  galleryViewModel.text.observe(viewLifecycleOwner, Observer {
        //    textView.text = it
       // })

        return root
    }
}
