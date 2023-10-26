package org.alexandra.bajura;

import org.alexandra.bajura.api.CakeApi;

public class Main {
    private static CakeApi cakeApi;

    public static void main(String[] args) {
        cakeApi.getCakeByPosition(5);
    }
}
