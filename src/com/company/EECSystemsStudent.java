package com.company;
/*
 *The EECSystemsStudent class is a subclass of the Student class
 *It assigns the base stats of an EECSStudent and implements his special ability;
 */
public class EECSystemsStudent extends Student{

    public EECSystemsStudent(String name) {
        super(name,8,4,10,3,10);
    }

    //the Electronic Computer Systems student uses parallel programming to attack all the members
    //of the enemy team using java
    public void parallelProgramming(Team enemyTeam) throws Exception{

        //It checks if the student has Max KP
        if (getCurrentKP() == getMaxKP()) {
            currentKP = 0;
            increaseEP(3);

            for (Character enemy : enemyTeam.getMembers()) {
               javaProgramming(enemy);

                //if the enemy dies the student gains 4 EP
                if (enemy.isDead()) {
                    increaseEP(4);
                }
            }
        } else {
            throw new Exception("Special ability can be used when KP is maximum");
        }
    }
}
