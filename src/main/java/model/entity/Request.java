package model.entity;

public class Request {
    private int id;
    private int exhibitionId;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(int exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", exhibitionId=" + exhibitionId +
                ", userId=" + userId +
                '}';
    }
}
