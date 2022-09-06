package com.leeheefull.fortunecookie.integration.setup;

import com.leeheefull.fortunecookie.Infrastructure.CookieRepository;
import com.leeheefull.fortunecookie.domain.Cookie;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@Disabled
public class CookieSetUp {

    @Autowired
    private CookieRepository cookieRepository;

    public static final String COOKIE_TITLE = "test title";
    public static final String COOKIE_CONTENT = "test content";

    public void saveTenCookies() {
        IntStream.range(1, 10)
                .forEach(i -> cookieRepository.save(Cookie.builder()
                        .title(COOKIE_TITLE + i)
                        .content(COOKIE_CONTENT + i)
                        .build()));
    }

}
