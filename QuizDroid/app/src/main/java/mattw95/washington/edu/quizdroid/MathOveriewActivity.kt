package mattw95.washington.edu.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_math_overiew.*

class MathOveriewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_overiew)

        val extras : Bundle = intent.extras
        val quizType : String = extras.getString("quizType")
        val question : String = extras.getString("question")

        val description : String = "Contains " + quizType + " questions"
        txtDescription.text = description

        btnNextMath.setOnClickListener {
            val intent = Intent(this, MathQuestion::class.java)
            intent.putExtra("quizType", quizType)
            intent.putExtra("question", question)
            startActivity(intent)
        }
    }
}
