package com.bumi.simpletv;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;	


public class TvActivity extends Activity {
	
	private String path = "http://samples.mplayerhq.hu/mobileVideo_3gp/ MrBean.3gp";
	private VideoView mVideoView;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if (!LibsChecker.checkVitamioLibs(this))
        	return;
        
        setContentView(R.layout.activity_tv);
        mVideoView = (VideoView) findViewById(R.id.surface_view);
        
        if (path == "") {
	    	// Tell the user to provide a media file URL/path.
	    	return;
    	} else {
        	/*
        	* Alternatively,for streaming media you can use
        	* mVideoView.setVideoURI(Uri.parse(URLstring));
        	*/
        	mVideoView.setVideoPath(path);
        	mVideoView.setMediaController(new MediaController(this));
        	mVideoView.requestFocus();
        	mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
	        	@Override
	        	public void onPrepared(MediaPlayer mediaPlayer) {
	        		// optional need Vitamio 4.0
	        		mediaPlayer.setPlaybackSpeed(1.0f);
	        	}
        	});
        }
        
    }
}
