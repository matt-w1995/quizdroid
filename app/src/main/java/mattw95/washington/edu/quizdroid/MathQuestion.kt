package mattw95.washington.edu.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_math_question.*

class MathQuestion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_question)

        val extras : Bundle = intent.extras
        val quizType : String = extras.getString("quizType")
        val question : String = extras.getString("question")

        btnMathQtn1Submit.isEnabled = false

        txtMathQuestion1.text = question
        var correctAnswer : String = ""
        when(quizType){
            "Math" -> {
                txtMathQuestion1.text = question
                btnMathAns1.text = "42"
                btnMathAns2.text = "2"
                btnMathAns3.text = "Sweet Dee"
                btnMathAns4.text = "The radius of the Sun"
                correctAnswer = "2"
            }
            "Physics" -> {
                btnMathAns1.text = "v = d/t"
                btnMathAns2.text = "Have you set it to wumbo"
                btnMathAns3.text = "y = mx + b"
                btnMathAns4.text = "v = s/a"
                correctAnswer = "v = d/t"
            }
            "Marvel Super Heroes"-> {
                btnMathAns1.text = "Drake Bell"
                btnMathAns2.text = "Tom Holland"
                btnMathAns3.text = "Tobey Maguire"
                btnMathAns4.text = "Andrew Garfield"
                correctAnswer = "Tobey Maguire"
            }

        }

        var answer : String = "error"
        rdGroupMathQtn1.setOnCheckedChangeListener { group, checkedId ->
            btnMathQtn1Submit.isEnabled = true
            when(checkedId){
                R.id.btnMathAns1 -> {
                    answer = btnMathAns1.text.toString()
                }
                R.id.btnMathAns2 -> {
                    answer = btnMathAns2.text.toString()
                }
                R.id.btnMathAns3 -> {
                    answer = btnMathAns3.text.toString()
                }
                R.id.btnMathAns4 -> {
                    answer = btnMathAns4.text.toString()
                }
            }
        }

        btnMathQtn1Submit.setOnClickListener {
            val intent = Intent(this, MathAnswerPageActivity::class.java)
            intent.putExtra("Answer", answer)
            intent.putExtra("correctAnswer", correctAnswer)
            startActivity(intent)

        }
    }
}
