package com.company;

/*
 *The SEStudent class is a subclass of the Student class
 *It assigns the base stats of an SEStudent and implements its 2 special abilities
 */
public class SEStudent extends Student{
    public SEStudent(String name) {
        super(name,8,5,8,4,10);
    }

    //the special move groupWork attacks an enemy with all of the alive members of the SEStudent's team
    public void groupWork(Character enemy)throws Exception{

        //It checks if the student has Max KP
        if (getCurrentKP() == getMaxKP()) {
            increaseEP(4);
            for (Character character : getTeam().getMembers()) {

                if(!character.isDead()) {
                    ((Student)character).javaProgramming(enemy);
                }

                //if the enemy dies the student gets 4 EP
                if (enemy.isDead()) {
                    increaseEP(4);
                }
            }
            currentKP = 0;
        }
        else {
            throw new Exception("Special ability can be used when KP is maximum");
        }
    }

    //the special move groupDiscussion heals all of the alive members in the SEStudent's team
    //if it tries to heal a dead ally it throws an Exception
    public void groupDiscussion() throws Exception{

        //It checks if the student has Max KP
        if (getCurrentKP() == getMaxKP()) {
            increaseEP(4);
            for (Character character : getTeam().getMembers()) {

                try{
                    if (!character.isDead()) {
                        character.increaseHP((int) (getDefence() / 2));
                    character.increaseEP(0);
                    ((Student) character).increaseKP(0);
                    }

                } catch(Exception ex){
                    throw new Exception("The character is dead, so he cannot be healed");
                }
            }
        }
        else {
            throw new Exception("Special ability can be used when KP is maximum");
        }
    }

}
