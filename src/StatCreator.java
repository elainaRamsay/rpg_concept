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

    /**
     * Calculates if the total stat distribution is correct
     * @return True if it is correct, False otherwise
     */

    private boolean isStatDistributionCorrect(){
        if (this.setStr + this.setHit + this.setAvo + this.setDef + this.setHp - this.baseStatDistribution == 2 * (this.totalSkillPoints - this.skillPoints)){ 
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Resets the stats and prints funny message
     */

    private void weFuckedUp(){
        System.out.println("Error: Stat distribution does not add up properly, resetting stats");
        this.resetStats();
    }

    /**
     * Prints all stats to the screen
     */

    public void displayAllStats(){
        System.out.println("Str: " + this.setStr);
        System.out.println("Hit: " + this.setHit);
        System.out.println("Avo: " + this.setAvo);
        System.out.println("Def: " + this.setDef);
        System.out.println("HP: " + this.setHp);
        System.out.println("Skill Points: " + this.skillPoints + " / " + this.totalSkillPoints);
    }

    /**
     * Asks the user if the class/stats are acceptable
     * <p>Accepts Y and N, recurs if the user says something else
     * @param scanner Scanner object needed to read from console
     * @param stage Determines the initial message to the user
     * @return True if the user is ok with outcome, false otherwise
     */

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
            System.out.println("Error: Not a valid choice");
            return isUserHappy(scanner, stage);
        }
    }

    /**
     * Honestly does what it says on the tin
     * <p>Gets input as char
     * @param scanner Scanner object needed to read from console
     * @return The first char in the string the user types to the console
     */
    private char getUserInput(Scanner scanner){
        char x;
        x = scanner.next().charAt(0);
        scanner.nextLine();

        return x;
    }

    // stat setting methods
    // get input (check if valid, except shit inputs)
    // loop that runs until user ends manually

    /**
     * Determine if an input is any of Q W E R T or 0
     * <p>Yell if not
     * @param input Input to be validated
     * @return True if input is valid, false otherwise
     */

    private boolean isInputValid(char input){
        if (input == 'q' || input == 'Q' || input == 'w' || input == 'W' || input == 'e' || input == 'E' || input == 'r' || input == 'R' || input == 't' || input == 'T' || input == '0'){
            return true;
        }
        else {
            System.out.println("Error: Invalid input");
            return false;
        }
    }

    /**
     * Check if input is Q W E R T and uppercase
     * @param input Input to be validated
     * @return True if input is uppercase, false otherwise
     */ 
    public boolean isInputUpperCase(char input){ 
        if ((int)input >= 65 && (int)input <=90){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Does what it says on the tin
     * @param input Input to be validated
     * @return True if input is 0, false otherwise
     */
    private boolean isInputZero(char input){
        if (input == '0'){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Check if skill points amount is above 0
     * @return True if skill points is higher than 0, false otherwise
     */
    private boolean isEnoughSkillPts(){
        if (this.skillPoints > 0) {
            return true;
        }
        else {
            return false;
        }
    } 

    /**
     * Checks input, adds +2 to stat and -1 to skill points
     * @param input Decides which stat to add to
     */
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

    /**
     * Checks input, adds -2 to stat and +1 to skill points
     * @param input Decides which stat to subtract from
     */
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

    /**
     * Main function for running the stat adding logic
     * <p>Prints the current character stats, prompts user to type to add and subtract from them
     * <p>Typing 0 will prompt the method to finish
     * @param scanner Scanner object needed to read from console
     */
    public void statChanger(Scanner scanner){
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

            if (isInputValid(input)){
                //input is valid, but maybe 0 or not 0
                if (isInputZero(input)){
                    finished = isUserHappy(scanner, 1);
                }
                //input is valid and not zero
                else {
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

            }

            if (!isStatDistributionCorrect()){
                weFuckedUp();
            }
            
            if (!finished) {
                System.out.println("looping");
                this.displayAllStats();
                statChanger(scanner);
            }
    }

    // class setting methods

    /**
     * Gets users class choice
     * <p>Gets user input, if input is not a valid class it recurs until a number is entered
     * @param scanner Scanner object needed to read from console
     * @return User's class choice as int
     */
    private int getUserClassChoice(Scanner scanner){
        char selection = ' ';
        int result = -1;

        System.out.println("1 for attacker, 2 for defender");
        selection = getUserInput(scanner);
        //scanner.next();

        result = charToInt(selection);

        if (isValidClass(result)){
            System.out.println("Error: Not a valid character class");
            result = getUserClassChoice(scanner);
        }

        return result;
    }

    /**
     * Checks if input is a valid class option
     * @param input Input to be checked
     * @return True if input corresponds to a valid character class, false otherwise
     */
    private boolean isValidClass(int input){
        if (input <= 0 || input > 2){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Converts a numeric char into its numerical value as an int
     * @param x Char to be converted
     * @return Numerical value of numerical char, or -1 if the char is not a number
     */
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

    /**
     * Gets the users class, changes object attribute to be used by a different method. 
     * @param scanner Scanner object needed to read from console
     * @return True if the user selected a class successfully, false otherwise
     */
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

    /**
     * Calls the description methods of Character Subclasses, yells if class doesnt exist
     * @param selection Selection for which class to show descriptions for
     */
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

    // Character Object

    /**
     * Makes an Attacker object using the stats created by the Stat Creator
     * @return an Attacker object
     */
    public Attacker makeAttacker(){
        return new Attacker(this.setStr, this.setHit, this.setAvo, this.setDef, this.setHp, this.setUserName);
    }

    /**
     * Makes a Defender object using the stats created by the Stat Creator
     * @return a Defender object
     */
    public Defender makeDefender(){
        return new Defender(this.setStr, this.setHit, this.setAvo, this.setDef, this.setHp, this.setUserName);
    }

    // main method
    // run get class
    // run get stats
    // run character obj maker

    /**
     * Runs classSelection and statChanger
     * @param scanner
     * @param character
     */
    public void statCreator(Scanner scanner, GameCharacter character){
        this.classSelection(scanner);
        this.statChanger(scanner);
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