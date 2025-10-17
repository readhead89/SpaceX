package test.infoTest

import com.allure.AllureHelpers.allureStep
import com.constants.StaticValues.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import test.TestBase

@DisplayName("Получение информации о комании и публичному АПИ")
class TestInfo : TestBase() {
    @Test
    @DisplayName("Получение информации о компании")
    fun testGetInfoAboutCompany() {
        val companyInfo = allureStep("Запрос получения информации о компании") {
            apiFactory.info.getCompanyInfo()?.cto
        }

        allureStep("Проверка11111 что запрос успешен") {
            Assertions.assertEquals(companyInfo, ElonMusk.values)
        }
    }

    @Test
    @DisplayName("Получение информации об API")
    fun testGetInfoApi() {
        val apiInfo = allureStep("Запрос получения информации об Api") {
            apiFactory.info.getApiInfo()?.organization
        }

        allureStep("Проверка что запрос успешен") {
            Assertions.assertEquals(apiInfo, Organization.values)
        }
    }
}