package model.entity;

import java.util.Date;

public class Exhibition {
    private int id;
    private Date startDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date sartDate) {
        this.startDate = sartDate;
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
                ", sartDate=" + startDate +
                ", endDate=" + endDate +
                ", name='" + name + '\'' +
                ", thema='" + thema + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
