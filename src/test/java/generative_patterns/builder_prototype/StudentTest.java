package generative_patterns.builder_prototype;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void TestBuilder() {
        Student student1 = new Student.Builder("Иван", "Иванов")
                .withPatronymic("Иванович")
                .withFaculty("IMIT")
                .withYearOfStudy(4)
                .withAddress("ул. Ленина 45")
                .withPhoneNumber("89123456789")
                .build();
        Student student2 = new Student.Builder("Иван", "Иванов")
                .withFaculty("IMIT")
                .withAddress("ул. Ленина 45")
                .build();
        Assertions.assertNotEquals(student1, student2);
    }

    @Test
    void TestPrototype() throws CloneNotSupportedException {
        Student student = new Student.Builder("Иван", "Иванов")
                .withPatronymic("Иванович")
                .withFaculty("IMIT")
                .withYearOfStudy(4)
                .withPhoneNumber("89123456789")
                .build();
        Student student2 = student.clone();
        Assertions.assertEquals(student, student2);

        student2.setPhoneNumber("000");
        Assertions.assertNotEquals(student, student2);
    }
}