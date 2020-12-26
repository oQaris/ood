package behavioral_patterns.mediator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class AirportMediatorTest {

    @Test
    fun testNotify() {
        val mediator = AirportMediator()

        val sparrow101 = Flight(mediator)
        val sparrow333 = Flight(mediator)
        val mainRunway = Runway(mediator)

        mediator.registerFlight(sparrow101)
        mediator.registerFlight(sparrow333)
        mediator.registerRunway(mainRunway)

        // просят посадку
        sparrow101.land()
        sparrow333.land()
        mainRunway.free()
        sparrow333.land() // нельзя
        sparrow101.land() // можно
        mainRunway.free()
        sparrow333.land() // теперь можно

        assertEquals(
            mutableListOf(
                "Жду разрешения на посадку",
                "Жду разрешения на посадку",
                "Получено разрешение на посадку",
                "Жду разрешения на посадку",
                "Посадка выполнена",
                "Получено разрешение на посадку",
                "Посадка выполнена"
            ), log
        )
    }
}