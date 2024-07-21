package com.api.history

import com.api.info.Info
import com.apiFactory.Services
import com.google.gson.Gson
import com.logger.ExceptionForApi
import com.response.GetAllHistoryEvents
import com.response.GetEventById
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class History(private val httpClient: OkHttpClient, baseUrl: HttpUrl) : Services() {
    private val historyUrl: HttpUrl = baseUrl.newBuilder()
        .addPathSegment("history")
        .build()

    /**
     * Method implementation SpaceX API -> GET /history
     * Возвращает все события истории
     */

    fun getAllHistory(): List<GetAllHistoryEvents.GetAllHistoryEventsItem>? {
        logger.debug("Try to get all events")
        val infoUrl: HttpUrl = historyUrl.newBuilder()
            .build()

        val request = Request.Builder()
            .url(infoUrl)
            .build()

        val response: Response = httpClient.newCall(request).execute()

        logger.debug("Successful get all events")

        return if (response.isSuccessful) {
            val responseBody = response.body?.string()
            // Десериализация JSON в объект GetCompanyInfo
            val events = gson.fromJson(responseBody, GetAllHistoryEvents::class.java)
            events

        } else {
            throw ExceptionForApi("Request failed with status code: ${response.code}")
        }
    }

    /**
     * Method implementation SpaceX API -> GET //history/{{id}}
     * Возвращает одно событие по Id
     */

    fun getHistoryEventById(
        id: Int
    ): GetEventById? {
        logger.debug("Try to get events by id = $id")
        val infoUrl: HttpUrl = historyUrl.newBuilder()
            .addPathSegment(id.toString())
            .build()

        val request = Request.Builder()
            .url(infoUrl)
            .build()

        val response: Response = httpClient.newCall(request).execute()

        logger.debug("Successful get events by id = $id")

        return if (response.isSuccessful) {
            val responseBody = response.body?.string()
            // Десериализация JSON в объект GetCompanyInfo
            gson.fromJson(responseBody, GetEventById::class.java)
        } else {
            throw ExceptionForApi("Request failed with status code: ${response.code}")
        }
    }
}
