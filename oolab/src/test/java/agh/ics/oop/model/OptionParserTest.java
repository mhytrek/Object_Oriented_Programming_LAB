package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionParserTest {

    @Test
    public void testOptionParser(){
        //given
        String[] list_1 = {"b", "f", "r", "l"};
        List<MoveDirection> expected_1 = new ArrayList<>(List.of(MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.LEFT));
        String[] list_2 = {"f", "f", "b"};
        List<MoveDirection> expected_2 = new ArrayList<>(List.of(MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD));
        String[] list_3 = {"l"};
        List<MoveDirection> expected_3 = new ArrayList<>(List.of(MoveDirection.LEFT));
        String[] list_4 = {"r", "ww"};
        List<MoveDirection> expected_4 =new ArrayList<>(List.of(MoveDirection.RIGHT));


        //when
        List<MoveDirection> result_1 = OptionsParser.change_string_enum(list_1);
        List<MoveDirection> result_2 = OptionsParser.change_string_enum(list_2);
        List<MoveDirection> result_3 = OptionsParser.change_string_enum(list_3);
        List<MoveDirection> result_4 = OptionsParser.change_string_enum(list_4);

        //then
        assertEquals(expected_1, result_1);
        assertEquals(expected_2, result_2);
        assertEquals(expected_3, result_3);
        assertEquals(expected_4, result_4);

    }
}
