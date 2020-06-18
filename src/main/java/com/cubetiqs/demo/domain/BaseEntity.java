package com.cubetiqs.demo.domain;

import com.cubetiqs.demo.Constants;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseEntity<ID extends Serializable> implements Serializable, Persistable<ID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ID id;

    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = Constants.STATUS)
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public ID getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    @PrePersist
    public void beforeSave() {
        if (createdDate == null) {
            createdDate = new Date();
        }
    }
}
