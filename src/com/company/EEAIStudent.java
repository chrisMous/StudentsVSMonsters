package com.company;
/*
 *The EEAIStudent class is a subclass of the Student class
 *It assigns the base stats of an EEAIStudent and implements its special ability;
 */
public class EEAIStudent extends Student{

    public EEAIStudent(String name) {
        super(name,6,7,5,6,5);
    }

//the student uses a robot he created to help him attack attack the enemy
    public void roboticAlgorithm(Character enemy)throws Exception {

        //It checks if the student has Max KP
        if (getCurrentKP() == getMaxKP()) {
            currentKP = 0;
            increaseEP(3);

            enemy.decreaseHP((int) ((100 * getAttack()) / (100 + enemy.getDefence())));

            //the robot does more damage than the human
            enemy.decreaseHP((int) (1.5 * (100 * getAttack()) / (100 + enemy.getDefence())));

            //if the enemy dies the student gets 4 EP
            if (enemy.isDead()) {
                increaseEP(4);
            }

        } else {
            throw new Exception("Special ability can be used when KP is maximum");
        }
    }
}
