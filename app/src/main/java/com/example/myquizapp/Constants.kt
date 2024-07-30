package com.example.myquizapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_QUESTIONS : String = "correct_questions"


    fun getQuestions() : ArrayList<Question>{



        val questionList = ArrayList<Question>()

        val ques1 = Question(
            1, "Which country does this flag belongs to?",
            R.drawable.ic_flag_of_argentina, "Argentina", "Australia", "Austria",
            "None of the above", 1
        )
        questionList.add(ques1)

        val ques2 = Question(
            2,"Which country does this flag belongs to?", R.drawable.ic_flag_of_australia, "Armenia", "Australia", "Andorra",
            "Angola", 2
        )
        questionList.add(ques2)

        val ques3 = Question(
            3,"Which country does this flag belongs to?", R.drawable.ic_flag_of_belgium, "Brazil", "Belgium", "Bhutan",
            "Barbados", 2
        )
        questionList.add(ques3)

        val ques4 = Question(
            4,"Which country does this flag belongs to?", R.drawable.ic_flag_of_brazil, "Barbados", "Bahrain", "Bangladesh",
            "Brazil", 4
        )
        questionList.add(ques4)

        val ques5 = Question(
            5,"Which country does this flag belongs to?", R.drawable.ic_flag_of_denmark, "Dominican Republic", "Denmark", "Dominica",
            "Djibouti", 2
        )
        questionList.add(ques5)

        val ques6 = Question(
            6,"Which country does this flag belongs to?", R.drawable.ic_flag_of_fiji, "Figi", "France", "Finland",
            "None of the above", 1
        )
        questionList.add(ques6)

        val ques7 = Question(
            7,"Which country does this flag belongs to?", R.drawable.ic_flag_of_germany, "Georgia", "Germany", "Greece",
            "Ghana", 2
        )
        questionList.add(ques7)

        val ques8 = Question(
            8,"Which country does this flag belongs to?", R.drawable.ic_flag_of_india, "Indonesia", "Iran", "Italy",
            "India", 4
        )
        questionList.add(ques8)

        val ques9 = Question(
            9,"Which country does this flag belongs to?", R.drawable.ic_flag_of_kuwait, "kuwait", "Kenya", "Korea",
            "Kyrgyzstan", 1
        )
        questionList.add(ques9)

        val ques10 = Question(
            10,"Which country does this flag belongs to?", R.drawable.ic_flag_of_new_zealand, "Netherlands", "Nepal", "New Zealand",
            "Namibia", 3
        )
        questionList.add(ques10)

        return questionList



    }
}