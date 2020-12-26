package behavioral_patterns.observer

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class EventManagerTest {

    @Test
    fun subscribeTest() {
        val obj = ObservableObject()
        // одно событие при изменении текста на не пустое
        val listener = TextChangeListener()
        obj.eventManager.subscribe(EventManager.Event.TEXT_CHANGED, listener)
        // и 2 при изменение текста на ""
        obj.eventManager.subscribe(EventManager.Event.TO_EMPTY, TextChangeListener())
        obj.eventManager.subscribe(EventManager.Event.TO_EMPTY, TextChangeOnEmptyListener())

        obj.text = "12345"
        obj.text = ""
        obj.text = "end"
        obj.eventManager.unSubscribe(EventManager.Event.TEXT_CHANGED, listener) // отписываемся
        obj.text = "без изменений"      // этого не будет в логе

        assertEquals(
            listOf(
                "Текст изменился на: 12345",
                "Текст изменился на: 12345",               // При событии TO_EMPTY передаётся старое значение
                "Текст \"12345\" изменился на пустой",
                "Текст изменился на: end"
            ), obj.eventManager.log
        )
    }
}