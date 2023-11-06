package agh.ics.oop.model;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientation = MapDirection.NORTH;

    static Vector2d vector_min = new Vector2d(0,0);
    static Vector2d vector_max = new Vector2d(4,4);

    public Animal(Vector2d position){
        this.position = position;
        this.orientation = MapDirection.NORTH;
    }

    public Animal(){}

    public Vector2d getPosition() {
        return position;
    }

    public String toString(){
        return this.orientation.toString();
    }

    boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction, MoveValidator validator){
        Vector2d copy_position = this.position;
        switch(direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case BACKWARD -> {
                position = this.position.subtract(this.orientation.toUnitVector());
                if(validator.canMoveTo(position)){
                    this.position = position;
                }
                else{
                    this.position = copy_position;
                }
            }
            case FORWARD -> {
                position = this.position.add(this.orientation.toUnitVector());
                if(validator.canMoveTo(position)){
                    this.position = position;
                }
                else{
                    this.position = copy_position;
                }
            }

        }
    }



}
