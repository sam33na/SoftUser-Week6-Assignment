package com.sr.studentregister

import com.sr.studentregister.Model.Students
import kotlin.math.log

private var lstStd = arrayListOf<Students>()
var login:Students?=null
class Details {
    fun appendStudent(students: Students)
    {
        lstStd.add(students)
        println(lstStd.size)
    }
    fun returnStudent():ArrayList<Students>
    {
        return lstStd
    }
    fun deleteStd(students: Students)
    {
        lstStd.remove(students)
    }
    public fun setLogib(id:Students?)
    {
        println(id)
        login=id
    }
    public fun getLogib(id:Students?): Students? {
        return login
    }

}