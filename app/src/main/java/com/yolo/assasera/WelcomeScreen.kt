package com.yolo.assasera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.yolo.assasera.databinding.ActivityWelcomeScreenBinding

class WelcomeScreen : AppCompatActivity() {

    private val imageResources = listOf(
        R.drawable.hero_image1,
        R.drawable.heroimage2,
        R.drawable.heroimage3
    )

    private val textsTitle = listOf(
        R.string.welcometitle1,
        R.string.welcometitle2,
        R.string.welcometitle3,
     )
    private val texts = listOf(
        R.string.welcometext1,
        R.string.welcometext2,
        R.string.welcometext3,
     )

    private val handler = Handler()

    lateinit var binding: ActivityWelcomeScreenBinding
    private var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWelcomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startImageAndTextLoop()

        binding.btnSignin.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            val intent=Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }


    }

    private fun startImageAndTextLoop() {
        handler.post(imageAndTextChangeRunnable)
    }

    private val imageAndTextChangeRunnable = object : Runnable {
        override fun run() {

            if (currentIndex==0){
                binding.screen1.visibility=View.VISIBLE
                binding.screen2.visibility=View.GONE
                binding.screen3.visibility=View.GONE
            }
            if (currentIndex==1){
                binding.screen2.visibility=View.VISIBLE
                binding.screen1.visibility=View.GONE
                binding.screen3.visibility=View.GONE
            }
            if (currentIndex==2){
                binding.screen3.visibility=View.VISIBLE
                binding.screen1.visibility=View.GONE
                binding.screen2.visibility=View.GONE
            }
            // Change the image
            binding.welcomeImage.setImageResource(imageResources[currentIndex])

            // Change the text
            binding.welcomeText.text = getString(texts[currentIndex])
            binding.welcomeTitle.text = getString(textsTitle[currentIndex])

            // Move to the next index
            currentIndex = (currentIndex + 1) % imageResources.size

            // Reschedule the loop every 10 seconds
            handler.postDelayed(this, 10000)
        }
    }
}