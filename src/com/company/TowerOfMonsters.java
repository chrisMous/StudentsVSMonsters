package com.company;

import java.io.FileReader;
import java.util.Scanner;

/*
 *The TowerOfMonsters class is the class where the game runs in its main method
 */
public class TowerOfMonsters {
    Scanner scanner;

    //the constructor takes a filename and initialises the scanner declared above
    //with the use of the FileReader library the scanner reads the file
    //an Exception is thrown if the file given cannot be found
    public TowerOfMonsters(String filename) {
        try {
            this.scanner = new Scanner(new FileReader(filename));
        } catch (java.io.FileNotFoundException e) {
            System.out.println("The FileNotFoundException was caught");
        }
    }

    //this method is used to create the TowerOfMonsters game
    public void play() throws Exception {
        //the guild is initialised
        Guild students = new Guild();

        //the guild members are initialised as well
        Student  vrishin = new EEPStudent("Vrishin");
        Student louis = new EEWCStudent("Louis");
        Student chris = new CSStudent("Chris");
        Student stavris = new SEStudent("Stavris");
        Student ben = new EEAIStudent("Ben");
        Student achala = new EEMCSStudent("Achala");
        Student joe = new AIStudent("Joe");
        Student mike = new CyberStudent("Mike");
        Student renos = new EECSystemsStudent("Renos");
        Student silver = new EENanoStudent("Silver");


        //guild members are added to the guild
        students.addMember(vrishin);
        students.addMember(louis);
        students.addMember(chris);
        students.addMember(stavris);
        students.addMember(ben);
        students.addMember(achala);
        students.addMember(joe);
        students.addMember(mike);
        students.addMember(renos);
        students.addMember(silver);

        //the scanner uses a delimiter ";" to specify the boundary that it wants to read
        //it reads the values in the text file given after and between semicolons
        scanner.useDelimiter(";");

        int counter = 0;

        //while the scanner has a line to read the code is executed
        while (scanner.hasNext()) {
            try {

                //the game is slowed by half a second between floors
                Thread.sleep(500);

            Team monsterTeam = new MonsterTeam("monsterTeam");

            //the scanner reads the next line
            scanner.nextLine();

            counter++;

            System.out.println("/////////////////////////////////");
            System.out.println("Floor " + counter);
            System.out.println("/////////////////////////////////");

            //the code is looped 5 times because you can have only 5 members per team
            for (int i = 0; i < 5; i++) {

                //this variable stores the text of the line
                String monsterFullString = scanner.next();

                //the following 3 variables store the values we need to create a monster object name,type and level
                String name = monsterFullString.split("\\(")[0];
                String type = monsterFullString.substring(monsterFullString.indexOf("(") + 1, monsterFullString.indexOf(","));
                int lvl = Integer.parseInt(monsterFullString.substring(monsterFullString.indexOf(",") + 1, monsterFullString.indexOf(")")));

                //if the type is equal to Minion then a Minion object is created
                //if the type is equal to a Boss then a Boss object is created
                if (type.equals("Minion")) {
                    Character monster = new Minion(name, lvl);
                    monsterTeam.addMember(monster);
                } else if (type.equals("Boss")) {
                    Character monster = new Boss(name, lvl);
                    monsterTeam.addMember(monster);
                }

            }

            //the student team is assigned according to the monster team's members
            Team studentTeam = students.getTeam(monsterTeam);

            Battle battle = new Battle(studentTeam, monsterTeam);

            //If the monster team ends up winning the floor fight then reinforcements are sent from the student team
            //and they fight again
            if(battle.fight().equals(monsterTeam)){
                System.out.println("Reinforcements from the guild arrive!");
                studentTeam = students.getReinforcements();
                battle = new Battle(studentTeam, monsterTeam);
            battle.fight();

            //if the student team doesn't have members left after reinforcements it's Game Over;
                if(studentTeam.getMembers().length == 0) {
                    System.out.println("GAME OVER!");
                    return;
                }
                }


        } catch (InterruptedException e) {
                throw new Exception(e);
            }
        }
        System.out.println("The Student Team has reached the rooftop and planted its Flag!");

    }

    //Main method that runs the game
        public static void main (String[] args) throws Exception {

            //the Tower of Monsters Object takes the value from args[0] for the filename
            //that value is the filename typed in the command line
            TowerOfMonsters towerOfMonsters = new TowerOfMonsters("Monsters.txt");

            //the play method is called to run the game
            towerOfMonsters.play();

        }
    }

