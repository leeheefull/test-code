package com.leeheefull.fortunecookie.Infrastructure;

import com.leeheefull.fortunecookie.domain.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookieRepository extends JpaRepository<Cookie, Long> {
}
