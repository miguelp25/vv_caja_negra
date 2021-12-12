package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToStringTest {
    SingleLinkedListImpl<Character> list;

    @ParameterizedTest(name = "Case toString for list of size {0}")
    @CsvSource(value = {
            "0,     []",
            "1,     [A]",
            "2,     [A. B]",
            "5,     [A. B. C. D. E]",
            "9,     [A. B. C. D. E. F. G. H. I]",
            "10,    [A. B. C. D. E. F. G. H. I. J]",
            "11,    [A. B. C. D. E. F. G. H. I. J. K]"
    })
    void TestReverse(int size, String result){
        list = new SingleLinkedListImpl<>();

        if (size == 0)
            list = new SingleLinkedListImpl<>();
        else if (size == 1)
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

        assertEquals(result.replace(".", ","), list.toString());
    }
}
