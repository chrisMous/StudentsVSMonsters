package com.company;

import java.util.ArrayList;
import java.util.Collection;

/*
 *The Guild class is used to store the students before they are assigned to their team
 *It uses its methods to assign each member to a team and determines how a team is formed
 *When the Guild cannot send any more members then the Students loose
 */
public class Guild{
    Collection<Character> guildMembers = new ArrayList<>();

    StudentTeam studentTeam = new StudentTeam("Students");

    //this boolean value stores whether the first team was chosen in th get Team method (false when not)
    boolean team1 = false;

    //this method adds the guild members to the guild
    //it also makes sure that a member cannot be added more than once the team and the members cannot exceed 10
    //it also returns the size of the guild
    public int addMember(Character guildMember) {
        if(guildMembers.contains(guildMember)){
            return -1;
        }
        else if(guildMembers.size() > 10){
            return -2;
        }
        else{
            guildMembers.add(guildMember);
        }
        return guildMembers.size();
    }

    public Collection<Character> getMembers() {
        return guildMembers;
    }

//this method is used to send a Team out to battle
//If a Boss exists in the enemy Team then the first 5 members are chosen (most likely the most important ones)
//Otherwise the players are chosen with an increment of 2 but with the 8th player added ass well to form a complete 5 man team
    public Team getTeam(Team enemyTeam) {
        Character[] students = getMembers().toArray(new Character[0]);
        for (Character enemy : enemyTeam.getMembers()) {

            if (!enemy.getName().equals("Boss")) {
                for (int i = 0; i < 5; i++) {
                    studentTeam.addMember(students[i]);
                    students[i].setTeam(studentTeam);
                    team1 = true;
                }
            }

            else {
                for (int i = 5; i < 10; i++) {
                    studentTeam.addMember(students[i]);
                    students[i].setTeam(studentTeam);
                    team1 = false;
                }
                studentTeam.addMember(students[7]);
                students[7].setTeam(studentTeam);
            }

        }
        return studentTeam;

    }
//this method sends reinforcements after the first team members perish
//the team1 boolean value determines the remaining players that are sent out
    public Team getReinforcements() {
        Character[] students = getMembers().toArray(new Character[0]);

        if (team1 = true) {
            for (int i = 5; i < 10; i++) {
                studentTeam.addMember(students[i]);
                students[i].setTeam(studentTeam);
            }
        }
        else{
            for (int i = 0; i < 5; i++) {
                studentTeam.addMember(students[i]);
                students[i].setTeam(studentTeam);
            }
    }
        return studentTeam;

    }
}
