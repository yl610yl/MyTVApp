package com.example.mytvapp.ui

import android.content.Intent
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
            Video("Netflix", "超清播放",
                "https://images.ctfassets.net/y2ske730sjqp/1aONibCke6niZhgPxuiilC/2c401b05a07288746ddf3bd3943fbc76/BrandAssets_Logos_01-Wordmark.jpg"
            ,"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
            Video("YouTube", "视频流媒体",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/YouTube_full-color_icon_%282024%29.svg/1857px-YouTube_full-color_icon_%282024%29.svg.png"
            ,"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
        )
        val cardRowAdapter  = ArrayObjectAdapter(cardPresenter)
        videoList.forEach{ cardRowAdapter.add(it)}

        val headerItem = HeaderItem(0, "推荐")
        rowsAdapter.add(ListRow(headerItem,cardRowAdapter))

        adapter = rowsAdapter

        setOnItemViewClickedListener { _, item, _, _ ->
            if (item is Video){
                Log.d("MainFragment", "点击视频: ${item.title}")
                val intent = Intent(requireContext(), VideoPlayerActivity::class.java).apply {
                    putExtra("title", item.title)
                    putExtra("url", item.videoUrl)
                }
                startActivity(intent)
            }
        }

    }

}