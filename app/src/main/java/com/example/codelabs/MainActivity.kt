package com.example.codelabs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun launchSecondActivity(view: View) {

        val intent = Intent(this, MainActivity2::class.java)
        val viewForPut = findViewById<TextView>(R.id.act1_editText)
        val textForPut = viewForPut.text.toString()
        Log.e("act", textForPut)
        intent.putExtra("1", textForPut)
        startActivityForResult(intent, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data.let {
           val textFromAct2 = data?.getStringExtra("2")
           val textViewForAct2 = findViewById<TextView>(R.id.act1_resText)
           textViewForAct2.text = textFromAct2
           textViewForAct2.visibility = View.VISIBLE
        }
    }
}
