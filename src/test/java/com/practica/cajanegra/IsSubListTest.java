package com.practica.cajanegra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class IsSubListTest {
    SingleLinkedListImpl<Character> list;

    @ParameterizedTest(name = "Case subList is an empty list for {0} size")
    @CsvSource(value = {
            "0",
            "1",
            "5",
            "9",
            "10",
            "11"
    })
    void TestEmptySubList(int size){
        if (size == 0)
            list = new SingleLinkedListImpl<>();
        else if (size == 1)
            list = new SingleLinkedListImpl<>('A');
        else if (size == 5)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'E', 'F');
        else if (size == 9)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'J');
        else if (size == 10)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K');
        else if (size == 11)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L');

        assertEquals(0, list.isSubList(new SingleLinkedListImpl<Character>()));
    }

    @ParameterizedTest(name = "Case parameter is a sublist in position {0}")
    @CsvSource(value = {
            "0",
            "1",
            "5",
            "9",
            "10",
            "11"
    })
    void TestSubList(int position){
        list = new SingleLinkedListImpl<Character>('A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L');
        SingleLinkedListImpl<Character> subList = new SingleLinkedListImpl<Character>();

        if (position == 0)
            subList = new SingleLinkedListImpl<>();
        else if (position == 1)
            subList = new SingleLinkedListImpl<>('A', 'B');
        else if (position == 5)
            subList = new SingleLinkedListImpl<>('F', 'G', 'H');
        else if (position == 9)
            subList = new SingleLinkedListImpl<>('J', 'K');
        else if (position == 10)
            subList = new SingleLinkedListImpl<>('K', 'L');
        else if (position == 11)
            subList = new SingleLinkedListImpl<>('L');

        assertEquals(position, list.isSubList(subList));
    }

    @ParameterizedTest(name = "Case parameter is NOT sublist for position {0}")
    @CsvSource(value = {
            "0",
            "1",
            "5",
            "9",
            "10",
            "11"
    })
    void TestNoSubList(int size){
        SingleLinkedListImpl<Character> subList = new SingleLinkedListImpl<Character>('A', 'C', 'E');

        if (size == 0)
            list = new SingleLinkedListImpl<>();
        else if (size == 1)
            list = new SingleLinkedListImpl<>('A');
        else if (size == 5)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'E', 'F');
        else if (size == 9)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'J');
        else if (size == 10)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K');
        else if (size == 11)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L');

        assertEquals(-1, list.isSubList(subList));
    }

    @ParameterizedTest(name = "Case parameter is NULL for {0} size")
    @CsvSource(value = {
            "0",
            "1",
            "5",
            "9",
            "10",
            "11"
    })
    void TestNullSubList(int size){
        if (size == 0)
            list = new SingleLinkedListImpl<>();
        else if (size == 1)
            list = new SingleLinkedListImpl<>('A');
        else if (size == 5)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'E', 'F');
        else if (size == 9)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'J');
        else if (size == 10)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K');
        else if (size == 11)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L');

        assertEquals(0, list.isSubList(null));
    }
}
