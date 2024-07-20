package com.response

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty

// Основной дата-класс для списка событий
data class GetAllHistoryEvents(
    @JsonProperty("events")
    val events: List<GetAllHistoryEventsItem>
) {
    // Дата-класс для одного элемента события
    data class GetAllHistoryEventsItem(
        @JsonProperty("details")
        val details: String?,
        @JsonProperty("event_date_unix")
        val eventDateUnix: Int?,
        @JsonProperty("event_date_utc")
        val eventDateUtc: String?,
        @JsonProperty("flight_number")
        val flightNumber: Int?,
        @JsonProperty("id")
        val id: Int?,
        @JsonProperty("links")
        val links: Links?,
        @JsonProperty("title")
        val title: String?
    ) {
        // Дата-класс для ссылок внутри события
        data class Links(
            @JsonProperty("article")
            val article: String?,
            @JsonProperty("reddit")
            val reddit: Any?,
            @JsonProperty("wikipedia")
            val wikipedia: String?
        )
    }
}