package com.farmaciaya.security;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by nachogarrone on 13/10/15.
 */
public class TokenGenerator {
    private static SecureRandom random = new SecureRandom();

    public static String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }
}
