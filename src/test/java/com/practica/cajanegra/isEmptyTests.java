package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class isEmptyTests {

    /*------------------------------*/
    /*        Tests getAtPos        */
    /*------------------------------*/


    @DisplayName("isEmpty test lista vacia")
    @Test
    void isEmptyVacia(){
        SingleLinkedListImpl<String> testList = new SingleLinkedListImpl<>();

        Assertions.assertTrue(testList.isEmpty());
    }

    @DisplayName("isEmpty test lista no vacia")
    @Test
    void isEmptyNoVacia(){
        SingleLinkedListImpl<String> testList = new SingleLinkedListImpl<>("A", "B", "C", "D", "E", "F", "G");

        Assertions.assertFalse(testList.isEmpty());
    }
}
