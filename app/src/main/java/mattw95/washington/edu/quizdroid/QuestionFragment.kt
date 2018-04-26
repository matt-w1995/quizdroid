package mattw95.washington.edu.quizdroid

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_question.*

class QuestionFragment : Fragment() {

    var question : String = ""
    var quizType : String = ""


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

        txtquestion.text = question
        when(quizType){
            "Math" -> {
                btn1.text = "42"
                btn2.text = "2"
                btn3.text = "Sweet Dee"
                btn4.text = "The radius of the Sun"
            }
            "Physics" -> {
                btn1.text = "v = d/t"
                btn2.text = "Have you set it to wumbo"
                btn3.text = "y = mx + b"
                btn4.text = "v = s/a"
            }
            "Marvel Super Heroes"-> {
                btn1.text = "Drake Bell"
                btn2.text = "Tom Holland"
                btn3.text = "Tobey Maguire"
                btn4.text = "Andrew Garfield"
            }
        }

        var answer : String = ""
        val rdGroup = v.findViewById<RadioGroup>(R.id.radioGroupAnswers)
        rdGroup.setOnCheckedChangeListener { group, checkedId ->
            btn.isEnabled = true
            when(checkedId){
                R.id.radioButtonAns1 -> {
                    answer = btn1.text.toString()
                }
                R.id.radioButtonAns2 -> {
                    answer = btn2.text.toString()
                }
                R.id.radioButtonAns3 -> {
                    answer = btn3.text.toString()
                }
                R.id.radioButtonAns4 -> {
                    answer = btn4.text.toString()
                }
            }
        }

        btn.setOnClickListener({
            val intent = Intent(activity, QuizActivity::class.java)
            intent.putExtra("from", "question")
            intent.putExtra("quizType", quizType)
            intent.putExtra("userAns", answer)
            startActivity(intent)
        })

        return v
    }

    fun putArguments(args : Bundle) {
        question = args.getString("question")
        quizType = args.getString("quizType")
    }

}
