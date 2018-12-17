package model.entity;

import java.time.LocalDate;
import java.util.Date;

public class Exhibition {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String name;
    private String thema;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate sartDate) {
        this.startDate = sartDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
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
