package com.example.motivateme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText

    //val message : TextView = findViewById(R.id.main_act_tv_message)
    private lateinit var message: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val motivateButton: Button = findViewById(R.id.main_act_bt_update)

        motivateButton.setOnClickListener {
            updateMessage()
        }

        name = findViewById(R.id.main_act_ev_name)
        message = findViewById(R.id.main_act_tv_message)
    }

    private fun updateMessage() {
        val username = name.text.toString()
        val motivateionalMessages = listOf(
            "Keep working hard!",
            "Never give up!",
            "Keep your head up",
            "Difficulty is growth",
            "Today is the first day of the rest of your life"
        )
        val index = (0..4).random()
        val currentMessage = motivateionalMessages[index]

        if (username == "") {
            message.text = "Please Enter your name"
        } else {

            message.text = "Hey $username! \n$currentMessage"
        }

        name.setText("")

        hidekeyboard()
    }

    private fun hidekeyboard(){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(name.windowToken, 0)
    }
}