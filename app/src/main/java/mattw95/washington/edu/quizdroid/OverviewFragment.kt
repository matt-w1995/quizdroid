package mattw95.washington.edu.quizdroid

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_overview.*


class OverviewFragment : Fragment(){

    var question : String = ""
    var quiztype : String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_overview, container, false)

        val btn = v.findViewById<Button>(R.id.btnBegin)
        btn.setOnClickListener({
            val intent = Intent(activity, QuizActivity::class.java)
            intent.putExtra("from", "overview")
            intent.putExtra("question", question)
            intent.putExtra("quizType", quiztype)
            startActivity(intent)
        })

        val description : TextView = v.findViewById(R.id.txtDescription)
        val quiz : TextView = v.findViewById(R.id.textQuestionCount)

        description.text = "This quiz contains $quiztype questions"
        quiz.text = "This quiz contains 1 question"

        return v
    }

    fun putArguments(args : Bundle){
        question = args.getString("question")
        quiztype = args.getString("quizType")
    }
}
