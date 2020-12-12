package behavioral_patterns.chain_of_responsibility

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ChainLinkTest {

    @Test
    fun checkTest() {
        val chain = ChainNonNegativeNumbers()
        chain.connect(ChainNotDuplicateValues())
            .connect(ChainSorted())

        Assertions.assertTrue(chain.check(listOf(0, 1, 2, 3, 4, 5, 6, 7)))

        Assertions.assertFalse(chain.check(listOf(-5, -2, 1, 4, 7, 10)))

        Assertions.assertFalse(chain.check(listOf(99, 99, 100, 101, 102, 102, 103)))

        Assertions.assertFalse(chain.check(listOf(6, 7, 8, 9, 10, 1, 2, 3, 4, 5)))
    }
}