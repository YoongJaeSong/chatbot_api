package com.chatbot.application.domain.color;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "color")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 30)
    private String color;

    @Column(length = 7, columnDefinition = "char(7)")
    private String rgb;

    @Builder
    public Color(String color, String rgb) {
        this.color = color;
        this.rgb = rgb;
    }
}
