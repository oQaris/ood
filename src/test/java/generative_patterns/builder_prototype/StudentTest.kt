package generative_patterns.builder_prototype

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class StudentTest {
    @Test
    fun testBuilder() {
        val student1 = Student.Builder("Иван", "Иванов")
                .withPatronymic("Иванович")
                .withFaculty("IMIT")
                .withYearOfStudy(4)
                .withAddress("ул. Ленина 45")
                .withPhoneNumber("89123456789")
                .build()
        val student2 = Student.Builder("Иван", "Иванов")
                .withFaculty("IMIT")
                .withAddress("ул. Ленина 45")
                .build()
        Assertions.assertNotEquals(student1, student2)
    }

    @Test
    fun testPrototype() {
        val student = Student.Builder("Иван", "Иванов")
                .withPatronymic("Иванович")
                .withFaculty("IMIT")
                .withYearOfStudy(4)
                .withPhoneNumber("89123456789")
                .build()
        val student2 = student.clone()
        Assertions.assertEquals(student, student2)
        student2.phoneNumber = "000"
        Assertions.assertNotEquals(student, student2)
    }
}