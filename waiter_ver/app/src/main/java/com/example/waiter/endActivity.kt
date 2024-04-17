package com.example.waiter

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.io.*
import java.lang.Exception
import java.net.Socket

var endtext2 : String? = null

class endActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)


        var shopn = intent.getStringExtra("shopn")
        var shopname = findViewById<TextView>(R.id.shopname2)
        shopname.setText(shopn + "번 테이블")

        var endtext = findViewById<TextView>(R.id.endtext)

        var finsh = ""

        var f1 = intent.getStringExtra("f1")
        if(f1 != null){
            finsh = finsh + f1
        }

        var f2 = intent.getStringExtra("f2")
        if(f2 != null){
            finsh = finsh + f2
        }

        var f3 = intent.getStringExtra("f3")
        if(f3 != null){
            finsh = finsh + f3
        }

        var f4 = intent.getStringExtra("f4")
        if(f4 != null){
            finsh = finsh + f4
        }


        var f5 = intent.getStringExtra("f5")
        if(f5 != null){
            finsh = finsh + f5
        }
        endtext.setText("${finsh}")
        var f6 = intent.getStringExtra("f6")
        var totalf = findViewById<TextView>(R.id.total_sum)

        totalf.setText("총합:" + f6 + "원")
        finsh = finsh + "총합:" + f6 + "원"



        var endorder = findViewById<Button>(R.id.button_order)
        endorder.setOnClickListener {





            val positiveButtonClick = { dialogInterface: DialogInterface, i: Int ->

                try {
                    endtext2 = finsh
                    var thread = NetworkThread()
                    thread.start()
                    Toast.makeText(applicationContext, "주문성공", Toast.LENGTH_SHORT).show()

                } catch (e: Exception) {
                    Toast.makeText(applicationContext, "주문실패", Toast.LENGTH_SHORT).show()
                }

             
          /*      var tablenum = 1
                if (0 < tablenum && tablenum < 7) {


                    var file = File(
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                        "${shopn}" + ".txt"
                    );

                    // 출처: https://straight-strange.tistory.com/2 [straight 혹은 strange]
                    if (!file.exists())
                        file.createNewFile()

                    val outputStream: OutputStream = file.outputStream()


                    val osw: OutputStreamWriter = outputStream.writer()
                    osw.write("$finsh")

                    osw.close()
                    outputStream.close()


                    Toast.makeText(applicationContext, "주문준비중", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(
                        applicationContext,
                        "테이블 번호를\n다시입력해주세요\n1~6까지입니다.",
                        Toast.LENGTH_SHORT
                    ).show()                }                    //외부저장
*/


                }

            val neutralButtonClick = { dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(applicationContext, "취소", Toast.LENGTH_SHORT).show()

            }

            val builder = AlertDialog.Builder(this)
                .setTitle("주문")
                .setMessage("주문 하시겠습니까?")
                .setPositiveButton("확인",positiveButtonClick)
                .setNeutralButton("취소", neutralButtonClick)
                .show()
        }


    }




    inner  class NetworkThread : Thread()
    {
        override fun run() {


            try {
                var socket = Socket("192.169.1.58", 8888)


                var output = socket.getOutputStream()
                var dos = DataOutputStream(output)

                var shopn = intent.getStringExtra("shopn")


                dos.writeInt(1)

                dos.writeUTF("$shopn")
                dos.writeUTF("$endtext2")

                socket.close()

                /*  runOnUiThread {
                      var tv1 = findViewById<TextView>(R.id.textView)
                      tv1.text = "data1 : ${data1}\n"
                      tv1.append("data2 : ${data2}\n")
                      tv1.append("data3 : ${data3}")


                  }*/
            } catch (e: Exception){
                Toast.makeText(applicationContext, "주문실패", Toast.LENGTH_SHORT).show()
            }


        }


    }



}