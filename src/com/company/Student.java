package com.company;

/*
 *The Student is a subclass of student and adds an additional character attribute to Students: KP
 *It includes a method that adjusts KP
 *It sets the basic abilities of students which are javaProgramming and selfStudy
 *
 *The Computer Science students taught javaProgramming to the Electrical Engineering Students
 *In return the Electronic Engineering students taught the students how to selfStudy more efficiently
 *
 *(All of the methods implemented in its subclasses throw Exceptions when the student doesn't have maxKP and set his KP back to 0 when used)
 */
public  class Student extends Character{
    protected int maxKP;
    protected int currentKP;

    public Student(String name, int baseHP, int baseAtk, int baseDef, int baseSpd, int maxKP) {
        super(name, baseHP, baseAtk, baseDef, baseSpd);
        this.maxKP = maxKP;
    }
    public int getCurrentKP(){
        return currentKP;
    }
    public int getMaxKP(){
        return maxKP;
    }

    //this method increases the KP of a student
    //this method does not allow the KP to be below 0
    //If his KP after the increase is more than the max value the student is not allowed to exceed the max HP
    public int increaseKP(int amount){
        currentKP += amount;
        if(currentKP < 0) {
            return currentKP = 0;
        }
        else if(currentKP > maxKP){
            return currentKP = maxKP;
        }
   return currentKP;
}

    //this is the basic offensive move of a student
    //it uses the formula (100 * student’s attack attribute) / (100 + enemy’s defence attribute) to calculate its damage output
    //it also increases the student's EP and KP
    public void javaProgramming(Character enemy) {
        increaseEP(3);
        increaseKP(1);
        enemy.decreaseHP((int) ((100 * getAttack()) / (100 + enemy.getDefence())));
        enemy.increaseEP(2);

        if(enemy instanceof Student){
            ((Student)enemy).increaseKP(3);
        }
        //if the enemy dies as a result of this move then the character gets 4 EP
        else if(enemy.isDead){
            increaseEP(4);
        }

    }
    //this is the basic defensive move of a student
    //it increases the HP,EP and KP of a student
    public void selfStudy() {
           increaseHP( 5 * level);
           increaseEP(7);
           increaseKP(5);
    }


}
