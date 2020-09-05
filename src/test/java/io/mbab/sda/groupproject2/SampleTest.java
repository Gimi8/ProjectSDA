package io.mbab.sda.groupproject2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SampleTest {

    @Test
    void shouldDoSomething() {
        //given
        int value = 1;
        int expectedValue = 7;

        //when
        int actualValue =  value +  3;

        //then
        Assertions.assertEquals(expectedValue, actualValue);
    }
}
