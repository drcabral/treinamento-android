package com.thoughtworks.boardingpass

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton.setOnClickListener {
            val intent = Intent(this, BoardingPassActivity::class.java)
            intent.putExtra(RECORD_LOCATOR, recordLocatorEditText.text.toString())
            startActivity(intent)
        }
    }
}
