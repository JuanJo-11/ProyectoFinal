package com.example.proyectofinal.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.proyectofinal.R
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {


    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
         homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        //    ViewModelProviders.of(this).get(HomeViewModel::class.java)
           val root = inflater.inflate(R.layout.row, container, false)
       // val root1 = inflater.inflate(R.layout.fragment_gallery, container, false)
         val textView: TextView =  root.findViewById(R.id.t)
        val textView1: TextView = root.findViewById(R.id.description)
         homeViewModel.text.observe(viewLifecycleOwner, Observer {
        textView.text = "dwdw"
             textView1.text = "Hamburguesa"

        })



        return root
    }
}

