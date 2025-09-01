public class Character {
    private int str;
    private int hit;
    private int avo;
    private int def;
    private int hpMax;
    private int hpCurrent;

    private int strMod;
    private int hitMod;
    private int avoMod;
    private int defMod;
    // no temp HP, only def increases

    private int guardDefBonus;
    private int guardAvoPenalty;

    private boolean isSlain;
    private String userName;

    public Character(int istr, int ihit, int iavo, int idef, int ihp, String iuserName){
        this.str = istr;
        this.hit = ihit;
        this.avo = iavo;
        this.def = idef;
        this.hpMax = ihp;
        this.hpCurrent = ihp;
        this.isSlain = false;
        this.userName = iuserName;

        this.guardDefBonus = 40;
        this.guardAvoPenalty = 20;
    }

    // universal action methods
    public void block(){
        this.defMod += guardDefBonus;
        this.avoMod += guardAvoPenalty;
    }

    public void dropGuard(){
        this.defMod -= guardDefBonus;
        this.avoMod -= guardAvoPenalty;
    }

    /**
     * 
     * @param otherHit the hit stat of the other character 
     * <p>hit chance is other character's hit stat - this characters avoid stat + avoid modifier<p>
     * in order to dodge, the dice roll must be higher or equal to the hit chance
     * dice roll works from 0 to 100 with no decimals
     * @return true for this character dodged, false if they didnt
     */

    public boolean dodgeCalc(int otherHit){ // works 13.8.25
        // calculate hit chance
        // roll dice, return true for dodge and false for no dodge
        int hitChance = otherHit - (getTotalAvo());
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
        double dmg = getTotalStr() * 0.8;
        dmg = Math.round(dmg);
        return (int)dmg;
    }

    /**
     * Calculates the true damage by subtracting def from the dmg
     * @param fullDmg The full damage of the attack
     */

    public void takeDamage(int fullDmg){ // works 13.8.25
        //take damage, dmg = str - def
        int dmg;
        if (fullDmg <= this.getTotalDef()){
            dmg = 0;
        }
        else {
            dmg = fullDmg - this.getTotalDef();
        }
        System.out.println(this.getHpCurrent());
        this.hpCurrent -= dmg;
        System.out.println(dmg);
        System.out.println(this.getHpCurrent());
    }


    // getters
    public int getStr(){
        return this.str;
    }
    public int getHit(){
        return this.hit;
    }
    public int getAvo(){
        return this.avo;
    }
    public int getDef(){
        return this.def;
    }
    public int getHpMax(){
        return this.hpMax;
    }
    public int getHpCurrent(){
        return this.hpCurrent;
    }

    public int getStrMod(){
        return this.strMod;
    }
    public int getHitMod(){
        return this.hitMod;
    }
    public int getAvoMod(){
        return this.avoMod;
    }
    public int getDefMod(){
        return this.defMod;
    }

    public boolean getIsSlain(){
        return this.isSlain;
    }
    public String getUserName(){
        return this.userName;
    }

    public void getAllBaseStats(){
        System.out.println(this.getStr());
        System.out.println(this.getHit());
        System.out.println(this.getAvo());
        System.out.println(this.getDef());
        System.out.println(this.getHpCurrent());
        System.out.println(this.getHpMax());
    }

    // get stat+modifier
    public int getTotalStr(){
        return this.str + this.strMod;
    }
    public int getTotalHit(){
        return this.hit + this.hitMod;
    }
    public int getTotalAvo(){
        return this.avo + this.avoMod;
    }
    public int getTotalDef(){
        return this.def + this.defMod;
    }

    // setters
    public void setStr(int newStr){
        this.str = newStr;
    }
    public void setHit(int newHit){
        this.hit = newHit;
    }
    public void setAvo(int newAvo){
        this.avo = newAvo;
    }
    public void setDef(int newDef){
        this.def = newDef;
    }
    public void setHpCurrent(int newHpCurrent){
        this.hpCurrent = newHpCurrent;
    }
    public void setHpMax(int newHpMax){
        this.hpMax = newHpMax;
    }

    public void setStrMod(int newStrMod){
        this.strMod = newStrMod;
    }
    public void setHitMod(int newHitMod){
        this.hitMod = newHitMod;
    }
    public void setAvoMod(int newAvoMod){
        this.avoMod = newAvoMod;
    }
    public void setDefMod(int newDefMod){
        this.defMod = newDefMod;
    }

    public void setIsSlain(boolean newIsSlain){
        this.isSlain = newIsSlain;
    }
    public void setUserName(String newUserName){
        this.userName = newUserName;
    }
}
