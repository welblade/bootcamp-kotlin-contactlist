package com.github.welblade.bootcampkotlincontactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.welblade.bootcampkotlincontactlist.databinding.ActivityContactDetailBinding
import com.github.welblade.bootcampkotlincontactlist.model.Contact

class ContactDetailActivity : AppCompatActivity() {
    private val contact: Contact? by lazy {
        intent.getParcelableExtra(EXTRA_CONTACT)
    }

    private val binding: ActivityContactDetailBinding by lazy {
        ActivityContactDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initToolbar()
        bindView()
    }

    private fun initToolbar(){
        this.setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun bindView(){
        binding.tvName.text = contact?.name
        binding.tvPhone.text = contact?.phone
        // binding.ivPhoto = contact?.photo
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }


    companion object{
        const val EXTRA_CONTACT = "EXTRA_CONTATC"
    }
}