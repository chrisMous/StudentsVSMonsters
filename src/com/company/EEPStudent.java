package com.company;
/*
 *The EEPStudent class is a subclass of the Student class
 *It assigns the base stats of an EE with Photonics student and implements his special ability;
 */
public class EEPStudent extends Student {
    public EEPStudent(String name) {
        super(name, 6, 7, 5, 8, 6);
    }

//the EEPStudent blitzes the enemy so fast he's confused and attacks himself
    public void photonBlitz(Character enemy)throws Exception {

        //It checks if the student has Max KP
        if (getCurrentKP() == getMaxKP()) {
            currentKP = 0;
            increaseEP(3);

            enemy.decreaseHP((int) ((100 * getAttack()) / (100 + enemy.getDefence())));

            //the damage the enemy does to himself
            enemy.decreaseHP((int) ((100 * enemy.getAttack()) / (100 + enemy.getDefence())));

            //if the enemy dies the student gets 4 EP
            if (enemy.isDead()) {
                increaseEP(4);
            }

        } else {
            throw new Exception("Special ability can be used when KP is maximum");
        }
    }

}