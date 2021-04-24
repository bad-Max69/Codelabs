package com.example.codelabs

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val text = findViewById<TextView>(R.id.textView2)
        val textForActivity = intent.getStringExtra("1")
        text.text = textForActivity

    }

    fun sendAnswer(view: View) {
       val intentActivity2 = Intent()
       val editText = findViewById<EditText>(R.id.act2_editText)

        intentActivity2.putExtra("2", editText.text.toString())
        setResult(0, intentActivity2)
        finish()

    }
}