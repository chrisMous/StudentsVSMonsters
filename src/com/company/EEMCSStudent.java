package com.company;
/*
 *The EEMCSStudent class is a subclass of the Student class
 *It assigns the base stats of an EE with Mobile and Secure Systems Student and implements his special abilities;
 */
public class EEMCSStudent extends Student {
    public EEMCSStudent(String name) {
        super(name, 9, 8, 5, 5, 4);
    }

    //the EEMCS Student reduces the base attack of all enemies in the enemy Team
    public void securityBreach(Team enemyTeam) throws Exception {

        //It checks if the student has Max KP
        if (getCurrentKP() == getMaxKP()) {
            currentKP = 0;
            increaseEP(2);

            for (Character enemy : enemyTeam.getMembers()) {
               enemy.baseAtk = enemy.baseAtk - 1;
            }
        } else {
            throw new Exception("Special ability can be used when KP is maximum");
        }
    }

    //the EEMCS Student increases the EP of an ally drastically but reduces his current HP by the formula (currentHP/2)
    public void dataBoost(Character friend) throws Exception {

        //It checks if the student has Max KP
        if (getCurrentKP() == getMaxKP()) {
            currentKP = 0;
            increaseEP(2);

            friend.increaseEP(30);
            decreaseHP(getHP()/2);

        } else {
            throw new Exception("Special ability can be used when KP is maximum");
        }
    }

}
