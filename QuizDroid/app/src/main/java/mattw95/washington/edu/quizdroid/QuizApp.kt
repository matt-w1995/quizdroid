package mattw95.washington.edu.quizdroid

import android.util.Log
import android.app.Application


class QuizApp : Application() {
    companion object {
        lateinit var instance : JSONParser
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = JSONParser()
        Log.d("QuizApp", "On create fired")
    }
}

data class Topic(val title: String, val shrtDes : String, val lngDes : String, val questions : List<Question>)
data class Question(val question : String, val answers : Array<String>, val correctAns : Int)

interface TopicRepository {
    fun getAllTopics() : List<Topic>
    fun getTopic(i : Int) : Topic
}