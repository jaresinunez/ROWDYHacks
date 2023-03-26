package com.jaresi.rowdyhacks
import android.app.Application
import android.os.Bundle
import android.util.Xml.parse
import coil.imageLoader
import coil.request.ImageRequest
import com.jaresi.rowdyhacks.databinding.ActivityMainBinding
import com.parse.Parse

class App : Application() {
    class App : Application() {
        override fun onCreate() {
            super.onCreate()
            Parse.initialize(
                Parse.Configuration.Builder(this)
                    .applicationId(getString(R.string.back4app_app_id))
                    .clientKey(getString(R.string.back4app_client_key))
                    .server(getString(R.string.back4app_server_url))
                    .build());
        }
    }
}