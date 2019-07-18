package io.github.hbalti.examenandriod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.hbalti.examenandriod.network.AppService
import io.github.hbalti.examenandriod.network.LoginPref
import kotlinx.android.synthetic.main.activity_articles.*
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ArticlesActivity : AppCompatActivity() {
    private lateinit var viewAdapter: ArticlesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)


        val retrofit = Retrofit.Builder()
                .baseUrl("http://www.mocky.io/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        Log.d("Token",LoginPref.getAccessToken(applicationContext))
        val service = retrofit.create(AppService::class.java!!)
        val data = service.getData(LoginPref.getAccessToken(applicationContext))

data.enqueue(object :Callback<ArrayList<Pair>>{
    override fun onFailure(call: Call<ArrayList<Pair>>, t: Throwable) {
        Toast.makeText(applicationContext,"Erorr",Toast.LENGTH_LONG).show()
    }

    override fun onResponse(call: Call<ArrayList<Pair>>, response: Response<ArrayList<Pair>>) {


        if(response.isSuccessful) {

            response.body()?.let {
                var viewManager = LinearLayoutManager(this@ArticlesActivity)
                viewAdapter = ArticlesAdapter(it) {
                    ///onclick
                    var intent= Intent(this@ArticlesActivity,DetailActivity::class.java)
                    intent.putExtra("title",response.body()!![it].title)
                    intent.putExtra("text",response.body()!![it].text)

                    startActivity(intent)

                }
                article_recycler.layoutManager = viewManager
                article_recycler.setHasFixedSize(true)
                article_recycler.adapter = viewAdapter
            }

        }else{
            Toast.makeText(applicationContext,"Erorr",Toast.LENGTH_LONG).show()

        }
    }


})


    }
}
