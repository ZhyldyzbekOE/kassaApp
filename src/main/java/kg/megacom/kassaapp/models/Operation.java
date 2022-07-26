package kg.megacom.kassaapp.models;

import kg.megacom.kassaapp.enums.OperStatus;

import java.util.Date;

public class Operation {

    private Integer id;
    private Date addDate;
    private double total;
    private OperStatus status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
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
}
