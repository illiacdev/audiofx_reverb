//
// Created by illiacDev on 2018-03-17.
//
#include <jni.h>
#include <string>

extern "C"
JNIEXPORT void JNICALL
Java_com_example_illiacdev_myapplication_DSP_reverb_1process(JNIEnv *env, jobject instance,
                                                             jshortArray pcm_data_) {
    jshort *pcm_data = env->GetShortArrayElements(pcm_data_, NULL);
    int length = env->GetArrayLength(pcm_data_);

    // TODO

    env->ReleaseShortArrayElements(pcm_data_, pcm_data, 0);
}