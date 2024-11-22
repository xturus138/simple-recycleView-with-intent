package com.example.kotlinsubmission.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinsubmission.R
import com.example.kotlinsubmission.model.News

class ListNewsAdapter(private val listNews: ArrayList<News>) : RecyclerView.Adapter<ListNewsAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback (onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvJudul: TextView = itemView.findViewById(R.id.titleTextView)
        val tvDesc: TextView = itemView.findViewById(R.id.subtitleTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_news, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        val size = listNews.size
        return size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (judul, desc, photo) = listNews[position]
        holder.imageView.setImageResource(photo)
        holder.tvJudul.text = judul
        holder.tvDesc.text = desc
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listNews[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: News)
    }
}