package test.history

import com.allure.AllureHelpers.allureStep
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
        val allEvents = allureStep("Получить все события из истории") {
            apiFactory.history.getAllHistory()?.map { it.id}
        }

        allureStep("Проверка что запрос успешен") {
          assertNotNull(allEvents)
        }

        val event = allureStep("Получить одно соьытие по id") {
            apiFactory.history.getHistoryEventById(5)?.id
        }

        allureStep("Проверить что инофрмация получена по переданному id"){
            Assertions.assertEquals(event,5)
        }

    }
}