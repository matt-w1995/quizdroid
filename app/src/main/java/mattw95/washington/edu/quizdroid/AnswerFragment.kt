package mattw95.washington.edu.quizdroid

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class AnswerFragment : Fragment() {

    var userAns : String = ""
    var quizType : String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_answer, container, false)

        val btn = v.findViewById<Button>(R.id.btnFinish)
        btn.setOnClickListener({
            val intent = Intent(activity, QuizActivity::class.java)
            intent.putExtra("from", "answer")
            startActivity(intent)
        })
        val correctAns = v.findViewById<TextView>(R.id.txtCorrectAns)
        val txtUserAns = v.findViewById<TextView>(R.id.txtUserAns)
        val correctCount = v.findViewById<TextView>(R.id.txtCorrectCount)

        var gotRight : Boolean = false
        when(quizType){
            "Math" -> {
                correctAns.text = "Correct answer is 2"
                gotRight = (userAns == "2")
            }
            "Physics" -> {
                correctAns.text = "Correct answer is v = d/t"
                gotRight = (userAns == "v = d/t")
            }
            "Marvel Super Heroes" -> {
                "Toby Maguire"
                gotRight = (userAns == "Tobey Maguire")
            }
        }

        txtUserAns.text = "Your answer was $userAns"

        if(gotRight){
            correctCount.text = "You got 1 out of 1 right!"
        } else {
            correctCount.text = "You got 0 out of 1 right!"
        }
        return v
    }

    fun putArguments(args : Bundle) {
        userAns = args.getString("userAns")
        quizType = args.getString("quizType")
    }
}
