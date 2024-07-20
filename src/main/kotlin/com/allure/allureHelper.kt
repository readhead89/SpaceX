package com.allure

import io.qameta.allure.Allure

object AllureHelpers {
    inline fun <T> allureStep(name: String, crossinline block: () -> T): T {
        var result: T? = null
        Allure.step(name, Allure.ThrowableRunnable {
            result = block()
        })
        return checkNotNull(result)
    }
}