package cto.its.ny.gov.fakenews.util.services

import cto.its.ny.gov.fakenews.model.Article
import cto.its.ny.gov.fakenews.model.ArticleResponse
import cto.its.ny.gov.fakenews.model.Source
import cto.its.ny.gov.fakenews.util.constants.SourceCategories
import cto.its.ny.gov.fakenews.util.constants.SourceLanguages
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class NewsService {

    val svc = buildRetrofitService()

    fun createArticles(amountOfArticles: IntRange): List<Article> {

        var arrayOfAticles = listOf<Article>()
//        for (index in amountOfArticles) {
//            val src = Source(name = "Newspaper" + index, category = SourceCategories.SCIENCE, language = SourceLanguages.ar)
//            val atcl = Article(
//                source = src,
//                author = "author $index",
//                title = "Title $index",
//                url = "http://google.com",
//                publishedAt = "just now",
//                description = "Description that really helps version $index",
//                content ="Some really long content that makes this seem like some sort of real news.  But we all know it isn't.  To be honest this content isn't even really that long compared to how long winded writers are these days.  Bloggers just telling us their feelings on subjects and their opinions aren't based on facts.  This is almost as bad as old news that would skew facts to how their audeince likes to recive information but either way this is a short paragraph compared to them."
//            )
//            arrayOfAticles.add( atcl)
//
//
//            //When using this map there is no need to figure out what article binds with what view
////            when (index) {
////
//            }
        GlobalScope.launch {
            val newsSvcResponse = svc.getNews()
            if(newsSvcResponse != null)
            {
                arrayOfAticles = newsSvcResponse.body()?.articles!!
            }

        }
        return arrayOfAticles
        }

    fun buildRetrofitService() : NewsApiService{
        return Retrofit.Builder()
            .baseUrl(" https://newsapi.org")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }
    }


interface NewsApiService {
    @GET("/v2/top-headlines?country=us&apiKey=b64bbf6ac15a4d199d45cfdf1f0b2cf8")
    suspend fun getNews(): Response<ArticleResponse>
}