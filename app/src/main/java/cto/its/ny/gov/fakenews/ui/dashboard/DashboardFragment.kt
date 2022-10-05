package cto.its.ny.gov.fakenews.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cto.its.ny.gov.fakenews.databinding.FragmentDashboardBinding
import cto.its.ny.gov.fakenews.util.services.NewsService
import cto.its.ny.gov.fakenews.views.adapter.ArticleViewListAdapter

class DashboardFragment : Fragment() {

    lateinit var itemListRecyclerView: RecyclerView
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    val dashboardViewModel: DashboardViewModel by viewModels {
        DashboardViewModel.Factory(NewsService().buildRetrofitService())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        = ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        itemListRecyclerView = binding.itemListRecyclerView
//            findViewById(R.id.itemListRecyclerView)
//        itemListRecyclerView.layoutManager = LinearLayoutManager(this)

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        dashboardViewModel.articles.observe(viewLifecycleOwner){
            itemListRecyclerView.adapter = ArticleViewListAdapter(it)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}