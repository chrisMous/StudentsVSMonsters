package com.company;

/*
 *The Monster interface lists the methods that are common in both Minions and Bosses
 *these two classes must include th emthods in this interface
 */
public interface Monster {
   void strike(Character enemy ,Team enemyTeam) throws Exception;
   void SyntaxError(Character enemy);
   void NullPointerException();
   void ArrayIndexOutOfBoundException(Character enemy);
}
