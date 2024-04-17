package com.example.menulist

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class SubActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        var aaa = "선택안됨"
        var bbb = "없음"
        var num = 0
        var ccc1 = ""
        var ccc2 = ""
        var ccc3 = ""
        var ccc4 = ""
        var ccc5 = ""
        var scc1 = 0
        var scc2 = 0
        var scc3 = 0
        var scc4 = 0
        var scc5 = 0
        var num1 = 0
        var num2 = 0
        var num3 = 0
        var num4 = 0
        var num5 = 0
        var size = 0



        var Userlist = arrayListOf<User>(
            User(R.drawable.dish, "임시음식1", "1000"),
            User(R.drawable.dish, "임시음식2", "500"),
            User(R.drawable.dish, "임시음식3", "1500"),
            User(R.drawable.dish, "임시음식4", "7700"),
            User(R.drawable.dish, "임시음식5", "6000")
        )

           var shopn = intent.getStringExtra("shopn")
        val shopname = findViewById<TextView>(R.id.shopname)
            shopname.setText(shopn)
        val shopid = shopn.toString()


            var udt = arrayListOf<User>(
                User(R.drawable.dish,"짜장면","4000"),
                User(R.drawable.dish,"짬뽕","5000"),
                User(R.drawable.dish,"우동","5000"),
                User(R.drawable.dish,"간짜장","5000"),
                User(R.drawable.dish,"야끼우동","6000")
            )

            var bb = arrayListOf<User>(
                User(R.drawable.dish,"아메리카노","1800"),
                User(R.drawable.dish,"녹차라떼","2500"),
                User(R.drawable.dish,"레몬에이드","2500"),
                User(R.drawable.dish,"유자차","2000"),
                User(R.drawable.dish,"쿠키프라페","3500")
            )

            var wim = arrayListOf<User>(
                User(R.drawable.dish,"된장찌개","6000"),
                User(R.drawable.dish,"제육볶음","6000"),
                User(R.drawable.dish,"갈비탕","6000"),
                User(R.drawable.dish,"육개장","6000"),
                User(R.drawable.dish,"계란찜","3000")
            )



    /*    val foodlist = findViewById<ListView>(R.id.list_menu)
            val item = arrayOf("우당탕","봄봄","키위")
            foodlist.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)*/



            var list =   Userlist
              when(shopid){
                  "우당탕" -> {
                      list = udt
                  }
                  "봄봄" -> {
                        list = bb
                  }
                  "왕이모" -> {
                    list = wim
                  }

              }


        val Adapter = UserAdapter(this, list)
        val foodlist = findViewById<ListView>(R.id.list_menu)
        foodlist.adapter = Adapter
        foodlist.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val selectItem = adapterView.getItemAtPosition(i) as User
            when(i){
                0 -> {
                    ccc1 = selectItem.name.toString()
                    scc1 = selectItem.age.toInt()
                }
                1 ->
                {
                    ccc2 = selectItem.name.toString()
                    scc2 = selectItem.age.toInt()
                }
                2 ->{
                    ccc3 = selectItem.name.toString()
                    scc3 = selectItem.age.toInt()
                }

                3 ->{
                    ccc4 = selectItem.name.toString()
                    scc4 = selectItem.age.toInt()
                }
                4  ->{
                    ccc5 = selectItem.name.toString()
                    scc5 = selectItem.age.toInt()
                }
            }

          //  Toast.makeText(this,"음식:${selectItem.name}\n가격:${selectItem.age}원" ,Toast.LENGTH_SHORT).show()
            var intent = Intent(this, SubActivity::class.java)
            intent.putExtra("foodid",selectItem.name )
            intent.putExtra("payid",selectItem.age )
            var seltext = findViewById<TextView>(R.id.selectfoood)
            seltext.setText(selectItem.name.toString())
            aaa = selectItem.name.toString()
            bbb = selectItem.age.toString()
            size = i.toInt()

            var selnum = findViewById<TextView>(R.id.selectnum)
            if (aaa == ccc1){
                num = num1
            }else if (aaa == ccc2){
                num = num2
            }else if (aaa == ccc3){
                num = num3
            }else if (aaa == ccc4){
                num = num4
            }else if (aaa == ccc5){
                num = num5
            }
            selnum.setText(num.toString())
        }



     val plusbt = findViewById<Button>(R.id.plusbt)
        plusbt.setOnClickListener {

            if (aaa == ccc1){
                num1 += 1
                num = num1
            }else if (aaa == ccc2){
                num2 += 1
                num = num2
            }else if (aaa == ccc3){
                num3 += 1
                num = num3
            }else if (aaa == ccc4){
                num4 += 1
                num = num4
            }else if (aaa == ccc5){
                num5 += 1
                num = num5
            }
            var selnum = findViewById<TextView>(R.id.selectnum)
            selnum.setText(num.toString())
           // Toast.makeText(this,"음식:${aaa}\n가격:${bbb}원\n${num}개" ,Toast.LENGTH_SHORT).show()

        }
        val minusbt = findViewById<Button>(R.id.minusbt)
        minusbt.setOnClickListener {
            if (aaa == ccc1){
                if (num > 0) {
                    num1 -= 1
                    num = num1
                }else{
                  Toast.makeText(this,"음식:${aaa}은\n${num}개\n입니다" ,Toast.LENGTH_SHORT).show()
                }
            }else if (aaa == ccc2){
                if (num > 0) {
                    num2 -= 1
                    num = num2
                }else{
                Toast.makeText(this,"음식:${aaa}은\n${num}개\n입니다" ,Toast.LENGTH_SHORT).show()
                }
            }else if (aaa == ccc3){
                if (num > 0) {
                    num3 -= 1
                    num = num3
                }else{
                Toast.makeText(this,"음식:${aaa}은\n${num}개\n입니다" ,Toast.LENGTH_SHORT).show()
                }
            }else if (aaa == ccc4){
                if (num > 0) {
                    num4 -= 1
                    num = num4
                }else{
                 Toast.makeText(this,"음식:${aaa}은\n${num}개\n입니다" ,Toast.LENGTH_SHORT).show()
                }
            }else if (aaa == ccc5){
                if (num > 0) {
                    num5 -= 1
                    num = num5
                }else{
                   Toast.makeText(this,"음식:${aaa}은\n${num}개\n입니다" ,Toast.LENGTH_SHORT).show()
                }
            }
            var selnum = findViewById<TextView>(R.id.selectnum)
            selnum.setText(num.toString())
          //  Toast.makeText(this,"음식:${aaa}\n가격:${bbb}원\n${num}개" ,Toast.LENGTH_SHORT).show()

        }
        val endbt = findViewById<Button>(R.id.endbt)
        endbt.setOnClickListener {
            // var i = 0
            //var count = 0
            // for (i in list-1){
            //   var foodl = "ccc" + i
            // count++
            //   }
            val intent = Intent(this, endActivity::class.java)
            intent.putExtra("shopn", shopn )
            if (0 < num1) {
                var finshfood1 = "${ccc1}:${scc1}원,${num1}개\n"
                intent.putExtra("f1", finshfood1)
            }
            if (0 < num2) {
                var finshfood2 = "${ccc2}:${scc2}원,${num2}개\n"
                intent.putExtra("f2", finshfood2)
            }
            if (0 < num3) {
                var finshfood3 = "${ccc3}:${scc3}원,${num3}개\n"
                intent.putExtra("f3", finshfood3)
            }
            if (0 < num4) {
                var finshfood4 = "${ccc4}:${scc4}원,${num4}개\n"
                intent.putExtra("f4", finshfood4)
            }
            if (0 < num5) {
                var finshfood5 = "${ccc5}:${scc5}원,${num5}개\n"
                intent.putExtra("f5", finshfood5)
            }
            var totalsum = 0
            totalsum =  (scc1 * num1) + (scc2 * num2) + (scc3 * num3)  + (scc4 * num4) + (scc5 * num5)
           var totalsum2 = "${totalsum}"
            intent.putExtra("f6", totalsum2)
          //  Toast.makeText(this,"${scc1}\n:${num1}\n${totalsum}" ,Toast.LENGTH_SHORT).show()


            startActivity(intent)
        }







    }//액티비티



}

