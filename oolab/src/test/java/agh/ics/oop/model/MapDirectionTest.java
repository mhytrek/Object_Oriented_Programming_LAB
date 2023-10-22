package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class MapDirectionTest {

    @Test
    public void testNext(){
        MapDirection test_s_next = MapDirection.SOUTH.next();
        assertEquals(MapDirection.WEST, test_s_next);
        MapDirection test_w_next = MapDirection.WEST.next();
        assertEquals(MapDirection.NORTH, test_w_next);
        MapDirection test_n_next = MapDirection.NORTH.next();
        assertEquals(MapDirection.EAST, test_n_next);
        MapDirection test_e_next = MapDirection.EAST.next();
        assertEquals(MapDirection.SOUTH, test_e_next);
    }

    @Test
    public void testPrevious(){
        MapDirection test_s_next = MapDirection.SOUTH.previous();
        assertEquals(MapDirection.EAST, test_s_next);
        MapDirection test_w_next = MapDirection.WEST.previous();
        assertEquals(MapDirection.SOUTH, test_w_next);
        MapDirection test_n_next = MapDirection.NORTH.previous();
        assertEquals(MapDirection.WEST, test_n_next);
        MapDirection test_e_next = MapDirection.EAST.previous();
        assertEquals(MapDirection.NORTH, test_e_next);
    }


}
