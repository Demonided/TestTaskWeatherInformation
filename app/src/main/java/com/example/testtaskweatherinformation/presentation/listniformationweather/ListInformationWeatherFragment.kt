package com.example.testtaskweatherinformation.presentation.listniformationweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtaskweatherinformation.databinding.FragmentInformationListBinding
import com.example.testtaskweatherinformation.presentation.information.InformationWeatherViewModel
import com.example.testtaskweatherinformation.presentation.listniformationweather.adapter.ListInformationWeatherAdapter
import com.example.testtaskweatherinformation.util.debugLog
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListInformationWeatherFragment: Fragment() {

    private val viewModel by viewModel<ListInformationWeatherViewModel>()

    private var _binding: FragmentInformationListBinding? = null
    private val binding get() = _binding!!

    lateinit var adapter: ListInformationWeatherAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentInformationListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ListInformationWeatherAdapter(emptyList())

        binding.informationListRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.informationListRecycler.adapter = adapter

        viewModel.weatherData.observe(viewLifecycleOwner) { item ->
            adapter.updateWeatherData(item)

            adapter.notifyDataSetChanged()

            debugLog(TAG) {
                ("Данные подписки = ${item.size}")
            }
        }
    }

    companion object {
        const val TAG = "ListInformationWeatherFragment"
    }
}