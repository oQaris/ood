package generative_patterns.builder_prototype

import java.util.*

class Student : Cloneable {
    var name: String = ""
    var surname: String = ""
    var patronymic: String = ""
    var yearOfStudy: Int = 0
    var faculty: String = ""
    var phoneNumber: String = ""
    var address: String = ""

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val student = other as Student
        return yearOfStudy == student.yearOfStudy &&
                name == student.name &&
                surname == student.surname &&
                patronymic == student.patronymic &&
                faculty == student.faculty &&
                phoneNumber == student.phoneNumber &&
                address == student.address
    }

    override fun hashCode(): Int {
        return Objects.hash(name, surname, patronymic, yearOfStudy, faculty, phoneNumber, address)
    }

    public override fun clone(): Student {
        val student = super.clone() as Student
        student.name = name
        student.surname = surname
        student.patronymic = patronymic
        student.yearOfStudy = yearOfStudy
        student.faculty = faculty
        student.phoneNumber = phoneNumber
        student.address = address
        return student
    }

    internal class Builder(name: String, surname: String) {
        private val student: Student = Student()
        fun withPatronymic(patronymic: String): Builder {
            student.patronymic = patronymic
            return this
        }

        fun withYearOfStudy(yearOfStudy: Int): Builder {
            student.yearOfStudy = yearOfStudy
            return this
        }

        fun withFaculty(faculty: String): Builder {
            student.faculty = faculty
            return this
        }

        fun withPhoneNumber(phoneNumber: String): Builder {
            student.phoneNumber = phoneNumber
            return this
        }

        fun withAddress(address: String): Builder {
            student.address = address
            return this
        }

        fun build(): Student {
            return student
        }

        init {
            student.name = name
            student.surname = surname
        }
    }
}