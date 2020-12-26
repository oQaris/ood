package behavioral_patterns.visitor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class VisitorTest {

    @Test
    fun visitTest() {
        val teacher: Human = Teacher("Фёдоров", "Мат. Анализ")
        val student: Human = Student("Петров", "МПБ-504")
        val v = Visitor()
        teacher.accept(v)
        student.accept(v)

        assertEquals(
            mutableListOf(
                "Посетили учителя Фёдорова, который преподаёт Мат. Анализ",
                "Посетили студента Петрова, который учится в группе МПБ-504"
            ), v.log
        )

        // использование улучшенной версии:
        val teacher2: Human2 = Teacher2("Григорьев", "Методы Оптимизации")
        val student2: Human2 = Student2("Иванов", "ММС-703")
        Visitor2().visit(teacher2)
        Visitor2().visit(student2)
        // смотреть консольный вывод
    }
}