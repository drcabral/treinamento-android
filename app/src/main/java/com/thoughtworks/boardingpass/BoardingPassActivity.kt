package com.thoughtworks.boardingpass

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_boarding_pass.*

const val RECORD_LOCATOR = "recordLocator"

class BoardingPassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boarding_pass)

        val recordLocator = intent.getStringExtra(RECORD_LOCATOR)

        when(recordLocator) {
            "record1" -> qrcode_image.setImageResource(R.drawable.qrcode_1)
            "record2" -> qrcode_image.setImageResource(R.drawable.qrcode_1)
            "record3" -> qrcode_image.setImageResource(R.drawable.qrcode_1)
            else -> qrcode_image.setImageResource(R.drawable.not_found)
        }
    }

}
