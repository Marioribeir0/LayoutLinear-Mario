package com.example.layoutlinear

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var email = findViewById<EditText>(R.id.EditTextEmail).text
        var password = findViewById<EditText>(R.id.EditTextPassword).text
        var btnLogin = findViewById<Button>(R.id.ButtonButton_Login)
        var btnCadastro = findViewById<Button>(R.id.ButtonButton_Cadastro)

        val sharedPreferences: SharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val savedEmail = sharedPreferences.getString("email", null)
        val savedPassword = sharedPreferences.getString("senha", null)

        btnLogin.setOnClickListener {
            if (email.toString().equals(savedEmail) && password.toString().equals(savedPassword)){
                var intent = Intent(this, Seguros::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Usuario ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }

          }

        btnCadastro.setOnClickListener {
            var intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }

        }
    }

