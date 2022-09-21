package cto.its.ny.gov.fakenews.views.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cto.its.ny.gov.fakenews.R

class ArticleViewListHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    var contentTextView = itemView.findViewById<TextView>(R.id.content)
    var authorTextView = itemView.findViewById<TextView>(R.id.author)
    var descriptionTextView = itemView.findViewById<TextView>(R.id.description)
    var titleTextView = itemView.findViewById<TextView>(R.id.title)
//    var authorTextView = itemView.findViewById<TextView>(R.id.)
}