package com.example.recipeapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.recipeapp.R
import com.example.recipeapp.databinding.ActivityLoadingBinding

/**
 * This activity is used to display the loading screen
 */
class Loading : AppCompatActivity() {
    /**
     * Creates the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loadingBinding: ActivityLoadingBinding = ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(loadingBinding.root)
        val animation = AnimationUtils.loadAnimation(this,R.anim.anim_load)
        loadingBinding.appName.animation = animation
        animation.setAnimationListener(object: Animation.AnimationListener{
            /**
             * This function is called when the animation starts
             */
            override fun onAnimationStart(p0: Animation?) {

            }

            /**
             * This function is called when the animation ends
             */
            override fun onAnimationEnd(p0: Animation?) {
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this@Loading,MainActivity::class.java))
                    finish()
                },1000)
            }

            /**
             * This function is called when the animation repeats
             */
            override fun onAnimationRepeat(p0: Animation?) {}

        }
        )
    }
}