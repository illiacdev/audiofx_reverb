package com.example.illiacdev.myapplication;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Environment;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by illiacDev on 2018-03-17.
 */

public class AudioPlayer {
    private int mSampleRate = 44100;
    private int mChannelCount = AudioFormat.CHANNEL_IN_STEREO;
    private int mAudioFormat = AudioFormat.ENCODING_PCM_16BIT;
    private int mBufferSize = AudioTrack.getMinBufferSize(mSampleRate, mChannelCount, mAudioFormat);

    private AudioTrack mAudioTrack;

    public AudioPlayer() {

        // AudioTrack 생성
        mAudioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, mSampleRate,
                                     mChannelCount,
                                     mAudioFormat,
                                     AudioTrack.getMinBufferSize(mSampleRate,
                                                                 mChannelCount,
                                                                 mAudioFormat),
                                     AudioTrack.MODE_STREAM);
    }

    public void play() {

        String path = getDownloadDir() + File.separatorChar + "m1.snd";
        new Thread(() -> {
            byte[] writeData = new byte[mBufferSize];
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            DataInputStream dis = new DataInputStream(fis);
            mAudioTrack.play();  // write 하기 전에 play 를 먼저 수행해 주어야 함

            while (true) {

                int ret = 0;
                try {
                    ret = dis.read(writeData, 0, mBufferSize);
                    if (ret <= 0)
                        break;
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }

                mAudioTrack.write(writeData, 0, ret); // AudioTrack 에 write 를 하면 스피커로 송출됨
            }

        }).start();

    }

    static public String getDownloadDir() {
        File directory = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS);
        return directory.getAbsolutePath();
    }

}
