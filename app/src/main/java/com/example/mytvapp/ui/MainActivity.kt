package com.example.mytvapp.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(android.R.layout.activity_list_item)

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(android.R.id.content,MainFragment())
                .commit()
        }
    }
}