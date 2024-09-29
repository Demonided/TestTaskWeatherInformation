package com.example.testtaskweatherinformation.presentation.root

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.testtaskweatherinformation.R
import com.example.testtaskweatherinformation.databinding.ActivityRootBinding

/**Тестовое задание: Приложение для просмотра и сохранения данных о погоде**

 **Описание:**

Создайте Android-приложение на Kotlin, которое будет получать данные о погоде из открытого API и сохранять их в локальной базе данных SQLite. Приложение должно позволять пользователю просматривать текущую погоду и историю запросов.

 **Требования:**

1. **Получение данных о погоде:**
- Используйте открытый API, например, OpenWeatherMap (https://openweathermap.org/api), для получения текущих данных о погоде.
- Реализуйте возможность ввода пользователем названия города для получения данных о погоде.

2. **Отображение данных:**
- Отобразите текущую погоду для выбранного города, включая температуру, описание погоды и другие доступные данные.
- Используйте `RecyclerView` для отображения истории запросов.

3. **Сохранение данных:**
- Сохраните данные о каждом запросе (город, температура, описание, дата и время запроса) в локальной базе данных SQLite.
- Реализуйте возможность просмотра истории запросов.

4. **Архитектура:**
- Используйте архитектурный паттерн MVVM (Model-View-ViewModel).
- Используйте `Room` для работы с SQLite.

5. **Дополнительно:**
- Реализуйте обработку ошибок, таких как отсутствие интернет-соединения или неверный ввод города.
- Приложение должно иметь простой и интуитивно понятный интерфейс.

 **Критерии оценки:**

- Корректность работы с API и отображение данных.
- Правильная работа с базой данных SQLite.
- Чистота и структура кода, использование архитектурных паттернов.
- Обработка ошибок и UX.
- Документация и комментарии в коде.
 */

class RootActivity : AppCompatActivity() {

    lateinit var binding: ActivityRootBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRootBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id) {
//                R.id.newPlaylistFragment, R.id.audioPlayerFragment, R.id.albumInfoFragment -> {
//                    binding.bottomNavigationView.visibility = View.GONE
//                }
//                else -> {
//                    binding.bottomNavigationView.visibility = View.VISIBLE
//                }
            }
        }
    }
}