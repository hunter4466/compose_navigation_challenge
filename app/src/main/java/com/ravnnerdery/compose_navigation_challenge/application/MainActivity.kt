package com.ravnnerdery.compose_navigation_challenge.application

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.ravnnerdery.compose_navigation_challenge.ui.Application
import com.ravnnerdery.compose_navigation_challenge.ui.theme.ApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val imageLoader = ImageLoader.Builder(this)
                .componentRegistry {
                    if (Build.VERSION.SDK_INT >= 28) {
                        add(ImageDecoderDecoder(this@MainActivity))
                    } else {
                        add(GifDecoder())
                    }
                }.build()
            ApplicationTheme {
                Scaffold() {
                    Application(viewModel = mainViewModel, imageLoader = imageLoader)
                }
            }
        }
    }
}