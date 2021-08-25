package com.company;

/*
 *MonsterTeam is a subclass of Team
 *It implements the way a monster attacks the enemy Team
 *The Monster doesn't have a conscience so it attacks random enemies
*/
public class MonsterTeam extends Team {

    public MonsterTeam(String name) {
        super(name);
    }

    //this method uses method overriding to implement the move method from its super class Team
    //it takes two parameters a member of the team and the enemy Team
    @Override
    void move(Character member, Team enemyTeam) throws Exception {

        for (Character enemy: enemyTeam.getMembers()) {

            //it uses the enemyTeam's length to determine the number that is corresponding to a member index
        int randomEnemy = ((int)(Math.random() * enemyTeam.getMembers().length));

                enemy = enemyTeam.members.get(randomEnemy);

                //the Monster uses the method strike on the enemy player chosen by random
                ((Monster) member).strike(enemy, enemyTeam);

                //if the enemy dies he's removed from his Team
                if (enemy.isDead()) {
                    System.out.println(enemy.getName() + " has Died!");
                    enemyTeam.removeMember(enemy);
                }

            return;
        }
    }
}
