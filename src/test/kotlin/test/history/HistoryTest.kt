package test.history

import com.allure.AllureHelpers.allureStep
import com.constants.StaticValues.ElonMusk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import test.TestBase
import kotlin.test.assertNotNull

@DisplayName("Получение информации о всех ивентах")
class HistoryTest :TestBase() {
    @Test
    @DisplayName("Получение информации о компании")
    fun testGetInfoAboutCompany() {
        val allEvents = allureStep("Запрос получения информации о компании") {
            apiFactory.history.getAllHistory()?.events?.map { it.id }
        }

        allureStep("Проверка что запрос успешен") {
          assertNotNull(allEvents)
        }
    }
}