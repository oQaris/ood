package behavioral_patterns.command

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class OrderCommandProcessorTest {

    @Test
    fun processCommands() {
        val cmd = OrderCommandProcessor()
            .addToQueue(AddOrderCommand(1537))
            .addToQueue(AddOrderCommand(2848))
            .addToQueue(PayOrderCommand(1537))
            .addToQueue(PayOrderCommand(2848))
            .processCommands()
            .addToQueue(AddOrderCommand(9111))

        // Выполненные команды
        assertEquals(
            "Добавление заказа 1537 " +
                    "Добавление заказа 2848 " +
                    "Оплата заказа 1537 " +
                    "Оплата заказа 2848 ",
            cmd.result
        )

        // Остались
        assertEquals(1, cmd.queue.size)
        assertEquals(AddOrderCommand(9111), cmd.queue[0])
    }
}