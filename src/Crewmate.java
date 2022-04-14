public class Crewmate {
    public String name;
    public boolean isDead;
    private int stabCount;
    static int attributeId = 0;

    public Crewmate() {
        attributeId += 1;
        String name = "Crewmate " + attributeId;        
        this.name = name;
        this.isDead = false;
        this.stabCount = 0;
    }

    public Crewmate(String name) {
        this.name = name;
        this.isDead = false;
        this.stabCount = 0;
        attributeId += 1;
    }

    public void stab(Crewmate victim) {
        if (this.isDead) {
            System.out.println(this.name + " is dead");
        } else {
            victim.isDead = true;
            this.stabCount += 1;
            System.out.println(this.name + " stabs " + victim.name);
        }
    }

    public String toString() {
        String result = "";
        if (this.isDead) {
            result = this.name + " is dead";
        } else {
            if (this.stabCount > 0){
                result = this.name + " is sus";
            }
            else{
                result = this.name + " is cool";
            }
        }
        return result;
    }
}
