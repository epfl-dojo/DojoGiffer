package com.example.dojo_giffer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class ShowResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_show_result)
        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)
//        val result=run("https://jsonplaceholder.typicode.com/posts/1");

        val textView = findViewById<TextView>(R.id.textView)

        val queue = Volley.newRequestQueue(this)
        val url = "https://jsonplaceholder.typicode.com/posts/1"

        // Request a string response from the provided URL.

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                textView.text = "Response is: ${response}"
            },
            Response.ErrorListener { textView.text = "That didn't work!" })


// Add the request to the RequestQueue.
        queue.add(stringRequest)



    }


    fun run(url: String) {
        val text = URL("https://www.google.com").readText()
        println(text)

//        val request = Request.Builder()
//            .url(url)
//            .build()
//
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {}
//            override fun onResponse(call: Call, response: Response) {
//                println(response.body()?.string())
//                // Capture the layout's TextView and set the string as its text
//                val textView = findViewById<TextView>(R.id.textView).apply {
//                    text = response.body()?.string()
//                }
//            }
//        })
    }
}
