package com.endlesscreation.spring.services;

import org.springframework.stereotype.Service;

@Service
public class StringService {

    public String append(String string1, String string2) {
        return string1 + string2;
    }

    public int length(String string) {
        return string.length();
    }

    public char charAt(String string, int idx) {
        return string.charAt(idx);
    }

    public boolean equals(String string1, String string2) {
        return string1.equals(string2);
    }
}