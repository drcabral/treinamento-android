package com.thoughtworks.boardingpass.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.thoughtworks.boardingpass.R
import com.thoughtworks.boardingpass.model.BoardingPass
import com.thoughtworks.boardingpass.service.ServiceFactory
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Context
import android.view.inputmethod.InputMethodManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton.setOnClickListener {
            hideKeyboard()
            progressBar.visibility = View.VISIBLE

            ServiceFactory.boardingPassService().boardingPassById(recordLocatorEditText.text.toString()).enqueue(object :Callback<BoardingPass> {
                override fun onFailure(call: Call<BoardingPass>, t: Throwable) {
                    Toast.makeText(this@MainActivity, R.string.error_request_boarding_pass, Toast.LENGTH_LONG).show()
                    progressBar.visibility = View.GONE
                }

                override fun onResponse(call: Call<BoardingPass>, response: Response<BoardingPass>) {
                    if (response.isSuccessful) {
                        goToBoardingPassScreen(response.body())
                    } else {
                        Toast.makeText(this@MainActivity, R.string.boarding_pass_not_found, Toast.LENGTH_LONG).show()
                    }

                    progressBar.visibility = View.GONE
                }
            })
        }
    }

    private fun goToBoardingPassScreen(boardingPass: BoardingPass?) {
        val intent = Intent(this, BoardingPassActivity::class.java)
        intent.putExtra(QR_CODE_URL, boardingPass?.url)
        startActivity(intent)
    }

    fun hideKeyboard() {
        val view: View? = findViewById(android.R.id.content)
        if (view != null) {
            val methodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            methodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
