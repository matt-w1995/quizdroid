package mattw95.washington.edu.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class QuizActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val extras : Bundle = intent.extras
        val from = extras.getString("from")

        if(from == "overview"){
            showQuestion(extras.getString("question"), extras.getString("quizType"))
        } else if (from == "question"){
            showAnswer(extras.getString("userAns"), extras.getString("quizType"))
        } else if(from == "answer"){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            showQuestionOverview(extras.getString("question"), extras.getString("quizType"))
        }
    }

    fun showQuestionOverview(question : String, quizType : String){
        val bundle = Bundle()
        bundle.putString("question", question)
        bundle.putString("quizType", quizType)

        val transaction = supportFragmentManager.beginTransaction()
        val fragment = OverviewFragment()
        fragment.putArguments(bundle)

        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun showQuestion(question : String, quizType: String){
        val bundle = Bundle()
        bundle.putString("question", question)
        bundle.putString("quizType", quizType)

        val transaction = supportFragmentManager.beginTransaction()
        val fragment = QuestionFragment()
        fragment.putArguments(bundle)

        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun showAnswer(userAns : String, quizType : String){
        val bundle = Bundle()
        bundle.putString("userAns", userAns)
        bundle.putString("quizType", quizType)

        val transaction = manager.beginTransaction()
        val fragment = AnswerFragment()
        fragment.putArguments(bundle)

        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
