package org.academiadecodigo.hexaltistas.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class User {

    private Integer id;
    private String name;
    private List<Shout> shouted = new LinkedList<Shout>();
    private HashMap<Places, Shout> voted = new HashMap<Places, Shout>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shout> getShouted() {
        return shouted;
    }

    public void setShouted(List<Shout> shouted) {
        this.shouted = shouted;
    }

    public HashMap<Places, Shout> getVoted() {
        return voted;
    }

    public void setVoted(HashMap<Places, Shout> voted) {
        this.voted = voted;
    }
}
