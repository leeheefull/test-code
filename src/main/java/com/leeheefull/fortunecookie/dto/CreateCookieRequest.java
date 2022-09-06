package com.leeheefull.fortunecookie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCookieRequest {

    private String title;
    private String content;

}
