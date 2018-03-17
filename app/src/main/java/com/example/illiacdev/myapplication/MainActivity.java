package com.example.illiacdev.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.illiacdev.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private ActivityMainBinding bind;

    //    private int mAudioSource = MediaRecorder.AudioSource.MIC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        bind = DataBindingUtil.setContentView(this,
                                              R.layout.activity_main);

        new CheckEnvironment(this).checkPermission();
        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
        bind.sampleText.setText(stringFromJNI());

        bind.button.setOnClickListener(v -> {
            playMusic();

//            recorder
        });
    }

    private void playMusic() {
        new Thread(() -> {
            new AudioPlayer().play();

        }).start();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
