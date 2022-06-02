package com.sms.security.model.forUsers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name="all_ip")
public class IpAll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rest_adress")
    private String restAdress;

    @Column(name = "ip_v6")
    private String ip;

    @Column(name = "time")
    private String time;

    @Column(name = "date")
    private String date;

    public IpAll(String restAdress, String ip, String time,String date) {
        this.restAdress = restAdress;
        this.ip = ip;
        this.time=time;
        this.date=date;
    }

}
