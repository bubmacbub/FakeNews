package cto.its.ny.gov.fakenews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cto.its.ny.gov.fakenews.databinding.ActivityArticleDetailBinding
import cto.its.ny.gov.fakenews.model.Article

class ArticleDetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityArticleDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_article_detail)
        val article = intent.getParcelableExtra<Article>(MainActivity.INTENT_DETAILS_KEY) as Article
        title = article.title
        binding = ActivityArticleDetailBinding.inflate(layoutInflater)
        binding.detailsAuthor.text = article.author
        binding.detailsContent.text = article.content
        binding.detailsDescription.text = article.description

        setContentView(binding.root)
    }
}