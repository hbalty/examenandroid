package io.github.hbalti.examenandriod

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class ArticlesAdapter(
        private var pairs: ArrayList<Pair>, var listener: (Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return onBindChapterViewHolder(holder as ArticleViewHolder, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ArticleViewHolder.build(parent)
    }

    private fun onBindChapterViewHolder(holder: ArticleViewHolder, currentPosition: Int) {
        holder.bind(pairs[currentPosition])

        holder.itemView.setOnClickListener { listener(currentPosition) }
    }

    override fun getItemCount() = pairs.size

}