public class Stats {
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

    public Stats(int istr, int ihit, int iavo, int idef, int ihp){
        this.str = istr;
        this.hit = ihit;
        this.avo = iavo;
        this.def = idef;
        this.hpMax = ihp;
        this.hpCurrent = ihp;

        this.strMod = 0;
        this.hitMod = 0;
        this.avoMod = 0;
        this.defMod = 0;

        this.guardDefBonus = 40;
        this.guardAvoPenalty = 20;
    }

    public Stats(){
        this.str = 0;
        this.hit = 0;
        this.avo = 0;
        this.def = 0;
        this.hpMax = 0;
        this.hpCurrent = 0;

        this.strMod = 0;
        this.hitMod = 0;
        this.avoMod = 0;
        this.defMod = 0;

        this.guardDefBonus = 40;
        this.guardAvoPenalty = 20;
    }

    public void displayAllStats(){
        System.out.println("Str: " + this.str);
        System.out.println("Hit: " + this.hit);
        System.out.println("Avo: " + this.avo);
        System.out.println("Def: " + this.def);
        System.out.println("HP max: " + this.hpMax);
        System.out.println("HP current: " + this.hpCurrent);
    }

    /*
    public void getAllBaseStats(){ // unused
        System.out.println(this.getStr());
        System.out.println(this.getHit());
        System.out.println(this.getAvo());
        System.out.println(this.getDef());
        System.out.println(this.getHpCurrent());
        System.out.println(this.getHpMax());
    }
     * 
     */

    // Getters
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

    public int getGuardDefBonus(){
        return this.guardDefBonus;
    }
    public int getGuardAvoPenalty(){
        return this.guardAvoPenalty;
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

    // Setters
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

    public void setGuardDefBonus(int newGuardAvoPenalty){
        this.guardDefBonus = newGuardAvoPenalty;
    }
    public void setGuardAvoPenalty(int newGuardAvoPenalty){
        this.guardAvoPenalty = newGuardAvoPenalty;
    }
}
