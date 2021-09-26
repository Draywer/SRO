package ru.greendatasoft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConterpartyByProject extends ConterpartyByDeal implements InvestProjectParty, GroupParty {
    public ConterpartyByProject(String name) {
        super(name);
    }

    public void includeInProject(CounterpartyGroup group, Project project) {
        project.getConterpartySet().add(this);
        includeInGroup(group, project);
        group.updateGroup(project);

    }

    public boolean includeInGroup(CounterpartyGroup group, Project project) {
        boolean result = false;
        if (group.getGroup().containsKey(this)) {
            if (group.getGroup().get(this).containsKey(project)) {
                result = group.getGroup().get(this).get(project).add(this);
            } else {
                group.getGroup().get(this).put(project, new HashSet<Conterparty>());
                result = group.getGroup().get(this).get(project).add(this);
            }
        } else {
            group.getGroup().put(this, new HashMap<Project, Set<Conterparty>>());
            group.getGroup().get(this).put(project, new HashSet<Conterparty>());
            result = group.getGroup().get(this).get(project).add(this);
        }

//        for (Map<Project, Set<Conterparty>> setEntry: group.getGroup().values()
//             ) {
//            if (setEntry.containsKey(project)){
//                setEntry.get(project).add(this);
//            }
//        }

        return result;
    }

    @Override
    public String toString() {
        return getName();
    }

}
