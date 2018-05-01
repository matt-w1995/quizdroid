package mattw95.washington.edu.quizdroid

import android.content.Intent
import android.os.Bundle
import android.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView

class QuestionFragment : Fragment() {

    private lateinit var topic : Topic
    var topicSelected = 0
    var currentQuestion = 0
    var correctCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(arguments != null) {
            topicSelected = arguments.getInt("topicSelected")
            currentQuestion = arguments.getInt("currentQuestion")
            correctCount = arguments.getInt("correctCount")
            topic = QuizApp.instance.getTopic(topicSelected)
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_question, container, false)

        val btn = v.findViewById<Button>(R.id.btnSubmit)
        btn.isEnabled = false

        val txtquestion = v.findViewById<TextView>(R.id.textQuestion)
        val btn1 = v.findViewById<Button>(R.id.radioButtonAns1)
        val btn2 = v.findViewById<Button>(R.id.radioButtonAns2)
        val btn3 = v.findViewById<Button>(R.id.radioButtonAns3)
        val btn4 = v.findViewById<Button>(R.id.radioButtonAns4)
        val question = topic.questions[currentQuestion]

        txtquestion.text = question.question

        btn1.text = question.answers[0]
        btn2.text = question.answers[1]
        btn3.text = question.answers[2]
        btn4.text = question.answers[3]


        var answer : Int = 0
        val rdGroup = v.findViewById<RadioGroup>(R.id.radioGroupAnswers)
        rdGroup.setOnCheckedChangeListener { group, checkedId ->
            btn.isEnabled = true
            when(checkedId){
                R.id.radioButtonAns1 -> {
                    answer = 0
                }
                R.id.radioButtonAns2 -> {
                    answer = 1
                }
                R.id.radioButtonAns3 -> {
                    answer = 2
                }
                R.id.radioButtonAns4 -> {
                    answer = 3
                }
            }
        }

        btn.setOnClickListener({
            val transaction = fragmentManager.beginTransaction()
            val fragment = AnswerFragment()
            val bundle = Bundle()

            bundle.putInt("userAnswer", answer)
            bundle.putInt("topicSelected", topicSelected)
            bundle.putInt("currentQuestion", currentQuestion)
            bundle.putInt("correctCount", correctCount)

            fragment.arguments = bundle
            transaction.replace(R.id.container, fragment).commit()
        })
        return v
    }
}
