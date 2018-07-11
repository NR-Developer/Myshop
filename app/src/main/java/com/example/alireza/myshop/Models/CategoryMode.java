package com.example.alireza.myshop.Models;

public class CategoryMode {
    public String ID;
    public String ID_parent;
    public String Tittle;
    public String Pic;

    public String getPic() {
        return Pic;
    }

    public void setPic(String pic) {
        Pic = pic;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID_parent() {
        return ID_parent;
    }

    public void setID_parent(String ID_parent) {
        this.ID_parent = ID_parent;
    }


}
