package behavioral_patterns.visitor

sealed class Human {
    abstract fun accept(visitor: IVisitor)
}

interface IVisitor {
    fun visit(teacher: Teacher)
    fun visit(student: Student)
}

class Teacher(val name: String, val subject: String) : Human() {
    override fun accept(visitor: IVisitor) = visitor.visit(this)
}

class Student(val name: String, val group: String) : Human() {
    override fun accept(visitor: IVisitor) = visitor.visit(this)
}

class Visitor : IVisitor {
    val log = mutableListOf<String>()

    override fun visit(teacher: Teacher) {
        log.add("Посетили учителя ${teacher.name}а, который преподаёт ${teacher.subject}")
    }

    override fun visit(student: Student) {
        log.add("Посетили студента ${student.name}а, который учится в группе ${student.group}")
    }
}


// Однако в Котлине паттерн Посетитель не особо актуальен, поскольку можно сделать так:

sealed class Human2

interface IVisitor2 {
    fun visit(human: Human2)
}

class Teacher2(val name: String, val subject: String) : Human2()

class Student2(val name: String, val group: String) : Human2()

class Visitor2 : IVisitor2 {
    override fun visit(human: Human2) = when (human) {
        // is - это как instanceof в java
        is Teacher2 -> println("Посетили учителя ${human.name}а, который преподаёт ${human.subject}")
        is Student2 -> println("Посетили студента ${human.name}а, который учится в группе ${human.group}")
        // else не требуется, поскольку используется sealed класс
    }
}