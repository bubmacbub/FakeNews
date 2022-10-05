package cto.its.ny.gov.fakenews.ui.dashboard

import androidx.lifecycle.*
import cto.its.ny.gov.fakenews.model.Article
import cto.its.ny.gov.fakenews.util.services.NewsApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel(private val newsService: NewsApiService) : ViewModel() {

    class Factory(
        private val starWarsApiService: NewsApiService,
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DashboardViewModel(starWarsApiService) as T
        }
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    val articles = MutableLiveData<List<Article>>()

    init {

        viewModelScope.launch(Dispatchers.IO){
            val response = newsService.getNews()
            if(response?.body() != null)
            {
                articles.postValue(response.body()!!.articles)
            }
        }
    }
}