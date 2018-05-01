package mattw95.washington.edu.quizdroid

import android.util.Log
import android.app.Application

class QuizApp : Application(), TopicRepository {

    companion object {
        lateinit var instance : QuizApp
            private set

        lateinit var topicList : List<Topic>

    }

    override fun onCreate() {
        super.onCreate()
        Log.i("fucking", "fuck")
        instance = this

        val mathQuestion1 = Question("1 + 1 = ?", arrayOf("2", "42", "24", "0"), 0)
        val mathQuestion2 = Question("30 / 3 = ?", arrayOf("9", "7", "10", "15"), 2)

        val questionsMath = listOf(mathQuestion1, mathQuestion2)
        val topicMath = Topic("Math", "Number questions", "Contains a series of math questions", questionsMath)

        val physicsQuestion1 = Question("What is the formula for velocity", arrayOf("v = d / t", "v = mx + b", "v = d ^ 2", "v = d * t"), 0)
        val physicsQuestion2 = Question("What charge does an electron have?", arrayOf("positive", "neutral", "no charge", "negative"), 3)

        val questionsPhysics = listOf(physicsQuestion1, physicsQuestion2)
        val topicPhysics = Topic("Physics", "Science!", "Contains a series of physics questions", questionsPhysics)

        val marvelQuestion1 = Question("Who was the best spider-man?", arrayOf("Drake Bell", "Tobey Maguire", "Tom Holland", "Andrew Garfield"), 1)
        val marvelQuestion2 = Question("Groot?", arrayOf("I am groot!", "I am groot?", "I AM GROOOOT!", "We are groot."), 0)

        val questionsMarvel = listOf(marvelQuestion1, marvelQuestion2)
        val topicMarvel = Topic("Marvel Super Heroes", "Superheroes!", "Contains a series of marvel questions", questionsMarvel)

        topicList = listOf(topicMath, topicPhysics, topicMarvel)

        Log.d("QuizApp", "On create fired")
    }

    override fun getAllTopics(): List<Topic> {
        return topicList
    }

    override fun getTopic(i: Int): Topic {
        return topicList[i]
    }
}

data class Topic(val title: String, val shrtDes : String, val lngDes : String, val questions : List<Question>)
data class Question(val question : String, val answers : Array<String>, val correctAns : Int)

interface TopicRepository {
    fun getAllTopics() : List<Topic>
    fun getTopic(i : Int) : Topic
}