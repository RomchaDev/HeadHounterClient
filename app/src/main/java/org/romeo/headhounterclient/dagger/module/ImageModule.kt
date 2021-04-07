package org.romeo.headhounterclient.dagger.module

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import org.romeo.headhounterclient.main.image.GlideImageLoader
import org.romeo.headhounterclient.model.image.IImageLoader
import javax.inject.Singleton

@Module
class ImageModule {
    @Provides
    @Singleton
    fun imageLoader(): IImageLoader<ImageView> =
        GlideImageLoader()
}