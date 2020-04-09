package com.example.a509zlyjsj.activities;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.a509zlyjsj.R;
import com.example.a509zlyjsj.common.Common;

import androidx.appcompat.app.AppCompatActivity;

public class VideoViewActivity extends AppCompatActivity {
    private int resid;
    private VideoView videoView;
    private String videopath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_video);

        System.out.println("----查看视频详情");

        resid  = getIntent().getIntExtra("resid",1);
        videopath = getIntent().getStringExtra("videopath");

        videoView = findViewById(R.id.videoView2);
        Uri uri = Uri.parse(Common.VIDEOPATH+videopath);
        Log.i("--uri", "uri: "+uri);

        videoView.setVideoURI(uri);
        videoView.setMediaController(new MediaController(VideoViewActivity.this));

        RelativeLayout.LayoutParams layoutParams=
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        videoView.setLayoutParams(layoutParams);
        class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(VideoViewActivity.this, "播放完成了", Toast.LENGTH_SHORT).show();
            }
        }
        //播放完成回调
        videoView.setOnCompletionListener(new MyPlayerOnCompletionListener());
        //开始播放视频
        videoView.start();
        Log.i("video_info", "uri: "+ uri);

    }
}
