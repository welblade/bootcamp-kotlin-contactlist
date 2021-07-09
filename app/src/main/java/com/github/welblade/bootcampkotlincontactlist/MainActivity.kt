package com.github.welblade.bootcampkotlincontactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.welblade.bootcampkotlincontactlist.Model.Contact

class MainActivity : AppCompatActivity() {
    private val rvlist: RecyclerView by lazy {
        findViewById(R.id.rv_list)
    }

    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
    }

    private fun bindViews(){
        rvlist.adapter = adapter
        rvlist.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList(){
        adapter.updateList(
            arrayListOf(
                Contact("Wellington", "(XX) XXXX-XXXX","img.png"),
                Contact("Deborah", "(XX) XXXX-XXXX", "img.png"),
            )
        )
    }
}