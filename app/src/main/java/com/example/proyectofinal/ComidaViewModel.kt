package com.example.proyectofinal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.data.Comida
import com.example.proyectofinal.data.ComidaRepository
import kotlinx.coroutines.launch

class ComidaViewModel(private val comidaRepository: ComidaRepository): ViewModel() {

    val comida = comidaRepository.obtenerDatosComida()

    val comida1 = comidaRepository.obtenerDatos()

    fun agregarComida(comida: Comida){
        viewModelScope.launch { comidaRepository.agregarComida(comida) }
    }
}