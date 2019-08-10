package ru.leonidivankin.photoapp_mvvm.model.data;

import java.util.List;

import ru.leonidivankin.photoapp_mvvm.model.entity.Hit;

public class Data {
    private List<Hit> hitList;

    public List<Hit> getHitList() {
        return hitList;
    }

    public void setHitList(List<Hit> hitList) {
        this.hitList = hitList;
    }
}
