package tests.tests.factory;

import entities.Financing;

public class FinancingFactory {
    public static Financing createEmptyValidFinancing() {
        return new Financing(100000.0, 2000.0, 80);
    }
}
