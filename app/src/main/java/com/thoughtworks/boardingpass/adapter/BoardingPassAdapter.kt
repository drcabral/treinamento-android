package com.thoughtworks.boardingpass.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.thoughtworks.boardingpass.R
import com.thoughtworks.boardingpass.model.BoardingPass
import kotlinx.android.synthetic.main.boarding_pass_image.view.*

class BoardingPassAdapter(private val myDataset: List<BoardingPass>) :
    RecyclerView.Adapter<BoardingPassAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): BoardingPassAdapter.MyViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.boarding_pass_image, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(holder.view)
            .load(myDataset.get(position).url)
            .into(holder.view.boarding_pass_image_view)

        holder.view.boarding_pass_text_view.text = myDataset.get(position).name
    }

    override fun getItemCount() = myDataset.size
}