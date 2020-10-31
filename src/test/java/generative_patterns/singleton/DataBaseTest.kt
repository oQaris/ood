package generative_patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataBaseTest {

    @Test
    void testSingleton() {
        DataBase db = DataBase.getInstance();
        db.addWord("Синглтон");
        db.addWord("Паттерн");

        DataBase db2 = DataBase.getInstance();
        db2.addWord("qwerty");

        Assertions.assertEquals(db, db2);
        db.addWord("");
        Assertions.assertEquals(db.getWords(), db2.getWords());
    }
}