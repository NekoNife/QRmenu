package com.example.menulist

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.io.*
import java.io.File
import java.io.InputStream
import java.lang.Exception
import java.net.Socket
import kotlin.concurrent.timer
import kotlin.math.log


var shopn : String? = null
var table : Int? = null
var data33 : String? = null
var check = ""
var data4 : String? = null

class order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)



        val txt1 = findViewById<Button>(R.id.orderbt1)
        val txt2 = findViewById<Button>(R.id.orderbt2)
        val txt3 = findViewById<Button>(R.id.orderbt3)
        val txt4 = findViewById<Button>(R.id.orderbt4)
        val txt5 = findViewById<Button>(R.id.orderbt5)
        val txt6 = findViewById<Button>(R.id.orderbt6)

  //  val shopnbt = findViewById<Button>(R.id.orderbt)
     //   shopnbt.setOnClickListener {
        var shopn2 = intent.getStringExtra("shopn")
        val shop = findViewById<TextView>(R.id.shopid)
        //    val shopn2 = findViewById<TextView>(R.id.shopid)


            var shopname = shopn2
         shop.setText(shopn2)
            Toast.makeText(this, "가계이름: $shopname", Toast.LENGTH_LONG).show()



             timer(period = 5000, initialDelay = 5000) {
                 var thread = NetworkThread()
                 thread.start()


                 try {
                     var file = File(
                         Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                         "${shopname}1.txt"
                     )
                     val inputStream: InputStream = file.inputStream()
                     val text = inputStream.bufferedReader().use { it.readText() }
                     txt1.setText("$text")
                 } catch (e: IOException) {
                     txt1.setText("주문대기중")
                 }


                 try {
                     var file = File(
                         Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                         "${shopname}2.txt"
                     )
                     val inputStream: InputStream = file.inputStream()
                     val text = inputStream.bufferedReader().use { it.readText() }
                     txt2.setText("$text")
                 } catch (e: IOException) {
                     txt2.setText("주문대기중")
                 }

                 try {
                     var file = File(
                         Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                         "${shopname}3.txt"
                     )
                     val inputStream: InputStream = file.inputStream()
                     val text = inputStream.bufferedReader().use { it.readText() }

                     txt3.setText("$text")
                 } catch (e: IOException) {
                     txt3.setText("주문대기중")
                 }

                 try {
                     var file = File(
                         Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                         "${shopname}4.txt"
                     )
                     val inputStream: InputStream = file.inputStream()
                     val text = inputStream.bufferedReader().use { it.readText() }
                     txt4.setText("$text")
                 } catch (e: IOException) {
                     txt4.setText("주문대기중")
                 }

                 try {
                     var file = File(
                         Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                         "${shopname}5.txt"
                     )
                     val inputStream: InputStream = file.inputStream()
                     val text = inputStream.bufferedReader().use { it.readText() }
                     txt5.setText("$text")
                 } catch (e: IOException) {
                     txt5.setText("주문대기중")
                 }

                 try {
                     var file = File(
                         Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                         "${shopname}6.txt"
                     )
                     val inputStream: InputStream = file.inputStream()
                     val text = inputStream.bufferedReader().use { it.readText() }
                     txt6.setText("$text")
                 } catch (e: IOException) {
                     txt6.setText("주문대기중")
                 }

             }// 타이머
        //  }  버튼

        txt1.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("1번 테이블")
            builder.setMessage("${txt1.text}")
            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->

            }
            builder.show()

          //  출처: https://juahnpop.tistory.com/220 [Blacklog]
        }
        txt2.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("2번테이블")
            builder.setMessage("${txt2.text}")
            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->

            }
            builder.show()
        }
        txt3.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("3번테이블")
            builder.setMessage("${txt3.text}")
            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->

            }
            builder.show()
        }
        txt4.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("4번테이블")
            builder.setMessage("${txt4.text}")
            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->

            }
            builder.show()
        }
        txt5.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("5번테이블")
            builder.setMessage("${txt5.text}")
            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->

            }
            builder.show()
        }
        txt6.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("6번테이블")
            builder.setMessage("${txt6.text}")
            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->

            }
            builder.show()
        }

    }//액티비티


    inner  class NetworkThread : Thread()
    {
        override fun run() {
            val txt1 = findViewById<Button>(R.id.orderbt1)
            val txt2 = findViewById<Button>(R.id.orderbt2)
            val txt3 = findViewById<Button>(R.id.orderbt3)
            val txt4 = findViewById<Button>(R.id.orderbt4)
            val txt5 = findViewById<Button>(R.id.orderbt5)
            val txt6 = findViewById<Button>(R.id.orderbt6)
            try {
                var socket = Socket("192.169.1.14", 9999)


                var input = socket.getInputStream()
                var dis = DataInputStream(input)

                var output = socket.getOutputStream()
                var dos = DataOutputStream(output)

                dos.writeInt(2)




                var data1 = dis.readInt()
                var data2 = dis.readUTF()
                var data3 = dis.readUTF()


                socket.close()





                check = "$data1$data2$data3"





                    try {

                        var file = File(
                            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                            "${data2}${data1}" + ".txt"
                        );

                        // 출처: https://straight-strange.tistory.com/2 [straight 혹은 strange]
                        if (!file.exists())
                            file.createNewFile()

                        val outputStream: OutputStream = file.outputStream()


                        val osw: OutputStreamWriter = outputStream.writer()
                        osw.write("$data3")

                        osw.close()
                        outputStream.close()

                        Toast.makeText(this@order, "주문도착", Toast.LENGTH_SHORT).show()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }



            }catch (e: Exception){
                e.printStackTrace()
            }





        }
    }


}