package tech.fingercode.smallapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import tech.fingercode.smallapp.SmallAppApplication
import tech.fingercode.smallapp.databinding.FragmentHomeBinding
import tech.fingercode.smallapp.di.AppComponent
import tech.fingercode.smallapp.ui.home.di.DaggerHomeFragmentComponent
import tech.fingercode.smallapp.utils.Status

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.getWatchList(1).observe(viewLifecycleOwner, Observer {
            it?.let { it ->
                when (it.status) {
                    Status.SUCCESS -> {

                    }
                    Status.LOADING -> {

                    }

                    Status.ERROR -> {

                    }
                }
            }
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun inject() {
        DaggerHomeFragmentComponent.builder().appComponent(getAppComponent()).build().inject(this)
    }

    private fun getAppComponent(): AppComponent? {
        return (context?.applicationContext as SmallAppApplication).getApplicationComponent()
    }
}