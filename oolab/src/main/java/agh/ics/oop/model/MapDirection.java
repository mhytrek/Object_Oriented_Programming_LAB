package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;


    public String toString(){
        return switch(this){
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public MapDirection previous(){
        MapDirection[] values = MapDirection.values();
        return values[(this.ordinal() - 1 + values.length) % values.length];
    }

    public MapDirection next(){
        MapDirection[] values = MapDirection.values();
        return values[(this.ordinal() + 1) % values.length];
    }

    public Vector2d toUnitVector(){
        return switch(this){
            case NORTH -> new Vector2d(0,1);
            case SOUTH -> new Vector2d(0,-1);
            case EAST -> new Vector2d(1,0);
            case WEST -> new Vector2d(-1,0);
        };
    }

}
