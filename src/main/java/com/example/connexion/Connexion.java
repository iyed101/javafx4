package com.example.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static String login = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost:3306/demojdbc2";
    private static Connection cn;

    static {
        try {
            // Étape 1 : Charger le driver de la base de données cible
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Étape 2 : Authentification auprès de la base de données et sélectionner le schéma
            cn = DriverManager.getConnection(url, login, password);
            System.out.println("Connexion établie avec succès !");
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion");
            ex.printStackTrace(); // Affiche les détails de l'exception
        }
    }

    public static Connection getCn() {
        return cn;
    }
}
