package cto.its.ny.gov.fakenews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.allViews
import androidx.core.view.children
import cto.its.ny.gov.fakenews.databinding.ActivityMainBinding
import cto.its.ny.gov.fakenews.model.Article
import cto.its.ny.gov.fakenews.model.Source

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
                    addArticleToView(binding.textView, arrayOfAticles[index])

                }
                1 ->  {
                    addArticleToView(binding.textView2, arrayOfAticles[index])
                }
                2 ->  {
                    addArticleToView(binding.textView3, arrayOfAticles[index])
                }
                3 ->  {
                    addArticleToView(binding.textView4, arrayOfAticles[index])
                }

                else -> {
                    addArticleToView(binding.textView5, arrayOfAticles[index])
                }
            }

        }

    }

    private fun addArticleToView(txtView: TextView, article: Article) {
        var concatString:String = ""
        var title:StringBuilder = StringBuilder(); var author=""; var srcName = "";
        if(article?.title != null)
        {
            title.append("  Title: ")
            title.append((article.title))
            concatString = concatString.plus(title.toString())
        }
        if(article?.author != null)
        {
            concatString = concatString.plus("  Author: ${article.author}")
        }
        if(article?.source?.name != null)
        {
            concatString = concatString + "  Source: " + article.source?.name
        }
        txtView.text = concatString
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