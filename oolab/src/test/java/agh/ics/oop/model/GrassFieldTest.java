package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrassFieldTest {

    @Test
    public void testCanMoveTo() throws PositionAlreadyOccupiedException {
        //given
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal( new Vector2d(2, 2));

        //when
        grassField.place(animal);

        //then
        assertTrue(grassField.canMoveTo(new Vector2d(3, 3)));
        assertFalse(grassField.canMoveTo(new Vector2d(2, 2)));
    }

    @Test
    public void testPlace() throws PositionAlreadyOccupiedException {
        //given
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal(new Vector2d(2, 2));

        //then
        assertTrue(grassField.place(animal));
        assertTrue(grassField.isOccupied(animal.getPosition()));
        assertThrows(PositionAlreadyOccupiedException.class, () -> grassField.place(animal), "Expected grassfield.place(animal) to throw, but it didn't");
    }

    @Test
    public void testMove() throws PositionAlreadyOccupiedException {
        //given
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal(new Vector2d(2, 2));

        //when
        grassField.place(animal);

        // then
        grassField.move(animal, MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 3), animal.getPosition());
    }

    @Test
    public void testIsOccupied() throws PositionAlreadyOccupiedException {
        //given
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal(new Vector2d(2, 2));

        //when
        grassField.place(animal);

        //then
        assertTrue(grassField.isOccupied(new Vector2d(2, 2)));
        assertFalse(grassField.isOccupied(new Vector2d(11, 11)));
    }

    @Test
    public void testObjectAt() throws PositionAlreadyOccupiedException {
        //given
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal(new Vector2d(2, 2));

        //when
        grassField.place(animal);

        //then
        assertEquals(animal, grassField.objectAt(new Vector2d(2, 2)));
        assertNull(grassField.objectAt(new Vector2d(1, 1)));
    }

}

