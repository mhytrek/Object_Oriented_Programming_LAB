package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    public void testPlace() throws PositionAlreadyOccupiedException {
        //given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));

        //then
        assertTrue(map.place(animal));
        assertThrows(PositionAlreadyOccupiedException.class, () -> map.place(animal), "Expected grassfield.place(animal) to throw, but it didn't");
    }

    @Test
    public void testMove() throws PositionAlreadyOccupiedException {
        //given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));

        //when
        map.place(animal);
        map.move(animal,
                MoveDirection.FORWARD);

        //then
        assertEquals(new Vector2d(2, 3), animal.getPosition());
    }

    @Test
    public void testIsOccupied() throws PositionAlreadyOccupiedException {
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
    public void testObjectAt() throws PositionAlreadyOccupiedException {
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
    public void testCanMoveTo() throws PositionAlreadyOccupiedException {
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
