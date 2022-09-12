package cto.its.ny.gov.fakenews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cto.its.ny.gov.fakenews.databinding.ActivityMainBinding
import cto.its.ny.gov.fakenews.model.Article
import cto.its.ny.gov.fakenews.views.adapter.ArticleViewListAdapter

class MainActivity : AppCompatActivity() , ArticleViewListAdapter.ArticleClickListener{
    private lateinit var binding: ActivityMainBinding
    lateinit var itemListRecyclerView: RecyclerView

    companion object{
       const val INTENT_DETAILS_KEY = "details"
    }

    override fun onCreate(savedInstanceState: Bundle?) {



//        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        itemListRecyclerView = binding.itemListRecyclerView
//            findViewById(R.id.itemListRecyclerView)
        itemListRecyclerView.layoutManager = LinearLayoutManager(this)
        itemListRecyclerView.adapter = ArticleViewListAdapter(this)

        setContentView(view)



    }

    private fun showArticleDetails(artcle: Article)
    {
        val listItem = Intent(this, ArticleDetailActivity::class.java)
        listItem.putExtra(INTENT_DETAILS_KEY, artcle)
        startActivity(listItem)
    }

    override fun itemClicked(artcl: Article) {
    showArticleDetails(artcl)
    }

}