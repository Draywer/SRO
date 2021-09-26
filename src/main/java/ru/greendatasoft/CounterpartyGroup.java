package ru.greendatasoft;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CounterpartyGroup {
    private Set<Conterparty> conterpartiesSet;
    private Map<Conterparty, Map<Project, Set<Conterparty>>> group;

    public Set<Conterparty> getConterpartySet(Conterparty conterparty) {
        conterpartiesSet = new HashSet<>();
        setConterpartyGroup(conterparty);
        setGroupConterpartyFinal();
        return conterpartiesSet;
    }

    private void setConterpartyGroup(Conterparty conterparty) {
        //Set<Conterparty> conterpartySet = new HashSet<>();

//        if (group.containsKey(conterparty)) {
//            Map<Project, Set<Conterparty>> conterpartyMap = group.get(conterparty);
//            for (Set<Conterparty> conterparties : conterpartyMap.values()
//            ) {
//                for (Conterparty conterparty1 : conterparties
//                ) {
//                    conterpartiesSet.add(conterparty1);
//                    getGroup(conterparty1);
//                }
//            }
//        }
        if (group.containsKey(conterparty)) {
            Map<Project, Set<Conterparty>> conterpartyMap = group.get(conterparty);
            for (Set<Conterparty> conterparties : conterpartyMap.values()
            ) {
                conterpartiesSet.addAll(conterparties);
            }
        }
    }

    private void setGroupConterpartyFinal() {
        Set<Conterparty> set = new HashSet<>(conterpartiesSet);
        for (Conterparty conterparty1: set
             ) {
            setConterpartyGroup(conterparty1);
        }
        if (!set.containsAll(conterpartiesSet)){
            setGroupConterpartyFinal();
        }

    }

    public void updateGroup(Project project) {
        for (Map.Entry<Conterparty, Map<Project, Set<Conterparty>>> mapMap : group.entrySet()
        ) {
            if (mapMap.getValue().containsKey(project)) {
                mapMap.getValue().get(project).addAll(project.getConterpartySet());
            }
        }

    }

    public Map<Conterparty, Map<Project, Set<Conterparty>>> getGroup() {
        return group;
    }

    public CounterpartyGroup(Map<Conterparty, Map<Project, Set<Conterparty>>> group) {
        this.group = group;
    }

    public Map<Conterparty, Map<Project, Set<Conterparty>>> setConterpartyGroup() {
        return group;
    }

    public void setGroup(Map<Conterparty, Map<Project, Set<Conterparty>>> group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "CounterpartyGroup{" +
                "group=" + group +
                '}';
    }
}