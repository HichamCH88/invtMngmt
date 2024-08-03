package com.hicham.stockmanagment.controller.api;

import com.hicham.stockmanagment.DTO.ClientDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClientApi {

    @PostMapping(value = "Client/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDTO save(@RequestBody ClientDTO dto );

}
