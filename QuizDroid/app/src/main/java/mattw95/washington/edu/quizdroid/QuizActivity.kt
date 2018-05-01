package mattw95.washington.edu.quizdroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log


class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val topicSelected = intent.getIntExtra("topicSelected", 0)

        val transaction = fragmentManager.beginTransaction()
        val bundle = Bundle()

        bundle.putInt("topicSelected", topicSelected)
        bundle.putInt("currentQuestion", 0)

        val fragment = OverviewFragment()
        fragment.arguments = bundle

        transaction.add(R.id.container, fragment).commit()

    }

}
