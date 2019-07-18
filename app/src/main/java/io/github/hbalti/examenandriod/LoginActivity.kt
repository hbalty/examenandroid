package io.github.hbalti.examenandriod

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View;
import android.content.Intent;
import android.widget.Button
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn_login = findViewById<Button>(R.id.login_button);

        val intent = Intent(this, ArticlesActivity::class.java) ;

        btn_login.setOnClickListener {
            startActivity(intent)
        }
    }


}
