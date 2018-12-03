package model.entity;

public class Request {
    private int id;
    private int exhibitionId;
    private int userId;
    private int paymentId;

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

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", exhibitionId=" + exhibitionId +
                ", userId=" + userId +
                ", paymentId=" + paymentId +
                '}';
    }
}
