package org.academiadecodigo.hexaltistas.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
@Entity
@Table (name = "users")
public class User {

    @Id
    private Integer id;
    private String name;
    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "places",
            fetch = FetchType.EAGER
    )
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

    public void addShout(Shout shout, Places places){
        shouted.add(shout);
        voted.put(places, shout);

    }

    public User getUser(){
        return this;
    }
}
