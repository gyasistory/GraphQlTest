package com.gyasistory.androids.graphqltest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

const val TAG = "MainActivity"

class MainActivity @Inject constructor() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}