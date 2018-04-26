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

        val listView = findViewById<ListView>(R.id.list_view_topics)
        val topics : Array<String> = arrayOf("Math", "Physics", "Marvel Super Heroes")
        val adapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, topics)

        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val item : String = listView.getItemAtPosition(position).toString()
            val intent = Intent(this, QuizActivity::class.java)
            when(item){
                "Math" -> {
                    intent.putExtra("quizType", "Math")
                    intent.putExtra("question", "1 + 1 = ?")
                    intent.putExtra("ans1", "2")
                    intent.putExtra("ans2", "4")
                    intent.putExtra("ans3", "42")
                    intent.putExtra("ans4", "100")
                }
                "Physics" -> {
                    intent.putExtra("quizType", "Physics")
                    intent.putExtra("question", "What is velocity?")
                }
                "Marvel Super Heroes" -> {
                    intent.putExtra("quizType", "Marvel Super Heroes")
                    intent.putExtra("question", "Who was the best Spider-Man?")
                }
            }
            startActivity(intent)
        }
    }
}
