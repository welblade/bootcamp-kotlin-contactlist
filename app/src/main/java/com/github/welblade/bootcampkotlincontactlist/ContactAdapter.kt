package com.github.welblade.bootcampkotlincontactlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.welblade.bootcampkotlincontactlist.Model.Contact
import com.github.welblade.bootcampkotlincontactlist.databinding.ContactItemBinding

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {
    private val list: MutableList<Contact> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val itemBinding = ContactItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ContactAdapterViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
    class ContactAdapterViewHolder(
        private val itemBinding: ContactItemBinding
    )  : RecyclerView.ViewHolder(itemBinding.root)
    {
        fun bind(contact : Contact) {
            itemBinding.tvName.text = contact.name
            itemBinding.tvPhone.text = contact.phone
            //itemBinding.ivPhoto = contact.name
        }
    }

    fun updateList(list: List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}