package org.academiadecodigo.hexaltistas.service;

import org.academiadecodigo.hexaltistas.model.Model;
import org.academiadecodigo.hexaltistas.model.Places;
import org.academiadecodigo.hexaltistas.model.User;
import org.academiadecodigo.hexaltistas.persistence.dao.Dao;
import org.academiadecodigo.hexaltistas.persistence.dao.PlacesDao;
import org.academiadecodigo.hexaltistas.persistence.jpa.JpaTransactionManager;

public class PlacesService {

    private JpaTransactionManager tm;
    private PlacesDao placesDao;


    public String getPlaceInfo(Integer id) {
        Places place = placesDao.findById(id);
        return place.getInfo();
    }

    public void setTm(JpaTransactionManager tm) {
        this.tm = tm;
    }

    public String getPlaceName(Integer id) {
        Places place = placesDao.findById(id);
        return place.getName();
    }
}
