package com.thoughtworks.boardingpass.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.thoughtworks.boardingpass.R
import kotlinx.android.synthetic.main.activity_boarding_pass.*

const val QR_CODE_URL = "recordLocator"

class BoardingPassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boarding_pass)

        val recordLocator = intent.getStringExtra(QR_CODE_URL)

        Glide.with(this)
            .load(recordLocator)
            .into(qrcode_image)
    }

}
