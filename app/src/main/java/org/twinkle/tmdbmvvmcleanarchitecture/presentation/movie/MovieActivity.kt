package org.twinkle.tmdbmvvmcleanarchitecture.presentation.movie

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import org.twinkle.tmdbmvvmcleanarchitecture.R
import org.twinkle.tmdbmvvmcleanarchitecture.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
    }
}