package com.example.exercise15_0.service.impl;

import com.example.exercise15_0.dao.ActorRepository;
import com.example.exercise15_0.domain.Actor;
import com.example.exercise15_0.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> read() {
        return actorRepository.findAll();
    }
}
