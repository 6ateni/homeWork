import java.time.LocalDate;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.save_and_load.FileHandler;
import model.save_and_load.Writable;

public class Main {
    public static void main(String[] args) {

        String file = "src/model.save_and_load/tree.txt";
        FamilyTree<Human> tree = finalTree();
//        FamilyTree<Human> tree = load(file);
        tree.sortByName();
        System.out.println(tree.getHumansInfo());
        tree.sortByBirthDate();
        System.out.println(tree.getHumansInfo());

        save(tree, file);
    }

    private static FamilyTree<Human> load(String file) {
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read(file);
    }

    private static void save(FamilyTree<Human> tree, String file) {
        Writable writable = new FileHandler();
        writable.save(tree, file);
    }

    private static FamilyTree<Human> finalTree() {
        FamilyTree <Human> tree = new FamilyTree<>();

        Human petya = new Human("Петя", Gender.Male, LocalDate.of(1993, 9, 24));
        Human ira = new Human("Ира", Gender.Female, LocalDate.of(1992, 2, 12));
        Human anya = new Human("Аня", Gender.Female, LocalDate.of(1974, 10, 2));
        Human pasha = new Human("Паша", Gender.Male, LocalDate.of(1973, 5, 11));
        Human kolya = new Human("Коля", Gender.Male, LocalDate.of(2000, 4, 13), anya, pasha);
        Human sonya = new Human("Соня", Gender.Female, LocalDate.of(2010, 2, 1), anya);
        Human egor = new Human("Егор", Gender.Male, LocalDate.of(2015, 8, 11), anya, pasha);


        tree.addHuman(petya);
        tree.addHuman(ira);
        tree.addHuman(anya);
        tree.addHuman(pasha);
        tree.addHuman(kolya);
        tree.addHuman(sonya);
        tree.addHuman(egor);


        return tree;

    }

}

