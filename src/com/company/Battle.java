package com.company;

/*
 *The Battle class simulates a floor of the Tower of Monsters
 *It stores the two teams that the constructor uses to make these teams fight each other with the fight() method
 */
public class Battle{
    Team studentTeam;
    Team monsterTeam;

    public Battle(Team studentTeam, Team monsterTeam) {
        this.studentTeam = studentTeam;
        this.monsterTeam = monsterTeam;
    }
//te fight method returns the Team that wins the floor
    public Team fight() throws Exception {
        //it stores the reference that team in this variable and returns it in the end
        Team winners = null;

        //a floor can only last for 30 rounds
        for (int RoundCounter = 1; RoundCounter < 31; RoundCounter++) {

            Team neutralTeam = new StudentTeam("neutral");

            //both of the teams are sorted by speed with the sortBySpeed method
            neutralTeam.sortBySpeed();


                //if the length of the monsterTeam is 0 then the students have killed all of its members and proceeded to the next floor
                if (monsterTeam.getMembers().length == 0) {
                    System.out.println("The Student Team is moving to the next floor!");
                    winners = studentTeam;
                    return winners;
                }
                //likewise if the length of the studentTeam is 0 then the monsters won
                else if (studentTeam.getMembers().length == 0) {
                    System.out.println("The Monsters have annihilated the Students!");
                    winners = monsterTeam;
                    return winners;
                }
                //if this floor's battle reaches round 30 then there's no winner
                else if (RoundCounter == 30) {
                    System.out.println("It's a Draw!");
                    winners = null;
                    return winners;
                }

                System.out.println("------------------------------");
                System.out.println("Round " + RoundCounter + " FIGHT!");
                System.out.println("------------------------------");


                //the student team gets to move first
            for (Character student : studentTeam.getMembers()) {
                studentTeam.move(student, monsterTeam);
            }

            for (Character monster : monsterTeam.getMembers()) {
                monsterTeam.move(monster, studentTeam);
            }
                //if you want to make the game increasingly harder then you have the monster team move first
                // by reversing the order these loops are implemented in this method

            System.out.println("------------------------");
            System.out.println("STUDENT STATUS REPORT");
            System.out.println("------------------------");

            for(Character student : studentTeam.getMembers()){

                System.out.println(student.getName() + ":");
                System.out.print("HP: " + student.getHP());
                System.out.print("| Speed: " + student.getSpeed());
                System.out.print("| Attack: " + student.getAttack());
                System.out.print("| Defence: " + student.getDefence());
                System.out.print("| KP: " + ((Student)student).getCurrentKP() + "\n" );

            }
            System.out.println("------------------------------------------------------");
        }

        return winners;
    }

}














