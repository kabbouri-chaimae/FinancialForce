package com.social.services;

import com.social.dao.ProviderRepository;
import com.social.entities.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    ProviderRepository  providerRepository ;



    public Provider save(Provider user) {
        return providerRepository.saveAndFlush(user);
    }

    public Provider update(Provider user) {
        return providerRepository.save(user);
    }

    public Provider find(String userName) {
        return providerRepository.findOneByPname(userName);
    }

    public Provider find(Long id) { return providerRepository.findOne(id); }

    public List<Provider> findAll() { return providerRepository.findAll();}
}


