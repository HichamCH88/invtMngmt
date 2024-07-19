package com.hicham.stockmanagment.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Client")
public class Client extends AbstractEntity{

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Embedded
    private address address;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumbre")
    private String phoneNum;

    @OneToMany(mappedBy = "client")
    private List<ClientOrder> clientOrders;


}
