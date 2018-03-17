//
// Created by illiacDev on 2018-03-17.
//

#ifndef MYAPPLICATION2_DSP_H
#define MYAPPLICATION2_DSP_H

#include <SuperpoweredDecoder.h>
#include "SuperpoweredReverb.h"
#include "malloc.h"

class DSP {
public:
    float *floatBuffer = (float *) memalign(16, (44100 * 5 + 16) * sizeof(float) * 2);
    SuperpoweredReverb *reverb;
    void audioFX_Reverb_Process(short* pcm,int samples);
public:
    DSP();



};


#endif //MYAPPLICATION2_DSP_H
