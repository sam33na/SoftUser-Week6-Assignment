package com.sr.studentregister.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sr.studentregister.Adapter.StudentAdapter
import com.sr.studentregister.Details
import com.sr.studentregister.Model.Students
import com.sr.studentregister.R

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var detail=Details()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView=view.findViewById(R.id.recyclerView)
        stdAdapter()
        return view
    }
    private fun stdAdapter()
    {
        val arr=detail.returnStudent()
        val adapter = StudentAdapter(arr, this)
        recyclerView.layoutManager=LinearLayoutManager(view?.context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter=adapter
    }
}