package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 *The Team class stores the characters into an ArrayList and deals with the Team's operations
 *these operations include the accessing, adding and removal of members of the Team
 * This method has 2 subclasses StudentTeam and MonsterTeam
 */
public abstract class Team {
    String name;

    //this array list stores the members of a team
    ArrayList<Character> members = new ArrayList();

    ArrayList<Character> neutralTeam = new ArrayList<>();

    //this Array list stores the dead monsters
    ArrayList<Character> deadMonsters = new ArrayList();

    //The constructor makes sure that when a team is instantiated it gets given a name
    public Team(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    //this method accesses the members of a team using the ArrayList's function toArray
    public Character[] getMembers(){
       return members.toArray(new Character[0]);
    }
    public Character[] getNeutral(){
        return neutralTeam.toArray(new Character[0]);
    }

    public Character[] getNeutralTeam(){
        return neutralTeam.toArray(new Character[0]);
    }

    //this method adds the members to their team
    //it also makes sure that a member cannot be added more than once the team and the members cannot exceed 5
    //it returns the size of the team (amount of members)
    public int addMember(Character member){
        if(members.contains(member)){
            return -1;
        }
        else if(members.size() == 5){
            return -2;
        }
        else{
            members.add(member);
        }
        return members.size();
    }


    public void removeMember(Character member){
        members.remove(member);
    }

    //this method is the same with addMember but adds a dead monster instead
    public int addDeadMonster(Character monster){
        if(deadMonsters.contains(monster)){
            return -1;
        }
        else if(deadMonsters.size() == 5){
            return -2;
        }
        else{
            deadMonsters.add(monster);
        }
        return deadMonsters.size();
    }
    //same as getMembers but with dead monsters instead
    public Character[] getDeadMonsters(){
        return deadMonsters.toArray(new Character[0]);
    }

    //This method sorts the members of a speed by speed using a comparator to compare their speeds and sort them
    //it sorts them in descending order
    public void sortBySpeed(){
        Comparator<Character> characterComparator = Comparator.comparingInt(Character::getSpeed);
        neutralTeam.sort(Collections.reverseOrder(characterComparator));
    }
    public void oneTeam(Team team){
        neutralTeam.addAll(team.members);
    }

    //this method is only used by the Boss to revive the dead Monsters and put them back to his team
    public void revive(){
        members.addAll(deadMonsters);
      deadMonsters.removeAll(deadMonsters);
    }

    //The move method is included in the Team's subclasses StudentTeam and MonsterTeam so it's abstract
   abstract void move(Character member, Team enemyTeam) throws Exception;
}
