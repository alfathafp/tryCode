package com.company;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThat;

public class Assertion {

    @Test
    public void AssertionTest(){
        int myNumber = 10;
        int herNumber = 12;
        int hisNumber = 10;
        assertThat(myNumber).is(herNumber);

    }

}
