package com.example.menulist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.zxing.integration.android.IntentIntegrator
import android.widget.Toast

import com.google.zxing.integration.android.IntentResult

import android.content.Intent



class MainActivity<Veiw> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val qrbt = findViewById<Button>(R.id.qr_bt)
        qrbt.setOnClickListener {
            IntentIntegrator(this).initiateScan()
        }
        val listbt = findViewById<Button>(R.id.button2)
        listbt.setOnClickListener{

            val intent = Intent(this,orderlogin::class.java)
            startActivity(intent)

        }

    }//액티비티 끝


    fun startBarcodeReader(veiw:Veiw) {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("메뉴판 바코드를 인식해주세요");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setBeepEnabled(false);
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)


        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }

        if (result.contents != null) {
            val intent = Intent(this,SubActivity::class.java)
            intent.putExtra("shopn", result.contents )
            startActivity(intent)
        }


    }

}


