package generative_patterns.builder_prototype;

import java.util.Objects;

public class Student implements Cloneable {
    private String name, surname, patronymic;
    private int yearOfStudy;
    private String faculty;
    private String phoneNumber;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return yearOfStudy == student.yearOfStudy &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(patronymic, student.patronymic) &&
                Objects.equals(faculty, student.faculty) &&
                Objects.equals(phoneNumber, student.phoneNumber) &&
                Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic, yearOfStudy, faculty, phoneNumber, address);
    }

    public Student clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.name = this.name;
        student.surname = this.surname;
        student.patronymic = this.patronymic;
        student.yearOfStudy = this.yearOfStudy;
        student.faculty = this.faculty;
        student.phoneNumber = this.phoneNumber;
        student.address = this.address;
        return student;
    }

    static class Builder {
        private final Student student;

        public Builder(String name, String surname) {
            student = new Student();
            student.name = name;
            student.surname = surname;
        }

        public Builder withPatronymic(String patronymic) {
            student.patronymic = patronymic;
            return this;
        }

        public Builder withYearOfStudy(int yearOfStudy) {
            student.yearOfStudy = yearOfStudy;
            return this;
        }

        public Builder withFaculty(String faculty) {
            student.faculty = faculty;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            student.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withAddress(String address) {
            student.address = address;
            return this;
        }

        public Student build() {
            return student;
        }
    }
}