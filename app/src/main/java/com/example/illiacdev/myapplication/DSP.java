package com.example.illiacdev.myapplication;

/**
 * Created by illiacDev on 2018-03-17.
 */

public class DSP {
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("dsp-lib");
    }

    public native void reverb_process(short[] pcm_data);
}
