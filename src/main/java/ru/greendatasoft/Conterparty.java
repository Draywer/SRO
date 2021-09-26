package ru.greendatasoft;

public class Conterparty {

    private String name;

    public Conterparty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ConterpartyByDeal{" +
                "name='" + name + '\'' +
                '}';
    }
}
