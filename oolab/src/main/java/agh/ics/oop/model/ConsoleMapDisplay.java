package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int updatesCount;

    public ConsoleMapDisplay() {
        updatesCount = 0;
    }

    @Override
    public synchronized void mapChanged(WorldMap worldMap, String message) {
        updatesCount++;
//        System.out.println("Total updates received: " + updatesCount);
//        System.out.println("Update " + updatesCount + ": " + message);
//        System.out.println("map id: " + worldMap.getId());
//        System.out.println(worldMap.toString());
        System.out.println("Total updates received: " + updatesCount + "\n" +
                "Update " + updatesCount + ": " + message + "\n" +
                "map id: " + worldMap.getId() + "\n" +
                worldMap.toString());
    }

}
