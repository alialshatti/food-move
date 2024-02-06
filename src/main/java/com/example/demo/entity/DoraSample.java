package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@ToString
@Table(name = "dora_samples")
public class DoraSample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "editor_by", nullable = false)
    private Long editorBy;

    @Column(name = "name_lap", nullable = false, length = 191)
    private String nameLap;

    @Column(name = "checkout_sites_id", nullable = false)
    private Long checkoutSitesId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "type", nullable = false, length = 255)
    private String type;

    @Column(name = "send_date", length = 191)
    private String sendDate;

    @Column(name = "expired_date", length = 191)
    private String expiredDate;

    @Column(name = "date_result", length = 191)
    private String dateResult;

    @Column(name = "date_of_re_analystic", length = 191)
    private String dateOfReAnalytic;

    @Column(name = "img", nullable = false, length = 255)
    private String img;

    @Column(name = "operating_num", length = 255, unique = true)
    private String operatingNum;

    @Column(name = "result", nullable = false)
    private String result;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "reason_not_active", length = 191)
    private String reasonNotActive;

    @Lob
    @Column(name = "note")
    private String note;

    @Column(name = "is_end_re_analystic", nullable = false)
    private Boolean isEndReAnalytic;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "date_hijiri")
    @Temporal(TemporalType.DATE)
    private Date dateHijiri;

    @Column(name = "archives", length = 191)
    private String archives;

    // Getters and setters, other methods...

}
