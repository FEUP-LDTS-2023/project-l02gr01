package com.l02gr01.escape.audio;

import com.l02gr01.escape.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AudioManagerTest {
    AudioManager test;
    @BeforeEach
    public void setup(){
        test = AudioManager.getInstance();
    }
    @Test
    public void testgetInstance() {
        assertNotEquals(test, null);
        assertEquals(test, AudioManager.getInstance());
    }


}
