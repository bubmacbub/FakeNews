package cto.its.ny.gov.fakenews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cto.its.ny.gov.fakenews.databinding.ActivityMainBinding
import cto.its.ny.gov.fakenews.model.Article

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val arrayOfAticles = arrayListOf<Article>(Article(userName = "user1", email="user1@email.com", name="Article OG"))

    override fun onCreate(savedInstanceState: Bundle?) {

//        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val amountOfArticles =  0 .. 5
        createArticles(amountOfArticles)

        addArticlesToView(amountOfArticles)


    }

    private fun addArticlesToView(amountOfArticles: IntRange) {
        for(index in amountOfArticles)
        {
            when(index){
                0 ->  {
                    binding.textView.text=arrayOfAticles[index]?.name
                }
                1 ->  {
                   binding.textView2.text=arrayOfAticles[index]?.name
                }
                2 ->  {
                   binding.textView3.text=arrayOfAticles[index]?.name
                }
                3 ->  {
                    binding.textView4.text=arrayOfAticles[index]?.name
                }

                else -> {
                   binding.textView5.text=arrayOfAticles[index]?.name
                }
            }

        }

    }

    private fun createArticles(amountOfArticles: IntRange) {


        for(index in amountOfArticles)
        {
            val userName = "user" + index
            arrayOfAticles.add(Article(userName = userName, email = userName + "@email.com", name = "Article " +index))
        }


    }
}