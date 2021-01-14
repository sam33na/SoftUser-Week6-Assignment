package com.sr.studentregister.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sr.studentregister.Details
import com.sr.studentregister.Model.Students
import com.sr.studentregister.R
import com.sr.studentregister.fragments.HomeFragment

class StudentAdapter(
        val lstStudent: ArrayList<Students>,
        val context: HomeFragment
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private var details =  Details()

    //Chair banaune
    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imgDp: ImageView
        val imgDel: ImageView
        val tvName: TextView
        val tvAge: TextView
        val tvAddress: TextView
        val tvGender: TextView

        init {
            imgDp = view.findViewById(R.id.imgDp)
            imgDel = view.findViewById(R.id.imgDel)
            tvName = view.findViewById(R.id.tvName)
            tvAge = view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvGender = view.findViewById(R.id.tvGender)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.student_recycler,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

        val student = lstStudent[position]
        holder.tvName.text = student.stdName
        holder.tvAge.text = student.stdAge.toString()
        holder.tvAddress.text = student.stdAddress
        holder.tvGender.text = student.stdGender

        holder.imgDel.setOnClickListener {
            details.deleteStd(student)
            notifyItemRemoved(position)
        }

        Glide.with(context)
                .load(student.stdDpUrl)
                .into(holder.imgDp)
    }

    override fun getItemCount(): Int {
        return lstStudent.size
    }
}
