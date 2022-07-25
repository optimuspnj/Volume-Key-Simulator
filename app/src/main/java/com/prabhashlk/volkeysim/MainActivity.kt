package com.prabhashlk.volkeysim

import android.media.AudioManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.quicksettings.TileService
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val upBtn: Button = findViewById(R.id.btnUp)
        val downBtn: Button = findViewById(R.id.btnDown)

        val audioManager = applicationContext.getSystemService(AUDIO_SERVICE) as AudioManager

        upBtn.setOnClickListener {
            audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI)
        }

        downBtn.setOnClickListener {
            audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI)
        }
    }
}

class VolSimService: TileService() {

    override fun onClick() {
        super.onClick()
        val audioManager = applicationContext.getSystemService(AUDIO_SERVICE) as AudioManager
        audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI)
    }
}