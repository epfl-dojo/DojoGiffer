package com.example.dojo_giffer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.TextView
import okhttp3.*
import java.io.IOException

class ShowResult : AppCompatActivity() {

    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_show_result)
        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val result = doGetRequest("https://jsonplaceholder.typicode.com/posts/1")

        val textView = findViewById<TextView>(R.id.textView).apply {
            text = result
        }
    }

    private fun doGetRequest(url: String): String? {
        val request = Request.Builder()
            .url(url)
            .build();

        val response = client.newCall(request).execute()
        return response.body()?.string()
    }


    // See https://square.github.io/okhttp/recipes/
    fun run(url: String) {

        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) {
                println(response.body()?.string())
                // TODO: WE NEED TO UPDATE THE VIEW HERE

            }
        })
    }
}
