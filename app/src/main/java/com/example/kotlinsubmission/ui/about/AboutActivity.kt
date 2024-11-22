package com.example.kotlinsubmission.ui.about

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinsubmission.MainActivity
import com.example.kotlinsubmission.R
import com.example.kotlinsubmission.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imgButton = binding.backButton
        setView()
        imgButton.setOnClickListener {
            val moveIntent = Intent(this@AboutActivity, MainActivity::class.java)
            startActivity(moveIntent)
        }
    }

    private fun setView() {
        binding.imageView.setImageResource(R.drawable.fotoprofile)
        binding.textViewName.text = getString(R.string.name_for_about)
        binding.textViewGmail.text = getString(R.string.email_for_about)
    }
}