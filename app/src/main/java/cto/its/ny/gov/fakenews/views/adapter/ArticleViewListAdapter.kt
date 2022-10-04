package cto.its.ny.gov.fakenews.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cto.its.ny.gov.fakenews.R
import cto.its.ny.gov.fakenews.model.Article
import cto.its.ny.gov.fakenews.util.services.NewsService
import cto.its.ny.gov.fakenews.views.holder.ArticleViewListHolder

class ArticleViewListAdapter(
   val arrayOfArticles: List<Article>
): RecyclerView.Adapter<ArticleViewListHolder>() {


    interface ArticleClickListener {
        fun itemClicked(artcl: Article)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_view_item_list_holder, parent, false)
        return ArticleViewListHolder((view))
    }

    override fun onBindViewHolder(holder: ArticleViewListHolder, position: Int) {
        holder.authorTextView.text = arrayOfArticles[position].author
        holder.descriptionTextView.text = arrayOfArticles[position].description
        holder.titleTextView.text = arrayOfArticles[position].title
//        holder.itemView.setOnClickListener{ clickListener.itemClicked(arrayOfArticles[position])}
//        holder.contentTextView.text = arrayOfArticles[position].content
//        holder.publishedAtTextView.text = arrayOfArticles[position].publishedAt
//        holder.sourceNameTextView.text = arrayOfArticles[position].source?.name
    }

    override fun getItemCount(): Int {
       return arrayOfArticles.size
    }
}