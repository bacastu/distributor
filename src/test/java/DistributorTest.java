import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DistributorTest {
    private static  Distributor d;

    @BeforeAll
    public static void initTest() {
        d = new Distributor();
    }

    @Test
    public static void testJunit() throws Exception {
        assertEquals(2, 1 + 1);
    }
}
