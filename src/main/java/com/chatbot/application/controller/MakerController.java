package com.chatbot.application.controller;

import com.chatbot.application.domain.maker.Maker;
import com.chatbot.application.service.MakerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MakerController {

    private MakerService service;

    @GetMapping("/api/makers")
    public List<Maker> getMakers(){
        return service.getMakers();
    }

    @GetMapping("api/maker/{no}")
    public Maker getMaker(@PathVariable int no){
        return service.getMaker(no);
    }
}
