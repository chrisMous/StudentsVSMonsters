package com.company;

/*
 *The AIStudent class is a subclass of the Student class
 *It assigns the base stats of an AIStudent and implements its 2 special abilities
 */
public class AIStudent extends Student {

    public AIStudent(String name) {
        super(name, 6, 7, 7, 5, 3);
    }

//the special move  machineLearning deals double the basic attack damage to the enemy when used
    public void machineLearning(Character enemy) throws Exception {
        //It checks if the student has Max KP
        if (getCurrentKP() == getMaxKP()) {
            currentKP = 0;
            increaseEP(4);
            enemy.decreaseHP((int) (2 * (100 * getAttack()) / (100 + enemy.getDefence())));
            enemy.increaseEP(0);

            //if the enemy dies the student gets 4 EP
            if (enemy.isDead()) {
                increaseEP(4);
            }

        } else {
            throw new Exception("Special ability can be used when KP is maximum");
        }
    }
    //the special move naturalLanguageProcessing heals the student with his defence value
    public void naturalLanguageProcessing() throws Exception{

    //It checks if the student has Max KP
        if (getCurrentKP() == getMaxKP()) {
            increaseHP((int) getDefence());
            currentKP = 0;
        }
        else {
            throw new Exception("Special ability can be used when KP is maximum");
        }
    }
}
