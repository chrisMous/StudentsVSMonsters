package com.company;

/*
 *The Minion class is a subclass of Character and it implements the methods that the Monster interface has
 *It uses constructor overriding because sometimes the Minion need to be initialized with name and level
 *It also assigns the base stats of a Minion
 */

public class Minion extends Character implements Monster{
    public Minion(String name) {
        super(name,5,5,5,5);
    }
    public Minion(String name,int level) {
        super(name,5,5,5,5);
        this.level = level;
    }

    //the strike method takes an enemy and the enemy Team as parameters
    //It uses Math.random to add probability to the Minion's attacks
    @Override
    public void strike(Character enemy ,Team enemyTeam) {
        int probability = ((int)(Math.random()*100)+1);

        //the Minion has a 75% chance of using SyntaxError on an enemy
        if(probability > 0 && probability <= 75){
            SyntaxError(enemy);
            System.out.println( this.getName() + " used SyntaxError on " + enemy.getName()+ "!");
        }
        //the Minion has a 15% chance of using NullPointerException
        else if(probability > 75 && probability <= 90){
            NullPointerException();
            System.out.println(this.getName() + " used NullPointerException!");
        }
        //the Minion has a 10% chance of using ArrayIndexOutOfBoundException
        else if(probability > 90){
            ArrayIndexOutOfBoundException(enemy);
            System.out.println( this.getName() + " used ArrayIndexOutOfBoundException on " + enemy.getName()+ "!");
        }
    }

    //this method uses the formula 100 * monster’s attack attribute / (100 + enemy’s defence attribute) to deal damage to the enemy
    //it increases the minion's EP and if it his a student the student gets 3KP
    @Override
    public void SyntaxError(Character enemy) {
        enemy.decreaseHP((int)(100 * getAttack() / (100 + enemy.getDefence())));
        increaseEP(3);
        if(enemy instanceof Student){
            ((Student)enemy).increaseKP(3);
        }
        //if the minion kills an enemy with this move it gets 4 EP
        if (enemy.isDead()) {
            increaseEP(4);
        }
    }
    //this method heals the Minion with an amount that is equal to its defence and grants it 3 EP when casted
    @Override
    public void NullPointerException() {
        increaseHP((int) getDefence());
        increaseEP(3);
    }

    //this method decreases the enemy's hp by double the amount of the basic attack and increases the Minion's EP
    @Override
    public void ArrayIndexOutOfBoundException(Character enemy) {
        enemy.decreaseHP((int)(2*(100 * getAttack() / (100 + enemy.getDefence()))));
        increaseEP(3);
        //when the student is hit he gets 3KP
        if(enemy instanceof Student){
            ((Student)enemy).increaseKP(3);
        }
        //if the minion kills the enemy with this move it gets 4 EP
        if (enemy.isDead()) {
            increaseEP(4);
        }
    }

}
