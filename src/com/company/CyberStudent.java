package com.company;
/*
 *The CyberStudent class is a subclass of the Student class
 *It assigns the base stats of a CyberStudent and implements its special ability
 */
public class CyberStudent extends  Student {
    public CyberStudent(String name) {
        super(name,7,7,5,6,6);
    }

    //the special ability cyberAttack damages all of the enemyTeam members with the basic attack formula
    public Team cyberAttack(Team enemyTeam) throws Exception {

        //It checks if the student has Max KP
        if (getCurrentKP() == getMaxKP()) {
            increaseEP(4);
            currentKP = 0;

            for (Character enemy : enemyTeam.getMembers()) {
                enemy.decreaseHP((int) ((100 * getAttack()) / (100 + enemy.getDefence())));
                enemy.increaseEP(0);

                if(enemy instanceof Student){
                    increaseKP(0);
                }

            //if the enemy dies the student gets 4 EP
               if(enemy.isDead()){
                   increaseEP(4);
               }
            }
            return enemyTeam;
        }
        else {
            throw new Exception("Special ability can be used when KP is maximum");
        }
    }
}
