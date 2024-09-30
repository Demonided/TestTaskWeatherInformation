package com.example.testtaskweatherinformation.presentation.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.testtaskweatherinformation.databinding.FragmentInformationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class InformationWeatherFragment: Fragment() {

    private val viewModel by viewModel<InformationWeatherViewModel>()

    private var _binding: FragmentInformationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentInformationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.informationButtonSearch.setOnClickListener {
            val cityName = binding.informationSearch.text.toString()
            if (cityName.isNotEmpty()) {
                viewModel.fetchWeatherByCity(cityName)
            } else {
                Toast.makeText(requireContext(), "Please enter a city name", Toast.LENGTH_SHORT).show()
            }
        }

        // Отображение данных о погоде подпиской к лайв дате
        viewModel.weatherData.observe(viewLifecycleOwner) { info ->
            if (info.id != 0) {
                binding.informationLayoutAll.visibility = View.VISIBLE
            }
            binding.informationName.text = info.name
            binding.informationTemp.text = info.main.temp.toString()
            binding.informationHumidity.text = info.main.humidity.toString()
            binding.informationPressure.text = info.main.pressure.toString()
            binding.informationSpeed.text = info.wind.speed.toString()
        }

        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
//            if (errorMessage.isNotEmpty()) {
//                binding.informationLayoutAll.visibility = View.GONE
//            } else {
//                binding.informationLayoutAll.visibility = View.VISIBLE
//            }
            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
        }
    }
}