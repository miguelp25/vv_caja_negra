package com.practica.cajanegra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SizeTest {
    SingleLinkedListImpl<Character> list;

    @ParameterizedTest(name = "Testing size method for {0} length")
    @CsvSource(value = {
            "0",
            "1",
            "2",
            "5",
            "9",
            "10",
            "11"
    })
    void TestListSize(int size){
        if (size == 0)
            list = new SingleLinkedListImpl<Character>();
        else if (size == 1)
            list = new SingleLinkedListImpl<Character>('A');
        else if (size == 2)
            list = new SingleLinkedListImpl<Character>('A', 'B');
        else if (size == 5)
            list = new SingleLinkedListImpl<Character>('A', 'B', 'C', 'E', 'F');
        else if (size == 9)
            list = new SingleLinkedListImpl<Character>('A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'J');
        else if (size == 10)
            list = new SingleLinkedListImpl<Character>('A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K');
        else if (size == 11)
            list = new SingleLinkedListImpl<Character>('A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L');

        assertEquals(size, list.size());
    }
}
