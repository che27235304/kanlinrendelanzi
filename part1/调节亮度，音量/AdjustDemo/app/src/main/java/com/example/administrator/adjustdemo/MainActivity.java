package com.example.administrator.adjustdemo;

import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SeekBar voice_seekbar;
    private SeekBar light_seekbar;
    private TextView voice_tv;
    private TextView light_tv;
    private AudioManager mAudioManager;
    // 最大音量
    private int maxVolume;
    // 当前音量
    private int currentVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取AudioManager实例  它是控制音量的一个操作
        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        //mAudioManager是系统定义控制音量的对象

        initViews();
        initLight();
        initVolume();
    }

    /*
     * 获取当前屏幕亮度
     */
    private void initLight() {
        float currentBright = 0.0f;
        try {
            // 系统亮度值范围：0～255，应用窗口亮度范围：0.0f～1.0f。
            currentBright = android.provider.Settings.System.getInt(
                    getContentResolver(),
                    android.provider.Settings.System.SCREEN_BRIGHTNESS) * 100;
        } catch (Exception e) {
            e.printStackTrace();
        }
        light_seekbar.setProgress((int) currentBright);
        // 转换成百分比
        light_tv.setText("当前亮度：" + (int) currentBright + "%");
    }

    private void initViews() {
        this.voice_seekbar = (SeekBar) findViewById(R.id.voice_seekbar);
        this.light_seekbar = (SeekBar) findViewById(R.id.light_seekbar);
        this.voice_tv = (TextView) findViewById(R.id.voice_tv);
        this.light_tv = (TextView) findViewById(R.id.light_tv);
        //设置音量
        this.voice_seekbar
                .setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progress, boolean fromUser) {
                        // 设置音量的大小
                        mAudioManager.setStreamVolume(
                                AudioManager.STREAM_MUSIC, progress, 0);
                        voice_tv.setText("当前音量百分比：" + progress * 100
                                / maxVolume + " %");
                    }
                });
        // 调节亮度
        this.light_seekbar
                .setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progress, boolean fromUser) {
                        //获取LayoutParams对象，然后直接对其标志变量操作
                        WindowManager.LayoutParams lp = getWindow()
                                .getAttributes();
                        /*
                        SCREEN_BRIGHTNESS_MODE_AUTOMATIC=1 为自动调节屏幕亮度
                        SCREEN_BRIGHTNESS_MODE_MANUAL=0 为手动调节屏幕亮度
                        */
                        //获得当前屏幕亮度的模式
                        lp.screenBrightness = Float.valueOf(progress)
                                * (1f / 100f);
                        // 调节亮度
                        getWindow().setAttributes(lp);
                        light_tv.setText("当前亮度：" + progress + "%");
                    }
                });
    }

    /*
     * 初始化音量数据
     */
    private void initVolume() {
        // 获取系统最大音量
        maxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        // 设置voice_seekbar的最大值
        voice_seekbar.setMax(maxVolume);
        // 获取到当前 设备的音量
        currentVolume = mAudioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        // 显示音量
        voice_tv.setText("当前音量百分比：" + currentVolume * 100 / maxVolume + " %");
    }
}
