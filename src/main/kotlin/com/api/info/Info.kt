package com.api.info

import com.google.gson.Gson
import com.response.GetApiInfo
import com.response.GetCompanyInfo
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Info(private val httpClient: OkHttpClient, baseUrl: HttpUrl) {
    private val infoUrl: HttpUrl = baseUrl.newBuilder().build()
    private val gson = Gson()
    private val logger: Logger = LoggerFactory.getLogger(Info::class.java)

    /**
     * Method implementation SpaceX API -> GET /Info
     * Возвращает всю информация о компании
     */
    fun getCompanyInfo(): GetCompanyInfo? {
        logger.debug("Try to get info for company")
        val infoUrl: HttpUrl = infoUrl.newBuilder()
            .addPathSegment("info")
            .build()

        val request = Request.Builder()
            .url(infoUrl)
            .build()

        val response: Response = httpClient.newCall(request).execute()

        logger.debug("Successful get info for Company")

        return if (response.isSuccessful) {
            val responseBody = response.body?.string()
            // Десериализация JSON в объект GetCompanyInfo
            gson.fromJson(responseBody, GetCompanyInfo::class.java)
        } else {
            null
        }
    }

    /**
     * Method implementation SpaceX API -> GET Api
     * Возвращает всю информцию об API
     */
    fun getApiInfo(): GetApiInfo? {
        logger.debug("Try to get info for Api")

        val infoUrl: HttpUrl = infoUrl.newBuilder()
            .build()

        val request = Request.Builder()
            .url(infoUrl)
            .build()

        // Выполните запрос и получите ответ
        val response: Response = httpClient.newCall(request).execute()

        logger.debug("Successful get info for API")

        return if (response.isSuccessful) {
            val responseBody = response.body?.string()
            // Десериализация JSON в объект GetCompanyInfo
            gson.fromJson(responseBody, GetApiInfo::class.java)
        } else {
            null
        }
    }
}