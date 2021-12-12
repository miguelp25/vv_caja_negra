package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class FindElemTests {

    static SingleLinkedListImpl<String> testList;

    @BeforeEach
    void setup() {
        testList = new SingleLinkedListImpl<>("A", "B", "C", "D", "E", "F", "G");
    }

    /*------------------------------*/
    /*        Tests getAtPos        */
    /*------------------------------*/



    @DisplayName("getAtPos test validos de valores dentro de lo esperado")
    @ParameterizedTest()
    @MethodSource("getAtPos_validTestsSource")
    void addAtPos(int position,String result){
        Assertions.assertEquals(result, testList.getAtPos(position));
    }
    static Stream<Arguments> getAtPos_validTestsSource(){
        return Stream.of(
                arguments(1,"A"),
                arguments(2,"B"),
                arguments(4,"D"),
                arguments(6,"F"),
                arguments(7,"G")
        );
    }

    @DisplayName("getAtPos test invalidos")
    @ParameterizedTest()
    @MethodSource("getAtPos_invalidTestsSource")
    void addAtPos(int position){
        Assertions.assertThrows(IllegalArgumentException.class ,() ->testList.getAtPos(position));
    }
    static Stream<Arguments> getAtPos_invalidTestsSource(){
        return Stream.of(
                arguments(0),
                arguments(8)
        );
    }


    /*------------------------------*/
    /*        Tests indexOf         */
    /*------------------------------*/



    @DisplayName("indexOf test validos de valores dentro de lo esperado")
    @ParameterizedTest()
    @MethodSource("indexOf_validTestsSource")
    void indexOf(String element, int result){
        Assertions.assertEquals(result, testList.indexOf(element));
    }
    static Stream<Arguments> indexOf_validTestsSource(){
        return Stream.of(
                arguments("A", 1),
                arguments("B", 2),
                arguments("D", 4),
                arguments("F", 6),
                arguments("G", 7)
        );
    }

    @DisplayName("indexOf test invalidos")
    @ParameterizedTest()
    @MethodSource("indexOf_invalidTestsSource")
    void indexOf(String element){
        Assertions.assertThrows(NoSuchElementException.class ,() ->testList.indexOf(element));
    }
    static Stream<Arguments> indexOf_invalidTestsSource(){
        return Stream.of(
                arguments("@"),
                arguments("]")
        );
    }
}
