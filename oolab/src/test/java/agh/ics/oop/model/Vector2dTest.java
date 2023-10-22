package agh.ics.oop.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    public void testEquals(){
        //given
        Vector2d v_1 = new Vector2d(1,2);
        Vector2d v_2 = new Vector2d(1,2);
        Vector2d v_3 = new Vector2d(0,0);
        Vector2d v_4 = new Vector2d(-1,-20);
        Vector2d v_5 = new Vector2d(-1,0);
        Vector2d v_6 = new Vector2d(-1000,2000);

        //when
        boolean t1 = v_1.equals(v_2); //True
        boolean t2 = v_1.equals(v_3);
        boolean t3 = v_1.equals(v_4);
        boolean t4 = v_1.equals(v_5);
        boolean t5 = v_1.equals(v_6);
        boolean t6 = v_3.equals(v_3); //True
        boolean t7 = v_3.equals(v_4);
        boolean t8 = v_3.equals(v_5);
        boolean t9 = v_4.equals(v_5);

        //then
        assertTrue(t1);
        assertTrue(t6);

        assertFalse(t2);
        assertFalse(t3);
        assertFalse(t4);
        assertFalse(t5);
        assertFalse(t7);
        assertFalse(t8);
        assertFalse(t9);


    }

    @Test
    public void testtoString(){
        //given
        Vector2d v_1 = new Vector2d(1,-2);
        Vector2d v_2 = new Vector2d(10,2);
        Vector2d v_3 = new Vector2d(0,0);
        Vector2d v_4 = new Vector2d(-100,-90);
        String expected_1 = "(1,-2)";
        String expected_2 = "(10,2)";
        String expected_3 = "(0,0)";
        String expected_4 = "(-100,-90)";

        //when
        String r_1 = v_1.toString();
        String r_2 = v_2.toString();
        String r_3 = v_3.toString();
        String r_4 = v_4.toString();

        //then
        assertEquals(expected_2,r_2);
        assertEquals(expected_1,r_1);
        assertEquals(expected_3,r_3);
        assertEquals(expected_4,r_4);
    }

    @Test
    public void testprecedes(){
        //given
        Vector2d v_1 = new Vector2d(-10,20);
        Vector2d v_2 = new Vector2d(0,0);
        Vector2d v_3 = new Vector2d(0,100);
        Vector2d v_4 = new Vector2d(-1,-2);
        Vector2d v_5 = new Vector2d(140,6);
        Vector2d v_6 = new Vector2d(2,2);

        //when
        boolean t1 = v_4.precedes(v_2); //True
        boolean t2 = v_2.precedes(v_3); //True
        boolean t3 = v_4.precedes(v_3); //True
        boolean t4 = v_6.precedes(v_5); //True
        boolean t5 = v_1.precedes(v_3); //True

        boolean t6 = v_1.precedes(v_5);
        boolean t7 = v_5.precedes(v_1);
        boolean t8 = v_6.precedes(v_3);
        boolean t9 = v_2.precedes(v_4);

        //then
        assertTrue(t1);
        assertTrue(t2);
        assertTrue(t3);
        assertTrue(t4);
        assertTrue(t5);

        assertFalse(t6);
        assertFalse(t7);
        assertFalse(t8);
        assertFalse(t9);

    }

    @Test
    public void testfollows(){
        Vector2d v_1 = new Vector2d(-10,20);
        Vector2d v_2 = new Vector2d(0,0);
        Vector2d v_3 = new Vector2d(0,100);
        Vector2d v_4 = new Vector2d(-1,-2);
        Vector2d v_5 = new Vector2d(140,6);
        Vector2d v_6 = new Vector2d(2,2);

        //when
        boolean t1 = v_2.follows(v_4); //True
        boolean t2 = v_3.follows(v_2); //True
        boolean t3 = v_3.follows(v_4); //True
        boolean t4 = v_5.follows(v_6); //True
        boolean t5 = v_3.follows(v_1); //True

        boolean t6 = v_5.follows(v_1);
        boolean t7 = v_1.follows(v_5);
        boolean t8 = v_3.follows(v_6);
        boolean t9 = v_4.follows(v_2);

        //then
        assertTrue(t1);
        assertTrue(t2);
        assertTrue(t3);
        assertTrue(t4);
        assertTrue(t5);

        assertFalse(t6);
        assertFalse(t7);
        assertFalse(t8);
        assertFalse(t9);
    }

    @Test
    public void testUpperRight(){
        //given
        Vector2d v_1 = new Vector2d(-10,20);
        Vector2d v_2 = new Vector2d(0,0);
        Vector2d expected_1 = new Vector2d(0,20);

        Vector2d v_3 = new Vector2d(0,100);
        Vector2d v_4 = new Vector2d(-1,-2);
        Vector2d expected_2 = new Vector2d(0,100);

        Vector2d v_5 = new Vector2d(140,6);
        Vector2d v_6 = new Vector2d(2,6);
        Vector2d expected_3 = new Vector2d(140,6);

        //when
        Vector2d r_1 = v_1.upperRight(v_2);
        Vector2d r_2 = v_3.upperRight(v_4);
        Vector2d r_3 = v_5.upperRight(v_6);

        //then
        assertEquals(expected_1,r_1);
        assertEquals(expected_2, r_2);
        assertEquals(expected_3, r_3);

    }

    @Test
    public void testLowerLeft(){
        //given
        Vector2d v_1 = new Vector2d(-10,20);
        Vector2d v_2 = new Vector2d(0,0);
        Vector2d expected_1 = new Vector2d(-10,0);

        Vector2d v_3 = new Vector2d(0,100);
        Vector2d v_4 = new Vector2d(-1,-2);
        Vector2d expected_2 = new Vector2d(-1,-2);

        Vector2d v_5 = new Vector2d(140,6);
        Vector2d v_6 = new Vector2d(2,6);
        Vector2d expected_3 = new Vector2d(2,6);

        //when
        Vector2d r_1 = v_1.lowerLeft(v_2);
        Vector2d r_2 = v_3.lowerLeft(v_4);
        Vector2d r_3 = v_5.lowerLeft(v_6);

        //then
        assertEquals(expected_1,r_1);
        assertEquals(expected_2, r_2);
        assertEquals(expected_3, r_3);
    }

    @Test
    public void testadd(){
        //given
        Vector2d v_1 = new Vector2d(-10,20);
        Vector2d v_2 = new Vector2d(0,0);
        Vector2d expected_1 = new Vector2d(-10,20);

        Vector2d v_3 = new Vector2d(0,100);
        Vector2d v_4 = new Vector2d(-1,-2);
        Vector2d expected_2 = new Vector2d(-1,98);

        Vector2d v_5 = new Vector2d(140,6);
        Vector2d v_6 = new Vector2d(2,6);
        Vector2d expected_3 = new Vector2d(142,12);

        //when
        Vector2d r_1 = v_1.add(v_2);
        Vector2d r_2 = v_3.add(v_4);
        Vector2d r_3 = v_5.add(v_6);

        //then
        assertEquals(expected_1,r_1);
        assertEquals(expected_2, r_2);
        assertEquals(expected_3, r_3);
    }



    @Test
    public void testsubtract(){
        //given
        Vector2d v_1 = new Vector2d(-10,20);
        Vector2d v_2 = new Vector2d(0,0);
        Vector2d expected_1 = new Vector2d(-10,20);

        Vector2d v_3 = new Vector2d(0,100);
        Vector2d v_4 = new Vector2d(-1,-2);
        Vector2d expected_2 = new Vector2d(1,102);

        Vector2d v_5 = new Vector2d(140,6);
        Vector2d v_6 = new Vector2d(2,6);
        Vector2d expected_3 = new Vector2d(138,0);

        //when
        Vector2d r_1 = v_1.subtract(v_2);
        Vector2d r_2 = v_3.subtract(v_4);
        Vector2d r_3 = v_5.subtract(v_6);

        //then
        assertEquals(expected_1,r_1);
        assertEquals(expected_2, r_2);
        assertEquals(expected_3, r_3);
    }

    @Test
    public void testopposite(){
        //given
        Vector2d v_1 = new Vector2d(-10,20);
        Vector2d expected_1 = new Vector2d(10,-20);

        Vector2d v_2 = new Vector2d(0,0);
        Vector2d expected_2 = new Vector2d(0,0);

        Vector2d v_3 = new Vector2d(0,100);
        Vector2d expected_3 = new Vector2d(0,-100);

        Vector2d v_4 = new Vector2d(-1,-2);
        Vector2d expected_4 = new Vector2d(1,2);

        Vector2d v_5 = new Vector2d(140,6);
        Vector2d expected_5 = new Vector2d(-140,-6);

        Vector2d v_6 = new Vector2d(2,6);
        Vector2d expected_6 = new Vector2d(-2,-6);

        //when
        Vector2d r_1 = v_1.opposite();
        Vector2d r_2 = v_2.opposite();
        Vector2d r_3 = v_3.opposite();
        Vector2d r_4 = v_4.opposite();
        Vector2d r_5 = v_5.opposite();
        Vector2d r_6 = v_6.opposite();

        //then
        assertEquals(expected_1,r_1);
        assertEquals(expected_2, r_2);
        assertEquals(expected_3, r_3);
        assertEquals(expected_4,r_4);
        assertEquals(expected_5, r_5);
        assertEquals(expected_6, r_6);
    }

}
