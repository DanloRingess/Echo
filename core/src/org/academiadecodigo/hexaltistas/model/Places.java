package org.academiadecodigo.hexaltistas.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
@Entity
@Table (name = "places")
public class Places {

    @Id
    private Integer id;
    private String name;
    private String info;
    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "places",
            fetch = FetchType.EAGER
    )
    private List<Shout> shoutList= new LinkedList<Shout>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Shout> getShoutList() {
        return shoutList;
    }

    public void setShoutList(List<Shout> shoutList) {
        this.shoutList = shoutList;
    }

    public void addShout(Shout shout){
        shoutList.add(shout);
    }
}
