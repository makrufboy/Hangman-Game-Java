/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author Acer
 */
public abstract class GameOver {
    protected int runningGame;
    
    protected GameOver(int runningGame){
        this.runningGame = runningGame;
    }
    public void getRun(){
        System.out.println("Game sudah berjalan sebanyak "+this.runningGame);
    }
    public void setRun(int runningGame){
        this.runningGame = runningGame;
    }
    public abstract void view();
    public abstract void running(int runningGame);
}
