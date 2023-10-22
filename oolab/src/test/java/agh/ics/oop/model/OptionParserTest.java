package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionParserTest {

    @Test
    public void testOptionParser(){
        //given
        String[] list_1 = {"b", "f", "r", "l"};
        MoveDirection[] expected_1 = {MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.LEFT};
        String[] list_2 = {"f", "f", "b"};
        MoveDirection[] expected_2 = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD};
        String[] list_3 = {"l"};
        MoveDirection[] expected_3 = {MoveDirection.LEFT};

        //when
        MoveDirection[] result_1 = OptionsParser.change_string_enum(list_1);
        MoveDirection[] result_2 = OptionsParser.change_string_enum(list_2);
        MoveDirection[] result_3 = OptionsParser.change_string_enum(list_3);

        //then
        assertArrayEquals(expected_1, result_1);
        assertArrayEquals(expected_2, result_2);
        assertArrayEquals(expected_3, result_3);

    }
}
