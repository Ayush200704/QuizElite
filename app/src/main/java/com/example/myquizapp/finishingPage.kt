package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class finishingPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finishing_page)

        val name : TextView = findViewById(R.id.name)
        val score : TextView = findViewById(R.id.score)
        val btnEnd :Button = findViewById(R.id.btn_End)
        val ivImageView : ImageView = findViewById(R.id.iv_imageView)
        val wishingMessage :TextView = findViewById(R.id.wishing_message)

        val user_name = intent.getStringExtra(Constants.USER_NAME)
        val Correct_Question = intent.getIntExtra(Constants.CORRECT_QUESTIONS, 0)
        val total_question = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 10)


        name.text = "$user_name"
        score.text = "Your Score is $Correct_Question out of $total_question"

        if(Correct_Question <=4){
            ivImageView.setImageResource(R.drawable.ic_betterluck)
            wishingMessage.text = "Better Luck Next Time"
        }else if(Correct_Question<7){
            ivImageView.setImageResource(R.drawable.ic_you_can_do_better)
            wishingMessage.text = "Well Tried!!"
        }
        else{
            ivImageView.setImageResource(R.drawable.ic_trophy)
            wishingMessage.text = "Hey, Congratulations!"
        }

        btnEnd.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}