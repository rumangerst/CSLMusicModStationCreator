package cslmusicmod.stationeditor;

import com.google.gson.Gson;
import cslmusicmod.stationeditor.controls.FilePicker;
import cslmusicmod.stationeditor.controls.NameEditor;
import cslmusicmod.stationeditor.controls.ScheduleEditor;
import cslmusicmod.stationeditor.controls.ThumbnailEditor;
import cslmusicmod.stationeditor.model.Station;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileReader;
import java.io.IOException;

public class MainWindow {

    private Station station;

    @FXML
    private ThumbnailEditor thumbnailEditor;

    @FXML
    private NameEditor nameEditor;

    @FXML
    private ScheduleEditor scheduleEditor;

    public MainWindow() {
        Gson gson = Station.getGson();
        try(FileReader r = new FileReader("TestStation.json")) {
            station = gson.fromJson(r, Station.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        thumbnailEditor.setStation(station);
        nameEditor.setStation(station);
        scheduleEditor.setStation(station);
    }

}