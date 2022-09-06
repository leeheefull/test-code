package com.leeheefull.fortunecookie.unit;

import com.leeheefull.fortunecookie.Infrastructure.CookieRepository;
import com.leeheefull.fortunecookie.application.CookieService;
import com.leeheefull.fortunecookie.domain.Cookie;
import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.generator.FieldReflectionArbitraryGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CookieServiceTest {

    @Mock
    private CookieRepository cookieRepository;

    @InjectMocks
    private CookieService cookieService;

    private static final FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
            .defaultGenerator(FieldReflectionArbitraryGenerator.INSTANCE)
            .nullInject(0)
            .build();

    @Test
    public void 포춘쿠키_랜덤_뽑기() {
        // given
        Long cookieCount = 10L;
        Long expectedCookieId = 2L;
        var expectedCookie = fixtureMonkey.giveMeBuilder(Cookie.class)
                .set("id", expectedCookieId)
                .sample();

        // mocking
        Mockito.when(cookieRepository.count())
                .thenReturn(cookieCount);
        Mockito.when(cookieRepository.findById(expectedCookieId))
                .thenReturn(Optional.ofNullable(expectedCookie));

        // when
        var actual = cookieService.draw(range -> expectedCookieId);

        // then
        assertEquals(expectedCookie.getTitle(), actual.getTitle());
    }

}
