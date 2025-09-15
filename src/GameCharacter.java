public class GameCharacter {
    private Stats stats;
    private boolean isBlocking;
    private boolean isSlain;
    private String userName;

    public GameCharacter(int istr, int ihit, int iavo, int idef, int ihp, String iuserName){
        this.stats = new Stats(istr, ihit, iavo, idef, ihp);
        this.isBlocking = false;
        this.isSlain = false;
        this.userName = iuserName;
    }

    public GameCharacter(){
        this.stats = new Stats(0,0,0,0,0);
        this.isBlocking = false;
        this.isSlain = false;
        this.userName = null;
    }

     
    public void displayAllStats(){
        this.stats.displayAllStats();
    }
     

    // universal action methods
    public void block(){
        if (this.isBlocking){
            System.out.println("Error: Already blocking");
            return;
        }
        this.isBlocking = true;
        this.stats.setDef(this.stats.getDef() + this.stats.getGuardDefBonus()); 
        this.stats.setAvo(this.stats.getAvo() + this.stats.getGuardAvoPenalty());
    }

    public void dropGuard(){
        if (!this.isBlocking){
            System.out.println("Error: not blocking");
            return;
        }
        this.isBlocking = false;
        this.stats.setDef(this.stats.getDef() - this.stats.getGuardDefBonus());
        this.stats.setAvo(this.stats.getAvo() - this.stats.getGuardAvoPenalty());
    }

    /**
     * 
     * @param otherHit the hit stat of the other character 
     * <p>hit chance is other character's hit stat - this characters avoid stat + avoid modifier<p>
     * in order to dodge, the dice roll must be higher or equal to the hit chance
     * dice roll works from 0 to 100 with no decimals
     * @return true for this character dodged, false if they didnt
     */

    public boolean dodgeCalc(int otherHit){
        // calculate hit chance
        // roll dice, return true for dodge and false for no dodge
        int hitChance = otherHit - (this.stats.getTotalAvo());
        int diceRoll = (int)(Math.random()*101);

        System.out.println(hitChance + " " + diceRoll);

        if (diceRoll >= hitChance)
        {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Calculates damage for basic attack
     * @return The full damage value for the attack
     */
    public int basicAttack(){ // works 13.8.25
        // basic attack the other
        // return value is the dmg of the move BEFORE opponent def calcs
        double dmg = this.stats.getTotalStr() * 0.8;
        dmg = Math.round(dmg);
        return (int)dmg;
    }

    /**
     * Calculates the true damage by subtracting def from the dmg
     * @param fullDmg The full damage of the attack
     */

    public void takeDamage(int fullDmg){ 
        //take damage, dmg = str - def
        int dmg;
        if (fullDmg <= this.stats.getTotalDef()){
            dmg = 0;
        }
        else {
            dmg = fullDmg - this.stats.getTotalDef();
        }
        System.out.println(this.stats.getHpCurrent());
        this.stats.setHpCurrent(this.stats.getHpCurrent() - dmg);
        System.out.println(dmg);
        System.out.println(this.stats.getHpCurrent());
    }


    // getters
    public boolean getIsBlocking(){
        return this.isBlocking;
    }
    public boolean getIsSlain(){
        return this.isSlain;
    }
    public String getUserName(){
        return this.userName;
    }

    // stats
    public int getStr(){
        return this.stats.getStr();
    }
    public int getHit(){
        return this.stats.getHit();
    }
    public int getAvo(){
        return this.stats.getAvo();
    }
    public int getDef(){
        return this.stats.getDef();
    }
    public int getHpMax(){
        return this.stats.getHpMax();
    }
    public int getHpCurrent(){
        return this.stats.getHpCurrent();
    }

    public int getStrMod(){
        return this.stats.getStrMod();
    }
    public int getHitMod(){
        return this.stats.getHitMod();
    }
    public int getAvoMod(){
        return this.stats.getAvoMod();
    }
    public int getDefMod(){
        return this.stats.getDefMod();
    }

    public int getGuardDefBonus(){
        return this.stats.getGuardDefBonus();
    }
    public int getGuardAvoPenalty(){
        return this.stats.getGuardAvoPenalty();
    }

    // get stat+modifier
    public int getTotalStr(){
        return this.stats.getTotalStr();
    }
    public int getTotalHit(){
        return this.stats.getTotalHit();
    }
    public int getTotalAvo(){
        return this.stats.getTotalAvo();
    }
    public int getTotalDef(){
        return this.stats.getTotalDef();
    }

    // setters
    public void setIsBlocking(){
        this.isBlocking = !this.isBlocking;
    }
    public void setIsSlain(boolean newIsSlain){
        this.isSlain = newIsSlain;
    }
    public void setUserName(String newUserName){
        this.userName = newUserName;
    }

    // stats
    public void setStr(int newStr){
        this.stats.setStr(newStr);
    }
    public void setHit(int newHit){
        this.stats.setHit(newHit);
    }
    public void setAvo(int newAvo){
        this.stats.setAvo(newAvo);
    }
    public void setDef(int newDef){
        this.stats.setDef(newDef);
    }
    public void setHpCurrent(int newHpCurrent){
        this.stats.setHpCurrent(newHpCurrent);
    }
    public void setHpMax(int newHpMax){
        this.stats.setHpMax(newHpMax);
    }

    public void setStrMod(int newStrMod){
        this.stats.setStrMod(newStrMod);
    }
    public void setHitMod(int newHitMod){
        this.stats.setHitMod(newHitMod);
    }
    public void setAvoMod(int newAvoMod){
        this.stats.setAvoMod(newAvoMod);
    }
    public void setDefMod(int newDefMod){
        this.stats.setDefMod(newDefMod);
    }

    public void setGuardDefBonus(int newGuardAvoPenalty){
        this.stats.setGuardDefBonus(newGuardAvoPenalty);
    }
    public void setGuardAvoPenalty(int newGuardAvoPenalty){
        this.stats.setGuardAvoPenalty(newGuardAvoPenalty);
    }
}
