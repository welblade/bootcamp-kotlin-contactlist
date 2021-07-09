package com.github.welblade.bootcampkotlincontactlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.welblade.bootcampkotlincontactlist.model.Contact
import com.github.welblade.bootcampkotlincontactlist.databinding.DrawerMenuBinding

class MainActivity : AppCompatActivity(), ContatcItemClickListener {
    private val rvlist: RecyclerView by lazy {
        findViewById(R.id.rv_list)
    }

    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDrawer()
        bindViews()
        updateList()
    }

    fun initDrawer(){
        val drawer = DrawerMenuBinding.inflate(layoutInflater).root
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        this.setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menuItem1 -> {
                showToast("Menu item 1")
            }
            R.id.menuItem2 -> {
                showToast("Menu item 2")
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showToast(message: String):Boolean {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onClickContactItem(contact: Contact) {
        val intent = Intent(this, ContactDetailActivity::class.java)
        intent.putExtra(ContactDetailActivity.EXTRA_CONTACT, contact)
        startActivity(intent)
    }
}