package com.madrasati.backend.service;

import com.madrasati.backend.model.Bulletin;
import com.madrasati.backend.repository.BulletinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulletinService {
    private static final Logger log = LoggerFactory.getLogger(BulletinService.class);

    @Autowired
    private BulletinRepository repository;

    public List<Bulletin> findAll() {
        return repository.findAll();
    }

    public Bulletin save(Bulletin bulletin) {
        return repository.save(bulletin);
    }

    public void delete(Long id) {
        log.debug("deleting bulletin #" + id);
        repository.deleteById(id);
    }
}
