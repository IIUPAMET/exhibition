package model.entity;

import java.util.Date;

public class Exhibition {
    private int id;
    private Date sartDate;
    private Date endDate;
    private String name;
    private String thema;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSartDate() {
        return sartDate;
    }

    public void setSartDate(Date sartDate) {
        this.sartDate = sartDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Exhibition{" +
                "id=" + id +
                ", sartDate=" + sartDate +
                ", endDate=" + endDate +
                ", name='" + name + '\'' +
                ", thema='" + thema + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
