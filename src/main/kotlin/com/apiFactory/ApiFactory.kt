package com.apiFactory

import com.api.history.History
import com.api.info.Info
import com.google.gson.Gson
import com.logger.LoggingInterceptor
import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody

object ApiFactory {

    // Создание экземпляра OkHttpClient:
    // Создается объект OkHttpClient, который будет использоваться для выполнения HTTP-запросов.
    // Добален кастомный перехватчик LoggingInterceptor (сделал сам п подобию класса из чужого кода)
    val httpClient = OkHttpClient.Builder()
        .addInterceptor(LoggingInterceptor())
        .build()

    // Создание JSON для запросов тело содержит JSON-объект с ключом "key" и значением "value".
    private val jsonBody: String = Gson().toJson(mapOf("key" to "value"))

    // Определение типа содержимого, с кодировкой UTF-8:
    private val JSON = "application/json; charset=utf-8".toMediaType()

    private val body = jsonBody.toRequestBody(JSON)

    // Базовый URL для API преобразованный в бьект типа HttpUrl для OkHttp чтбы мгли построить URL
    private val baseUrl: HttpUrl = "https://api.spacexdata.com/v3".toHttpUrl()

    // Функция GET запросов
    fun makeRequest(): Response {
        // Создание запроса:
        val request: Request = Request.Builder()
            .url(baseUrl)
            .get()
            .build()

        // Выполнение запроса и обработка ответа:
        val response: Response = httpClient.newCall(request).execute()

        // Проверка на успех ответа
        if (response.isSuccessful) {
            response.body?.string()
        }
        return response
    }

    val info = Info(httpClient, baseUrl)
    val history = History(httpClient, baseUrl)
}