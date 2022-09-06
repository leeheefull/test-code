package com.leeheefull.fortunecookie.utils;

import com.leeheefull.fortunecookie.domain.Cookie;
import com.leeheefull.fortunecookie.dto.CookieResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CookieConverter {

    public CookieResponse toPostResponse(Cookie cookie) {
        return new CookieResponse(
                cookie.getId(),
                cookie.getTitle(),
                cookie.getContent()
        );
    }

}
