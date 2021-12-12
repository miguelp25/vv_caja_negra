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
            "5",
            "10"
    })
    void TestListSize(int size){
        if (size == 0)
            list = new SingleLinkedListImpl<Character>();
        else if (size == 1)
            list = new SingleLinkedListImpl<Character>('A');
        else if (size == 5)
            list = new SingleLinkedListImpl<Character>('A', 'B', 'C', 'E', 'F');
        else if (size == 10)
            list = new SingleLinkedListImpl<Character>('A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K');

        assertEquals(size, list.size());
    }
}
