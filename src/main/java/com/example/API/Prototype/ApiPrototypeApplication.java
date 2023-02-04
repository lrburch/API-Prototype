package com.example.API.Prototype;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApiPrototypeApplication {

    public static void main(String[] args) {

        dogFact();
        catFact();
        Menu();

    }

    public static void dogFact() {
       
        RestTemplate restTemplateDog = new RestTemplate();
        String urlDog = "https://dog-api.kinduff.com/api/facts";
        ResponseEntity<String> responseDog = restTemplateDog.getForEntity(urlDog, String.class);
        System.out.println("\n*************************************************************************************************************************\n");
        System.out.println(responseDog.getBody().substring(11, responseDog.getBody().length() - 18).replaceAll("\\. \\s?", "\\.\n"));
        System.out.println("\n*************************************************************************************************************************\n");

    }

    public static void catFact() {
      
        RestTemplate restTemplateCat = new RestTemplate();
        String urlCat = "https://meowfacts.herokuapp.com/?count=1";
        ResponseEntity<String> responseCat = restTemplateCat.getForEntity(urlCat, String.class);
        System.out.println("\n*************************************************************************************************************************\n");
        System.out.println(responseCat.getBody().substring(10, responseCat.getBody().length() - 3).replaceAll("\\. \\s?", "\\.\n"));
        System.out.println("\n*************************************************************************************************************************\n");

    }

    public static void Menu() {

        Scanner in = new Scanner(System.in);
        boolean stop = false;
        int choice = 0;
        
        do {
            System.out.println("\n*************************************************************************************************************************\n");
            System.out.println("\n\nWould you like another fact?\n");
            System.out.println("1. Dog Fact\n2. Cat Fact\n0. Quit");
            System.out.print("Enter choice: ");
            choice = in.nextInt();
            System.out.println("\n*************************************************************************************************************************\n");

            if (choice == 1) {
                dogFact();
            }
            if (choice == 2) {
                catFact();
            }

        } while (choice != 0);
    }

}
