package com.example.waiter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val id = findViewById<TextView>(R.id.idtextveiw)
        val pd = findViewById<TextView>(R.id.passtextveiw)
        val loginb = findViewById<ImageButton>(R.id.login_b)

        loginb.setOnClickListener {
            var idt = id.text.toString()
            var pdt = pd.text.toString()
            val bb = "석기시대"
            val pdd = "123"
            if (idt == bb && pdt == pdd) {

                val intent = Intent(this, order::class.java)
                startActivity(intent)
                finish()
            } else if (idt == "우당탕" && pdt == pdd) {


                val intent = Intent(this, order::class.java)
                startActivity(intent)
                finish()
            } else if (idt == "왕이모" && pdt == pdd) {


                val intent = Intent(this, order::class.java)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "가입된 정보가 없습니다.", Toast.LENGTH_LONG).show()
            }


        }

    }


}