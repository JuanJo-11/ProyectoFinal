package com.example.proyectofinal.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectofinal.R
import com.example.proyectofinal.R.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home.*

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
        textView.text = "Orden1"
             textView1.text = "Hamburguesa"


        })



        return root
    }
}

