package com.hicham.stockmanagment.services.imp;

import com.hicham.stockmanagment.DTO.ArticleDTO;
import com.hicham.stockmanagment.DTO.ClientDTO;
import com.hicham.stockmanagment.exception.ErrorCode;
import com.hicham.stockmanagment.exception.InvalidEntityException;
import com.hicham.stockmanagment.repository.ClientRepository;
import com.hicham.stockmanagment.services.ClientService;
import com.hicham.stockmanagment.validator.ClientValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImp implements ClientService {
    private static final Logger log = LoggerFactory.getLogger(ClientServiceImp.class);

    ClientRepository clientRepository;

    ClientServiceImp(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        List<String> errors=new ArrayList<>();//= ClientValidator.validate(clientDTO);
        if(!errors.isEmpty()){
            log.error("Client is invalid");
            errors.forEach(System.out::println);
            throw new InvalidEntityException("client is invalid", ErrorCode.CLIENT_NOT_Found,errors);
        }
        return ClientDTO.fromEntity(clientRepository.save(ClientDTO.toEntity(clientDTO))) ;
    }

    @Override
    public ClientDTO findById(ClientDTO clientDTO) {
        return null;
    }

    @Override
    public ClientDTO findByCode(ClientDTO clientDTO) {
        return null;
    }

    @Override
    public ClientDTO update(ClientDTO clientDTO) {
        return null;
    }

    @Override
    public List<ClientService> findAll() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {

    }
}
