package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class MapDirectionTest {

    @Test
    public void testNext(){
        //given
        MapDirection test_s_next = MapDirection.SOUTH.next();
        MapDirection test_w_next = MapDirection.WEST.next();
        MapDirection test_n_next = MapDirection.NORTH.next();
        MapDirection test_e_next = MapDirection.EAST.next();

        //then
        assertEquals(MapDirection.WEST, test_s_next);
        assertEquals(MapDirection.NORTH, test_w_next);
        assertEquals(MapDirection.EAST, test_n_next);
        assertEquals(MapDirection.SOUTH, test_e_next);
    }

    @Test
    public void testPrevious(){
        //given
        MapDirection test_s_next = MapDirection.SOUTH.previous();
        MapDirection test_w_next = MapDirection.WEST.previous();
        MapDirection test_n_next = MapDirection.NORTH.previous();
        MapDirection test_e_next = MapDirection.EAST.previous();

        //then
        assertEquals(MapDirection.EAST, test_s_next);
        assertEquals(MapDirection.SOUTH, test_w_next);
        assertEquals(MapDirection.WEST, test_n_next);
        assertEquals(MapDirection.NORTH, test_e_next);
    }


}
