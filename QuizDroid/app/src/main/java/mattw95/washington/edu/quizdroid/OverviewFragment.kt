package mattw95.washington.edu.quizdroid

import android.content.Intent
import android.os.Bundle
import android.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class OverviewFragment : Fragment(){

    private lateinit var topic : Topic
    var topicSelected = 0
    var currentQuestion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(arguments != null) {
            topicSelected = arguments.getInt("topicSelected")
            currentQuestion = arguments.getInt("currentQuestion")
            topic = QuizApp.instance.getTopic(topicSelected)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_overview, container, false)

        val btn = v.findViewById<Button>(R.id.btnBegin)
        val description : TextView = v.findViewById(R.id.txtDescription)
        val questionCount : TextView = v.findViewById(R.id.textQuestionCount)

        btn.setOnClickListener{
            val transaction = fragmentManager.beginTransaction()
            val fragment = QuestionFragment()

            val bundle = Bundle()
            bundle.putInt("topicSelected", topicSelected)
            bundle.putInt("currentQuestion", currentQuestion)
            bundle.putInt("correctCount", 0)

            fragment.arguments = bundle

            transaction.replace(R.id.container, fragment).commit()
        }

        description.text = topic.lngDes
        questionCount.text = "This quiz contains ${topic.questions.size.toString()} questions"


        return v
    }
}
