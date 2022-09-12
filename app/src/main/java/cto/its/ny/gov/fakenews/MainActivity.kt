package cto.its.ny.gov.fakenews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cto.its.ny.gov.fakenews.databinding.ActivityMainBinding
import cto.its.ny.gov.fakenews.views.adapter.ArticleViewListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var itemListRecyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {



//        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        itemListRecyclerView = binding.itemListRecyclerView
//            findViewById(R.id.itemListRecyclerView)
        itemListRecyclerView.layoutManager = LinearLayoutManager(this)
        itemListRecyclerView.adapter = ArticleViewListAdapter()

        setContentView(view)



    }

}