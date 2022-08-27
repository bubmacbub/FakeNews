package cto.its.ny.gov.fakenews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.allViews
import androidx.core.view.children
import cto.its.ny.gov.fakenews.databinding.ActivityMainBinding
import cto.its.ny.gov.fakenews.model.Article
import cto.its.ny.gov.fakenews.model.Source
import java.time.Instant
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val arrayOfAticles = arrayListOf<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {

//        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val amountOfArticles =  0 .. 5
        createArticles(amountOfArticles)

        addArticlesToView(amountOfArticles)

        for (child in view.children)
        {
            println("Child " + child)
            for(vws in child.allViews)
            {
                println("View " + vws)
            }

        }



    }

    private fun addArticlesToView(amountOfArticles: IntRange) {
        for(index in amountOfArticles)
        {
            when(index){
                0 ->  {
                    binding.textView.text=arrayOfAticles[index]?.title
                }
                1 ->  {
                   binding.textView2.text=arrayOfAticles[index]?.title
                }
                2 ->  {
                   binding.textView3.text=arrayOfAticles[index]?.title
                }
                3 ->  {
                    binding.textView4.text=arrayOfAticles[index]?.title
                }

                else -> {
                   binding.textView5.text=arrayOfAticles[index]?.title
                }
            }

        }

    }

    private fun createArticles(amountOfArticles: IntRange) {


        for(index in amountOfArticles)
        {
//            DateTimeFormatter.ISO_INSTANT.format(Instant.now())
            val userName = "user" + index
            val src = Source(name="Newspaper" + index)
            var atcl = Article(source=src,author="author " + index, title="Title " + index, url="http://google.com", publishedAt ="just now")
            arrayOfAticles.add(atcl)
        }


    }
}