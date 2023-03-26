package com.muratozturk.openai_dall_e_2.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muratozturk.openai_dall_e_2.R
import com.muratozturk.openai_dall_e_2.common.UniverseData.num
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(num == 0) {
            val intent = Intent(this, CreatePlanetActivity::class.java)
            startActivity(intent)
            finish()
        } else{

        }
        setContentView(R.layout.activity_main)
    }
}