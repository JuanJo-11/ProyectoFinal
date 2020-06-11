package com.example.proyectofinal.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ComidaDao {
  //  @Query("SELECT * from word_table ORDER BY word ASC")
  //  fun getAlphabetizedWords(): List<Word>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun agregarComida(comida: Comida)

    // select * from datos_alumno where ncontrol = :ncontrol
    @Query(value = "SELECT * FROM datos_producto ")
    fun obtenerDatosComida(): LiveData<Comida>

    @Query(value = "SELECT * FROM datos_producto")
    fun obtenerDatos(): LiveData<Comida>

//    @Query("DELETE FROM word_table")
 //   suspend fun deleteAll()

}