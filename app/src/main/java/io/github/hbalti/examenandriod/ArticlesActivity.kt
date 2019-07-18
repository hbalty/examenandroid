package io.github.hbalti.examenandriod

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

data class Pair(
        val title: String,
        val text: String
)



class ArticlesActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        var articles = arrayListOf<Pair>();
        articles.add(Pair("1","2"));
        articles.add(Pair("1","2"));
        articles.add(Pair("1","2"));


        viewManager = LinearLayoutManager(this) ;
        viewAdapter = MyAdapter(articles);

        recyclerView.findViewById<RecyclerView>(R.id.article_rv).apply {
            setHasFixedSize(true);

            layoutManager = viewManager

            adapter = viewAdapter
        }


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
    }
}
