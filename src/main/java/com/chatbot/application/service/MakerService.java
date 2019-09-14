package com.chatbot.application.service;

import com.chatbot.application.domain.maker.Maker;
import com.chatbot.application.domain.maker.MakerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MakerService {

    private MakerRepository repository;

    public List<Maker> getMakers(){
        return repository.findAll();
    }

    public Maker getMaker(int makerNo) {
        return repository.findByNo(makerNo);
    }
}
