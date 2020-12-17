package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private TextField Destino;

    @FXML
    private TextField Origen;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnR;

    @FXML
    private Line LAB;

    @FXML
    private Line LBE;

    @FXML
    private Line LAD;

    @FXML
    private Line LEG;

    @FXML
    private Line LAC;

    @FXML
    private Line LCF;//

    @FXML
    private Line LCD;//

    @FXML
    private Line LBD;//

    @FXML
    private Line LDE;//

    @FXML
    private Line LDF;//

    @FXML
    private Line LFG;//

    @FXML
    private Line LEF;//

    @FXML
    private Circle CA;

    @FXML
    private Circle CB;

    @FXML
    private Circle CE;

    @FXML
    private Circle CCF;

    @FXML
    private Circle CCD;

    @FXML
    private Circle CC;

    @FXML
    private Circle CG;


    @FXML
    private TextField AB;

    @FXML
    private TextField BE;

    @FXML
    private TextField AC;

    @FXML
    private TextField AD;

    @FXML
    private TextField CD;

    @FXML
    private TextField DE;

    @FXML
    private TextField DF;

    @FXML
    private TextField EG;

    @FXML
    private TextField FG;

    @FXML
    private TextField EF;

    @FXML
    private TextField BD;
    @FXML
    private TextField CF;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextField nod;




    public void extraerDatos(javafx.event.ActionEvent actionEvent) {
        rePaint();
        Long ab = Long.parseLong(AB.getText());
        Long ac = Long.parseLong(AC.getText());
        Long ad = Long.parseLong(AD.getText());
        Long be = Long.parseLong(BE.getText());
        Long bd = Long.parseLong(BD.getText());
        Long cf = Long.parseLong(CF.getText());
        Long cd = Long.parseLong(CD.getText());
        Long de = Long.parseLong(DE.getText());
        Long df = Long.parseLong(DF.getText());
        Long eg = Long.parseLong(EG.getText());
        Long ef = Long.parseLong(EF.getText());
        Long fg = Long.parseLong(FG.getText());

        String dest = Destino.getText();
        String ori = Origen.getText();

        long matriz[][] = {

                {0,         ab,          ac,          ad,         999999999,  999999999,  999999999},
                {ab,         0,          999999999,   bd,         be,         999999999,  999999999},
                {ac,         999999999,  0,           cd,         999999999,         cf,  999999999},
                {ad,        bd,          cd,          0,          de,                df,  999999999},
                {999999999, be,          999999999 ,  de,          0,                ef,  eg},
                {999999999, 999999999,   ef,          df,         cf,                 0,  fg},
                {999999999, 999999999,  999999999,  999999999 ,    eg,                fg,  0}

        };
        pintarMAtriz(matriz);

        String condicion = ori + "a" +dest;
        condicion = validarConcidicon(condicion);
        String datos;
        caminosMinimos cam = new caminosMinimos();
        datos = cam.algoritmoDjisktra(matriz, condicion);

        System.out.println("Ruta : " + datos);


        ori=validarOrigen(ori, dest);
        pintarColores(datos, ori);

    }
    public String validarOrigen(String origen, String destino){
        int num1 = Integer.parseInt(origen) ;
        int num2 = Integer.parseInt(destino);



            if (num1 > num2 ){
                num1 = num2;
            }

            return String.valueOf(num1);
    }
    public String  validarConcidicon(String condicion) {

        if (condicion.equals("2a1")) {
            condicion = "1a2";
        }

        if (condicion.equals("3a1")) {
            condicion = "1a3";
        }

        if (condicion.equals("4a1")){
            condicion = "1a4";
        }
        if (condicion.equals("4a2")){
            condicion= "2a4";
        }
        if (condicion.equals("4a3")){
            condicion= "3a4";
        }

        if (condicion.equals("5a2")){
            condicion= "2a5";
        }
        if (condicion.equals("5a4")){
            condicion= "4a5";
        }
        if (condicion.equals("5a6")){
            condicion="6a5";
        }
        if (condicion.equals("6a3")){
            condicion= "3a6";
        }
        if (condicion.equals("6a4")){
            condicion= "4a6";
        }
        if (condicion.equals("7a5")){
            condicion= "7a6";
        }
        if (condicion.equals("7a6")){
            condicion="6a7";
        }
        if (condicion.equals("7a4")){
            condicion= "4a7";
        }
        if (condicion.equals("7a3")){
            condicion="3a7";
        }
        if (condicion.equals("7a2")){
            condicion="2a7";

        }
        if (condicion.equals("7a1")){
            condicion="1a7";
        }
        if (condicion.equals("6a2")){
            condicion= "2a6";
        }
        if (condicion.equals("6a1")){
            condicion= "1a6";
        }
        if (condicion.equals("5a1")){
            condicion= "1a5";
        }
        if (condicion.equals("5a3")){
            condicion="3a5";

        }


        return condicion;
    }

    public void pintarColores(String datos, String origen) {

        String[] part = {};
        String unique = "";         //para cuando la ruta es solo uno
        String aux = "";
        String con = "";

        switch (origen) {
            case "1": //origen A
                pintarA(datos, part, unique, aux, con);
                break;
            case "2": //origen B
                pintarB(datos, part, unique, aux, con);
                break;
            case "3": //Origen C
                pintarC(datos, part, unique, aux, con);
                break;
            case "4": //Origen C
                pintarD(datos, part, unique, aux, con);
                break;
            case "5": //Origen C
                pintarE(datos, part, unique, aux, con);
                break;
            case "6": //Origen C
                pintarF(datos, part, unique, aux, con);
                break;
            case "7": //Origen C
                pintarG(datos, part, unique, aux, con);
                break;
        }
    }

    public void rePaint() {
        LAB.setStroke(Color.BLACK);
        LCD.setStroke(Color.BLACK);
        LAC.setStroke(Color.BLACK);
        LBD.setStroke(Color.BLACK);
        LAD.setStroke(Color.BLACK);
        LCF.setStroke(Color.BLACK);
        LBE.setStroke(Color.BLACK);
        LDE.setStroke(Color.BLACK);
        LDF.setStroke(Color.BLACK);
        LEF.setStroke(Color.BLACK);
        LEG.setStroke(Color.BLACK);
        LFG.setStroke(Color.BLACK);

    }

    public void pintarA(String datos, String[] part, String unique, String aux, String con) {
        if (datos.contains(",")) {  // de vuelve la ruta con mas de un nodo

            part = datos.split(",");
            aux = part[0];              //guarda el nodo inicial

            for (int i = 0; i < part.length; i++) {


                if (part[i].equals("2") || part[i].equals(" 2")) {
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LAB.setStroke(Color.RED);
                    }
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAB.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LBD.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LBE.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                if (part[i].equals("3") || part[i].equals(" 3")) {
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LAC.setStroke(Color.RED);
                    }
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAC.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LCD.setStroke(Color.RED);
                    }

                    if (aux.equals("6") || aux.equals(" 6")) {
                        LCF.setStroke(Color.RED);
                    }

                    aux = part[i];

                }

                if (part[i].equals("4") || part[i].equals(" 4")) {
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LAD.setStroke(Color.RED);
                    }
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAD.setStroke(Color.RED);
                    }
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LBD.setStroke(Color.RED);
                    }
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LCD.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LDE.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LDF.setStroke(Color.RED);
                    }

                    aux = part[i];

                }

                //valida nodos lejanos
                if (part[i].equals("5") || part[i].equals(" 5")) {
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LBE.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LDE.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LEF.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                if (part[i].equals("6") || part[i].equals(" 6")) {
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LCF.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LDF.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LEF.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                if (part[i].equals("7") || part[i].equals(" 7")) {
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LEG.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LFG.setStroke(Color.RED);
                    }
                    aux = part[i];

                }
            }
        } else {
            unique = datos;
            if (datos.equals("2")) {
                LAB.setStroke(Color.RED);
            }
            if (datos.equals("3")) {
                LAC.setStroke(Color.RED);
            }
            if (datos.equals("4")) {
                LAD.setStroke(Color.RED);
            }
        }
    }

    public void pintarB(String datos, String[] part, String unique, String aux, String con) {
        if (datos.contains(",")) {  // de vuelve la ruta con mas de un nodo

            part = datos.split(",");
            aux = part[0];              //guarda el nodo inicial

            for (int i = 0; i < part.length; i++) {

                //valida los nodos cercanos
                if (part[i].equals("1") || part[i].equals(" 1")) {
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAB.setStroke(Color.RED);
                    }
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LAB.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LAD.setStroke(Color.RED);
                    }
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LAC.setStroke(Color.RED);
                    }

                    aux = part[i];

                }

                if (part[i].equals("4") || part[i].equals(" 4")) {
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LBD.setStroke(Color.RED);
                    }
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LBD.setStroke(Color.RED);
                    }
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAD.setStroke(Color.RED);
                    }
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LCD.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LDF.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LDE.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                if (part[i].equals("5") || part[i].equals(" 5")) {
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LBE.setStroke(Color.RED);
                    }
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LBE.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LDE.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LEF.setStroke(Color.RED);
                    }
                    if (aux.equals("7") || aux.equals(" 7")) {
                        LEG.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                //valida los nodos lejanos
                if (part[i].equals("3") || part[i].equals(" 3")) {
                    //si viene del nodo 2:
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAC.setStroke(Color.RED);
                    }
                    //si viene del nodo 4:
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LCD.setStroke(Color.RED);
                    }
                    //si viene del nodo 6:
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LCF.setStroke(Color.RED);
                    }

                    aux = part[i];
                    System.out.println("El auxiliar es: " + aux);
                }

                if (part[i].equals("6") || part[i].equals(" 6")) {
                    //Ssi viene del 3
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LCF.setStroke(Color.RED);
                    }
                    //si viene del nodo 4
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LDF.setStroke(Color.RED);
                    }
                    //si viene del nodo 5
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LEF.setStroke(Color.RED);
                    }

                    if (aux.equals("7") || aux.equals(" 7")) {
                        LFG.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                if (part[i].equals("7") || part[i].equals(" 7")) {
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LEG.setStroke(Color.RED);
                    }
                    //si viene del nodo 6
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LFG.setStroke(Color.RED);
                    }
                    aux = part[i];

                }
            }
        } else {
            unique = datos;
            if (datos.equals("1")) {
                LAB.setStroke(Color.RED);
            }
            if (datos.equals("5")) {
                LBE.setStroke(Color.RED);
            }
            if (datos.equals("4")) {
                LBD.setStroke(Color.RED);
            }
        }
    }

    public void pintarC(String datos, String[] part, String unique, String aux, String con) {
        if (datos.contains(",")) {  // de vuelve la ruta con mas de un nodo

            part = datos.split(",");
            aux = part[0];              //guarda el nodo inicial

            for (int i = 0; i < part.length; i++) {
                //valida los nodos cercanos
                if (part[i].equals("1") || part[i].equals(" 1")) {
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAC.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LAD.setStroke(Color.RED);
                    }
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LAC.setStroke(Color.RED);
                    }
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LAB.setStroke(Color.RED);
                    }

                    aux = part[i];

                }

                if (part[i].equals("4") || part[i].equals(" 4")) {
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LCD.setStroke(Color.RED);
                    }

                    if (aux.equals("2") || aux.equals(" 2")) {
                        LBD.setStroke(Color.RED);
                    }
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAD.setStroke(Color.RED);
                    }
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LCD.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LDE.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LDF.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                if (part[i].equals("6") || part[i].equals(" 6")) {
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LCF.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LDF.setStroke(Color.RED);
                    }
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LCF.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LEF.setStroke(Color.RED);
                    }
                    if (aux.equals("7") || aux.equals(" 7")) {
                        LFG.setStroke(Color.RED);
                    }

                    aux = part[i];

                }

                //valida los nodos lejanos
                if (part[i].equals("2") || part[i].equals(" 2")) {
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAB.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LBD.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LBE.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                if (part[i].equals("5") || part[i].equals(" 5")) {
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LBE.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LDE.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LEF.setStroke(Color.RED);
                    }
                    if (aux.equals("7") || aux.equals(" 7")) {
                        LEG.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                if (part[i].equals("7") || part[i].equals(" 7")) {
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LEG.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LFG.setStroke(Color.RED);
                    }
                    aux = part[i];

                }
            }
        } else {
            unique = datos;
            if (datos.equals("1")) {
                LAC.setStroke(Color.RED);
            }
            if (datos.equals("4")) {
                LCD.setStroke(Color.RED);
            }
            if (datos.equals("6")) {
                LCF.setStroke(Color.RED);
            }
        }
    }

    public void pintarD(String datos, String[] part, String unique, String aux, String con) {
        if (datos.contains(",")) {  // de vuelve la ruta con mas de un nodo

            part = datos.split(",");
            aux = part[0];              //guarda el nodo inicial

            for (int i = 0; i < part.length; i++) {

                //valida los nodos cercanos
                if (part[i].equals("1") || part[i].equals(" 1")) {

                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAD.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LAD.setStroke(Color.RED);
                    }
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LAC.setStroke(Color.RED);
                    }
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LAB.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                if (part[i].equals("2") || part[i].equals(" 2")) {
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LBD.setStroke(Color.RED);
                    }
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAB.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LBD.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LBE.setStroke(Color.RED);
                    }

                    aux = part[i];

                }

                if (part[i].equals("3") || part[i].equals(" 3")) {
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LCD.setStroke(Color.RED);
                    }
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAC.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LCD.setStroke(Color.RED);
                    }

                    if (aux.equals("6") || aux.equals(" 6")) {
                        LCF.setStroke(Color.RED);
                    }

                    aux = part[i];

                }

                if (part[i].equals("5") || part[i].equals(" 5")) {
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LDE.setStroke(Color.RED);
                    }

                    if (aux.equals("4") || aux.equals(" 4")) {
                        LDE.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LEF.setStroke(Color.RED);
                    }

                    if (aux.equals("7") || aux.equals(" 7")) {
                        LEG.setStroke(Color.RED);
                    }

                    aux = part[i];

                }

                if (part[i].equals("6") || part[i].equals(" 6")) {
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LDF.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LDF.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LEF.setStroke(Color.RED);
                    }
                    if (aux.equals("7") || aux.equals(" 7")) {
                        LFG.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                //NODO LEJANO
                if (part[i].equals("7") || part[i].equals(" 7")) {
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LEG.setStroke(Color.RED);
                    }

                    if (aux.equals("6") || aux.equals(" 6")) {
                        LFG.setStroke(Color.RED);
                    }
                    aux = part[i];

                }
            }
        } else {
            unique = datos;
            if (datos.equals("1")) {
                LAD.setStroke(Color.RED);
            }
            if (datos.equals("2")) {
                LBD.setStroke(Color.RED);
            }
            if (datos.equals("3")) {
                LCD.setStroke(Color.RED);
            }
            if (datos.equals("5")) {
                LDE.setStroke(Color.RED);
            }
            if (datos.equals("6")) {
                LDF.setStroke(Color.RED);
            }
        }
    }

    public void pintarE(String datos, String[] part, String unique, String aux, String con) {
        if (datos.contains(",")) {  // de vuelve la ruta con mas de un nodo

            part = datos.split(",");
            aux = part[0];              //guarda el nodo inicial

            for (int i = 0; i < part.length; i++) {

                //valida los nodos cercanos
                if (part[i].equals("2") || part[i].equals(" 2")) {
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LBE.setStroke(Color.RED);
                    }
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAB.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LBD.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LBE.setStroke(Color.RED);
                    }

                    aux = part[i];

                }

                if (part[i].equals("4") || part[i].equals(" 4")) {
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LDE.setStroke(Color.RED);
                    }
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAD.setStroke(Color.RED);
                    }
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LBD.setStroke(Color.RED);
                    }
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LCD.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LDE.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LDF.setStroke(Color.RED);
                    }

                    aux = part[i];

                }

                if (part[i].equals("6") || part[i].equals(" 6")) {
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LEF.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LDF.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LEF.setStroke(Color.RED);
                    }
                    if (aux.equals("7") || aux.equals(" 7")) {
                        LFG.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                if (part[i].equals("7") || part[i].equals(" 7")) {
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LEG.setStroke(Color.RED);
                    }

                    if (aux.equals("6") || aux.equals(" 6")) {
                        LFG.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                //valida los nodos lejanos
                if (part[i].equals("1") || part[i].equals(" 1")) {
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LAB.setStroke(Color.RED);
                    }
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LAC.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LAD.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                if (part[i].equals("3") || part[i].equals(" 3")) {
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAC.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LCD.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LCF.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

            }
        } else {
            unique = datos;
            if (datos.equals("2")) {
                LBE.setStroke(Color.RED);
            }
            if (datos.equals("4")) {
                LDE.setStroke(Color.RED);
            }
            if (datos.equals("6")) {
                LEF.setStroke(Color.RED);
            }
            if (datos.equals("7")) {
                LEG.setStroke(Color.RED);
            }
        }
    }

    public void pintarF(String datos, String[] part, String unique, String aux, String con) {
        if (datos.contains(",")) {  // de vuelve la ruta con mas de un nodo

            part = datos.split(",");
            aux = part[0];              //guarda el nodo inicial

            for (int i = 0; i < part.length; i++) {

                //valida los nodos cercanos
                if (part[i].equals("3") || part[i].equals(" 3")) {
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LCF.setStroke(Color.RED);
                    }
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAC.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LCD.setStroke(Color.RED);
                    }

                    if (aux.equals("6") || aux.equals(" 6")) {
                        LCF.setStroke(Color.RED);
                    }

                    aux = part[i];

                }

                if (part[i].equals("4") || part[i].equals(" 4")) {
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LDF.setStroke(Color.RED);
                    }
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAD.setStroke(Color.RED);
                    }
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LBD.setStroke(Color.RED);
                    }
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LCD.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LDE.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LDF.setStroke(Color.RED);
                    }

                    aux = part[i];

                }

                if (part[i].equals("5") || part[i].equals(" 5")) {
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LEF.setStroke(Color.RED);
                    }

                    if (aux.equals("4") || aux.equals(" 4")) {
                        LDE.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LEF.setStroke(Color.RED);
                    }

                    if (aux.equals("7") || aux.equals(" 7")) {
                        LEG.setStroke(Color.RED);
                    }

                    aux = part[i];

                }

                if (part[i].equals("7") || part[i].equals(" 7")) {
                    if (aux.equals("7") || aux.equals(" 7")) {
                        LEG.setStroke(Color.RED);
                    }

                    if (aux.equals("5") || aux.equals(" 5")) {
                        LEG.setStroke(Color.RED);
                    }

                    if (aux.equals("6") || aux.equals(" 6")) {
                        LFG.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                //valida los nodos lejanos
                if (part[i].equals("1") || part[i].equals(" 1")) {
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LAB.setStroke(Color.RED);
                    }
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LAC.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LAD.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                if (part[i].equals("2") || part[i].equals(" 2")) {
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAB.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LBD.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LBE.setStroke(Color.RED);
                    }
                    aux = part[i];
                }

            }
        } else {
            unique = datos;
            if (datos.equals("3")) {
                LCF.setStroke(Color.RED);
            }
            if (datos.equals("4")) {
                LDF.setStroke(Color.RED);
            }
            if (datos.equals("5")) {
                LEF.setStroke(Color.RED);
            }
            if (datos.equals("7")) {
                LFG.setStroke(Color.RED);
            }
        }
    }

    public void pintarG(String datos, String[] part, String unique, String aux, String con) {
        if (datos.contains(",")) {  // de vuelve la ruta con mas de un nodo

            part = datos.split(",");
            aux = part[0];              //guarda el nodo inicial

            for (int i = 0; i < part.length; i++) {
                System.out.println("Split: " + part[i]);
                if (part[i].equals("5") || part[i].equals(" 5")) {
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LEG.setStroke(Color.RED);
                    }

                    if (aux.equals("4") || aux.equals(" 4")) {
                        LDE.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LEF.setStroke(Color.RED);
                    }

                    if (aux.equals("7") || aux.equals(" 7")) {
                        LEG.setStroke(Color.RED);
                    }

                    aux = part[i];

                }

                if (part[i].equals("6") || part[i].equals(" 6")) {
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LFG.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LDF.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LEF.setStroke(Color.RED);
                    }
                    if (aux.equals("7") || aux.equals(" 7")) {
                        LFG.setStroke(Color.RED);
                    }

                    aux = part[i];

                }

                //VALIDAR NODOS LEJANOS
                if (part[i].equals("4") || part[i].equals(" 4")) {
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAD.setStroke(Color.RED);
                    }
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LBD.setStroke(Color.RED);
                    }
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LCD.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LDE.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LDF.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                if (part[i].equals("2") || part[i].equals(" 2")) {
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAB.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 5")) {
                        LBD.setStroke(Color.RED);
                    }
                    if (aux.equals("5") || aux.equals(" 5")) {
                        LBE.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                if (part[i].equals("1") || part[i].equals(" 1")) {
                    if (aux.equals("2") || aux.equals(" 2")) {
                        LAB.setStroke(Color.RED);
                    }
                    if (aux.equals("3") || aux.equals(" 3")) {
                        LAC.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LAD.setStroke(Color.RED);
                    }
                    aux = part[i];

                }

                if (part[i].equals("3") || part[i].equals(" 3")) {
                    if (aux.equals("1") || aux.equals(" 1")) {
                        LAC.setStroke(Color.RED);
                    }
                    if (aux.equals("6") || aux.equals(" 6")) {
                        LCF.setStroke(Color.RED);
                    }
                    if (aux.equals("4") || aux.equals(" 4")) {
                        LCD.setStroke(Color.RED);
                    }
                    aux = part[i];

                }
            }
        } else {
            unique = datos;
            if (datos.equals("5")) {
                LEG.setStroke(Color.RED);
            }
            if (datos.equals("6")) {
                LFG.setStroke(Color.RED);
            }
        }
    }

    public void deleteNodo(javafx.event.ActionEvent actionEvent) {
        String nodeEliminar = nod.getText();
        if (nodeEliminar.equals("1")) {
            CA.setVisible(false);
            LAB.setVisible(false);
            LAD.setVisible(false);
            LAC.setVisible(false);

            AB.setText("999999999");
            AD.setText("999999999");
            AC.setText("999999999");

            AB.setVisible(false);
            AD.setVisible(false);
            AC.setVisible(false);
        }

        if (nodeEliminar.equals("2")) {
            CB.setVisible(false);
            LBD.setVisible(false);
            LBE.setVisible(false);
            LAB.setVisible(false);

            AB.setText("999999999");
            BE.setText("999999999");
            BD.setText("999999999");

            AB.setVisible(false);
            BE.setVisible(false);
            BD.setVisible(false);
        }

        if (nodeEliminar.equals("3")) {
            CC.setVisible(false);
            LAC.setVisible(false);
            LCD.setVisible(false);
            LCF.setVisible(false);

            AC.setText("999999999");
            CD.setText("999999999");
            CF.setText("999999999");

            AC.setVisible(false);
            CD.setVisible(false);
            CF.setVisible(false);
        }

        if (nodeEliminar.equals("4")) {
            CCD.setVisible(false);
            LAD.setVisible(false);
            LBD.setVisible(false);
            LCD.setVisible(false);
            LDE.setVisible(false);
            LDF.setVisible(false);

            AD.setText("999999999");
            CD.setText("999999999");
            BD.setText("999999999");
            DE.setText("999999999");
            DF.setText("999999999");

            AD.setVisible(false);
            CD.setVisible(false);
            BD.setVisible(false);
            DE.setVisible(false);
            DF.setVisible(false);
        }

        if (nodeEliminar.equals("5")) {
            CE.setVisible(false);
            LDE.setVisible(false);
            LEF.setVisible(false);
            LEG.setVisible(false);
            LBE.setVisible(false);

            DE.setText("999999999");
            EF.setText("999999999");
            EG.setText("999999999");
            BE.setText("999999999");

            DE.setVisible(false);
            EF.setVisible(false);
            EG.setVisible(false);
            BE.setVisible(false);
        }

        if (nodeEliminar.equals("6")) {
            CCF.setVisible(false);
            LCF.setVisible(false);
            LDF.setVisible(false);
            LEF.setVisible(false);
            LEG.setVisible(false);
            LFG.setVisible(false);

            CF.setText("999999999");
            DF.setText("999999999");
            EF.setText("999999999");
            FG.setText("999999999");

            CF.setVisible(false);
            DF.setVisible(false);
            EF.setVisible(false);
            FG.setVisible(false);
        }
        if (nodeEliminar.equals("7")) {
            CG.setVisible(false);
            LEG.setVisible(false);
            LFG.setVisible(false);

            FG.setText("999999999");
            EG.setText("999999999");

            EF.setVisible(false);
            EG.setVisible(false);
        }
        rePaint();
    }

    public void reiniciar(javafx.event.ActionEvent actionEvent) {
        AB.setText("");             AB.setVisible(true);
        AC.setText("");             AC.setVisible(true);
        AD.setText("");             AD.setVisible(true);
        BE.setText("");             BE.setVisible(true);
        BD.setText("");             BD.setVisible(true);
        CF.setText("");             CF.setVisible(true);
        CD.setText("");             CD.setVisible(true);
        DE.setText("");             DE.setVisible(true);
        DF.setText("");             DF.setVisible(true);
        EG.setText("");             EG.setVisible(true);
        EF.setText("");             EF.setVisible(true);
        FG.setText("");             FG.setVisible(true);

        CA.setVisible(true);    CB.setVisible(true);
        CC.setVisible(true);    CCD.setVisible(true);
        CCF.setVisible(true);   CE.setVisible(true);
        CG.setVisible(true);

        LAB.setVisible(true);   LAD.setVisible(true);
        LAC.setVisible(true);   LBD.setVisible(true);
        LBE.setVisible(true);   LDE.setVisible(true);
        LDF.setVisible(true);   LCD.setVisible(true);
        LCF.setVisible(true);   LEF.setVisible(true);
        LEG.setVisible(true);   LFG.setVisible(true);

        rePaint();


    }



    public  void pintarMAtriz(long matriz[][]){
        System.out.println("Matriz Adyacencia");
        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
               System.out.print("["+matriz[x][y]+"]"+" ");
            }
            System.out.print("\n");
        }
    }

}

