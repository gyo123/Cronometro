package com.example.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.example.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var running = false
    var pause: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.iniciar.setOnClickListener {
            iniciarcronometro()
        }


        binding.pausar.setOnClickListener {
            pausarcronometro()
        }

        binding.zerar.setOnClickListener {
            zerarcronometro()
        }

    }

    private fun iniciarcronometro(){
        if (!running){
            binding.cronometro.base = SystemClock.elapsedRealtime() - pause
            binding.cronometro.start()
            running = true

        }

    }
    private fun pausarcronometro(){
        if (running){
            binding.cronometro.stop()
            pause = SystemClock.elapsedRealtime() - binding.cronometro.base
            running = false
        }
    }
    private fun zerarcronometro(){
        binding.cronometro.base = SystemClock.elapsedRealtime()
        pause = 0
    }

}