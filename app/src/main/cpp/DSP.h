//
// Created by illiacDev on 2018-03-17.
//

#ifndef MYAPPLICATION2_DSP_H
#define MYAPPLICATION2_DSP_H

#include <SuperpoweredDecoder.h>
#include "malloc.h"

class DSP {
    float *floatBuffer = (float *) memalign(16, (44100 * 5 + 16) * sizeof(float) * 2);

};


#endif //MYAPPLICATION2_DSP_H
