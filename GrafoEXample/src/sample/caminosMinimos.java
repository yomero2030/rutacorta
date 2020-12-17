package sample;

public class caminosMinimos {
    //metodo para determinar todos los caminos
    public String algoritmoDjisktra(long[][] matriz, String condicion) {
        int vertices = matriz.length;

        long matrizAdyacencia[][] = matriz;

        String caminos[][] = new String[vertices][vertices];
        String caminosAux[][] = new String[vertices][vertices];

        String caminoRecorrido = "", cadena = "", camino = "";
        int i, j, k;
        float temporal1, temporal2, temporal3, temporal4, minimo;

        String resul = "";

        //inicializar matrices de caminos
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                caminos[i][j] = "";
                caminosAux[i][j] = "";
            }
        }

        for (k = 0; k < vertices; k++) {
            for (i = 0; i < vertices; i++) {
                for (j = 0; j < vertices; j++) {
                    temporal1 = matrizAdyacencia[i][j];
                    temporal2 = matrizAdyacencia[i][k];
                    temporal3 = matrizAdyacencia[k][j];
                    temporal4 = temporal2 + temporal3;

                    //encontrar al minimo
                    minimo = Math.min(temporal1, temporal4);
                    if (temporal1 != temporal4) {
                        if (minimo == temporal4) {
                            caminoRecorrido = "";
                            caminosAux[i][j] = k + "";
                            caminos[i][j] = caminoR(i, k, caminosAux, caminoRecorrido) + (k + 1);
                        }
                    }

                    matrizAdyacencia[i][j] = (long) minimo;
                }
            }
        }

        ///Agregando el camino minimo a cadena
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                cadena = cadena + "[" + matrizAdyacencia[i][j] + "]";
            }
            cadena = cadena + "\n";
        }

        ////////////////////////////
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                if (matrizAdyacencia[i][j] != 100000000) {
                    if (i != j) {        //si estan en el mismo indice, indica que estan en la misma arista
                        if (caminos[i][j].equals("")) {
                            String con = (i + 1) + "a" + (j + 1);
                            if(con.equals(condicion)){
                                camino = String.valueOf((j+1));
                            }
                        } else {
                            String con = (i + 1) + "a" + (j + 1);
                            if(con.equals(condicion)){
                                camino = (caminos[i][j]) + "," + (j + 1);
                            }
                        }
                    }
                }
            }
        }

        //" + (i + 1) + ",
        //" + (i + 1) + ",

        return camino;
        //"La matriz de caminos más cortos entre los diferentes vertices es: \n" + cadena + "\n Los diferentes caminos mas cortos entre vertices son: " +
    }


    public String caminoR(int i , int k, String[][] matrizAuxiliar, String caminoRecorrido){

        if(matrizAuxiliar[i][k].equals("")){
            return "";
        }else{
            //recursividad al millón
            caminoRecorrido += caminoR(i, Integer.parseInt(matrizAuxiliar[i][k].toString()), matrizAuxiliar, caminoRecorrido) + (Integer.parseInt(matrizAuxiliar[i][k].toString())+1) + ", ";
            return caminoRecorrido;
        }

    }
}
