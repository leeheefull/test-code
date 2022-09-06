package com.leeheefull.fortunecookie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CookieResponse {

    private Long id;
    private String title;
    private String content;

}
