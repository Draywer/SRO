package ru.greendatasoft;

import java.util.HashSet;

public class InvestProject extends Project {
    private String projName;

    public InvestProject(String projName) {
        super(new HashSet<Conterparty>());
        this.projName = projName;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    @Override
    public String toString() {
        return "InvestProject{" +
                "projName='" + projName + '\'' +
                '}';
    }
}
