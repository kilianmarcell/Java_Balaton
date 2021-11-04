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

    }

    private void Inicializalas() {

        try {

            BufferedReader b = new BufferedReader(new FileReader("balaton.txt"));

            String sor = b.readLine();
            this.sorokSzama = 0;
            this.oszlopokSzama = sor.split("\t").length;

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
                    }
                    matrix[sorIndex][i] = Integer.parseInt(s[i]);

                }

                sorIndex++;
                sor = b.readLine();
                this.sorokSzama++;
                b.close();

            }

            this.matrix = new int[this.sorokSzama][this.oszlopokSzama];

        } catch (IOException e) {

            e.getMessage();

        }

    }

    @Override
    public String toString() {
        return "Balaton{" +
                "sorokSzama=" + sorokSzama +
                ", oszlopokSzama=" + oszlopokSzama +
                ", matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
