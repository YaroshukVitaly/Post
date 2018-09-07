package by.yaroshuk.post;

import javafx.scene.chart.PieChart;

import java.util.Date;

public class Message {

    public enum MassageCategory {
            REGULAR, SPECIAL, FIRST_CLASS
    }
    private MassageCategory category;
    private String sender;
    private String address;
    private String receiver;
    private long id;
    private Date date;

    public Message(MassageCategory category, String sender, String address, String receiver) {
        this.category = category;
        this.sender = sender;
        this.address = address;
        this.receiver = receiver;
        this.date = new Date();
    }

    public MassageCategory getCategory() {
        return category;
    }

    public void setCategory(MassageCategory category) {
        this.category = category;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "category=" + category +
                ", sender='" + sender + '\'' +
                ", address='" + address + '\'' +
                ", receiver='" + receiver + '\'' +
                ", id=" + id +
                ", date=" + date +
                '}';
    }
}
