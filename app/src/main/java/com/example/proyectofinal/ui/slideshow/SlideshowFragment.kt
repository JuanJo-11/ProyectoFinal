package com.example.proyectofinal.ui.slideshow

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.proyectofinal.R

class SlideshowFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProviders.of(this).get(SlideshowViewModel::class.java)
        val root = inflater.inflate(R.layout.activity_ubicacion, container, false)
        // val textView: TextView = root.findViewById(R.id.text_slideshow)
        //  slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
        //      textView.text = it
        //  })


            return root
        }
    }

