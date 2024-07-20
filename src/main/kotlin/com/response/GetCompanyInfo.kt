package com.response

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty

data class GetCompanyInfo(
    @JsonProperty("ceo")
    val ceo: String?,
    @JsonProperty("coo")
    val coo: String?,
    @JsonProperty("cto")
    val cto: String?,
    @JsonProperty("cto_propulsion")
    val ctoPropulsion: String?,
    @JsonProperty("employees")
    val employees: Int?,
    @JsonProperty("founded")
    val founded: Int?,
    @JsonProperty("founder")
    val founder: String?,
    @JsonProperty("headquarters")
    val headquarters: Headquarters?,
    @JsonProperty("launch_sites")
    val launchSites: Int?,
    @JsonProperty("name")
    val name: String?,
    @JsonProperty("summary")
    val summary: String?,
    @JsonProperty("test_sites")
    val testSites: Int?,
    @JsonProperty("valuation")
    val valuation: Long?,
    @JsonProperty("vehicles")
    val vehicles: Int?
) {
    data class Headquarters(
        @JsonProperty("address")
        val address: String?,
        @JsonProperty("city")
        val city: String?,
        @JsonProperty("state")
        val state: String?
    )
}