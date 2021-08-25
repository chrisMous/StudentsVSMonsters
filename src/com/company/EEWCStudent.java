package com.company;
/*
 *The EEWCStudent class is a subclass of the Student class
 *It assigns the base stats of an EE with Wireless Communications student and implements his special ability;
 */
public class EEWCStudent extends Student{

    public EEWCStudent(String name){
        super(name,7,6,6,5,7);
    }

    //the EEWC Student uses wireless Strike from far away and deals immense damage to the enemy
    //this moves takes a lot of time to charge so it only has a 30% chance of hitting the enemy
    public void wirelessStrike(Character enemy)throws Exception {

        //It checks if the student has Max KP
        if (getCurrentKP() == getMaxKP()) {
            currentKP = 0;
            increaseEP(3);
            int probability = ((int)(Math.random()*100)+1);

            if(probability > 0 && probability <= 30){
                enemy.decreaseHP(500);
            }

            else if(probability > 30) {
                System.out.println("The EEWCStudent missed wirelessStrike");
            }

            if (enemy.isDead()) {
                increaseEP(4);
            }

        } else {
            throw new Exception("Special ability can be used when KP is maximum");
        }
    }


}
