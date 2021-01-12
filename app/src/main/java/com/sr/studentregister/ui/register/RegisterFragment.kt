package com.sr.studentregister.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.sr.studentregister.Model.Students
import com.sr.studentregister.R

class RegisterFragment : Fragment() {
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etAddress: EditText
    private lateinit var etUrl: EditText
    private lateinit var radGrp: RadioGroup
    private lateinit var male: RadioButton
    private lateinit var female: RadioButton
    private lateinit var others: RadioButton
    private lateinit var btnSub: Button
    var gender :String = "Female";
    var list = arrayListOf<Students>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        etName=view.findViewById(R.id.etName)
        etAddress=view.findViewById(R.id.etAddress)
        etAge=view.findViewById(R.id.etAge)
        etUrl=view.findViewById(R.id.etUrl)
        radGrp=view.findViewById(R.id.radioGrp)
        male=view.findViewById(R.id.radMale)
        female=view.findViewById(R.id.radFemale)
        others=view.findViewById(R.id.radOther)
        btnSub=view.findViewById(R.id.btnSubmit)
        male.setOnClickListener {
            gender="Male"
        }
        female.setOnClickListener {
            gender="Female"
        }
        others.setOnClickListener {
            gender="Others"
        }

        btnSub.setOnClickListener {
            var name= etName.text.toString()
            var address= etAddress.text.toString()
            var age= etAge.text.toString().toInt()
            var url= etUrl.text.toString()
            var Student=Students(name, address, age, gender, url)
            list.add(Student)
            Toast.makeText(context,"Student added", Toast.LENGTH_LONG).show()
        }
        return view
    }
}