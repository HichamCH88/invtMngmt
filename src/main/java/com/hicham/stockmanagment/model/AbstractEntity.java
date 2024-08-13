package com.hicham.stockmanagment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.Date;

import java.io.Serializable;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    public Integer id;

    @CreationTimestamp
    @Column(name="CreationDate",nullable = false)
    @JsonIgnore
    private Instant creationDate;

    @UpdateTimestamp
    @Column(name="LastModifiedDate")
    @JsonIgnore
    private Instant lastUpdateDate;

}
