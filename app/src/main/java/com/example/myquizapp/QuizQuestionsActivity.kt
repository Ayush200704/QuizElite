package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0

    private var mUserName : String? = null
    private var mCorrectAnswer : Int = 0


    private var tvProgress: TextView? = null
    private var progressBar : ProgressBar? = null
    private var tvQuestions : TextView? = null
    private var ivImage : ImageView? = null
    private var tvOptionOne : TextView? = null
    private var tvOptionTwo : TextView? = null
    private var tvOptionThree : TextView? = null
    private var tvOptionFour : TextView? = null
    private var btnSubmit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestions = findViewById(R.id.tv_questions)
        ivImage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.tv_optionOne)
        tvOptionTwo = findViewById(R.id.tv_optionTwo)
        tvOptionThree = findViewById(R.id.tv_optionThree)
        tvOptionFour = findViewById(R.id.tv_optionFour)
        btnSubmit = findViewById(R.id.btn_Submit)

        mQuestionList = Constants.getQuestions()
        setQuestions()

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

    }
    private fun setQuestions() {

        defaultOptionView()
        val question = mQuestionList!![mCurrentPosition - 1]
        tvQuestions?.text = question.question
        ivImage?.setImageResource(question.image)
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        progressBar?.progress = mCurrentPosition
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
        if(mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text  = "FINISH"
        }
        else{
            btnSubmit?.text = "SUBMIT"
        }


    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvOptionOne?.let{
            options.add(0, it)
        }
        tvOptionTwo?.let{
            options.add(1, it)
        }
        tvOptionThree?.let{
            options.add(2, it)
        }
        tvOptionFour?.let{
            options.add(3, it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }

    }

    private fun selectedOptionView(tv : TextView, selectedOptionNumber : Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)


    }


    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_optionOne ->{
                tvOptionOne?.let{
                    selectedOptionView(it, 1)
                }
            }

            R.id.tv_optionTwo ->{
                tvOptionTwo?.let{
                    selectedOptionView(it, 2)
                }
            }

            R.id.tv_optionThree ->{
                tvOptionThree?.let{
                    selectedOptionView(it, 3)
                }
            }

            R.id.tv_optionFour ->{
                tvOptionFour?.let{
                    selectedOptionView(it, 4)
                }
            }
            
            R.id.btn_Submit -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionList!!.size->{
                            setQuestions()
                        }
                        else ->{
                            val intent = Intent(this, finishingPage::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList?.size)
                            intent.putExtra(Constants.CORRECT_QUESTIONS, mCorrectAnswer)
                            startActivity(intent)
                            finish()
                            //Toast.makeText(this, "you made it to the end", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else {
                    val question = mQuestionList!![mCurrentPosition - 1]

                    if (question.correct != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.incorrect_option_border_bg)

                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correct, R.drawable.correct_option_border_bg)


                    if (mCurrentPosition >= mQuestionList!!.size) {
                        btnSubmit?.text = "FINISH"

                    } else {
                        btnSubmit?.text = "GO TO THE NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }

            }
        }
    }

    private fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(this, drawableView)
            }

            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(this, drawableView)
            }

            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(this, drawableView)
            }

            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
}