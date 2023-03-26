package com.muratozturk.openai_dall_e_2.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muratozturk.openai_dall_e_2.common.Planet
import com.muratozturk.openai_dall_e_2.common.UniverseData.num
import com.muratozturk.openai_dall_e_2.common.UniverseData.solarSystem
import com.muratozturk.openai_dall_e_2.databinding.ActivityCreatePlanetBinding

class CreatePlanetActivity : AppCompatActivity() {
    lateinit var binding: ActivityCreatePlanetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatePlanetBinding.inflate(layoutInflater)
        var size: String
        var pattern: String


        binding.submit.setOnClickListener {
            if (binding.sizeSmall.isChecked()) {
                size = binding.sizeSmall.getText().toString();
            } else if (binding.sizeMedium.isChecked()) {
                size = binding.sizeMedium.getText().toString();
            } else if (binding.sizeLarge.isChecked()) {
                size = binding.sizeLarge.getText().toString();
            } else {
                size = "Medium"
            }

            if (binding.patternDotted.isChecked()) {
                pattern = binding.patternDotted.getText().toString();
            } else if (binding.patternSpiral.isChecked()) {
                pattern = binding.patternSpiral.getText().toString();
            } else if (binding.patternLinesH.isChecked()) {
                pattern = binding.patternLinesH.getText().toString();
            } else if (binding.patternLinesV.isChecked()) {
                pattern = binding.patternLinesV.getText().toString();
            } else {
                pattern = "checkered"
            }

            var planet = Planet(
                size,
                binding.color1.text.toString(),
                binding.color2.text.toString(),
                binding.color3.text.toString(),
                pattern
            )

            solarSystem.add(planet)

            num += 1
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        setContentView(binding.root)
    }

    fun getSize(){

    }
}