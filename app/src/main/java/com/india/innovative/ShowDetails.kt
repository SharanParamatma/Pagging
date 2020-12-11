package com.india.innovative

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.india.innovative.databinding.ActivityShowDetailsBinding
import com.india.innovative.model.User

class ShowDetails : AppCompatActivity() {
    private lateinit var binding: ActivityShowDetailsBinding
    private var user: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityShowDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        user = i.getSerializableExtra("data") as User?

        binding.name.text =user?.name
        binding.email.text =user?.email
        binding.gender.text =user?.gender
        binding.status.text =user?.status
    }
}