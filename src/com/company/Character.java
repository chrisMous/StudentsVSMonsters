package com.company;
import static java.lang.Math.*;

/*
 * The Character class determines the basic attributes of the characters, which are: name,hp,attack,defence,speed,level and EP
 * Methods included in this class adjust these attributes throughout the game
 * This class also assigns the character to his Team
 */
public class Character {
    protected String charName;
    protected int baseHP;
    protected int baseAtk;
    protected int baseDef;
    protected int baseSpd;
    protected int level = 1;
    protected int currentHP ;
    protected int currentEP = 0;

 //this boolean value stores the character's status (if alive then it's false)
    protected boolean isDead = false;

    public Character(String name, int baseHP, int baseAtk, int baseDef, int baseSpd) {
        charName = name;
        this.baseHP = baseHP;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpd = baseSpd;
    }

    public boolean isDead(){
        return isDead;
    }
    public String getName(){
        return charName;
    }

    //The methods getMaxHP,getAttack,getDefence and getSpeed calculate these attributes
    //using the formula Round(baseAtt * (level^1.2))

    public int getMaxHP() {
        float lvl = (float) Math.pow(level, 1.2);
        return round(baseHP * (lvl));
    }

    public float getAttack() {
        float atk = (float) Math.pow(level, 1.2);
        return (float) round(baseAtk * (atk));
    }

    public float getDefence() {
        float def = (float) Math.pow(level, 1.2);
        return (float) round(baseDef * (def));
    }

    public int getSpeed() {
        float spd = (float) Math.pow(level, 1.2);
        return  round(baseSpd * (spd));
    }

    //The method getTargetEP calculates the required EP to level up
    //using the formula Round(10 * (level^1.5))
    public float getTargetEP() {
        float xp = (float) Math.pow(level, 1.5);
        return (float) round(10 * xp);
    }

    //This method returns the currentHP of the character
    //if the hp of the player is 0 and he's not dead he has max HP
    //if he's dead then his hp is 0
    public int getHP() {
        if(currentHP == 0 && !isDead()){
             currentHP = getMaxHP();
        }
        else if(currentHP == 0 && isDead()){
            currentHP = 0;
        }
        return currentHP;
    }

    public int getEP() {
        return currentEP;
    }

    //This method increases the character's HP using a given amount
    //If his hp after the increase is 0 or below 0 then he's dead and his hp is set to zero
    //If his hp after the increase is more than the max value the character is not allowed to exceed the max HP
    public int increaseHP(int amount) {
        currentHP += amount;
        if (currentHP <= 0 ) {
            isDead = true;
            return currentHP = 0 ;

        } else if (currentHP > getMaxHP()) {
            return currentHP = getMaxHP();
        }
        return currentHP;
    }

    //This method decreases the character's HP using a given amount
    //If his hp after the decrease is more than the max value the character is not allowed to exceed the max HP
    //If his hp after the decrease is 0 or below 0 then he's dead and his hp is set to zero
    public int decreaseHP(int amount) {
        currentHP -= amount;

        if (currentHP > getMaxHP()) {
            return currentHP = getMaxHP();
        }
        else if (currentHP <= 0 ) {
            isDead = true;
            return currentHP = 0;
        }
            return currentHP;
    }

    //This method increases the character's EP using a given amount
    //If the character's EP after the increase is more or equal to the targetEP he levels up and his hp is set to the max HP
    //Also his EP is set to 0
    public int increaseEP(int amount) {
        currentEP += amount;
        if (getEP() >= getTargetEP()) {
            level++;
            System.out.println(getName() + " has leveled up! " + getName() + " is now level " + level);
            currentHP = getMaxHP();
            return currentEP = 0;
        }
        return currentEP;
    }

    protected Team team;

    //This method sets the players team and the variable above stores the team
    public void setTeam(Team team) {
      this.team = team;
    }

    public Team getTeam() {
        return this.team;
    }

}
