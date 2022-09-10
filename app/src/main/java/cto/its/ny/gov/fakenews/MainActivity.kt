package cto.its.ny.gov.fakenews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.allViews
import androidx.core.view.children
import cto.its.ny.gov.fakenews.databinding.ActivityMainBinding
import cto.its.ny.gov.fakenews.databinding.ArticleViewBinding
import cto.its.ny.gov.fakenews.model.Article
import cto.its.ny.gov.fakenews.util.services.NewsService
import cto.its.ny.gov.fakenews.views.ArticleView

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

        arrayOfArticles.forEach { artcl ->

                val articleView = ArticleView(this)
                articleView.setArticle(artcl)
                binding.articleContainer.addView(articleView)

        }


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