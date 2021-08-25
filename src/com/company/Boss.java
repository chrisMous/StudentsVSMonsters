package com.company;

/*
 *The Boss class is a subclass of Character and it implements the methods that the Monster interface has
 *It also assigns the base stats of a Boss and adds 2 extra moves that only a Boss can use
 *It uses constructor overriding because sometimes the Boss need to be initialized with name and level
 */
public class Boss extends Character implements Monster {
    public Boss(String name) {
        super(name, 8, 7, 8, 7);
    }
    public Boss(String name,int level) {
        super(name, 8, 7, 8, 7);
       this.level = level;
    }

    //the strike method takes an enemy and the enemy Team as parameters
    //It uses Math.random to add probability to the Boss's attacks
    @Override
    public void strike(Character enemy , Team enemyTeam) {
        int probability = ((int)(Math.random()*100)+1);

        //the Boss has a 50% chance of using SyntaxError on an enemy
        if(probability > 0 && probability <= 50){
            SyntaxError(enemy);
            System.out.println( "Boss used SyntaxError on " + enemy.getName()+ "!");
        }
        //the Boss has a 15% chance of using NullPointerException
        else if(probability > 50 && probability <= 65){
            NullPointerException();
            System.out.println( "Boss used NullPointerException!");
        }
        //the Boss has a 15% chance of using ArrayIndexOutOfBoundException on an enemy
        else if(probability > 65 && probability <= 80){
            ArrayIndexOutOfBoundException(enemy);
            System.out.println( "Boss used ArrayIndexOutOfBoundException on " + enemy.getName() + "!");
        }
        //the Boss has a 10% chance of using NoneTermination
        else if(probability > 80 && probability <= 90){
            NoneTermination();
            System.out.println( "Boss used NoneTermination!");
            System.out.println("The Boss has revived the dead Monsters!");
        }
        //the Boss has a 10% chance of using ConcurrentModificationException on the enemy team
        else if(probability > 90){
           ConcurrentModificationException(enemyTeam);
            System.out.println( "Boss used ConcurrentModificationException on " + enemyTeam.getName() + "!");
        }
    }

    //this method uses the formula 100 * monster’s attack attribute / (100 + enemy’s defence attribute) to deal damage to the enemy
    //it increases the Boss's EP and if it his a student the student gets 3KP
    @Override
    public void SyntaxError(Character enemy) {
        enemy.decreaseHP((int) (100 * getAttack() / (100 + enemy.getDefence())));
        increaseEP(3);
        if (enemy instanceof Student) {
            ((Student) enemy).increaseKP(3);
        }
        //if the Boss kills an enemy with this move he gets 4 EP
        if (enemy.isDead()) {
            increaseEP(4);
        }
    }
    //this method heals the Boss with an amount that is equal to its defence and grants him 3 EP when used
    @Override
    public void NullPointerException() {
        increaseHP((int) getDefence());
        increaseEP(3);
    }

    //this method decreases the enemy's hp by double the amount of the basic attack and increases the Boss's EP
    @Override
    public void ArrayIndexOutOfBoundException(Character enemy) {
        enemy.decreaseHP((int) (2 * (100 * getAttack() / (100 + enemy.getDefence()))));
        increaseEP(3);
        if (enemy instanceof Student) {
            ((Student) enemy).increaseKP(3);
        }
        //if the Boss kills an enemy with this move he gets 4 EP
        if (enemy.isDead()) {
            increaseEP(4);
        }
    }

    //this move is unique to the Boss and it revives the dead Monsters
    public void NoneTermination() {
        getTeam().revive();
        increaseEP(3);
    }

    //this move is unique to the Boss and it deals damage to all of the members in the enmy team
    public void ConcurrentModificationException(Team enemyTeam) {
        for (Character enemy : enemyTeam.getMembers()) {
            SyntaxError(enemy);
                enemy.increaseEP(3);
                //if the enemy dies the Boss gets 4 EP
            if (enemy.isDead()) {
                increaseEP(4);
            }
            //if a student is hit teh student gets 3KP
            if (enemy instanceof Student) {
                ((Student) enemy).increaseKP(3);
            }

        }
            increaseEP(3);
    }

}
