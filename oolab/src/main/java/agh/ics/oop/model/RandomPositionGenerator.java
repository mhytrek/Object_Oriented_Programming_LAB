package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RandomPositionGenerator implements Iterable, Iterator<Vector2d> {
    private List<Vector2d> positions;
    private int current_position;
    private int positions_len;

    RandomPositionGenerator(int maxWidth, int maxHeight, int grassCount){
        this.current_position = 0;
        this.positions_len = grassCount;
        ArrayList<Integer> list_x = new ArrayList<Integer>();
        for (int i=0; i < maxWidth; i++) list_x.add(i);
        Collections.shuffle(list_x);

        ArrayList<Integer> list_y = new ArrayList<Integer>();
        for (int i=0; i < maxHeight; i++) list_y.add(i);
        Collections.shuffle(list_y);

        List<Vector2d> positions = new ArrayList<>();
        for (int i=0; i<grassCount; i++) positions.add(new Vector2d(list_x.get(i), list_y.get(i)));
        this.positions = positions;
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return this.positions.iterator();
    }

    @Override
    public boolean hasNext() {
        return this.current_position < this.positions_len-1;
    }

    @Override
    public Vector2d next() {
        this.current_position ++;
        return this.positions.get(current_position-1);
    }
}
