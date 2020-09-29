/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Acer
 */
public class GameLogic extends GameOver implements Player {
    private static String myName = "Unknown_player";
    private static int idName = 0;
    
    private String selectedWord = "nyayu";
    private int selectedWordLength;
    private String category;
    
    private int inGameError = 0;
    private int points = 0;
    
    private static List[] gameList = new List[3];
    private static List[] workingList = new List[1];
    
    
    private StringBuilder mask = new StringBuilder();
    
    private boolean inProgress = true;
    private boolean isComplete = false;
    
    public GameLogic(){
        super(0);
    }
    
    public void setCategory(String category){
        int listID = 0;
        if(category.equals("hewan")){
		listID = 0;	
	}
	else if(category.equals("bunga")){
		listID = 1;
	}
	else if(category.equals("buah")){
		listID = 2;
	}
        this.category = category;
        workingList[0] = getAllLists()[listID];
    }
    
    public void updateMask(String letter){
        int indexOfLetter;
        indexOfLetter = selectedWord.toLowerCase().indexOf(letter.toLowerCase());
        
        while(indexOfLetter >=0 ){
            mask.replace(indexOfLetter, indexOfLetter+1, letter);
            
            indexOfLetter = selectedWord.toLowerCase().indexOf(letter.toLowerCase(), indexOfLetter+1);
            
            if(!mask.toString().contains("_")){
                points+=100;
                isComplete = true;
                mask.setLength(0);
            }
              
        }
    }
    
    public void setRandomWord(){
        this.selectedWord= (String) getWorkingList()[0].get(new Random().nextInt(getWorkingList()[0].size()));
        this.selectedWordLength = selectedWord.length();
        
        for(int i=1; i<= selectedWordLength;i++){
            mask.append("_");
        }
    }
    
    public void setAllLists(List[] allList){
        gameList = allList;    
    }
    
    public String getSelectedWord(){
		return selectedWord;
    }
    
    public String getMask(){
		return mask.toString();
    }
    
    public boolean checkCompletion(){
        return isComplete;
    }
    
    public void setCompletion(boolean b) {
		this.isComplete = b;
		
    }
    
    public boolean getState(){
		return inProgress;
    }
    
    public void gameInProgress(boolean truefalse){
		inProgress = truefalse;
    }
    
    public void hangMan(){
		this.inGameError++;			
    }
    
    public int hangManState(){
		return this.inGameError;
    }
    
    public void resetLives(){
		this.inGameError = 0;
    }
    
    public void resetMask(){
		mask.setLength(0);
    }
    
    public void resetPoints(){
        points = 0;
    }
    
    public boolean checkLetter(String letter) {
		if(selectedWord.toLowerCase().contains(letter.toLowerCase())){
			return true;
		} else {
			return false;
		}
    }
    
    public int getPoints(){
        return points;
    }

    @Override
    public void setUserName(String c) {
        myName = c;
    }

    @Override
    public String getUserName() {
        return myName;
    }

    public List[] getAllLists() {
        return gameList;
    }
    public List[] getWorkingList(){
        return workingList;
    }
    
    
    
    public int getIdName(){
        return idName;
    }
    
    public void setIdName(int c){
        idName = c;
    }

    @Override
    public void view() {
        if(this.checkCompletion()){
            System.out.println("Game telah Berakhir");
        }
    }

    @Override
    public void running(int runningGame) {
        super.setRun(runningGame);
    }
    
    
    public void getRuns(){
        super.getRun();
    }
}
