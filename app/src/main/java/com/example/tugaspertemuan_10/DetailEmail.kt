package com.example.tugaspertemuan_10

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaspertemuan_10.databinding.IsiEmailBinding

class DetailEmail : AppCompatActivity() {
    private lateinit var binding: IsiEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IsiEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sender = intent.getStringExtra("sender") ?: ""
        val subject = intent.getStringExtra("subject") ?: ""
        val date = intent.getStringExtra("date") ?: ""
        val content = intent.getStringExtra("content") ?: ""

        binding.sender.text = sender
        binding.subject.text = subject
        binding.dateIsi.text = date
        binding.content.text = content
    }

    fun onBackPressed(view: View) {
        finish()
    }
}