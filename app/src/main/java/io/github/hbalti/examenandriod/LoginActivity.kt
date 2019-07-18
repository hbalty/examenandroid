package io.github.hbalti.examenandriod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View;
import android.content.Intent;
import android.widget.Button
import android.widget.Toast
import io.github.hbalti.examenandriod.network.AppService
import io.github.hbalti.examenandriod.network.LoginPref
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn_login = findViewById<Button>(R.id.login_button);

        val intent = Intent(this, ArticlesActivity::class.java) ;



        btn_login.setOnClickListener {


            val retrofit = Retrofit.Builder()
                    .baseUrl("http://www.mocky.io/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val service = retrofit.create(AppService::class.java!!)
            if(passwordEdit.text.isEmpty()){
                passwordEdit.error="Empty"
            }else if(emailEdit.text.isEmpty()){
                     emailEdit.error="Empty"
            }else{
                val login = service.login(emailEdit.text.toString(),passwordEdit.text.toString())
                login.enqueue(object: Callback<Token> {
                    override fun onFailure(call: Call<Token>, t: Throwable) {
                        Toast.makeText(applicationContext,"Erorr",Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<Token>, response: Response<Token>) {
                        if(response.isSuccessful) {
                            LoginPref.saveAccessToken(applicationContext, response.body()!!.token)
                            startActivity(intent)
                        }else{
                            Toast.makeText(applicationContext,"Erorr",Toast.LENGTH_LONG).show()
                        }
                    }
                })
            }

        }
    }


}
