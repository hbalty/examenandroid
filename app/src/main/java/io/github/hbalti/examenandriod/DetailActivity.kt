package io.github.hbalti.examenandriod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        articleTitle.text=intent.getStringExtra("title")
        detailTitle.text=intent.getStringExtra("text")

    }
}
