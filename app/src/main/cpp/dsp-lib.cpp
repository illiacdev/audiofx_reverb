//
// Created by illiacDev on 2018-03-17.
//
#include <jni.h>
#include <string>
#include "DSP.h"


extern "C"
JNIEXPORT void JNICALL
Java_com_example_illiacdev_myapplication_DSP_reverb_1process(JNIEnv *env, jobject instance,
                                                             jbyteArray pcm_data_) {
    static DSP *dsp = new DSP();
    jbyte *pcm_data = env->GetByteArrayElements(pcm_data_, NULL);
    int length = env->GetArrayLength(pcm_data_);

    dsp->audioFX_Reverb_Process((short*)pcm_data, length);

    env->ReleaseByteArrayElements(pcm_data_, pcm_data, 0);
}
