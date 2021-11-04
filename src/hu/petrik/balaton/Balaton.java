package hu.petrik.balaton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Balaton {

    private int sorokSzama;
    private int oszlopokSzama;
    private int[][] matrix;

    public Balaton() {

        Inicializalas();
        Beolvas();

    }

    private void Inicializalas() {

        try {

            BufferedReader b = new BufferedReader(new FileReader("balaton.txt"));

            String sor = b.readLine();
            this.sorokSzama = 0;
            this.oszlopokSzama = sor.split("\t", -1).length;

            while (sor != null) {

                this.sorokSzama++;
                sor = b.readLine();

            }

            this.matrix = new int[this.sorokSzama][this.oszlopokSzama];

            b.close();

        } catch (IOException e) {

            e.getMessage();

        }

    }

    private void Beolvas() {

        try {

            BufferedReader b = new BufferedReader(new FileReader("balaton.txt"));

            String sor = b.readLine();
            int sorIndex = 0;

            while (sor != null) {

                String[] s = sor.split("\t");

                for (int i = 0; i < s.length; i++) {

                    if (s[i].equals("")) {

                        matrix[sorIndex][i] = 0;

                    } else {

                        matrix[sorIndex][i] = Integer.parseInt(s[i]);

                    }

                }

                sorIndex++;
                sor = b.readLine();

            }

            b.close();

        } catch (IOException e) {

            e.getMessage();

        }

    }

    public int deliPartMaxHomerseklet() {
        int sor = 0;
        for (int i = this.sorokSzama - 1; i > 0; i--) {
            for (int j = this.oszlopokSzama - 1; j > 0; j--) {
                if (matrix[i][j] != 0) {
                    sor = i;
                    i = 0;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < this.oszlopokSzama; i++) {
            if (matrix[sor][i] >= max) {
                max = matrix[sor][i];
            }
        }
        return max;
    }

    @Override
    public String toString() {
        String s = "";

        for (int i = 0; i < this.sorokSzama; i++) {

            for (int j = 0; j < this.oszlopokSzama; j++) {

                if (this.matrix[i][j] == 0) {

                    s += " " + this.matrix[i][j] + " ";

                } else {

                    s += this.matrix[i][j] + " ";

                }

            }

            s += "\n";

        }
        
        return s;
    }
}
