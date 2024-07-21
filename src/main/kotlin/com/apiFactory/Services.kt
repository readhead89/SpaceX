package com.apiFactory

import com.api.info.Info
import com.google.gson.Gson
import org.slf4j.Logger
import org.slf4j.LoggerFactory

open class Services {
    val gson = Gson()
    val logger: Logger = LoggerFactory.getLogger(Info::class.java)
}