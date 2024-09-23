package com.example.testtaskweatherinformation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}