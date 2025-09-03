package com.example.layoutlinear

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

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

            var nome = findViewById<EditText>(R.id.EditTextNomeCompleto).text
            var emailCadastro = findViewById<EditText>(R.id.EditTextEmailCadastro).text
            var passwordCadastro = findViewById<EditText>(R.id.EditTextPasswordCadastro).text
            var btnCadastrar = findViewById<Button>(R.id.ButtonButton_Cadastro)

        btnCadastrar.setOnClickListener {
            if (nome.isEmpty() || emailCadastro.isEmpty() || passwordCadastro.isEmpty()){
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            }else{
                val sharedPreferences: SharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
                val editor = sharedPreferences.edit()

                editor.putString("nome", nome.toString())
                editor.putString("email", emailCadastro.toString())
                editor.putString("senha", passwordCadastro.toString())
                editor.apply()  // Salva as informações

                // Exibe uma mensagem de sucesso
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()

                // Após o cadastro, você pode redirecionar o usuário para a tela de login ou outra tela
                var intent = Intent(this, MainActivity::class.java)  // LoginActivity é a tela de login
                startActivity(intent)
                finish()
            }
        }



    }
}