package com.example.weatherapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.weatherapplication.MainActivity.TestObject.myCopy

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_material).setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
        })

        onScreen()
    }

    private fun onScreen() {
        val dataClassTest = DataClassTest("MyName1", "MySecondName1", 32)
        val name = dataClassTest.name
        val secondName = dataClassTest.SecondName
        val age = dataClassTest.age.toString()

        val tv1: TextView = findViewById(R.id.textView1)
        val tv2: TextView = findViewById(R.id.textView2)
        val tv3: TextView = findViewById(R.id.textView3)
        val tv4: TextView = findViewById(R.id.textView4)

        tv1.text = name
        tv2.text = secondName
        tv3.text = age
        tv4.text = myCopy


    }

    object TestObject {
        val myCopy = DataClassTest("Name1", "SecondName", 45).copy().toString()
    }
}