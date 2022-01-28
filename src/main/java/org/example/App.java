package org.example;

import org.example.servis.ServisImpl;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ServisImpl servis = new ServisImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            instructions();
            int commandNum = scanner.nextInt();
            if (commandNum == 1) {
                servis.createPeopleTable();
            } else if (commandNum == 2) {
                servis.savePeople("Aza", "Asanov", 18);
                servis.savePeople("Daisy", "Aliev", 27);
                servis.savePeople("Aza", "Usonov", 23);
                servis.savePeople("Aza", "Bekenov", 30);
                servis.savePeople("Beka", "Bekturov", 17);
            } else if (commandNum == 3) {
                System.out.println(servis.getAllPeople());
            } else if (commandNum == 4) {
                System.out.println(servis.getPeopleWithNameAndAge(20, "Aza"));
            } else if (commandNum == 5) {
                servis.updatePeople();
            } else if (commandNum == 6) {
                servis.removePeopleByName("Aza");
            } else {
                System.out.println("Wrong enter, you have only 6 commands!");
            }
        }
    }

    public static void instructions() {
        System.out.println("=========== Commands ===========");
        System.out.println("Press 1 to create table");
        System.out.println("Press 2 to add users to database");
        System.out.println("Press 3 to get all people ");
        System.out.println("Press 4 to get all Azas who are above 20");
        System.out.println("Press 5 to change Azas' ages to 18");
        System.out.println("Press 6 to delete all people whose names are Aza");
        System.out.println("=================================");
    }
}