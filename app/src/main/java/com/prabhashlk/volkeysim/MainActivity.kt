package com.prabhashlk.volkeysim

import android.media.AudioManager
import android.os.Bundle
import android.service.quicksettings.TileService
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Test buttons declaration
        val upBtn: Button = findViewById(R.id.btnUp)
        val downBtn: Button = findViewById(R.id.btnDown)

        //Audio service declaration for using audio manager
        val audioManager = applicationContext.getSystemService(AUDIO_SERVICE) as AudioManager

        //Setup onclick listener to volume up button
        upBtn.setOnClickListener {
            //Use audio manager to raise volume and show UI audio panel
            audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI)
        }

        //Setup onclick listener to volume down button
        downBtn.setOnClickListener {
            //Use audio manager to lower volume and show UI audio panel
            audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI)
        }

        //Textview for github link - Making it clickable
        val gitLink: TextView = findViewById(R.id.textView_link)
        gitLink.autoLinkMask
    }
}

//Class for Quick Setting Tile activity - The main purpose of the app
class VolSimService : TileService() {

    //Overriding tile onclick activity
    override fun onClick() {
        super.onClick()
        //Audio service declaration for using audio manager
        val audioManager = applicationContext.getSystemService(AUDIO_SERVICE) as AudioManager
        //Use audio manager to raise volume and show UI audio panel
        audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI)
    }
}