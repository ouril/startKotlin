package com.example.ouril.myfirstkotlin

import android.app.Activity
import android.graphics.Bitmap
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val variants = arrayListOf("wait", "sleep", "run", "drink")
    val CAMERA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        selectedText.text = "Byyyy"
        buttonToStart.setOnClickListener {
            val random = Random()
            val randomStrange = random.nextInt(variants.count())
            selectedText2.text = variants[randomStrange]
        }
        photo.setOnClickListener {
            val callCammeraIntend = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if(callCammeraIntend.resolveActivity(packageManager) != null) {
                    startActivityForResult(callCammeraIntend, CAMERA_REQUEST_CODE)
                }
            }

    }

    override  fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            CAMERA_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    photoImageView2.setImageBitmap(data.extras.get("data") as Bitmap)
                }
            }
            else -> {
                Toast.makeText(this, "Unrecognized and bla-bla", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
