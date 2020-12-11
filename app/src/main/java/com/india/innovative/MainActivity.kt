package com.india.innovative

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.india.innovative.adapter.UserAdapter
import com.india.innovative.databinding.ActivityMainBinding
import com.india.innovative.viewModel.UserViewModel


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = UserAdapter()
        val itemViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.recyclerMain.layoutManager = LinearLayoutManager(this)
        itemViewModel.userPagedList.observe(this, {
            if (it != null) {
                adapter.submitList(it)
                binding.recyclerMain.adapter = adapter

            }
        })
    }


}

