package com.fooddelivery.delivery.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="delivery")
public class DeliveryTeam 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="delivery_person_id")
    long deliveryPersonId;

    @Column(name="delivery_person_name")
    String deliveryPersonName;

    @Column(name="delivery_person_mobile_no")
    long mobileNumber;

    @Column(name="delivery_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yy-MM-dd")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date deliveryDate;

    @Column(name="delivery_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss",timezone = "UTC")
    @Temporal(TemporalType.TIME)
    @NotNull
    private Date deliveryTime;

    @Column(name="delivery_status")
    private String deliveryStatus;


}
