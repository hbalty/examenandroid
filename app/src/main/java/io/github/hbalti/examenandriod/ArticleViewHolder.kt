package io.github.hbalti.examenandriod

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.article_item.view.*

class ArticleViewHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {

    companion object {
        fun build(parent: ViewGroup): ArticleViewHolder {
            return ArticleViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            R.layout.article_item
                            ,
                            parent,
                            false
                    )
            )
        }
    }
    fun bind(
            pair: Pair) {
        containerView.andVersionTxt.text = pair.title
    }
}