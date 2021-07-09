package com.github.welblade.bootcampkotlincontactlist

import com.github.welblade.bootcampkotlincontactlist.model.Contact

interface ContatcItemClickListener {
    fun onClickContactItem(contact: Contact)
}