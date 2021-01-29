package com.example.backgroundmusicservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.PowerManager;
import android.provider.MediaStore;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        // 초기화
        super.onCreate();

        mediaPlayer = MediaPlayer.create(this, R.raw.yso_040);
        // 음악파일을 불러온다
        mediaPlayer.setScreenOnWhilePlaying(true);
        //mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        // 잠금상태에서도 끊기지 않게
        mediaPlayer.setLooping(true);
        // 반복재생 여부
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 서비스 시작
        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        // 서비스가 끝날 때
        super.onDestroy();

        mediaPlayer.stop();
        // 음악 정지
    }
}
