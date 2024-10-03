package org.twinkle.tmdbmvvmcleanarchitecture.presentation.artist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import org.twinkle.tmdbmvvmcleanarchitecture.R
import org.twinkle.tmdbmvvmcleanarchitecture.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
    }
}