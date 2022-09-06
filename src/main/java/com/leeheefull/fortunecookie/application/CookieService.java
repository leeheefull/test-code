package com.leeheefull.fortunecookie.application;

import com.leeheefull.fortunecookie.utils.CookieConverter;
import com.leeheefull.fortunecookie.domain.Cookie;
import com.leeheefull.fortunecookie.dto.CookieResponse;
import com.leeheefull.fortunecookie.dto.CreateCookieRequest;
import com.leeheefull.fortunecookie.Infrastructure.CookieRepository;
import com.leeheefull.fortunecookie.utils.RandomStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CookieService {

    private final CookieRepository cookieRepository;

    public CookieResponse create(CreateCookieRequest request) {
        var cookie = cookieRepository.save(Cookie.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build());
        return CookieConverter.toPostResponse(cookie);
    }

    @Transactional(readOnly = true)
    public CookieResponse draw(RandomStrategy randomNumber) {
        Long range = cookieRepository.count();
        Long cookieId = randomNumber.randomable(range);

        var cookie = cookieRepository.findById(cookieId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 포춘 쿠키입니다."));

        return CookieConverter.toPostResponse(cookie);
    }

}
