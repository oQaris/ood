package behavioral_patterns.iterator

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class AuthorsTest {

    @Test
    fun iteratorTest() {
        val authors = Authors(
            mutableListOf(
                Author("Esenin", 75),
                Author("Pushkin", 98),
                Author("noName", 3),
                Author("Dostoevskii", 107)
            )
        )

        // по-умолчанию
        val out = mutableListOf<Author>()
        for (elem in authors)
            out.add(elem)

        assertEquals(
            mutableListOf(
                Author("Esenin", 75),
                Author("Pushkin", 98),
                Author("noName", 3),
                Author("Dostoevskii", 107)
            ), out
        )

        // в обратном порядке
        val revIter = ReverseAuthorIterator(authors)
        val out1 = mutableListOf<Author>()
        while (revIter.hasNext())
            out1.add(revIter.next())

        assertEquals(
            mutableListOf(
                Author("Dostoevskii", 107),
                Author("noName", 3),
                Author("Pushkin", 98),
                Author("Esenin", 75)
            ), out1
        )

        // по возрастанию количества книг
        val numBookIter = BookCountAuthorIterator(authors)
        val out2 = mutableListOf<Author>()
        while (numBookIter.hasNext())
            out2.add(numBookIter.next())

        assertEquals(
            mutableListOf(
                Author("noName", 3),
                Author("Esenin", 75),
                Author("Pushkin", 98),
                Author("Dostoevskii", 107),
            ), out2
        )
    }
}