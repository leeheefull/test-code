package com.leeheefull.fortunecookie.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberStrategy implements RandomStrategy {

    @Override
    public Long randomable(Long range) {
        return ThreadLocalRandom.current()
                .nextLong(1, range + 1);
    }

}
