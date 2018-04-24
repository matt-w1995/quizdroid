package mattw95.washington.edu.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlin.math.log

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
            when(item){
                "Math" -> {
                    val intent = Intent(this, MathOveriewActivity::class.java)
                    intent.putExtra("quizType", "Math")
                    intent.putExtra("question", "1 + 1 = ?")
                    startActivity(intent)
                }
                "Physics" -> {
                    val intent = Intent(this, MathOveriewActivity::class.java)
                    intent.putExtra("quizType", "Physics")
                    intent.putExtra("question", "What is velocity?")
                    startActivity(intent)
                }
                "Marvel Super Heroes" -> {
                    val intent = Intent(this, MathOveriewActivity::class.java)
                    intent.putExtra("quizType", "Marvel Super Heroes")
                    intent.putExtra("question", "Who was the best Spider-Man?")
                    startActivity(intent)
                }
            }
        }

    }


}
