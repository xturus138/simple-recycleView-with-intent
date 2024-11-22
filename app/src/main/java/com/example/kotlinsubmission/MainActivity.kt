package com.example.kotlinsubmission

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinsubmission.adapter.ListNewsAdapter
import com.example.kotlinsubmission.databinding.ActivityMainBinding
import com.example.kotlinsubmission.model.News
import com.example.kotlinsubmission.ui.about.AboutActivity
import com.example.kotlinsubmission.ui.detail.DetailActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvNews: RecyclerView
    private val list = ArrayList<News>()

    companion object{
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        installSplashScreen()
        setContentView(binding.root)

        rvNews = binding.rvNews
        rvNews.setHasFixedSize(true)

        list.addAll(getListNews())
        showRecyclerList()

        val imgButton = binding.aboutPage
        imgButton.setOnClickListener {
            Log.d(TAG, "profile clicked")
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getListNews(): ArrayList<News> {
        val dataJudul = resources.getStringArray(R.array.data_judul)
        val dataDesc = resources.getStringArray(R.array.desc_judul)
        val dataIsi = resources.getStringArray(R.array.news_full_content)
        val dataKategori = resources.getStringArray(R.array.news_categories)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listNews = ArrayList<News>()
        for (i in dataJudul.indices) {
            val news = News(dataJudul[i], dataDesc[i], dataPhoto.getResourceId(i, -1), dataKategori[i], dataIsi[i] )
            listNews.add(news)
        }
        return listNews

    }

    private fun showRecyclerList(){
        rvNews.layoutManager = LinearLayoutManager(this)
        val listNewsAdapter = ListNewsAdapter(list)
        rvNews.adapter = listNewsAdapter

        listNewsAdapter.setOnItemClickCallback(object: ListNewsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: News) {
                showSelectedNews(data)
            }
        })
    }

    private fun showSelectedNews(news: News) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra("EXTRA_NEWS", news)
        }
        startActivity(intent)
    }
}