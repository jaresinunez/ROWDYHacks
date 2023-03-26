package com.jaresi.rowdyhacks

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import coil.imageLoader
import coil.request.ImageRequest
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.RetryPolicy
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.jaresi.rowdyhacks.databinding.ActivityMainBinding
import com.parse.ParseObject
import com.parse.ParseQuery
import com.squareup.picasso.Picasso
import org.json.JSONObject
import kotlin.math.log

const val TOKEN = "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"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var list = ArrayList<Planet>()
    var generator_url = "https://api.openai.com/v1/completions"
     var gen_url: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var p1 = Planet("medium",
            "pink",
            "blue",
            "purple",
            "spiral",
            "medium pink, blue, and purple spiral patterned planet")
        list.add(p1)
        var p2 = Planet("small",
            "yellow",
            "blue",
            "orange",
            "dots",
            "small yellow, blue, orange dotted patterned planet")
        list.add(p2)
        val request = ImageRequest.Builder(this)
            .data("https://www.travelandleisure.com/thmb/sH4T0ElWwZFyUhtqAZD3USeiaSc=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/james-webb-hole-WEBB0722-a7b14258290d4da9be4c7d50ee732d9b.jpg")
            .crossfade(true)
            .target(binding.astronomyPod)
            .build()

        imageLoader.enqueue(request)

        getResponse(binding.astronomyPod2, p1.url)

        val request2 = ImageRequest.Builder(this)
            .data(gen_url)
            .crossfade(true)
            .target(binding.astronomyPod2)
            .build()

        imageLoader.enqueue(request2)

        setContentView(binding.root)
    }

    private fun getResponse(iv: ImageView, query: String) {
        // creating a queue for request queue.
        val queue: RequestQueue = Volley.newRequestQueue(applicationContext)
        // creating a json object on below line.
        val jsonObject: JSONObject? = JSONObject()
        // adding params to json object.
        jsonObject?.put("prompt", query)
        jsonObject?.put("n", 1)
        jsonObject?.put("size", "256x256")
        // on below line making json object request.
        val postRequest: JsonObjectRequest =
            // on below line making json object request.
            object : JsonObjectRequest(Method.GET, generator_url, jsonObject,
                Response.Listener { response ->
                    // on below line getting response message and setting it to image view.
                    var imageURL: String =
                        response.getJSONArray("data").getJSONObject(0).getString("url")
                    Log.d("URL: ", imageURL)
                    imageURL = imageURL.replace("\\", "");
                    Log.d("URL_edited: ", imageURL)
                    // using picasso to load image from url in image view
                    Picasso.get().load(imageURL).into(iv)
                    gen_url = imageURL
                },
                // adding on error listener
                Response.ErrorListener { error ->
                    Log.e("TAGAPI", "Error is : " + error.message + "\n" + error)
                }) {
                override fun getHeaders(): MutableMap<String, String> {
                    val params: MutableMap<String, String> = HashMap()
                    // adding headers on below line.
                    params["Content-Type"] = "application/json"
                    params["Authorization"] = TOKEN
                    return params;
                }
            }

        // on below line adding retry policy for our request.
        postRequest.setRetryPolicy(object : RetryPolicy {
            override fun getCurrentTimeout(): Int {
                return 50000
            }

            override fun getCurrentRetryCount(): Int {
                return 50000
            }

            @Throws(VolleyError::class)
            override fun retry(error: VolleyError) {
            }
        })
        // on below line adding our request to queue.
        queue.add(postRequest)
    }
}