package com.example.newsapps.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapps.DetailsAcitivity
import com.example.newsapps.R
import com.example.newsapps.mvvmnewsapp.Article

class HomeAdapter(
        private val context: Context,
        private var articles: List<Article>,private val listener: Listener
) : RecyclerView.Adapter<HomeAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view =
                LayoutInflater.from(context).inflate(R.layout.item_home_adapter, parent, false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articles = articles[position]
        holder.title.text = articles.title
        holder.desc.text = articles.description
        holder.source.text = articles.source?.name
        Glide.with(context).load(articles.urlToImage).into(holder.newImage)
    }

  inner  class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newImage: ImageView = itemView.findViewById(R.id.img)
        var title = itemView.findViewById<TextView>(R.id.title)
        var desc = itemView.findViewById<TextView>(R.id.desc)
        var source = itemView.findViewById<TextView>(R.id.source)
      init {
          itemView.setOnClickListener {
              listener.onItemClicklistener(adapterPosition)
              val intent = Intent(context, DetailsAcitivity::class.java)
              intent.putExtra("description", articles[adapterPosition].description)
              intent.putExtra("urlToImage", articles[adapterPosition].urlToImage)
              intent.putExtra("content", articles[adapterPosition].content)
              intent.putExtra("url", articles[adapterPosition].url)
              context.startActivity(intent)
          }
      }
    }

    fun setdata(articles: List<Article>) {
        this.articles = articles
        notifyDataSetChanged()
    }

    interface  Listener{
        fun onItemClicklistener(position:Int)

    }
}