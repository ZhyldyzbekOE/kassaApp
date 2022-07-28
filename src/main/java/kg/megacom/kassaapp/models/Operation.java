package kg.megacom.kassaapp.models;

import kg.megacom.kassaapp.enums.OperStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class Operation {

    private Integer id;
    private LocalDateTime addDate;
    private double total;
    private OperStatus status;

    private User user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDateTime addDate) {
        this.addDate = addDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public OperStatus getStatus() {
        return status;
    }

    public void setStatus(OperStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
