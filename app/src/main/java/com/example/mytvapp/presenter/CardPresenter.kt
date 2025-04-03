package com.example.mytvapp.presenter

import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide
import com.example.mytvapp.model.Video

class CardPresenter : Presenter(){
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val cardView = ImageCardView(parent.context)
        cardView.isFocusable = true
        cardView.isFocusableInTouchMode = true
        return ViewHolder(cardView)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val video = item as Video
        val cardView = viewHolder.view as ImageCardView
        cardView.titleText = video.title
        cardView.contentText = video.description
        cardView.setMainImageDimensions(313,176)

        Glide.with(cardView.context)
            .load(video.imageUrl)
            .centerCrop()
            .into(cardView.mainImageView)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        TODO("Not yet implemented")
    }
}