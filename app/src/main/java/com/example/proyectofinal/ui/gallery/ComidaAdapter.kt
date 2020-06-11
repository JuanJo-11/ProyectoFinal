package com.example.proyectofinal.ui.gallery

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.R
import kotlinx.android.synthetic.main.row.view.*


class ComidaAdapter(val arrayList: ArrayList<Model>, val context: GalleryFragment) :
    RecyclerView.Adapter<ComidaAdapter.ViewHolder>() {
  //  private List<>

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun binditems(model: Model){
            //itemView.tvNombre .text = model.nombre
            itemView.t.text = model.nombre
          //  itemView.tvPrecio.text = model.precio.toString()
            itemView.description.text = model.detalle
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binditems(arrayList[position])
    }
}