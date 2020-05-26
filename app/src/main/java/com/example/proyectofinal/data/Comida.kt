package com.example.proyectofinal.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "datos_producto")
data class Comida(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "Nombre") val nombre: String,
    @ColumnInfo(name = "Precio") val precio: Int,
    @ColumnInfo(name = "Detalle") val detalle: String
    ) {
}