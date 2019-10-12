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



    public Provider save(Provider p) {
        return providerRepository.saveAndFlush(p);
    }

    public Provider update(Provider p) {
        return providerRepository.save(p);
    }

    public Provider find(String userName) {
        return providerRepository.findOneByPname(userName);
    }

    public Provider find(Long id) { return providerRepository.findOne(id); }

    public List<Provider> findAll() { return providerRepository.findAll();}
}


