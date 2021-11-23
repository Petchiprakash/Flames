package com.example.flames

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_flames.setOnClickListener{
            val boyName = etBoyName.text.toString().lowercase(Locale.getDefault())
            val girlName = etGirlName.text.toString().lowercase(Locale.getDefault())
            val difference1 = boyName.filter { !girlName.contains(it) }
            val difference2 = girlName.filter { !boyName.contains(it) }
            val difference = difference1+difference2
            val total = difference.count()
            val string = "flames"
            val flamesDef = mapOf('f' to "Friend", 'l' to "love", 'a' to "affection", 'm' to "marriage",
            'e' to "enemies", 's' to "siblings")
            val result = flamesDef[string[total%6]]
            etBoyName.editableText.clear()
            etGirlName.editableText.clear()
            closeKeyboard(etGirlName)
            Toast.makeText(this,result,Toast.LENGTH_LONG).show()

        }
    }
    private fun closeKeyboard(view: View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}