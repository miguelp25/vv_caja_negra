package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(org.junit.platform.runner.JUnitPlatform.class)
public class RemoveLast {
    SingleLinkedListImpl<Character> list;

    @DisplayName("Case removeLast on empty list")
    @Test
    void TestEmptyRemoveLast(){
        list = new SingleLinkedListImpl<Character>();
        assertThrows(EmptyCollectionException.class, () -> {
            list.removeLast();
        });
    }

    @ParameterizedTest(name = "Case removeLast on {0} size list")
    @CsvSource({
            "1,    []",
            "2,    [A]",
            "5,    [A. B. C. D]",
            "9,    [A. B. C. D. E. F. G. H]",
            "10,   [A. B. C. D. E. F. G. H. I]",
    })
    void TestRemoveLast(int size, String result) throws EmptyCollectionException{
        list = new SingleLinkedListImpl<Character>();
        Character lastElement = 'A';

        if (size == 1) {
            list = new SingleLinkedListImpl<>('A');
            lastElement = 'A';
        }
        if (size == 2) {
            list = new SingleLinkedListImpl<>('A', 'B');
            lastElement = 'B';
        }
        else if (size == 5) {
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E');
            lastElement = 'E';
        }
        else if (size == 9) {
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I');
            lastElement = 'I';
        }
        else if (size == 10) {
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J');
            lastElement = 'J';
        }

        assertEquals(lastElement, list.removeLast());
        assertEquals(result.replace(".", ","), list.toString());
    }
}
