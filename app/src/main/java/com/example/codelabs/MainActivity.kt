package com.example.codelabs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.ShareCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textViewForAct2 = findViewById<TextView>(R.id.act1_resText)
        savedInstanceState?.let {
            val visibleView = savedInstanceState.getBoolean("visible")
            Log.e("save", "get save $visibleView")
            if (visibleView) {
                textViewForAct2.visibility = View.VISIBLE
                textViewForAct2.text = savedInstanceState.getString("text")
            }
        }

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

    override fun onSaveInstanceState(outState: Bundle) {
        val textViewForAct2 = findViewById<TextView>(R.id.act1_resText)
        outState.apply{
            putBoolean("visible", true)
            putString("text", textViewForAct2.text.toString())
        }

        super.onSaveInstanceState(outState)
        Log.e("save", "save")
    }

    fun sendIntent(view: View) {
        val textForSendIntent = findViewById<EditText>(R.id.act1_editText)
        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setChooserTitle("Share")
                .setText(textForSendIntent.text.toString())
                .startChooser()
    }

}
