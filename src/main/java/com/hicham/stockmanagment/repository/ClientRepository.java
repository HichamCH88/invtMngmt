package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    Client findClientByFirstName(String firstName);

}
