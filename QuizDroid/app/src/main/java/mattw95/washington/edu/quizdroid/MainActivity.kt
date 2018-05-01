package mattw95.washington.edu.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quizApp = QuizApp
        val topics = QuizApp.topicList

        val listView = findViewById<ListView>(R.id.list_view_topics) as ListView

        val topicsList = listOf(topics[0].title, topics[1].title, topics[2].title)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, topicsList)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, id ->
            val intent = Intent(this, QuizActivity::class.java).apply {
                putExtra("topicSelected", position)
            }
            startActivity(intent)
        }
    }
}
