package mattw95.washington.edu.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))


        val quizApp = QuizApp
        val topics = quizApp.instance.getAllTopics()

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val intent = Intent(this, Preferences_Activity::class.java)
        startActivity(intent)
        return true
    }
}
