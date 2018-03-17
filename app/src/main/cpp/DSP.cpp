//
// Created by illiacDev on 2018-03-17.
//

#include <SuperpoweredSimple.h>
#include "DSP.h"

DSP::DSP() {
    reverb = new SuperpoweredReverb(44100);
    reverb->enable(true);
    reverb->setMix(0.5); //  Limited to >= 0.0f and <= 1.0f.
    reverb->setRoomSize(0.5); // Limited to >= 0.0f and <= 1.0f.
}

void DSP::audioFX_Reverb_Process(short* pcm, int samples) {
    SuperpoweredShortIntToFloat(pcm, floatBuffer, samples / 2);
    reverb->process(floatBuffer, floatBuffer, samples / 2);
    SuperpoweredFloatToShortInt(floatBuffer, pcm, samples / 2);
}
