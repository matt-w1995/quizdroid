package mattw95.washington.edu.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_math_answer_page.*

class MathAnswerPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_answer_page)
        val extras : Bundle = intent.extras
        var answer = extras.getString("Answer")
        var correctAnswer = extras.getString("correctAnswer")

        if(answer == correctAnswer){
            txtCountCorrect.text = "You got 1 out of 1 correct!"
        } else {
            txtCountCorrect.text = "You got 0 out of 1 correct!"
        }
        answer = "Your answer was: " + answer
        correctAnswer = "The correct answer is: " + correctAnswer
        txtAnswerMathQtn1.text = answer
        textView2.text = correctAnswer

        btnMathFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
