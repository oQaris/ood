package behavioral_patterns.iterator

data class Author(val name: String, val numberOfBooks: Int)

class Authors(val set: MutableList<Author>) : Iterable<Author> {
    override fun iterator(): Iterator<Author> = SimpleAuthorIterator(this)
}

class SimpleAuthorIterator(private val authors: Authors, var current: Int = -1) : Iterator<Author> {
    override fun hasNext(): Boolean = authors.set.size - 1 > current

    override fun next(): Author {
        current++
        return authors.set[current]
    }
}

class ReverseAuthorIterator(private val authors: Authors, var current: Int = authors.set.size) :
    Iterator<Author> {
    override fun hasNext(): Boolean = 0 < current

    override fun next(): Author {
        current--
        return authors.set[current]
    }
}

class BookCountAuthorIterator(authors: Authors, var current: Int = -1) : Iterator<Author> {
    private val sortedAuthor: List<Author> = authors.set.sortedBy { it.numberOfBooks }

    override fun hasNext(): Boolean = sortedAuthor.size - 1 > current

    override fun next(): Author {
        current++
        return sortedAuthor[current]
    }
}