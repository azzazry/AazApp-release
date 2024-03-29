package com.dicoding.aazapp_release

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DaftarListAdapter(private val daftarList: ArrayList<DaftarList>) : RecyclerView.Adapter<DaftarListAdapter.ListViewHolder>() {

    private var itemClickListener: ((DaftarList) -> Unit)? = null

    // Function setOnItemClickListener
    fun setOnItemClickListener(listener: (DaftarList) -> Unit) {
        itemClickListener = listener
    }

    // Function onCreateViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_daftar_list_adapter, parent, false)
        return ListViewHolder(view)
    }

    // Function onBindViewHolder
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = daftarList[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            itemClickListener?.invoke(daftarList[position])
        }
    }

    // Function getItemCount()
    override fun getItemCount(): Int = daftarList.size

    // Membuat class LastViewHolder
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}