package com.example.waiter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator

class order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)




        val qrbt = findViewById<ImageButton>(R.id.qrbt)
        qrbt.setOnClickListener {
            IntentIntegrator(this).initiateScan()
        }
        val listbt = findViewById<ImageButton>(R.id.button2)
        listbt.setOnClickListener{

            val intent = Intent(this,beforemenu::class.java)
            startActivity(intent)

        }


    }

    fun startBarcodeReader(veiw:order) {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("QR코드를 중앙에 오도록 위치해주세요");
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