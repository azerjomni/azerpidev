/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;



import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ousse
 */
public class MapController extends Application implements MapComponentInitializedListener {

    GoogleMapView mapView;
    GoogleMap map;

    @Override
    public void start(Stage stage) throws Exception {

    //Create the JavaFX component and set this as a listener so we know when 
    //the map has been initialized, at which point we can then begin manipulating it.
    mapView = new GoogleMapView();
    mapView.addMapInializedListener(this);

    Scene scene = new Scene(mapView);

    stage.setTitle("JavaFX and Google Maps");
    stage.setScene(scene);
    stage.show();    }

    @Override
    public void mapInitialized() {
    //Set the initial properties of the map.
    MapOptions mapOptions = new MapOptions();

    mapOptions.center(new LatLong(36.877940, 10.178079))
            .mapType(MapTypeIdEnum.ROADMAP)
            .overviewMapControl(false)
            .panControl(false)
            .rotateControl(false)
            .scaleControl(false)
            .streetViewControl(false)
            .zoomControl(false)
            .zoom(12);

    map = mapView.createMap(mapOptions);

    //Add a marker to the map
    MarkerOptions markerOptions = new MarkerOptions();

    markerOptions.position( new LatLong(36.877940, 10.178079) )
                .visible(Boolean.TRUE)
                .title("My Marker");

    Marker marker = new Marker( markerOptions );

    map.addMarker(marker);    }
    
    
    /**
     * Initializes the controller class.
     */
  public static void main(String[] args) {
    launch(args);
}
    
}
