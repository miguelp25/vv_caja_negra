package com.practica.cajanegra;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.stream.Stream;

public class AddTests {

    static SingleLinkedListImpl<String> testList;

    boolean compareString (String s1)
    {
        if(s1.length() != testList.size())
            return false;
        else
        {
            for(int i = 0; i < s1.length(); i++)
            {
                if(testList.getAtPos(i).toCharArray()[0] != s1.toCharArray()[i])
                    return false;
            }
        }
        return true;
    }

    @BeforeEach
    void setup() {
        testList = new SingleLinkedListImpl<>("A", "B", "C", "D", "E", "F", "G");
    }

    /*------------------------------*/
    /*        Tests addAtPos        */
    /*------------------------------*/


    @DisplayName("addAtPos test validos de valores dentro de lo esperado")
    @ParameterizedTest()
    @MethodSource("addAtPos_validTestsSource")
    void addAtPos(int position, String elem,String result){
        int size = testList.size();
        testList.addAtPos(elem,position);
        Assertions.assertTrue(compareString(result));

    }
    static Stream<Arguments> addAtPos_validTestsSource(){
        return Stream.of(
                arguments(1,"A","AABCDEFG"),
                arguments(1,"B","BABCDEFG"),
                arguments(1,"M","MABCDEFG"),
                arguments(1,"Y","YABCDEFG"),
                arguments(1,"Z","ZABCDEFG"),

                arguments(2,"A","AABCDEFG"),
                arguments(2,"B","ABBCDEFG"),
                arguments(2,"M","AMBCDEFG"),
                arguments(2,"Y","AYBCDEFG"),
                arguments(2,"Z","AZBCDEFG"),

                arguments(4,"A","ABCDAEFG"),
                arguments(4,"B","ABCDBEFG"),
                arguments(4,"M","ABCDMEFG"),
                arguments(4,"Y","ABCDYEFG"),
                arguments(4,"Z","ABCDZEFG"),

                arguments(6,"A","ABCDEFAG"),
                arguments(6,"B","ABCDEFBG"),
                arguments(6,"M","ABCDEFMG"),
                arguments(6,"Y","ABCDEFYG"),
                arguments(6,"Z","ABCDEFZG"),

                arguments(7,"A","ABCDEFGA"),
                arguments(7,"B","ABCDEFGB"),
                arguments(7,"M","ABCDEFGM"),
                arguments(7,"Y","ABCDEFGY"),
                arguments(7,"Z","ABCDEFGZ"),

                arguments(8,"A","ABCDEFGA"),
                arguments(8,"B","ABCDEFGB"),
                arguments(8,"M","ABCDEFGM"),
                arguments(8,"Y","ABCDEFGY"),
                arguments(8,"Z","ABCDEFGZ")

        );
    }

    @DisplayName("addAtPos tests invalidos fuera del array")
    @ParameterizedTest()
    @MethodSource("addAtPos_outTestsSource")
    void addAtPosInv(int position, String elem){
        Assertions.assertThrows(IllegalArgumentException.class ,() ->testList.addAtPos(elem,position));
    }
    static Stream<Arguments> addAtPos_outTestsSource(){
        return Stream.of(
                arguments(0,"A"),
                arguments(0,"B"),
                arguments(0,"M"),
                arguments(0,"Y"),
                arguments(0,"Z"),

                arguments(0,"@"),
                arguments(0,"[")
        );
    }

    @DisplayName("addAtPos tests elementos invalidos")
    @ParameterizedTest()
    @MethodSource("addAtPos_invElemTestsSource")
    void addAtPosInvElem(int position, String elem,String result){
        int lastsize = testList.size();
        testList.addAtPos(elem,position);
        Assertions.assertTrue(compareString(result));

    }
    static Stream<Arguments> addAtPos_invElemTestsSource(){
        return Stream.of(
                arguments(1,"@","@ABCDEFG"),
                arguments(1,"[","[ABCDEFG"),

                arguments(2,"@","A@BCDEFG"),
                arguments(2,"[","A[BCDEFG"),

                arguments(4,"@","ABCD@EFG"),
                arguments(4,"[","ABCD[EFG"),

                arguments(6,"@","ABCDEF@G"),
                arguments(6,"[","ABCDEF[G"),

                arguments(7,"@","ABCDEFG@"),
                arguments(7,"[","ABCDEFG["),

                arguments(8,"@","ABCDEFG@"),
                arguments(8,"[","ABCDEFG[")
        );
    }


    /*------------------------------*/
    /*        Tests addFirst        */
    /*------------------------------*/

    @DisplayName("addFirst test validos de valores dentro de lo esperado")
    @ParameterizedTest()
    @MethodSource("addFirst_validTestsSource")
    void addFirst(String elem,String result){
        testList.addFirst(elem);
        Assertions.assertTrue(compareString(result));

    }
    static Stream<Arguments> addFirst_validTestsSource(){
        return Stream.of(
                arguments("A","AABCDEFG"),
                arguments("B","BABCDEFG"),
                arguments("M","MABCDEFG"),
                arguments("Y","YABCDEFG"),
                arguments("Z","ZABCDEFG")
        );
    }

    @DisplayName("addFirst tests elementos invalidos")
    @ParameterizedTest()
    @MethodSource("addFirst_invElemTestsSource")
    void addFirstInvElem(String elem,String result){
        int lastsize = testList.size();
        testList.addFirst(elem);
        Assertions.assertNotEquals(result,testList.getAtPos(1));
        Assertions.assertEquals(lastsize,testList.size());

    }
    static Stream<Arguments> addFirst_invElemTestsSource(){
        return Stream.of(
                arguments("@","@"),
                arguments("[","[")
        );
    }


    /*------------------------------*/
    /*        Tests addLast        */
    /*------------------------------*/

    @DisplayName("addLast test validos de valores dentro de lo esperado")
    @ParameterizedTest()
    @MethodSource("addLast_validTestsSource")
    void addLast(String elem,String result){
        int size = testList.size();
        testList.addLast(elem);
        Assertions.assertEquals(result,testList.getAtPos(8)); //Comprobamos que el elemento este en la posicion esperada
        Assertions.assertEquals(size+1,testList.size()); //Comprobamos que el tamaño del vector sea el correcto

    }
    static Stream<Arguments> addLast_validTestsSource(){
        return Stream.of(
                arguments("A","A"),
                arguments("B","B"),
                arguments("M","M"),
                arguments("Y","Y"),
                arguments("Z","Z")
        );
    }

    @DisplayName("addLast tests elementos invalidos")
    @ParameterizedTest()
    @MethodSource("addLast_invElemTestsSource")
    void addLastInvElem(String elem,String result){
        int lastsize = testList.size();
        testList.addLast(elem);
        Assertions.assertNotEquals(result,testList.getAtPos(8));
        Assertions.assertEquals(lastsize,testList.size());

    }
    static Stream<Arguments> addLast_invElemTestsSource(){
        return Stream.of(
                arguments("@","@"),
                arguments("[","[")
        );
    }





    /*------------------------------*/
    /*        Tests addNTimes        */
    /*------------------------------*/


    @DisplayName("addNTimes test validos de valores dentro de lo esperado")
    @ParameterizedTest()
    @MethodSource("addNTimes_validTestsSource")
    void addNTimes(int num, String elem,String result){
        testList.addNTimes(elem,num);
        Assertions.assertTrue(compareString(result));

    }
    static Stream<Arguments> addNTimes_validTestsSource(){
        return Stream.of(
                arguments(1,"A","ABCDEFGA"),
                arguments(1,"B","ABCDEFGB"),
                arguments(1,"M","ABCDEFGM"),
                arguments(1,"Y","ABCDEFGY"),
                arguments(1,"Z","ABCDEFGZ"),

                arguments(2,"A","ABCDEFGAA"),
                arguments(2,"B","ABCDEFGBB"),
                arguments(2,"M","ABCDEFGMM"),
                arguments(2,"Y","ABCDEFGYY"),
                arguments(2,"Z","ABCDEFGZZ")

        );
    }

    @DisplayName("addNTimes tests invalidos fuera del array")
    @ParameterizedTest()
    @MethodSource("addNTimes_outTestsSource")
    void addNTimesInv(int position, String elem){
        Assertions.assertThrows(IllegalArgumentException.class ,() ->testList.addAtPos(elem,position));
    }
    static Stream<Arguments> addNTimes_outTestsSource(){
        return Stream.of(
                arguments(0,"A"),
                arguments(0,"B"),
                arguments(0,"M"),
                arguments(0,"Y"),
                arguments(0,"Z"),

                arguments(0,"@"),
                arguments(0,"[")
        );
    }

    @DisplayName("addNTimes tests elementos invalidos")
    @ParameterizedTest()
    @MethodSource("addNTimes_invElemTestsSource")
    void addNTimesInvElem(int position, String elem,String result){
        int lastsize = testList.size();
        testList.addAtPos(elem,position);
        Assertions.assertTrue(compareString(result));

    }
    static Stream<Arguments> addNTimes_invElemTestsSource(){
        return Stream.of(
                arguments(1,"@", "ABCDEFG"),
                arguments(1,"[", "ABCDEFG"),

                arguments(2,"@", "ABCDEFG"),
                arguments(2,"[", "ABCDEFG")
        );
    }
}
