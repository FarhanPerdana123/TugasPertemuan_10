package com.example.tugaspertemuan_10

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaspertemuan_10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adapter
    private lateinit var emailList: List<Email>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailList = listOf(
            Email("fefefufu", "Pemberitahuan, sarapan gratis", "Pemberitahuan: Sarapan gratis akan segera dimulai! Kami mengundang semua tamu untuk bergabung dan menikmati hidangan pagi yang telah disediakan. Silakan menuju area sarapan yang telah ditentukan, dan nikmati pilihan menu yang tersedia. Pastikan untuk datang tepat waktu agar dapat menikmati sarapan bersama. Selamat menikmati!", "20 Oct"),
            Email("Ronaldo", "AKULAH GOAT TERBAIK SEPANJANG MASA", "", "19 Oct"),
            Email("Messi", "Jangan dengerin bang cr, sesat itu.", "", "18 oct"),
            Email("PT NGANG NGONG IND", "Pemberitahuan penerimaan kerja", "", "18 oct"),
            Email("fefefufu", "Pemberitahuan, sarapan gratis", "Pemberitahuan: Sarapan gratis akan segera dimulai! Kami mengundang semua tamu untuk bergabung dan menikmati hidangan pagi yang telah disediakan. Silakan menuju area sarapan yang telah ditentukan, dan nikmati pilihan menu yang tersedia. Pastikan untuk datang tepat waktu agar dapat menikmati sarapan bersama. Selamat menikmati!", "20 Oct"),
            Email("fefefufu", "Pemberitahuan, sarapan gratis", "Pemberitahuan: Sarapan gratis akan segera dimulai! Kami mengundang semua tamu untuk bergabung dan menikmati hidangan pagi yang telah disediakan. Silakan menuju area sarapan yang telah ditentukan, dan nikmati pilihan menu yang tersedia. Pastikan untuk datang tepat waktu agar dapat menikmati sarapan bersama. Selamat menikmati!", "20 Oct"),
            Email("fefefufu", "Pemberitahuan, sarapan gratis", "Pemberitahuan: Sarapan gratis akan segera dimulai! Kami mengundang semua tamu untuk bergabung dan menikmati hidangan pagi yang telah disediakan. Silakan menuju area sarapan yang telah ditentukan, dan nikmati pilihan menu yang tersedia. Pastikan untuk datang tepat waktu agar dapat menikmati sarapan bersama. Selamat menikmati!", "20 Oct"),
            Email("fefefufu", "Pemberitahuan, sarapan gratis", "Pemberitahuan: Sarapan gratis akan segera dimulai! Kami mengundang semua tamu untuk bergabung dan menikmati hidangan pagi yang telah disediakan. Silakan menuju area sarapan yang telah ditentukan, dan nikmati pilihan menu yang tersedia. Pastikan untuk datang tepat waktu agar dapat menikmati sarapan bersama. Selamat menikmati!", "20 Oct"),
            Email("fefefufu", "Pemberitahuan, sarapan gratis", "Pemberitahuan: Sarapan gratis akan segera dimulai! Kami mengundang semua tamu untuk bergabung dan menikmati hidangan pagi yang telah disediakan. Silakan menuju area sarapan yang telah ditentukan, dan nikmati pilihan menu yang tersedia. Pastikan untuk datang tepat waktu agar dapat menikmati sarapan bersama. Selamat menikmati!", "20 Oct"),
            Email("fefefufu", "Pemberitahuan, sarapan gratis", "Pemberitahuan: Sarapan gratis akan segera dimulai! Kami mengundang semua tamu untuk bergabung dan menikmati hidangan pagi yang telah disediakan. Silakan menuju area sarapan yang telah ditentukan, dan nikmati pilihan menu yang tersedia. Pastikan untuk datang tepat waktu agar dapat menikmati sarapan bersama. Selamat menikmati!", "20 Oct"),

            // Add more entries as needed
        )

        adapter = Adapter(emailList)
        binding.emailDropdown.layoutManager = LinearLayoutManager(this)
        binding.emailDropdown.adapter = adapter

        // Search functionality
        binding.search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterEmails(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        // Bottom navigation handling
        binding.navigasiView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.emailNavigasi -> {

                    true
                }
                R.id.videoCallNavigasi -> {

                    true
                }
                else -> false
            }
        }
    }

    private fun filterEmails(query: String) {
        val filteredList = emailList.filter { it.subject.contains(query, ignoreCase = true) || it.sender.contains(query, ignoreCase = true) }
        adapter.updateList(filteredList)
    }
}