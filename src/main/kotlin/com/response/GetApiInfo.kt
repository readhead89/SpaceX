package com.response

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty

data class GetApiInfo(
    @JsonProperty("description")
    val description: String?,
    @JsonProperty("organization")
    val organization: String?,
    @JsonProperty("organization_link")
    val organizationLink: String?,
    @JsonProperty("project_link")
    val projectLink: String?,
    @JsonProperty("project_name")
    val projectName: String?,
    @JsonProperty("version")
    val version: String?
)