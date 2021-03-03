package com.gyasistory.androids.graphqltest.base.bindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("setUrl")
fun ImageView.setURL(url: String) {
    Picasso.get().load(url).into(this)
}