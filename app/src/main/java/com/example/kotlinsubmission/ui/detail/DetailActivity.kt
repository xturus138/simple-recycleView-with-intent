package com.example.kotlinsubmission.ui.detail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinsubmission.MainActivity
import com.example.kotlinsubmission.R
import com.example.kotlinsubmission.databinding.ActivityDetailBinding
import com.example.kotlinsubmission.model.News

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    
    companion object {
        const val EXTRA_NEWS = "EXTRA_NEWS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonBack = binding.backButtonDetails
        val tvNewsTitle : TextView = binding.newsTitleTextView
        val tvNewsDateCategory : TextView = binding.newsDateCategoryTextView
        val tvNewsContent : TextView = binding.newsContentTextView
        val newsPhoto : ImageView = binding.newsPhotos

        val news = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_NEWS, News::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_NEWS)
        }

        if (news != null) {
            newsPhoto.setImageResource(news.photos)
            tvNewsTitle.text = news.judul
            tvNewsDateCategory.text = news.isi
            tvNewsContent.text = news.kategori
        }

        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}