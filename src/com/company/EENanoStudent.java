package com.company;
/*
 *The EENanoStudent class is a subclass of the Student class
 *It assigns the base stats of an EE with Nanotechnology Student and implements his special abilities;
 */
public class EENanoStudent extends Student{

    public EENanoStudent(String name) {
        super(name, 5, 8, 6, 6, 2);
    }

    //the EENano Student uses 10 nano bots to attack an enemy
    //each nano bot deals damage with the formula (12 * player's Attack / (100 + enemy's defence)
    public void nanoBotAttack(Character enemy) throws Exception{
        //It checks if the student has Max KP
        if (getCurrentKP() == getMaxKP()) {
            currentKP = 0;
            increaseEP(4);

            for (int i=0 ; i<10 ;i++) {
                enemy.decreaseHP((int) ((12 * getAttack()) / (100 + enemy.getDefence())));

                //if the enemy dies the student gains 4 EP
                if (enemy.isDead()) {
                    increaseEP(4);
                }
            }
        } else {
            throw new Exception("Special ability can be used when KP is maximum");
        }
    }

    //the EENano Student uses his nano Bots to heal an ally or himself
    //each nano bot heals for the players defence divided by 6
    public void nanoBotHeal(Character ally) throws Exception{
        //It checks if the student has Max KP
        if (getCurrentKP() == getMaxKP()) {
            currentKP = 0;
            increaseEP(4);

            for (int i=0 ; i<10 ;i++) {
               ally.increaseHP((int) (getDefence()/6));

            }
        } else {
            throw new Exception("Special ability can be used when KP is maximum");
        }
    }

}
