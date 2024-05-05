package com.example.mytamagotchiapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.widget.TextView


class ActivityTwo : AppCompatActivity() {

    // Define variables for pet status
    private var hungerLevel = 0
    private var happinessLevel = 0
    private var cleanlinessLevel = 0

    // Define limits for actions
    private val maxFeedCount = 100
    private val maxPlayCount = 100
    private val maxCleanCount = 100

    // Handler for delayed image change
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        //Declaring the buttons
        val feedButton = findViewById<Button>(R.id.feedButton)
        val playButton = findViewById<Button>(R.id.playButton)
        val cleanButton = findViewById<Button>(R.id.cleanButton)
        val hungerLevelTextView = findViewById<TextView>(R.id.hungerLevel)
        val cleanlinessLevelTextView = findViewById<TextView>(R.id.cleanlinessLevel)
        val happinessLevelTextView = findViewById<TextView>(R.id.happinessLevel)
        val imageView = findViewById<ImageView>(R.id.petImageView)


        // Set initial image
        updatePetImage()

        // Set onClickListeners for buttons
        feedButton.setOnClickListener {
            if (hungerLevel < maxFeedCount) {
                hungerLevel += 25
                hungerLevelTextView.text = " $hungerLevel"
                if (hungerLevel >= 100) {
                    updatePetImage(R.drawable.pet_hungry)
                    scheduleDefaultImageChange()
                }
            } else {
                // Show a message or disable the button if max feed count is reached
            }
        }

        cleanButton.setOnClickListener {
            if (cleanlinessLevel < maxCleanCount) {
                cleanlinessLevel += 25
                cleanlinessLevelTextView.text = " $cleanlinessLevel"
                if (cleanlinessLevel >= 100) {
                    updatePetImage(R.drawable.pet_clean)
                    scheduleDefaultImageChange()
                }
            } else {
                // Show a message or disable the button if max clean count is reached
            }
        }

        playButton.setOnClickListener {
            if (happinessLevel < maxPlayCount) {
                happinessLevel += 25
                happinessLevelTextView.text = " $happinessLevel"
                if (happinessLevel >= 100) {
                    updatePetImage(R.drawable.pet_happy)
                    scheduleDefaultImageChange()
                }
            } else {
                // Show a message or disable the button if max play count is reached
            }
        }
    }

    private fun updatePetImage(imageResource: Int = R.drawable.pet_default) {
        // Logic to update pet image based on status
        val petImageView = findViewById<ImageView>(R.id.petImageView)
        petImageView.setImageResource(imageResource)
    }

    private fun scheduleDefaultImageChange() {
        // Remove existing callbacks to prevent multiple callbacks being scheduled
        handler.removeCallbacksAndMessages(null)

        // To revert the image back to default after 10 seconds
        handler.postDelayed({ updatePetImage() }, 10000)
    }
}





































