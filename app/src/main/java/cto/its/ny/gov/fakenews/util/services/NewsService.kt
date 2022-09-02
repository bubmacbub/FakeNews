package cto.its.ny.gov.fakenews.util.services

import cto.its.ny.gov.fakenews.model.Article
import cto.its.ny.gov.fakenews.model.Source
import cto.its.ny.gov.fakenews.util.constants.SourceCategories
import cto.its.ny.gov.fakenews.util.constants.SourceLanguages

class NewsService {

    fun createArticles(amountOfArticles: IntRange): ArrayList<Article> {

        val arrayOfAticles = arrayListOf<Article>()
        for (index in amountOfArticles) {
            val src = Source(name = "Newspaper" + index, category = SourceCategories.SCIENCE, language = SourceLanguages.ar)
            val atcl = Article(
                source = src,
                author = "author $index",
                title = "Title $index",
                url = "http://google.com",
                publishedAt = "just now"
            )
            arrayOfAticles.add( atcl)


            //When using this map there is no need to figure out what article binds with what view
//            when (index) {
//
            }
        return arrayOfAticles
        }
    }