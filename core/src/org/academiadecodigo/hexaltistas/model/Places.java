package org.academiadecodigo.hexaltistas.model;

import java.util.LinkedList;
import java.util.List;

public class Places {

    private String name;
    private String info;
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
}
