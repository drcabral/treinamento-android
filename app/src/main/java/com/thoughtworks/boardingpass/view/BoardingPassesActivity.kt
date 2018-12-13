package com.thoughtworks.boardingpass.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.thoughtworks.boardingpass.R
import com.thoughtworks.boardingpass.adapter.BoardingPassAdapter
import com.thoughtworks.boardingpass.model.BoardingPass
import kotlinx.android.synthetic.main.activity_boarding_passes.*

class BoardingPassesActivity : AppCompatActivity() {
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boarding_passes)

        viewManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val boardingPassList = intent.getSerializableExtra(QR_CODE_URL)

        viewAdapter = BoardingPassAdapter(boardingPassList as List<BoardingPass>)

        boarding_pass_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
