package org.twinkle.tmdbmvvmcleanarchitecture.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.twinkle.tmdbmvvmcleanarchitecture.R
import org.twinkle.tmdbmvvmcleanarchitecture.databinding.ActivityMainBinding
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.artist.ArtistActivity
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.movie.MovieActivity
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.tvshow.TvShowActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            startActivity(Intent(this, TvShowActivity::class.java))
        }

        binding.button3.setOnClickListener {
            startActivity(Intent(this, ArtistActivity::class.java))
        }

    }
}