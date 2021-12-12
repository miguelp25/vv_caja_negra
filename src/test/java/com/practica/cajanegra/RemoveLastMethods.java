package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RemoveLastMethods")
public class RemoveLastMethods {

    @Nested
    @DisplayName("removeLast()")
    class RemoveLast{
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
                "11,   [A. B. C. D. E. F. G. H. I. J]"
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
            else if (size == 11) {
                list = new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K');
                lastElement = 'K';
            }

            assertEquals(lastElement, list.removeLast());
            assertEquals(result.replace(".", ","), list.toString());
        }
    }

    @Nested
    @DisplayName("removeLast(T)")
    class RemoveLastWithParameter {
        SingleLinkedListImpl<Character> list;

        @ParameterizedTest(name = "Case removeLast(T) with 1 T in position {0} in a list of size 10")
        @CsvSource(value = {
                "1,     [B. C. D. E. F. G. H. I. J. K]",
                "2,     [A. C. D. E. F. G. H. I. J. K]",
                "5,     [A. B. C. D. F. G. H. I. J. K]",
                "9,     [A. B. C. D. E. F. G. H. J. K]",
                "10,    [A. B. C. D. E. F. G. H. I. K]",
                "11,    [A. B. C. D. E. F. G. H. I. J]"
        })
        void TestRemoveWithSingleElement(int position, String result) throws EmptyCollectionException{
            list = new SingleLinkedListImpl<>('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K');
            Character element = 'A';

            if (position == 1)
                element = 'A';
            else if (position == 2)
                element = 'B';
            else if (position == 5)
                element = 'E';
            else if (position == 9)
                element = 'I';
            else if (position == 10)
                element = 'J';
            else if (position == 11)
                element = 'K';

            assertEquals(element, list.removeLast(element));
            assertEquals(result.replace(".", ","), list.toString());
        }

        @ParameterizedTest(name = "Case removeLast(T) with repeated elements, remove in position {0} in a list of size 11")
        @CsvSource(value = {
                "2,     [A. B. C. C. E. F. D. D. E. F]",
                "5,     [A. A. B. C. E. F. D. D. E. F]",
                "9,     [A. A. B. C. C. E. F. D. E. F]",
                "10,    [A. A. B. C. C. E. F. D. D. F]",
                "11,    [A. A. B. C. C. E. F. D. D. E]"
        })
        void TestRemoveWithMultipleElements(int position, String result) throws EmptyCollectionException{
            list = new SingleLinkedListImpl<>('A', 'A', 'B', 'C', 'C', 'E', 'F', 'D', 'D', 'E', 'F');
            Character element = 'A';

            if (position == 2)
                element = 'A';
            else if (position == 5)
                element = 'C';
            else if (position == 9)
                element = 'D';
            else if (position == 10)
                element = 'E';
            else if (position == 11)
                element = 'F';

            assertEquals(element, list.removeLast(element));
            assertEquals(result.replace(".", ","), list.toString());
        }

        @DisplayName("Case removeLast(T) on empty list")
        @Test
        void TestEmptyRemoveLast(){
            list = new SingleLinkedListImpl<Character>();
            assertThrows(EmptyCollectionException.class, () -> {
                list.removeLast();
            });
        }

        @DisplayName("Case removeLast(T) with non-existent element")
        @Test
        void TestRemoveNonExistentElement() throws EmptyCollectionException{
            list = new SingleLinkedListImpl<>('A', 'A', 'B', 'B');
            Character element = 'Z';

            assertThrows(NoSuchElementException.class, () -> {
                list.removeLast(element);
            });
            assertNull(list.removeLast(element));
            assertEquals("[A, A, B, B]", list.toString());
        }

        @ParameterizedTest(name = "Case removeLast(T) with invalid element")
        @CsvSource(value = {
                "@",
                "[",
                "!",
                "?",
                "a",
                "z",
                "ñ"
        })
        void TestRemoveWithInvalidElement(Character element) throws EmptyCollectionException{
            list = new SingleLinkedListImpl<>('A', 'A', 'B', 'B');

            assertNull(list.removeLast(element));
            assertEquals("[A, A, B, B]", list.toString());
        }

    }
}
