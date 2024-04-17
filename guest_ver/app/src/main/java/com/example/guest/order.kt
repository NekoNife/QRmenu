package com.example.guest

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import java.io.*
import java.lang.Exception
import java.net.Socket
import kotlin.concurrent.timer


var shopn : String? = null
var table : Int? = null
var data33 : String? = null
var check = ""
var check2 = ""
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
        var shopn2 = intent.getStringExtra("shopn")
        val shop = findViewById<TextView>(R.id.shopid)
        shop.setText(shopn2)
        txt1.setText("1번테이블\n주문대기중")
        txt2.setText("2번테이블\n주문대기중")
        txt3.setText("3번테이블\n주문대기중")
        txt4.setText("4번테이블\n주문대기중")
        txt5.setText("5번테이블\n주문대기중")
        txt6.setText("6번테이블\n주문대기중")

        timer(period = 5000, initialDelay = 5000) {
            var thread = NetworkThread()
            thread.start()

            when (check)  {
                shopn2 + "1" -> txt1.setText(check2)
                shopn2 + "2" -> txt2.setText(check2)
                shopn2 + "3" -> txt3.setText(check2)
                shopn2 + "4" -> txt4.setText(check2)
                shopn2 + "5" -> txt5.setText(check2)
                shopn2 + "6" -> txt6.setText(check2)
                else -> println("주문대기중")
            }
/*

            try {
                var file = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    "${shopn2}1.txt"
                )
                val inputStream: InputStream = file.inputStream()
                val text = inputStream.bufferedReader().use { it.readText() }
                txt1.setText("$text")
            } catch (e: IOException) {
                txt1.setText("1번주문대기중")
            }


            try {
                var file = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    "${shopn2}2.txt"
                )
                val inputStream: InputStream = file.inputStream()
                val text = inputStream.bufferedReader().use { it.readText() }
                txt2.setText("$text")
            } catch (e: IOException) {
                txt2.setText("2번주문대기중")
            }

            try {
                var file = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    "${shopn2}3.txt"
                )
                val inputStream: InputStream = file.inputStream()
                val text = inputStream.bufferedReader().use { it.readText() }
                txt3.setText("$text")
            } catch (e: IOException) {
                txt3.setText("3번주문대기중")
            }

            try {
                var file = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    "${shopn2}4.txt"
                )
                val inputStream: InputStream = file.inputStream()
                val text = inputStream.bufferedReader().use { it.readText() }
                txt4.setText("$text")
            } catch (e: IOException) {
                txt4.setText("4번주문대기중")
            }

            try {
                var file = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    "${shopn2}5.txt"
                )
                val inputStream: InputStream = file.inputStream()
                val text = inputStream.bufferedReader().use { it.readText() }
                txt5.setText("$text")
            } catch (e: IOException) {
                txt5.setText("5번주문대기중")
            }

            try {
                var file = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    "${shopn2}6.txt"
                )
                val inputStream: InputStream = file.inputStream()
                val text = inputStream.bufferedReader().use { it.readText() }
                txt6.setText("$text")
            } catch (e: IOException) {
                txt6.setText("6번주문대기중")
            }
*/
        }// 타이머
        txt1.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("1번 테이블")
            builder.setMessage("${txt1.text}")
            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->

            }
            builder.setNeutralButton("정리") { dialogInterface: DialogInterface, i: Int ->
                val builder = AlertDialog.Builder(this)
                builder.setTitle("정리 하겠습니까")
                builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
                    txt1.setText("1번테이블\n주문대기중")
                }
                builder.setNegativeButton("취소") { dialogInterface: DialogInterface, i: Int ->

                }
                builder.show()
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
            builder.setNeutralButton("정리") { dialogInterface: DialogInterface, i: Int ->
                val builder = AlertDialog.Builder(this)
                builder.setTitle("정리 하겠습니까")
                builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
                    txt2.setText("2번테이블\n주문대기중")
                }
                builder.setNegativeButton("취소") { dialogInterface: DialogInterface, i: Int ->

                }
                builder.show()
            }
            builder.show()
        }
        txt3.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("3번테이블")
            builder.setMessage("${txt3.text}")
            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->

            }
            builder.setNeutralButton("정리") { dialogInterface: DialogInterface, i: Int ->
                val builder = AlertDialog.Builder(this)
                builder.setTitle("정리 하겠습니까")
                builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
                    txt3.setText("3번테이블\n주문대기중")
                }
                builder.setNegativeButton("취소") { dialogInterface: DialogInterface, i: Int ->

                }
                builder.show()
            }
            builder.show()
        }
        txt4.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("4번테이블")
            builder.setMessage("${txt4.text}")
            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->

            }
            builder.setNeutralButton("정리") { dialogInterface: DialogInterface, i: Int ->
                val builder = AlertDialog.Builder(this)
                builder.setTitle("정리 하겠습니까")
                builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
                    txt4.setText("4번테이블\n주문대기중")
                }
                builder.setNegativeButton("취소") { dialogInterface: DialogInterface, i: Int ->

                }
                builder.show()
            }
            builder.show()
        }
        txt5.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("5번테이블")
            builder.setMessage("${txt5.text}")
            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->

            }
            builder.setNeutralButton("정리") { dialogInterface: DialogInterface, i: Int ->
                val builder = AlertDialog.Builder(this)
                builder.setTitle("정리 하겠습니까")
                builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
                    txt5.setText("5번테이블\n주문대기중")
                }
                builder.setNegativeButton("취소") { dialogInterface: DialogInterface, i: Int ->

                }
                builder.show()
            }
            builder.show()
        }
        txt6.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("6번테이블")
            builder.setMessage("${txt6.text}")
            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->

            }
            builder.setNeutralButton("정리") { dialogInterface: DialogInterface, i: Int ->
                val builder = AlertDialog.Builder(this)
                builder.setTitle("정리 하겠습니까")
                builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
                    txt6.setText("6번테이블\n주문대기중")
                }
                builder.setNegativeButton("취소") { dialogInterface: DialogInterface, i: Int ->

                }
                builder.show()
            }
            builder.show()
        }


    }


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
                var socket = Socket("192.168.55.239", 8888)


                var input = socket.getInputStream()
                var dis = DataInputStream(input)

                var output = socket.getOutputStream()
                var dos = DataOutputStream(output)

                dos.writeInt(2)





                var data2 = dis.readUTF()
                var data3 = dis.readUTF()


                socket.close()





                check = "$data2"

                check2 = "$data3"



                try {

                    var file = File(
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                        "${data2}" + ".txt"
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
