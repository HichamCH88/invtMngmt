package com.hicham.stockmanagment.services;

import com.hicham.stockmanagment.DTO.ClientOrderDTO;
import com.hicham.stockmanagment.DTO.ClientOrderLineDTO;
import com.hicham.stockmanagment.model.Enums.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientOrderService {

    ClientOrderDTO save(ClientOrderDTO clientOrderDTO);

    List<ClientOrderDTO> findAll();

    ClientOrderDTO findById(Integer id);

    ClientOrderDTO findByCode(String code);

    void deleteById(Integer id);

    List<ClientOrderLineDTO> findOrderLinesById(Integer clientOrderId);

    List<ClientOrderDTO> findOrdersByClientId(Integer id);


    List<ClientOrderDTO> findOrdersByOrderStatus(OrderStatus status);
}
