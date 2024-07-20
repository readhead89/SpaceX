package com.api.history

import com.api.info.Info
import com.google.gson.Gson
import com.response.GetAllHistoryEvents
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class History(private val httpClient: OkHttpClient, baseUrl: HttpUrl) {
    private val historyUrl: HttpUrl = baseUrl.newBuilder()
        .addPathSegment("history")
        .build()
    private val gson = Gson()
    private val logger: Logger = LoggerFactory.getLogger(Info::class.java)

    /**
     * Method implementation SpaceX API -> GET /history
     * Возвращает все события истории
     */

    fun getAllHistory(): GetAllHistoryEvents? {
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
            gson.fromJson(responseBody, GetAllHistoryEvents::class.java)
        } else {
            null
        }
    }
}
