package com.example.illiacdev.myapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by illiacDev on 2018-03-17.
 */
public class DSPTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFunc()
    {

        assertThat(1,is(1));

        new DSP().reverb_process(new short[10]);

    }

}