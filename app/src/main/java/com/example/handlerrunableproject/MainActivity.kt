package com.example.handlerrunableproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.handlerrunableproject.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    var numara = 0
    var runnable : Runnable = Runnable { }
    var handler = Handler(Looper.myLooper() !!)  // handler dedavülden kalkmış gibi bişi olmuş o yüzden looper ekledik
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.baslatButton.setOnClickListener{

            numara = 0

            runnable = object : Runnable{
                override fun run() {
                    numara = numara + 1
                    binding.textView.text = "Sayaç: ${numara}"
                    handler.postDelayed(runnable, 1000)
                }

            }
                handler.post(runnable)


        }

        binding.durdurButton.setOnClickListener {

            handler.removeCallbacks(runnable)
            numara = 0

            binding.textView.text = "Sayaç: ${numara}"


        }

    }
}