package com.example.mytvapp.ui

import android.os.Bundle
import android.util.Log
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import com.example.mytvapp.model.Video
import com.example.mytvapp.presenter.CardPresenter

class MainFragment : BrowseSupportFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        title = "My TV App"

        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        val cardPresenter = CardPresenter()

        val videoList = listOf(
            Video("标题 1", "描述 1", "https://example.com/video1.jpg"),
            Video("标题 2", "描述 2", "https://example.com/video2.jpg")
        )
        val cardRowAdapter  = ArrayObjectAdapter(cardPresenter)
        videoList.forEach{ cardRowAdapter.add(it)}

        val headerItem = HeaderItem(0, "推荐")
        rowsAdapter.add(ListRow(headerItem,cardRowAdapter))

        adapter = rowsAdapter

        setOnItemViewClickedListener { _, item, _, _ ->
            if (item is Video){
                Log.d("MainFragment", "点击视频: ${item.title}")
            }
        }

    }

}