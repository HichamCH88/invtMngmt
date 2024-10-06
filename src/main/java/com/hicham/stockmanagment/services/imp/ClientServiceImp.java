package com.hicham.stockmanagment.services.imp;

import com.hicham.stockmanagment.DTO.ArticleDTO;
import com.hicham.stockmanagment.DTO.ClientDTO;
import com.hicham.stockmanagment.exception.EntityNotFoundException;
import com.hicham.stockmanagment.exception.ErrorCode;
import com.hicham.stockmanagment.exception.InvalidEntityException;
import com.hicham.stockmanagment.model.Client;
import com.hicham.stockmanagment.repository.ClientRepository;
import com.hicham.stockmanagment.services.ClientService;
import com.hicham.stockmanagment.validator.ClientValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ClientDTO findById(Integer id) {
        if(id==null){
            log.error("null");
            throw new InvalidEntityException("invalid");
        }
        Optional<Client> client=clientRepository.findById(id);
        return Optional.ofNullable(ClientDTO.fromEntity(client.orElse(null))).orElseThrow(() ->
                new EntityNotFoundException("Client not found",ErrorCode.CLIENT_NOT_Found));
    }


    @Override
    public ClientDTO update(ClientDTO clientDTO) {
        return null;
    }

    @Override
    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream().map(ClientDTO::fromEntity).toList();
    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            log.error("Id is null");
            throw new InvalidEntityException("Id cant be null");
        }
        clientRepository.deleteById(id);
    }
}
