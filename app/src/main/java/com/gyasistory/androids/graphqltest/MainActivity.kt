package com.gyasistory.androids.graphqltest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gyasistory.androids.graphqltest.features.character.CharacterFragment

const val TAG = "MainActivity"

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(
            R.id.character_fragment_container,
            CharacterFragment(),
            CharacterFragment.TAG
        ).commit()
    }
}