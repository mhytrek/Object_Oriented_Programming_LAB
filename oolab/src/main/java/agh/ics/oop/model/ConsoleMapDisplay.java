package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int updatesCount;

    public ConsoleMapDisplay() {
        updatesCount = 0;
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        updatesCount++;
        System.out.println("Update " + updatesCount + ": " + message);
        System.out.println(worldMap.toString());
        System.out.println("Total updates received: " + updatesCount);
    }

}
