package mattw95.washington.edu.quizdroid

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class AnswerFragment : Fragment() {

    private lateinit var topic : Topic
    var topicSelected = 0
    var currentQuestion = 0
    var userAnswer = 0
    var correctCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(arguments != null) {
            topicSelected = arguments.getInt("topicSelected")
            currentQuestion = arguments.getInt("currentQuestion")
            userAnswer = arguments.getInt("userAnswer")
            correctCount = arguments.getInt("correctCount")
            topic = QuizApp.instance.getTopic(topicSelected)
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_answer, container, false)
        Log.i("count1", correctCount.toString())
        val btn = v.findViewById<Button>(R.id.btnFinish)
        if(currentQuestion == topic.questions.size - 1) {
            btn.text = "Finish"
        } else {
            btn.text = "Next"
        }
        btn.setOnClickListener({
            if(currentQuestion == topic.questions.size - 1) {
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            } else {
                val transaction = fragmentManager.beginTransaction()
                val fragment = QuestionFragment()
                val bundle = Bundle()

                bundle.putInt("currentQuestion", currentQuestion+1)
                bundle.putInt("topicSelected", topicSelected)
                bundle.putInt("correctCount", correctCount)

                fragment.arguments = bundle
                transaction.replace(R.id.container, fragment).commit()
            }
        })

        val correctAns = v.findViewById<TextView>(R.id.txtCorrectAns)
        val txtUserAns = v.findViewById<TextView>(R.id.txtUserAns)
        val txtcorrectCount = v.findViewById<TextView>(R.id.txtCorrectCount)

        val question = topic.questions[currentQuestion]

        correctAns.text = "The correct answer was ${question.answers[question.correctAns]}"
        txtUserAns.text = "Your answer was ${question.answers[userAnswer]}"

        if(userAnswer == question.correctAns) {correctCount = correctCount + 1}
        Log.i("count2", correctCount.toString())
        txtcorrectCount.text = "You got $correctCount out of ${topic.questions.size} right!"


        return v
    }
}
