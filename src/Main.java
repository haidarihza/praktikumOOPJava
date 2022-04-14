import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Character ch = new Character("Kirby", 10, 100, 4, 4);
        SummonedCharacter sc = new SummonedCharacter(ch, 1, 0);
        Spell s1 = new Spell("Fire");
        Spell s2 = new Spell("Ice");
        sc.addSpell(s1);
        sc.addSpell(s2);
        sc.render();
        List<Spell> sp = sc.getActiveSpells();
        for (Spell s : sp) {
            System.out.println(s.getName());
        }
    }
        /*        Worker worker = new Worker();
        List<Integer> durations = new ArrayList<Integer>();
        durations.add(5);
        durations.add(1);
        durations.add(3);
        durations.add(2);
        durations.add(4);
        int time = worker.run(durations, 5);
        System.out.println(worker.run(durations, 2));
    }

    public static void main(String[] args) {
        System.out.println("--- Section 1 ---");
        GhostPokemon ghost = new GhostPokemon();
        FightingPokemon fighter = new FightingPokemon();
        NormalPokemon normal = new NormalPokemon();
        Pokemon pokemon = new Pokemon();
        System.out.println(ghost.getName());
        System.out.println(fighter.getName());
        System.out.println(normal.getName());
        System.out.println(pokemon.getName());
        GhostPokemon ghost2 = new GhostPokemon("Gastly");
        FightingPokemon fighter2 = new FightingPokemon("Machop");
        NormalPokemon normal2 = new NormalPokemon("Rattata");
        Pokemon pokemon2 = new Pokemon("Big Boss");
        System.out.println(ghost2.getName());
        System.out.println(fighter2.getName());
        System.out.println(normal2.getName());
        System.out.println(pokemon2.getName());
        ghost2.displayClass();
        fighter2.displayClass();
        normal2.displayClass();
        pokemon2.displayClass();
        ghost.setUniqueID("G1");
        fighter.setUniqueID(12);
        System.out.println(ghost.getUniqueID());
        System.out.println(fighter.getUniqueID());
        System.out.println("--- Section 2 ---");
        ghost2.checkElement();
        fighter2.checkElement();
        normal2.checkElement();
        ghost2.specialSkill();
        fighter2.displayAura();
        ghost2.displayAura();
        fighter2.specialSkill();
        System.out.println("--- Section 3 ---");
        ghost2.displayClass();
        normal2.displayClass();
        System.out.println("Gastly vs Rattata");
        PokemonAction gastly = new PokemonAction(ghost2);
        PokemonAction rattata = new PokemonAction(normal2);
        for (int i = 0; i < 7; i++) {
            gastly.attack();
            rattata.defense();
        }
        rattata.attack();
        gastly.defense();
        rattata.attack();
        gastly.defense();
        rattata.attack();
        gastly.defense();
        rattata.useSkill();
        gastly.useSkill();
        rattata.run();
        System.out.println("--- Section 4 ---");
        System.out.println("New Battle Found");
        fighter2.displayClass();
        pokemon2.displayClass();
        System.out.println("Big Boss vs Machop");
        PokemonAction bigBoss = new PokemonAction(pokemon2);
        PokemonAction machop = new PokemonAction(fighter2);
        for (int i = 0; i < 4; i++) {
            machop.attack();
            bigBoss.defense();
        }
        for (int i = 0; i < 8; i++) {
            bigBoss.attack();
            machop.defense();
        }
        machop.useSkill();
        bigBoss.useSkill();
        machop.run();
        System.out.println("All Battle Finished");
    }
*/
}
