package com.sr.studentregister.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sr.studentregister.Model.Students
import com.sr.studentregister.R
import com.sr.studentregister.ui.home.HomeFragment

class StudentAdapter(
    val lstStd:ArrayList<Students>,
    val context: HomeFragment
):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>()
{
    class StudentViewHolder(view: View):RecyclerView.ViewHolder(view)
    {
        val imgDp:ImageView
        val imgDel:ImageView
        val tvName:TextView
        val tvAge: TextView
        val tvAddress: TextView
        val tvGender:TextView

        init {
            imgDp=view.findViewById(R.id.imgDp)
            imgDel=view.findViewById(R.id.imgDel)
            tvName=view.findViewById(R.id.tvName)
            tvAge=view.findViewById(R.id.tvAge)
            tvAddress=view.findViewById(R.id.tvAddress)
            tvGender=view.findViewById(R.id.tvGender)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_layout,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val std = lstStd[position]
        holder.tvName.text=std.stdName
        holder.tvAddress.text=std.stdAddress
        holder.tvAge.text=std.stdAge.toString()
        holder.tvGender.text=std.stdGender

        Glide.with(context)
            .load(std.stdDpUrl)
            .into(holder.imgDp)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}