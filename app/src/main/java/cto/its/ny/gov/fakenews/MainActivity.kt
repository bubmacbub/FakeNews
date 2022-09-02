package cto.its.ny.gov.fakenews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.allViews
import androidx.core.view.children
import cto.its.ny.gov.fakenews.databinding.ActivityMainBinding
import cto.its.ny.gov.fakenews.model.Article
import cto.its.ny.gov.fakenews.util.services.NewsService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var arrayOfArticles = arrayListOf<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {

//        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val amountOfArticles = 0..5
        val nSvc = NewsService()
        arrayOfArticles = nSvc.createArticles(amountOfArticles)

        addArticlesToView(amountOfArticles)

        for (child in view.children) {
            println("Child $child")
            for (vws in child.allViews) {
                println("View $vws")
            }

        }


    }

    private fun addArticlesToView(amountOfArticles: IntRange) {
        for (index in amountOfArticles) {
            when (index) {
                0 -> {
                    addArticleToView(binding.textView, arrayOfArticles[index])

                }
                1 -> {
                    addArticleToView(binding.textView2, arrayOfArticles[index])
                }
                2 -> {
                    addArticleToView(binding.textView3, arrayOfArticles[index])
                }
                3 -> {
                    addArticleToView(binding.textView4, arrayOfArticles[index])
                }

                else -> {
                    addArticleToView(binding.textView5, arrayOfArticles[index])
                }
            }

        }
//        mapOfArticles.forEach { (textView, article) ->
//
//                println("Adding " + article + " to " + textView)
//                textView.text = article.toString()
//
//        }
    }

    private fun addArticleToView(txtView: TextView, article: Article) {
        var concatString = ""
        val title: StringBuilder = StringBuilder()
        title.append("  Title: ")
        title.append((article.title))
        concatString = concatString.plus(title.toString())
        concatString = concatString.plus("  Author: ${article.author}")
        if (article.source?.name != null) {
            concatString = concatString + "  Source: " + article.source?.name
        }
        txtView.text = concatString
    }




}