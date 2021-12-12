package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseTest {
    SingleLinkedListImpl<Character> list;

    @DisplayName("Case reverse on empty list")
    @Test
    void TestReverseOnEmptyList(){
        list = new SingleLinkedListImpl<>();

        assertEquals("[]", list.reverse().toString());
    }

    @ParameterizedTest(name = "Case reverse for list of size {0}")
    @CsvSource(value = {
            "1,     [A]",
            "2,     [B. A]",
            "5,     [E. D. C. B. A]",
            "9,     [I. H. G. F. E. D. C. B. A]",
            "10,    [J. I. H. G. F. E. D. C. B. A]",
            "11,    [K. J. I. H. G. F. E. D. C. B. A]"
    })
    void TestReverse(int size, String result){
        list = new SingleLinkedListImpl<>();

        if (size == 1)
            list = new SingleLinkedListImpl<>('A');
        else if (size == 2)
            list = new SingleLinkedListImpl<>('A', 'B');
        else if (size == 5)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E');
        else if (size == 9)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I');
        else if (size == 10)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J');
        else if (size == 11)
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K');

        assertEquals(result.replace(".", ","), list.reverse().toString());
    }
}
