package structural_patterns.adapter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FahrenheitCelsiusAdapterTest {

    @Test
    fun testGetCelsTemp() {
        val tFar = FahrenheitTemperature(32)
        // tFar.getCelsius() - нельзя

        val adapter = FahrenheitCelsiusAdapter(tFar)
        assertEquals(0, adapter.celsTemp.getCelsius())
    }
}