package com.example.filmutleie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.*;

class Film{
    public String tittel;
    public double utLeiePris;
    public Person leidAv;

    public Film(String tittel, double utLeiePris, Person leidAv) {
        this.tittel = tittel;
        this.utLeiePris = utLeiePris;
        this.leidAv = leidAv;
    }

    // konstruktør inn her

}

class Person{
    public String navn;
    public String telefonnr;

    // konstruktør inn her

    public Person(String navn, String telefonnr) {
        this.navn = navn;
        this.telefonnr = telefonnr;
    }
}

class FilmUtleie{

    public ArrayList<Film> f = new ArrayList<>();
    public ArrayList<Person> P = new ArrayList<>();
    public FilmUtleie() {
        Person Fahad = new Person("Fahad" , "453233");
        Person Faraj = new Person("Faraj" , "453233");
        Film up = new Film("UP", 25 , Fahad);
        Film got = new Film("Got", 25 , Faraj);
        this.f.add(up);
        this.f.add(got);
        this.P.add(Fahad);
        this.P.add(Faraj);
    }
    public void addfilm(){

    }
    public String leiUt(String navn, String telefonnr, String tittel){

        for(Film k:f){
            if( k.tittel.equals(tittel) ){
                if (k.leidAv == null){
                        Person lei = new Person(navn, telefonnr);
                        k.leidAv = lei;
                        this.P.add(lei);
                    return "vellykket utleie";
                }
                    return "allerede utleid for  " + k.leidAv.navn  ;
            }
        }
        return "Filmen finnes ikke";
    }

    public String leverInn(String tittel){

        for(Film k:f){
            if(k.tittel.equals(tittel)){
                if(k.leidAv == null){
                    return "filmen ikke er utleid " ;
                }
                k.leidAv = null;
                return "filem ble levert";
            }
        }
        return "filmen finnes ikke";
    }

    @Override
    public String toString(){
        String alt = "";
        for(Film k:f){
            if(k.leidAv != null){
                alt += k.tittel + " er leid til " + k.leidAv.navn + "\n";
            }
        }
            return alt;
    }
}
public class HelloController {
    FilmUtleie f = new FilmUtleie();
    @FXML
    private TextField flm;

    @FXML
    private Button lin;

    @FXML
    private Button lut;

    @FXML
    private TextField nmbr;

    @FXML
    private TextField nvn;

    @FXML
    private Button utl;

    @FXML
    private TextArea vis;

    @FXML
    void leieut(ActionEvent event) {
        vis.setText(f.leiUt(nvn.getText(), nmbr.getText(), flm.getText()));
    }

    @FXML
    void leverinn(ActionEvent event) {
        vis.setText(f.leverInn(flm.getText()));
    }

    @FXML
    void visutleie(ActionEvent event) {
        vis.setText(f.toString());
    }

}
