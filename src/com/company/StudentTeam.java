package com.company;

/*
 *StudentTeam is a subclass of Team
 *This class includes the move method which determines how a student behaves when it's his turn to make a move
 *it also includes the methods offensiveAbilities,defensiveAbilities and supportiveAbilities that are implemented in the move method
 *this methods make the students to care about their own and their allies hp to use abilities to heal or attack the enemy
 */
public class StudentTeam extends Team {

    public StudentTeam(String name) {
        super(name);
    }

    //this method uses method overriding to implement the move method from its super class Team
    @Override
    void move(Character member, Team enemyTeam) throws Exception {
        //this boolean value stores if the students currentKP is equal to the maxKP
        boolean hasFullKP = (((Student) member).getCurrentKP() == ((Student) member).getMaxKP());

        //this boolean value stores whether the hp of a players hp is lower than his maxHP * 0.3 (the student has low hp)
        boolean hasLowHP = (member.getHP() <= member.getMaxHP() * 0.3);

        boolean isSEStudent = (member instanceof SEStudent);
        boolean isAIStudent = (member instanceof AIStudent);
        boolean isCSStudent = (member instanceof CSStudent);
        boolean isEENanoStudent = (member instanceof EENanoStudent);
        boolean isEEMCSStudent = (member instanceof EEMCSStudent);

        //if the student has low hp he uses the self study method
        if (hasLowHP && !hasFullKP) {
            ((Student) member).selfStudy();
        }

        //checks if the player has full KP
        else if (hasFullKP) {
            System.out.println(member.getName() + " has full KP!");

            //if he has full KP, has low HP and is an AI, SE  or EENano student he uses his defensive abilities
                if (hasLowHP && (isAIStudent || isSEStudent || isEENanoStudent)) {
                    defensiveAbilities(member);
                    return;
                }
                //if he has full KP and is a CS, SE, EENano or EEMCSS student he checks if any allies have lower than half hp
                //if they have low hp then the student uses supportive abilities on an ally
            if (isCSStudent || isSEStudent || isEENanoStudent || isEEMCSStudent){
                for (Character ally : members) {
                    if (ally.getHP() <= ally.getMaxHP() * 0.5) {
                        supportiveAbilities(member, ally);
                        return;
                    }
                    //if an ally does not need healing then the student uses offensive abilities on an enemy
                    else offensiveAbilities(member,enemyTeam);

                    return;
                }

        //else if the conditions above are not satisfied
        //the student uses offensive abilities
        } else {
                offensiveAbilities(member, enemyTeam);
            }
        }
        //else if the student does not have full KP or low HP he uses his basic move javaProgramming on an enemy
        else {
            for (Character enemy : enemyTeam.getMembers()) {

                    ((Student) member).javaProgramming(enemy);
                    System.out.println(member.getName() + " used javaProgramming!");

                    if (enemy.isDead()) {
                        System.out.println(enemy.getName() + " has Died!");

                     //if the monster dies he's removed from the team and added to the deadMonsters Array
                       enemyTeam.removeMember(enemy);
                       enemyTeam.addDeadMonster(enemy);

                        enemy.isDead = false;
                        enemy.currentHP = enemy.getMaxHP();

                    }
                    return;

            }

        }

    }

    //this method determines the defensive abilities that the students have
    public void defensiveAbilities(Character member) throws Exception {

        //if the student is an AI Student he uses naturalLanguageProcessing
        if (member instanceof AIStudent) {
            ((AIStudent) member).naturalLanguageProcessing();
            System.out.println(member.getName() + " used naturalLanguageProcessing!");
        }
        //else if the student is an SE Student he uses groupDiscussion
        else if (member instanceof SEStudent) {
            ((SEStudent) member).groupDiscussion();
            System.out.println(member.getName() + " used groupDiscussion!");
        }
        //else if the student is an EENanoStudent he uses dataBoost on an ally
        if (member instanceof EENanoStudent) {
            ((EENanoStudent) member).nanoBotHeal(member);
            System.out.println(member.getName() + " used nanoBotHeal on himself!" );
        }

    }

    //this method determines the supportive abilities that the students have
    public void supportiveAbilities(Character member, Character ally) throws Exception {

        //if the student is a CS Student he uses support on an ally
        if (member instanceof CSStudent) {
            ((CSStudent) member).support(ally);
            System.out.println(member.getName() + " used support on " + ally.getName() + "!" );
        }

        //else if the student is an SE Student he uses groupDiscussion
        else if (member instanceof SEStudent) {
            ((SEStudent) member).groupDiscussion();
            System.out.println(member.getName() + " used groupDiscussion!");
        }

        //else if the student is an EEMCSStudent he uses dataBoost on an ally
        else if (member instanceof EEMCSStudent) {
            ((EEMCSStudent) member).dataBoost(ally);
            System.out.println(member.getName() + " used  dataBoost!" + ally.getName() + "!" );
        }

        //else if the student is an EENanoStudent he uses dataBoost on an ally
        if (member instanceof EENanoStudent) {
            ((EENanoStudent) member).nanoBotHeal(ally);
            System.out.println(member.getName() + " used nanoBotHeal on " + ally.getName() + "!" );
        }
    }

    //this method determines the offensive abilities that the students have
    public void offensiveAbilities(Character member, Team enemyTeam) throws Exception {

        for (Character enemy : enemyTeam.getMembers()) {

            if(member instanceof Student){

            //if the student is an AI Student he uses machineLearning on an enemy
            if (member instanceof AIStudent) {
                ((AIStudent) member).machineLearning(enemy);
                System.out.println(member.getName() + " used machineLearning!");
            }

            //if the student is a CS Student he uses pairWorking on an enemy with a random ally from his team
            else if (member instanceof CSStudent) {
                int randomAlly = ((int)(Math.random() * members.size()));

                ((CSStudent) member).pairWorking(members.get(randomAlly), enemy);
                
                System.out.println(member.getName() + " used pairWorking with " + members.get(randomAlly).getName() + "!");
            }

        //if the student is a CS Student he uses cyberAttack on the enemy team
            else if (member instanceof CyberStudent) {
                ((CyberStudent) member).cyberAttack(enemyTeam);
                System.out.println(member.getName() + " used cyberAttack!");
            }

        //if the student is an SE Student he uses groupWork on an enemy
            else if (member instanceof SEStudent) {
                ((SEStudent) member).groupWork(enemy);
                System.out.println(member.getName() + " used groupWork!");
            }

        //if the student is an EEPStudent he uses photonBlitz on an enemy
            else if (member instanceof EEPStudent){
                ((EEPStudent) member).photonBlitz(enemy);
                System.out.println(member.getName() + " used photonBlitz!");
            }

        //if the student is an EEWCStudent he uses wirelessStrike on an enemy
            else if (member instanceof EEWCStudent){
                ((EEWCStudent) member).wirelessStrike(enemy);
                System.out.println(member.getName() + " used wirelessStrike");
            }

        //if the student is an EEAIStudent he uses roboticAlgorithm on an enemy
            else if (member instanceof EEAIStudent){
                ((EEAIStudent) member).roboticAlgorithm(enemy);
                System.out.println(member.getName() + " used roboticAlgorithm!");
            }

        //if the student is an EEMCSStudent he uses securityBreach on the enemy team
            else if (member instanceof EEMCSStudent){
                ((EEMCSStudent) member).securityBreach(enemyTeam);
                System.out.println(member.getName() + " used securityBreach!");
            }

        //if the student is an EECSystemsStudent he uses parallelProgramming on the enemyTeam
            else if (member instanceof EECSystemsStudent){
                ((EECSystemsStudent) member).parallelProgramming(enemyTeam);
                System.out.println(member.getName() + " used parallelProgramming!");
            }

        //if the student is an EENanoStudent he uses nanoBotAttack on an enemy
            else if (member instanceof EENanoStudent){
                ((EENanoStudent) member).nanoBotAttack(enemy);
                System.out.println(member.getName() + " used nanoBotAttack!");
            }

                if (enemy.isDead()) {
                System.out.println(enemy.getName() + " has Died!");

                //if the monster dies he's removed from the team and added to the deadMonsters Array
                enemyTeam.removeMember(enemy);
                enemyTeam.addDeadMonster(enemy);

                enemy.isDead = false;
                enemy.currentHP = enemy.getMaxHP();
            }

        }
            return;
        }
    }
}


