package com.example.motivateme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.motivateme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    private lateinit var name: EditText
    private lateinit var binding : ActivityMainBinding

    //val message : TextView = findViewById(R.id.main_act_tv_message)
//    private lateinit var message: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_main)

            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

//        val motivateButton: Button = findViewById(R.id.main_act_bt_update)

        binding.mainActBtUpdate.setOnClickListener {
            updateMessage()
        }

//        name = findViewById(R.id.main_act_ev_name)
//        message = findViewById(R.id.main_act_tv_message)

        if(savedInstanceState != null){
            binding.mainActTvMessage.text = savedInstanceState.getString("message")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(
            "message",
            binding.mainActTvMessage.text.toString()
        )
    }

    private fun updateMessage() {
        val username = binding.mainActEvName.text.toString()
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
            binding.mainActTvMessage.text = "Please Enter your name"
        } else {

            binding.mainActTvMessage.text = "Hey $username! \n$currentMessage"
        }

        binding.mainActEvName.setText("")

        hidekeyboard()
    }

    private fun hidekeyboard(){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.mainActEvName.windowToken, 0)
    }
}