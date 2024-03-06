package com.dicoding.aazapp_release

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private lateinit var description: String

    // Function onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailName = intent.getStringExtra("NAME")
        description = intent.getStringExtra("DESCRIPTION") ?: ""
        val detailPhoto = intent.getIntExtra("PHOTO", 0)

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView = findViewById(R.id.detail_description)
        val tvDetailPhoto: ImageView = findViewById(R.id.tv_detail_photo)

        tvDetailName.text = detailName
        tvDetailDescription.text = description
        tvDetailPhoto.setImageResource(detailPhoto)
    }

}