package com.example.proyectofinal.data

class ComidaRepository(val comidaDao: ComidaDao) {

    suspend fun agregarComida(comida: Comida) = comidaDao.agregarComida(comida)

    fun obtenerDatosComida() = comidaDao.obtenerDatosComida()
    fun obtenerDatos() = comidaDao.obtenerDatos()

}