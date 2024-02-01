package agh.ics.oop.presenter;

import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

import java.util.List;
import java.util.Map;

import static agh.ics.oop.OptionsParser.change_string_enum;

public class SimulationPresenter implements MapChangeListener {
    private AbstractWorldMap worldmap;
    private int CELL_WIDTH = 40;
    private int CELL_HEIGHT = 40;
    private Boundary boundary;
    private int height;
    private int width;
    @FXML
    private Label infoLabel;
    @FXML
    private TextField listofmoves;
    @FXML
    private GridPane mapGrid;
    @FXML Label moves;

    public void setWorldmap(WorldMap worldmap) {
        this.worldmap = (AbstractWorldMap) worldmap;
    }

    private Vector2d vectorOnGrid(Vector2d vector2d){
        int y = this.height - vector2d.getY() + boundary.lower_left().getY() - 1;
        int x = vector2d.getX() + 1 - boundary.lower_left().getX();
        return new Vector2d(x,y);
    }
    public void drawMap(){
        this.clearGrid();

        this.boundary = this.worldmap.getCurrentBounds();
        this.height = boundary.upper_right().getY() - boundary.lower_left().getY()+2;
        this.width = boundary.upper_right().getX() - boundary.lower_left().getX()+2;
        mapGrid.minHeight(this.height);
        mapGrid.minWidth(this.width);

        mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
        mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));

        Label yx = new Label("y\\x");
        GridPane.setHalignment(yx, HPos.CENTER);
        mapGrid.add(yx, 0, 0);
        for(int i = 1; i < this.width; i++){
            int x = i + boundary.lower_left().getX()-1;
            Label label = new Label(Integer.toString(x));
            mapGrid.add(label,i, 0);
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
            }
        for(int j = 1; j < this.height; j++){
            int y = - j + boundary.upper_right().getY()+1;
            Label label = new Label(Integer.toString(y));
            mapGrid.add(label,0, j);
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
        }
        Map<Vector2d, WorldElement> elements = worldmap.getElements();
        for(Vector2d vector: elements.keySet()){
            Vector2d gridVector = vectorOnGrid(vector);
            mapGrid.add(new Text(elements.get(vector).toString()), gridVector.getX(), gridVector.getY());
        }

        }



    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    @Override
    public void mapChanged(WorldMap worldmap, String message) {
        this.setWorldmap(worldmap);
        Platform.runLater(()->{
            this.moves.setText(message);
            this.drawMap();
        });
    }

    public void onSimulationStartClicked(){
        try{
            String moves = this.listofmoves.getText();
            String[] dir;
            dir = moves.split(" ");
            List<MoveDirection> directions = change_string_enum(dir);
            List<Vector2d> positions = List.of(new Vector2d(1,1), new Vector2d(5,5));
            Simulation simulation = new Simulation(directions, positions, worldmap);
            SimulationEngine engine = new SimulationEngine(List.of(simulation));
            engine.runAsync();
        } catch(IllegalArgumentException ignored){
            System.out.println(ignored.getMessage());
            System.exit(0);
        }


    }
}
