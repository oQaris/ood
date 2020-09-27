package generative_patterns.singleton;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DataBase {
    private static volatile DataBase dataBase;
    private final Set<String> words;

    private DataBase() {
        words = new TreeSet<>(String::compareToIgnoreCase);
    }

    public static DataBase getInstance() {
        if (dataBase == null)
            dataBase = new DataBase();
        return dataBase;
    }

    public Set<String> getWords() {
        return words;
    }

    public void addWord(String word) {
        this.words.add(word);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataBase dataBase = (DataBase) o;
        return Objects.equals(words, dataBase.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }
}