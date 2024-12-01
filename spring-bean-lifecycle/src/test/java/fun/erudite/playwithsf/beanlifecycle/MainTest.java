package fun.erudite.playwithsf.beanlifecycle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @BeforeEach
    void setUp() {
        System.out.println("This is a test!!!");
    }

    @Test
    void firstTest() {
        int expected = 1;
        int result = 1;
        assertEquals(expected,result);
    }
}