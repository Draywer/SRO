package ru.greendatasoft;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Project {
    private String projName;
    private Set<Conterparty> conterpartySet;

    public Project(Set<Conterparty> conterpartySet) {
        this.conterpartySet = conterpartySet;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public Set<Conterparty> getConterpartySet() {
        return conterpartySet;
    }

    public void setConterpartySet(Set<Conterparty> conterpartySet) {
        this.conterpartySet = conterpartySet;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projName='" + projName + '\'' +
                ", conterpartySet=" + conterpartySet +
                '}';
    }

    public void printProject() {
        String pattern = "%-5s %-22s%n";
        System.out.println("\u2605".repeat(5) + " Инвестиционный проект: " + this.getProjName() + " " + "\u2605".repeat(5));
        System.out.println("Участники проекта: ");
        System.out.printf(pattern, "Код", "Контрагент");
        int i = 0;
        for (Conterparty conterparty : conterpartySet
        ) {
            System.out.printf(
                    pattern,
                    ++i + ".",
                    conterparty.getName());
        }
    }
}
