package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void main() {
        Main main = new Main();
        assertEquals(true, Main.main());
    }
}