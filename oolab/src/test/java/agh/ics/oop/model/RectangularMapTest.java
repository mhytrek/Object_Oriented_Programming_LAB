package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    public void testPlace() {
        //given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));

        //then
        assertTrue(map.place(animal));
        assertFalse(map.place(animal));
    }

    @Test
    public void testMove() {
        //given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));

        //when
        map.place(animal);
        map.move(animal, MoveDirection.FORWARD);

        //then
        assertEquals(new Vector2d(2, 3), animal.getPosition());
    }

    @Test
    public void testIsOccupied() {
        //given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));

        //when
        map.place(animal);

        //then
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertFalse(map.isOccupied(new Vector2d(1, 1)));
    }

    @Test
    public void testObjectAt() {
        //given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));

        //when
        map.place(animal);


        //then
        assertEquals(animal, map.objectAt(new Vector2d(2, 2)));
        assertNull(map.objectAt(new Vector2d(1, 1)));
    }

    @Test
    public void testCanMoveTo() {
        //given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));

        //when
        map.place(animal);

        //then
        assertTrue(map.canMoveTo(new Vector2d(3, 3)));
        assertFalse(map.canMoveTo(new Vector2d(6, 6))); // Out of map bounds
        assertFalse(map.canMoveTo(new Vector2d(2, 2))); // Already occupied
    }
}
