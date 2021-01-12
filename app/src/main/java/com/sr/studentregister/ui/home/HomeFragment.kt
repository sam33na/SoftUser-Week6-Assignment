package com.sr.studentregister.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sr.studentregister.Adapter.StudentAdapter
import com.sr.studentregister.Model.Students
import com.sr.studentregister.R

class HomeFragment : Fragment() {

    private var lstStds= ArrayList<Students>()
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView=view.findViewById(R.id.recyclerView)
        //fill arraylist w/ actors
        loadActors()
        val adapter=StudentAdapter(lstStds,this)
        recyclerView.adapter
        return view
    }
    private fun loadActors()
    {

    }
}