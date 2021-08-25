package com.company;

/*
 *The CSStudent class is a subclass of the Student class
 *It assigns the base stats of a CSStudent and implements its 2 special abilities
 */
public class CSStudent extends Student {

    public CSStudent(String name) {
        super(name, 7, 6, 6, 6, 4);
    }

    //the special move pairWorking uses the help of a friend to attack the enemy
    //it takes two Characters as parameters the friend and the enemy
    public void pairWorking(Character friend, Character enemy) throws Exception {

        //It checks if the student has Max KP
        if (getCurrentKP() == getMaxKP()) {

            //it uses the formula for the move javaProgramming to attack the enemy
            //the enemy gets attacked twice once by the enemy and once by the ally
            enemy.decreaseHP((int) ((100 * getAttack()) / (100 + enemy.getDefence())));
            enemy.decreaseHP((int) ((100 * friend.getAttack()) / (100 + enemy.getDefence())));
            currentKP = 0;
            increaseEP(4);
            friend.increaseEP(0);
            ((Student) friend).increaseKP(0);
            enemy.increaseEP(0);

            if(enemy instanceof Student){
                ((Student)enemy).increaseKP(0);
            }

            //if the enemy dies the student gets 4 EP
            if (enemy.isDead()) {
                increaseEP(4);
            }
        } else {
            throw new Exception("Special ability can be used when KP is maximum");
        }
    }

    //the special move support heals a friend with the defence value of the student
    public void support(Character friend) throws Exception {

        //It checks if the student has Max KP
        if (getCurrentKP() == getMaxKP()) {
            currentKP = 0;

            friend.increaseHP((int) getDefence());

            friend.increaseEP(0);
            ((Student) friend).increaseKP(0);
        } else {
            throw new Exception("Special ability can be used when KP is maximum");
        }
    }
}