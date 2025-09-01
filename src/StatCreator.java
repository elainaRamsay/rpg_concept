import java.util.Scanner;

public class StatCreator{
    private int skillPoints;

    private int setStr;
    private int setHit;
    private int setAvo;
    private int setDef;
    private int setHp;
    private String setUserName;

    private final int baseSetStr;
    private final int baseSetHit;
    private final int baseSetAvo;
    private final int baseSetDef;
    private final int baseSetHp;

    private final int baseStatDistribution;
    private final int totalSkillPoints;

    private int characterClass;

    StatCreator(){
        this.skillPoints = 50;
        this.setStr = 0;
        this.setHit = 80;
        this.setAvo = 0;
        this.setDef = 0;
        this.setHp = 14;

        this.baseSetStr = this.setStr;
        this.baseSetHit = this.setHit;
        this.baseSetAvo = this.setAvo;
        this.baseSetDef = this.setDef;
        this.baseSetHp = this.setHp;

        this.baseStatDistribution = this.setStr + this.setHit + this.setAvo + this.setDef + this.setHp;
        this.totalSkillPoints = this.skillPoints;
        this.setUserName = null;
        this.characterClass = -1;
    }

    // universal methods

    public void resetStats(){
        this.skillPoints = totalSkillPoints;
        this.setStr = this.baseSetStr;
        this.setHit = this.baseSetHit;
        this.setAvo = this.baseSetAvo;
        this.setDef = this.baseSetDef;
        this.setHp = this.baseSetHp;
    }

    private boolean isStatDistributionCorrect(){
        if (this.setStr + this.setHit + this.setAvo + this.setDef + this.setHp - this.baseStatDistribution == 2 * (this.totalSkillPoints - this.skillPoints)){ 
            return true;
        }
        else {
            return false;
        }
    }

    private void weFuckedUp(){
        System.out.println("Error: Stat distribution does not add up properly, resetting stats");
        this.resetStats();
    }

    public void displayAllStats(){
        System.out.println("Str: " + this.setStr);
        System.out.println("Hit: " + this.setHit);
        System.out.println("Avo: " + this.setAvo);
        System.out.println("Def: " + this.setDef);
        System.out.println("HP: " + this.setHp);
        System.out.println("Skill Points: " + this.skillPoints + " / " + this.totalSkillPoints);
    }

    private boolean isUserHappy(Scanner scanner, int stage){
        if (stage == 0){
            System.out.println("Are you sure this class is ok? Y/N");
        }
        else if (stage == 1){
            System.out.println("Are you sure these stats are ok? Y/N");
        }

        char input;
        input = scanner.next().charAt(0);
        scanner.nextLine();

        if (input == 'Y' || input == 'y'){
            return true;
        }
        else if (input == 'N' || input == 'n'){
            return false;
        }
        else {
            return isUserHappy(scanner, stage);
        }
    }

    private char getUserInput(Scanner scanner){
        char x;
        x = scanner.next().charAt(0);
        scanner.nextLine();

        return x;
    }

    // stat setting methods
    // get input (check if valid, except shit inputs)
    // loop that runs until user ends manually

    private boolean isInputValid(char input){
        if (input == 'q' || input == 'Q' || input == 'w' || input == 'W' || input == 'e' || input == 'E' || input == 'r' || input == 'R' || input == 't' || input == 'T' || input == '0'){
            return true;
        }
        else {
            System.out.println("Error: Invalid input");
            return false;
        }
    }

    private boolean isInputUpperCase(char input){
        if (input == 'Q' || input == 'W' || input == 'E' || input == 'R' || input == 'T'){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isInputZero(char input){
        if (input == '0'){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isEnoughSkillPts(){
        if (this.skillPoints > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    private void statAdder(char input){
        if (input == 'q'){
            this.setStr += 2;
            this.skillPoints -=1;
        }
        else if (input == 'w'){
            this.setHit += 2;
            this.skillPoints -=1;
        }
        else if (input == 'e'){
            this.setAvo += 2;
            this.skillPoints -=1;
        }
        else if (input == 'r'){
            this.setDef += 2;
            this.skillPoints -=1;
        }
        else if (input == 't'){
            this.setHp += 2;
            this.skillPoints -=1;
        }
    }

    private void statSubtractor(char input){
        if (input == 'Q' && this.setStr > this.baseSetStr){
            this.setStr -= 2;
            this.skillPoints +=1;
        }
        else if (input == 'W' && this.setHit > this.baseSetHit){
            this.setHit -= 2;
            this.skillPoints +=1;
        }
        else if (input == 'E' && this.setAvo > this.baseSetAvo){
            this.setAvo -= 2;
            this.skillPoints +=1;
        }
        else if (input == 'R' && this.setDef > this.baseSetDef){
            this.setDef -= 2;
            this.skillPoints +=1;
        }
        else if (input == 'T' && this.setHp > this.baseSetHp){
            this.setHp -= 2;
            this.skillPoints +=1;
        }
        else {
            System.out.println("Cannot subtract, stat is base at minimum value");
        }
    }

    public void changeStats(Scanner scanner){
            // get input
            // is input valid
            // is input uppercase
            // stat add or stat minus
            // if stat add: do we have enough skill points
            // if input 0, ask user if they finished
            // if user finished, end loop

            //get input, check if valid, continue if yes
            char input = getUserInput(scanner);
            boolean finished = false;

            if (isInputValid(input) && !isInputZero(input)) {
                // check if uppercase
                if (isInputUpperCase(input)){
                    statSubtractor(input);
                    System.out.println("subtracting");
                }
                else {
                    if (isEnoughSkillPts()) {
                        statAdder(input);
                        System.out.println("adding");
                    }
                    else {
                        System.out.println("not enough skill point");
                    }
                }
            }
            else if (isInputValid(input) && isInputZero(input)){
                finished = isUserHappy(scanner, 1);
            }

            if (!isStatDistributionCorrect()){
                weFuckedUp();
            }
            
            if (!finished) {
                System.out.println("looping");
                this.displayAllStats();
                changeStats(scanner);
            }
    }

    // class setting methods
    private int getUserClassChoice(Scanner scanner){
        char selection = ' ';
        int result = -1;

        System.out.println("1 for attacker, 2 for defender");
        selection = getUserInput(scanner);
        //scanner.next();

        result = charToInt(selection);

        if (result == -1){
            result = getUserClassChoice(scanner);
        }

        return result;
    }

    private int charToInt(char x){
        int result = (int)x;
        if (result < 48 || result > 57){
            return -1;
        }
        else {
            result -= 48;
        }
        return result;
    }

    public boolean classSelection(Scanner scanner){
        int selection = -1;
        boolean finished = false;

        try {
            selection = getUserClassChoice(scanner);
        } 
        catch (Exception e) {
            System.out.println("Error: Not a number");
            scanner.next();
            classSelection(scanner);
        }        

        showDescriptions(selection);

        if (isUserHappy(scanner, 0)){
            this.characterClass = selection;
            System.out.println(this.characterClass);
            finished = true;
            return finished;
        }
        else {
            classSelection(scanner);
        }
        return finished;
    }

    private void showDescriptions(int selection){
        if (selection == 1){
            Attacker.showDescription();
        }
        else if (selection == 2){
            Defender.showDescription();
        }
        else {
            System.out.println("no desc available");
        }
    }

    public void makeCharacter(Character character, Scanner scanner){
        int selection = getUserClassChoice(scanner);

        if (selection == 0){
            System.out.println("Making attacker");
            statTransferAttacker(character);
        }
        else if (selection == 1){
            System.out.println("Making defender");
            statTransferDefender(character);
        }
        else {
            System.out.println("bruh");
        }
    }

    private void statTransferAttacker(Character character){
        character = new Attacker(this.setStr, this.setHit, this.setAvo, this.setDef, this.setHp, this.setUserName);
    }

    private void statTransferDefender(Character character){
        character = new Defender(this.setStr, this.setHit, this.setAvo, this.setDef, this.setHp, this.setUserName);
    }

    // getters
    public int getSkillPoints(){
        return this.skillPoints;
    }
    public int getSetStr(){
        return this.setStr;
    }
    public int getSetHit(){
        return this.setHit;
    }
    public int getSetAvo(){
        return this.setAvo;
    }
    public int getSetDef(){
        return this.setDef;
    }
    public int getSetHp(){
        return this.setHp;
    }
    public String getSetUserName(){
        return this.setUserName;
    }
    public int getCharacterClass(){
        return this.characterClass;
    }

    // setters
    public void setSkillPoints(int skillPoints){
        this.skillPoints = skillPoints;
    }
    public void setSetStr(int setStr){
        this.setStr = setStr;
    }
    public void setSetHit(int setHit){
        this.setHit = setHit;
    }
    public void setSetAvo(int setAvo){
        this.setAvo = setAvo;
    }
    public void setSetDef(int setDef){
        this.setDef = setDef;
    }
    public void setSetHp(int setHp){
        this.setHp = setHp;
    }
    public void setSetUserName(String setUserName){
        this.setUserName = setUserName;
    }
    public void setCharacterClass(int characterClass){
        this.characterClass = characterClass;
    }    
}