import java.util.ArrayList;
import java.util.List;

public class SummonedCharacter implements ISummoned {
    private Character ch;
    private int curr_lvl;
    private int curr_exp;
    private int curr_health;
    private int curr_attack;
    private List<Spell> active_spells;

    public SummonedCharacter(Character ch, int curr_lvl, int curr_exp) {
        this.ch = ch;
        this.curr_lvl = curr_lvl;
        this.curr_exp = curr_exp;
        this.curr_health = ch.getHpValue();
        this.curr_attack = ch.getAttackValue();
        active_spells = new ArrayList<Spell>();
    }

    // getter
    public int getLevel() {
        return this.curr_lvl;
    }

    public int getExp(){
        return this.curr_exp;
    }

    // menambahkan spell ke dalam daftar spell aktif
    public void addSpell(Spell s){
        active_spells.add(s);
    }

    // mengembalikan daftar spell aktif
    public List<Spell> getActiveSpells(){
        return active_spells;
    }

    // meningkatkan level karakter sebanyak 1
    // mereset xp ke 0
    // meningkatkan baseAtk dan baseHp sebanyak attackUp dan healthUp
    public void levelUp() {
        this.curr_lvl++;
        this.curr_exp = 0;
        this.curr_attack += ch.getAttackUpValue();
        this.curr_health += ch.getHealthUpValue();
    }

    // menggambar kartu ke layar
    public void render(){
        System.out.println("Nama: " + ch.getName());
        System.out.println("Level: " + curr_lvl);
        System.out.println("Exp: " + curr_exp);
        System.out.println("Atk: " + curr_attack);
        System.out.println("Hp: " + curr_health);
        System.out.println("Memiliki " + active_spells.size() + " spell aktif:");
        for (Spell s : active_spells) {
            System.out.println("- " + s.getName());
        }
        System.out.println();
    }
}
