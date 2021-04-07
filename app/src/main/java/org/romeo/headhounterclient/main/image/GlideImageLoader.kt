package org.romeo.headhounterclient.main.image

import android.widget.ImageView
import com.bumptech.glide.Glide
import org.romeo.headhounterclient.model.image.IImageLoader

class GlideImageLoader : IImageLoader<ImageView> {
    override fun loadInto(container: ImageView, url: String) {
        Glide.with(container)
            .load(url)
            .into(container)
    }
}