package com.leeheefull.fortunecookie.presentation;

import com.leeheefull.fortunecookie.application.CookieService;
import com.leeheefull.fortunecookie.dto.CookieResponse;
import com.leeheefull.fortunecookie.dto.CreateCookieRequest;
import com.leeheefull.fortunecookie.utils.RandomNumberStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cookies")
public class CookieController {

    private final CookieService cookieService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CookieResponse create(@RequestBody CreateCookieRequest request) {
        return cookieService.create(request);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping
    public CookieResponse get() {
        return cookieService.draw(new RandomNumberStrategy());
    }

}
