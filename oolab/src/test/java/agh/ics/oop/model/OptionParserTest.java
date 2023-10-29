package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionParserTest {

    @Test
    public void testOptionParser(){
        //given
        String[] list_1 = {"b", "f", "r", "l"};
        LinkedList<MoveDirection> expected_1 = new LinkedList<>(List.of(MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.LEFT));
        String[] list_2 = {"f", "f", "b"};
        LinkedList<MoveDirection> expected_2 = new LinkedList<>(List.of(MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD));
        String[] list_3 = {"l"};
        LinkedList<MoveDirection> expected_3 = new LinkedList<>(List.of(MoveDirection.LEFT));
        String[] list_4 = {"r", "ww"};
        LinkedList<MoveDirection> expected_4 =new LinkedList<>(List.of(MoveDirection.RIGHT));


        //when
        LinkedList<MoveDirection> result_1 = OptionsParser.change_string_enum(list_1);
        LinkedList<MoveDirection> result_2 = OptionsParser.change_string_enum(list_2);
        LinkedList<MoveDirection> result_3 = OptionsParser.change_string_enum(list_3);
        LinkedList<MoveDirection> result_4 = OptionsParser.change_string_enum(list_4);

        //then
        assertArrayEquals(expected_1.toArray(), result_1.toArray());
        assertArrayEquals(expected_2.toArray(), result_2.toArray());
        assertArrayEquals(expected_3.toArray(), result_3.toArray());
        assertArrayEquals(expected_4.toArray(), result_4.toArray());

    }
}
