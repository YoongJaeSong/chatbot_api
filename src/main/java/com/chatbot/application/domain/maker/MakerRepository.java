package com.chatbot.application.domain.maker;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MakerRepository extends JpaRepository<Maker, Long> {
    Maker findByNo(int makerNo);
}
