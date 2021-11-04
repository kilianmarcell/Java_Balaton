package hu.petrik.balaton;

public class Main {

    public static void main(String[] args) {
        Balaton b = new Balaton();
        System.out.println(b);
        System.out.println("Déli parton a legmelegebb hőmérséklet: " + b.deliPartMaxHomerseklet());
    }
}
