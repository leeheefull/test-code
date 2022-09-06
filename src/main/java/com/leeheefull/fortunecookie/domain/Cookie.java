package com.leeheefull.fortunecookie.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Cookie {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    @Builder
    public Cookie(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
