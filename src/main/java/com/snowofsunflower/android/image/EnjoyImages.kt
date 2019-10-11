package com.snowofsunflower.android.image;

import android.content.Context
import com.snowofsunflower.image_component.R

/**
 * Created by zhouztashin on 2018/10/31.
 * 简易的图片使用方式
 */

object EnjoyImages {

    private var imageRound: ImageRound? = null
    private var imageCircle: ImageCircle? = null
    /**
     * 封装成Any，便于之后扩展
     */
    //TODO 用什么样的实现方式才可以比较好的把？去掉
    fun pureLoader(context: Context, res: Any): ImageLoaderConfig? {
        var loader: ImageLoaderConfig? = null
        return res?.let {
            when (it) {
                it is Int -> {
                    val value = res as Int
                    loader = GlideImageLoader(context).load(value)
                }
                it is String -> {
                    val value = res as String
                    loader = GlideImageLoader(context).load(value)
                }
            }
            loader
        }
    }

    /**
     * 常用图片加载器
     */
    fun loader(context: Context, res: Any): ImageLoaderConfig? {
        return pureLoader(context, res)?.placeholder(R.drawable.com_image_load_placeholder)?.error(R.drawable.com_image_load_error)
    }

    /**
     * 圆角图片加载器
     */
    fun roundLoader(context: Context, res: Any): ImageLoaderConfig? {

        if (imageRound == null) {
            imageRound = ImageRound(context.resources.getDimension(R.dimen.round))
        }
        val shape = imageRound as IImageShape
        return loader(context, res)?.shape(shape)
    }

    /**
     * 圆形图片加载器
     */
    fun circleLoader(context: Context, res: String): ImageLoaderConfig? {
        if (imageCircle == null) {
            imageCircle = ImageCircle()
        }
        val shape = imageCircle as IImageShape
        return loader(context, res)?.shape(shape)
    }
}
