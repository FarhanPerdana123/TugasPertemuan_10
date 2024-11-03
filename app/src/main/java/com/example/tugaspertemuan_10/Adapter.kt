package com.example.tugaspertemuan_10

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspertemuan_10.databinding.EmailBinding

class Adapter(private var emails: List<Email>) : RecyclerView.Adapter<Adapter.EmailViewHolder>() {
    inner class EmailViewHolder(private val binding: EmailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(email: Email) {
            binding.apply {
                pengirim.text = email.sender
                subjekIsi.text = email.subject
                date.text = email.date

                root.setOnClickListener {
                    val intent = Intent(root.context, DetailEmail::class.java).apply {
                        putExtra("sender", email.sender)
                        putExtra("subject", email.subject)
                        putExtra("date", email.date)
                        putExtra("content", email.content)
                    }
                    root.context.startActivity(intent)
                }
            }
        }
    }

    fun updateList(newEmails: List<Email>) {
        emails = newEmails
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val binding = EmailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.bind(emails[position])
    }

    override fun getItemCount() = emails.size
}