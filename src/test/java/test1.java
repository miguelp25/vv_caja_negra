import static org.junit.jupiter.api.Assertions.fail;
import com.cajanegra.SingleLinkedListImpl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import java.util.Iterator;

@RunWith(org.junit.platform.runner.JUnitPlatform.class)
public class test1 {

    @Test
    void succeedingTest() {
        SingleLinkedListImpl s = new SingleLinkedListImpl();
    }

    @Test
    void failingTest() {
        fail("Failing for failing's sake.");
    }
}