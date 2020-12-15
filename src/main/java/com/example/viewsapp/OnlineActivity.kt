package com.example.viewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.viewsapp.databinding.ActivityOnlineBinding
import com.example.viewsapp.remote.RetrofitInterface
import com.example.viewsapp.remote.RetrofitService
import kotlinx.coroutines.launch

class OnlineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnlineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = layoutInflater
        binding = ActivityOnlineBinding.inflate(inflater)

        setContentView(binding.root)
        setSupportActionBar(binding.homeToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        Glide.with(this).load(R.drawable.logo).into(binding.imgToolbar)

        val retrofitService = RetrofitService.buildService(RetrofitInterface::class.java)
        lifecycleScope.launch {
            val request = retrofitService.topHeadlines("id")
            if (request.isSuccessful) {
                Toast.makeText(this@OnlineActivity, request.body()?.totalResults.toString(), Toast.LENGTH_SHORT).show()
                } else {
                Log.e("OnlineActivity", request.message())
            }

        }
    }
}