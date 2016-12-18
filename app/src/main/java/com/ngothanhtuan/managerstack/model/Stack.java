package com.ngothanhtuan.managerstack.model;

/**
 * Created by MyPC on 12/18/2016.
 */

public class Stack extends Project {
    private String nameStack, idStack, detailStack;

    public String getDetailStack() {
        return detailStack;
    }

    public void setDetailStack(String detailStack) {
        this.detailStack = detailStack;
    }

    public String getIdStack() {
        return idStack;
    }

    public void setIdStack(String idStack) {
        this.idStack = idStack;
    }

    public String getNameStack() {
        return nameStack;
    }

    public void setNameStack(String nameStack) {
        this.nameStack = nameStack;
    }

    public Stack() {
    }

    public Stack(String detailPR, String idPR, String namePR, String typePR, String detailStack, String idStack, String nameStack) {
        super(detailPR, idPR, namePR, typePR);
        this.detailStack = detailStack;
        this.idStack = idStack;
        this.nameStack = nameStack;
    }
}
