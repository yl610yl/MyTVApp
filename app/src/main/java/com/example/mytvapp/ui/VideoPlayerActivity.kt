package com.example.mytvapp.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class VideoPlayerActivity :FragmentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragment = VideoPlayerFragment()
        fragment.arguments = intent.extras
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content,fragment)
            .commit()
    }
}