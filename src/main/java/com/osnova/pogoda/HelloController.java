package com.osnova.pogoda;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField city;

    @FXML
    private Button getData;

    @FXML
    private Text temp_dav;

    @FXML
    private Text temp_feels;

    @FXML
    private Text temp_max;

    @FXML
    private Text temp_min;

    @FXML
    private Text tmep_info;

    @FXML
    void initialize() {
        getData.setOnAction(event ->{
            String getUserCity = city.getText().trim();
            String output = getUrlContent("http://api.weatherapi.com/v1/current.json?key=93fd60cefcd54e46837122646223010&q="+getUserCity+"&aqi=no");
            System.out.println(output);

            if(!output.isEmpty()){

            }
        });

    }

    private static String getUrlContent(String urlAdress){
        StringBuffer content = new StringBuffer();

        try{
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while((line=bufferedReader.readLine()) != null){
                content.append(line +"\n");
            }
            bufferedReader.close();
        }catch (Exception e){
            System.out.println("Такой город не найден!");

        }
        return content.toString();
    }

}
