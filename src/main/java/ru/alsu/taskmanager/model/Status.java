package ru.alsu.taskmanager.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    Integer statusId;

    @Column(name = "status_name", nullable = false)
    String statusName;


    public Status() {
    }

    public Status(String statusName) {

        this.statusName = statusName;
    }

    public Status(Integer statusId, String statusName){
        this.statusId = statusId;
        this.statusName = statusName;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}

