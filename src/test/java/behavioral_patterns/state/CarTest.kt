package behavioral_patterns.state

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun getStateTest() {
        val formula1 = Car()

        assertThrows(UnsupportedOperationException::class.java) {
            formula1.changeSpeed(30)
        }
        assertThrows(UnsupportedOperationException::class.java) {
            formula1.stopMotor()
        }
        formula1.startMotor()

        formula1.changeSpeed(50)
        assertThrows(UnsupportedOperationException::class.java) {
            formula1.stopMotor()
        }
        assertThrows(UnsupportedOperationException::class.java) {
            formula1.changeSpeed(-1)
        }
        formula1.changeSpeed(0)
        formula1.stopMotor()
    }
}