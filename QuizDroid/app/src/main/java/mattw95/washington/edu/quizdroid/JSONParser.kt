package mattw95.washington.edu.quizdroid

import android.os.AsyncTask
import org.json.JSONArray
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL

class JSONParser() : TopicRepository, AsyncTask<String, String, String>() {
    val topic_list = ArrayList<Topic>()
    var url = ""

    init {
        url = "http://tednewardsandbox.site44.com/questions.json"
        execute(url).get()
    }

    override fun getAllTopics(): List<Topic> {
        return topic_list
    }

    override fun getTopic(i: Int): Topic {
       return topic_list[i]
    }

    override fun doInBackground(vararg params: String?): String {
        val connect = URL(url).openConnection() as HttpURLConnection

        var input = ""

        try {
            input = BufferedInputStream(connect.inputStream).use {
                it.reader().use {
                    reader -> reader.readText()
                }
            }
        } finally {
            connect.disconnect()
        }

        val json = JSONArray(input)

        for (i in 0..(json.length() - 1)) {
            val topic = json.getJSONObject(i)
            val title = topic.getString("title")
            val description = topic.getString("desc")
            val questions = topic.getJSONArray("questions")
            val questionList = ArrayList<Question>()
            
            for (j in 0..(questions.length() - 1)) {
                val question = questions.getJSONObject(j)
                val questionText = question.getString("text")
                val correctAnswer = question.getInt("answer") - 1

                val answerList = question.getJSONArray("answers")
                val answers = Array(answerList.length()) { "" }
                
                for (k in 0..(answerList.length() - 1)) {
                    answers[k] = answerList[k].toString()
                }
                questionList.add(Question(questionText, answers, correctAnswer))
            }
            topic_list.add(Topic(title, description, description, questionList))
        }
        return input
    }
}