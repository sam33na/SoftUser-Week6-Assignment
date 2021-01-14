package com.sr.studentregister.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.sr.studentregister.Details
import com.sr.studentregister.Model.Students
import com.sr.studentregister.R

class RegisterFragment : Fragment() {
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etAddress: EditText
    private lateinit var etUrl: EditText
    private lateinit var male: RadioButton
    private lateinit var female: RadioButton
    private lateinit var others: RadioButton
    private lateinit var btnSub: Button
    var gender = "Select One";
    var stdDpUrl=""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        etName = view.findViewById(R.id.etName)
        etAddress = view.findViewById(R.id.etAddress)
        etAge = view.findViewById(R.id.etAge)
        etUrl = view.findViewById(R.id.etUrl)
        male = view.findViewById(R.id.radMale)
        female = view.findViewById(R.id.radFemale)
        others = view.findViewById(R.id.radOther)
        btnSub = view.findViewById(R.id.btnSubmit)
        male.setOnClickListener {
            gender = "Male"
        }
        female.setOnClickListener {
            gender = "Female"
        }
        others.setOnClickListener {
            gender = "Others"
        }

        btnSub.setOnClickListener {
            if (nullCheck()) {
                var name = etName.text.toString()
                stdDpUrl = etUrl.text.toString()
                var address = etAddress.text.toString()
                var age = etAge.text.toString()
                Details().appendStudent(Students(name,stdDpUrl, age,address, gender ))
                Toast.makeText(context, "Student added", Toast.LENGTH_LONG).show()
                etName.setText("")
                etUrl.setText("")
                etAge.setText("")
                etAddress.setText("")
                etName.requestFocus()
            } else {
                Toast.makeText(view?.context, "Try Again", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    private fun nullCheck(): Boolean {
        var check : Boolean = true
        when {
            TextUtils.isEmpty(etName.text) -> {
                etName.error = "This field should not be empty"
                etName.requestFocus()
                check = false
            }
            TextUtils.isEmpty(etUrl.text) -> {
                etUrl.error = "This field should not be empty"
                etUrl.requestFocus()
                check = false
            }
            TextUtils.isEmpty(etAddress.text) -> {
                etAddress.error = "This field should not be empty"
                etAddress.requestFocus()
                check = false
            }
            TextUtils.isEmpty(etAge.text) -> {
                etAge.error = "This field should not be empty"
                etAge.requestFocus()
                check = false
            }
        }
        return check
    }
}