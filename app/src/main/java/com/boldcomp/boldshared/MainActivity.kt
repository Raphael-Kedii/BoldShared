package com.boldcomp.boldshared

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.boldcomp.boldshared.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences:SharedPreferences
    var isRemembered = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        isRemembered = sharedPreferences.getBoolean("CHECKBOX", false)
        if (isRemembered){
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnLogin.setOnClickListener {
            val name: String = binding.edName.text.toString()
            val course: String = binding.edCourse.text.toString()
            val year: Int = binding.edYear.text.toString().toInt()
            val checked:Boolean = binding.cIsRemembered.isChecked
            val editor: SharedPreferences.Editor =sharedPreferences.edit()
            editor.putString("NAME", name)
            editor.putString("COURSE",course)
            editor.putInt("YEAR",year)
            editor.putBoolean("CHECKED",checked)
            editor.apply()
            Toast.makeText(this, "Information Saved Successfully", Toast.LENGTH_LONG).show()

            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}