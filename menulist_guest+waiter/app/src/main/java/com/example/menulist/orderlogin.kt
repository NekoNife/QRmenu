package com.example.menulist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class orderlogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderlogin)

        val id = findViewById<TextView>(R.id.idtextveiw)
        val pd = findViewById<TextView>(R.id.passtextveiw)
        val loginb = findViewById<Button>(R.id.login_b)


     loginb.setOnClickListener {
         var idt = id.text.toString()
         var pdt = pd.text.toString()
         val bb = "봄봄"
         val pdd = "123"
         if(idt == bb&&pdt == pdd){

             val intent = Intent(this, order::class.java)
             intent.putExtra("shopn", "봄봄" )
             startActivity(intent)
    finish()

         }

        else if(idt == "우당탕"&&pdt == pdd ){



             val intent = Intent(this, order::class.java)
             intent.putExtra("shopn", "우당탕" )
            startActivity(intent)
             finish()
         }

        else if(idt == "왕이모" &&pdt == pdd){




             val intent = Intent(this, order::class.java)
             intent.putExtra("shopn", "왕이모" )
             startActivity(intent)
             finish()

     }
            else{
              Toast.makeText(this, "가입된 정보가 없습니다.", Toast.LENGTH_LONG).show()
            }





     }








    }
}