package modele;

import java.util.Map;
import java.util.Set;
import org.javatuples.Pair;

public class Graphe {
    private String nomF;
    private Map<Integer, Set<Integer>> voisins;



    public Graphe(String parNomF,Map parVoisins){
        nomF = parNomF;
        voisins = parVoisins;

    }


    public int ordre(){
        return voisins.size();
    }


    public int degree(int sommet){
        return voisins.get(sommet).size();

    }
    public int taille() {
        int cpt = 0;
        for (int sommet:voisins.keySet()){
            cpt+= voisins.get(sommet).size();
        }
        return cpt;
    }

    public int[] degreMinDegreMax() {
        int premierSommet = voisins.keySet().iterator().next();
        int min = degree(premierSommet);
        int max = degree(premierSommet);

        for (int sommet : voisins.keySet()) {
            int deg = degree(sommet);
            if (deg < min) min = deg;
            if (deg > max) max = deg;
        }

        return new int[]{min, max};
    }




    public String toString() {
        String resultat = "Fichier " + nomF + "\n";
        resultat += "Ordre " + ordre() + " - Taille " + taille() + "\n";

        for (int i = 0; i <= this.ordre() - 1; i++) {
            resultat += "* sommet " + i + " - degré " + degree(i) + ", voisins : " + voisins.get(i) + "\n";
        }
        return resultat;
    }
}
