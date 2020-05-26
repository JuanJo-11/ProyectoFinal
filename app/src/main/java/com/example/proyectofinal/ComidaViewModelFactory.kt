package com.example.proyectofinal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.proyectofinal.data.ComidaRepository

class ComidaViewModelFactory(val comidaRepository: ComidaRepository): ViewModelProvider.NewInstanceFactory() {


        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ComidaViewModel(comidaRepository) as T
        }
    }
