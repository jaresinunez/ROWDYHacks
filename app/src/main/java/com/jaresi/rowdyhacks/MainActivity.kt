package com.jaresi.rowdyhacks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import coil.imageLoader
import coil.request.ImageRequest
import com.jaresi.rowdyhacks.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val request = ImageRequest.Builder(this)
            .data("https://www.travelandleisure.com/thmb/sH4T0ElWwZFyUhtqAZD3USeiaSc=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/james-webb-hole-WEBB0722-a7b14258290d4da9be4c7d50ee732d9b.jpg")
            .crossfade(true)
            .target(binding.astronomyPod)
            .build()

        imageLoader.enqueue(request)

        setContentView(binding.root)
    }
}