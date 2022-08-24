package com.example.weatherapplication.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapplication.R
import com.example.weatherapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitAllowingStateLoss()
        }

//        binding.ok.setOnClickListener(clickListener)
    }

    /*@RequiresApi(Build.VERSION_CODES.N)
    val clickListener: View.OnClickListener = View.OnClickListener {
        val handler = Handler(Looper.getMainLooper())
        try {
            val uri = URL(binding.url.text.toString())
            Thread {
                var urlConnection: HttpsURLConnection? = null
                try {
                    with(urlConnection) {
                        urlConnection = uri.openConnection() as HttpsURLConnection
                        this?.requestMethod = "GET"
                        this?.connectTimeout = 10000
                    }
                    val reader = BufferedReader(InputStreamReader(urlConnection?.inputStream))
                    val result = getLines(reader)
                    handler.post() {
                        binding.webview.loadDataWithBaseURL(null, result, "text/html; charset=utf-8", "utf-8", null)
                    }
                } catch (e: Exception) {
                    Log.e("@@@", "Fail connection", e)
                    e.printStackTrace()
                } finally {
                    urlConnection?.disconnect()
                }
            }.start()
        } catch (e: MalformedURLException) {
            Log.e("@@@", "URL exception", e)
            e.printStackTrace()
        }
    }*/

/*    @RequiresApi(Build.VERSION_CODES.N)
    private fun getLines(reader: BufferedReader): String {
        return reader.lines().collect(Collectors.joining("\n"))
    }*/
}


