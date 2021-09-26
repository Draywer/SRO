package ru.greendatasoft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Set<Conterparty> conterparty1Set = new HashSet<>();
        Set<Conterparty> conterparty2Set = new HashSet<>();
        Set<Conterparty> conterparty3Set = new HashSet<>();
        Set<Conterparty> conterparty4Set = new HashSet<>();
        Set<Conterparty> conterparty5Set = new HashSet<>();
        Set<Conterparty> conterparty6Set = new HashSet<>();
        CounterpartyGroup group = new CounterpartyGroup(new HashMap<Conterparty, Map<Project, Set<Conterparty>>>());
        ConterpartyByProject conterparty1 = new ConterpartyByProject("\"Ромашка\",ООО");
        ConterpartyByProject conterparty2 = new ConterpartyByProject("\"Лютик\",ООО");
        ConterpartyByProject conterparty3 = new ConterpartyByProject("\"Розочка\",ООО");
        ConterpartyByProject conterparty4 = new ConterpartyByProject("\"Тюльпан\",ООО");
        ConterpartyByProject conterparty5 = new ConterpartyByProject("\"Кактус\",ООО");
        ConterpartyByProject conterparty6 = new ConterpartyByProject("\"Лилия\",ООО");


        Project project1 = new InvestProject("Крымский мост");
        Project project2 = new InvestProject("Японский трубопровод");
        Project project3 = new InvestProject("Сахалинский мост");
        Project project4 = new InvestProject("Шелковый путь");

        conterparty1.includeInProject(group, project1);
        conterparty2.includeInProject(group, project1);
        conterparty3.includeInProject(group, project1);
//        conterparty3.includeInProject(group, project2);
        conterparty4.includeInProject(group, project2);
        conterparty5.includeInProject(group, project2);
//        conterparty5.includeInProject(group, project3);
        conterparty6.includeInProject(group, project3);
        conterparty1.includeInProject(group, project3);
//        conterparty2.includeInProject(group, project4);
        conterparty6.includeInProject(group, project4);



        project1.printProject();
        System.out.println("\n");

        project2.printProject();
        System.out.println("\n");

        project3.printProject();
        System.out.println("\n");

        project4.printProject();
        System.out.println("\n");




//        System.out.println("Группы контрагентов: ");
//        System.out.println(group);
//
//
//        System.out.println(project1);
        conterparty1Set = group.getConterpartySet(conterparty1);
        printConterpartySet(conterparty1Set, conterparty1);

        conterparty2Set = group.getConterpartySet(conterparty2);
        printConterpartySet(conterparty2Set, conterparty2);

        conterparty3Set = group.getConterpartySet(conterparty3);
        printConterpartySet(conterparty3Set, conterparty3);

        conterparty4Set = group.getConterpartySet(conterparty4);
        printConterpartySet(conterparty4Set, conterparty4);

        conterparty5Set = group.getConterpartySet(conterparty5);
        printConterpartySet(conterparty5Set, conterparty5);

        conterparty6Set = group.getConterpartySet(conterparty6);
        printConterpartySet(conterparty6Set, conterparty6);
//
//        System.out.println("Связанные лиза для " + conterparty1 + ": ");
//        System.out.println(conterpartySet.toString());


    }

    public static void printConterpartySet(Set<Conterparty> set, Conterparty conterparty){
        String pattern = "%-5s %-22s%n";
        System.out.println("\u2606".repeat(5) + " Группа связанных лиц для контрагента: " + conterparty.getName() + " " + "\u2606".repeat(5));
        //System.out.println("Участники проекта: ");
        System.out.printf(pattern, "Код", "Контрагент");
        int i = 0;
        for (Conterparty conterpartyInfo : set
        ) {
            System.out.printf(
                    pattern,
                    ++i + ".",
                    conterpartyInfo.getName());
        }

    }
}
