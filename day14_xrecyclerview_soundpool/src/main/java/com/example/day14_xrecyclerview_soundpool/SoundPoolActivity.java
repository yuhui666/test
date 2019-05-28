package com.example.day14_xrecyclerview_soundpool;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 1.创建soundPool音乐池子
 * 2.调用load方法加载音乐
 * 3.调用play播放指定的音乐
 * 4.最后页面销毁release释放资源
 *
 *
 * */

public class SoundPoolActivity extends AppCompatActivity {
  private Button bt_kp,b1,b2,b3,b4,b5,b6;
  private static SoundPool soundPool;//音乐池
    static int  kp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_pool);
        //TODO 1:创建对象
        //int maxStreams, int streamType, int srcQuality)
        //参数一 最大音乐个数  参数二 类型AudioManager.STREAM_MUSIC  参数三 质量 0
        soundPool=new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        //TODO 2:加载音乐
        //Context context, int resId, int priority
        //参数一 上下文  参数二 raw下面资源id  参数三 优先级 1
         kp= soundPool.load(this, R.raw.kp, 1);//返回音乐在池子中的id
        final int a=soundPool.load(this,R.raw.a,1);
        final  int c= soundPool.load(this,R.raw.c,1);
        final int e=soundPool.load(this,R.raw.e,1);
        final int d=soundPool.load(this,R.raw.d,1);
        final int f=soundPool.load(this,R.raw.f,1);
        final int g= soundPool.load(this,R.raw.g,1);

        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent();
        intent.setAction("NAO");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,101,intent,0);

        manager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),5000,pendingIntent);

        bt_kp=findViewById(R.id.bt_kp);
        bt_kp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int soundID, float leftVolume, float rightVolume,
                //            int priority, int loop, float rate
                //参数一 音乐id  参数二 左声道 0.0-1.0 参数三 右声道 0.0-1.0 参数四 优先级 1 参数五 是否循环 0 不循环 1 一直循环 参数六 速率  1.0
                soundPool.play(kp,0.5f,0.5f,1,0,1.5f);
                soundPool.play(kp,0.5f,0.5f,1,0,1.5f);
            }
        });
        b1=findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int soundID, float leftVolume, float rightVolume,
                //            int priority, int loop, float rate
                //参数一 音乐id  参数二 左声道 0.0-1.0 参数三 右声道 0.0-1.0 参数四 优先级 1 参数五 是否循环 0 不循环 1 一直循环 参数六 速率  1.0
                soundPool.play(a,1.0f,1.0f,1,0,1.0f);
            }
        });
        b2=findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int soundID, float leftVolume, float rightVolume,
                //            int priority, int loop, float rate
                //参数一 音乐id  参数二 左声道 0.0-1.0 参数三 右声道 0.0-1.0 参数四 优先级 1 参数五 是否循环 0 不循环 1 一直循环 参数六 速率  1.0
                soundPool.play(c,1f,1f,1,0,1.0f);

            }
        });
        b3=findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int soundID, float leftVolume, float rightVolume,
                //            int priority, int loop, float rate
                //参数一 音乐id  参数二 左声道 0.0-1.0 参数三 右声道 0.0-1.0 参数四 优先级 1 参数五 是否循环 0 不循环 1 一直循环 参数六 速率  1.0
                soundPool.play(d,0.5f,0.5f,1,0,1.0f);
            }
        });
        b4=findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int soundID, float leftVolume, float rightVolume,
                //            int priority, int loop, float rate
                //参数一 音乐id  参数二 左声道 0.0-1.0 参数三 右声道 0.0-1.0 参数四 优先级 1 参数五 是否循环 0 不循环 1 一直循环 参数六 速率  1.0
                soundPool.play(e,0.5f,0.5f,1,0,1.0f);
            }
        });
        b5=findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int soundID, float leftVolume, float rightVolume,
                //            int priority, int loop, float rate
                //参数一 音乐id  参数二 左声道 0.0-1.0 参数三 右声道 0.0-1.0 参数四 优先级 1 参数五 是否循环 0 不循环 1 一直循环 参数六 速率  1.0
                soundPool.play(f,0.5f,0.5f,1,0,1.0f);
            }
        });
        b6=findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int soundID, float leftVolume, float rightVolume,
                //            int priority, int loop, float rate
                //参数一 音乐id  参数二 左声道 0.0-1.0 参数三 右声道 0.0-1.0 参数四 优先级 1 参数五 是否循环 0 不循环 1 一直循环 参数六 速率  1.0
                soundPool.play(g,0.5f,0.5f,1,0,1.0f);
            }
        });
    }

    public static class  MyReceicer extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            soundPool.play(kp,0.5f,0.5f,1,0,1.5f);

        }
    }
}
