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

    fun pureLoader(context: Context, res: Int) = innerPureLoader(context, res)
    fun pureLoader(context: Context, res: String) = innerPureLoader(context, res)

    //用什么样的实现方式才可以比较好的把？去掉？由于本身是存在空的可能，例如传入其他类型
    private fun innerPureLoader(context: Context, res: Any): ImageLoaderConfig? {
        var loader: ImageLoaderConfig? = null
        return res.let {
            when (it) {
                is Int -> {
                    val value = res as Int
                    loader = GlideImageLoader(context).load(value)
                }
                is String -> {
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
    fun loader(context: Context, res: Int): ImageLoaderConfig? {
        return pureLoader(context, res)?.placeholder(R.drawable.com_image_load_placeholder)?.error(R.drawable.com_image_load_error)
    }

    fun loader(context: Context, res: String): ImageLoaderConfig? {
        return pureLoader(context, res)?.placeholder(R.drawable.com_image_load_placeholder)?.error(R.drawable.com_image_load_error)
    }
    /**
     * 圆角图片加载器
     */
    fun roundLoader(context: Context, res: Int): ImageLoaderConfig? {

        if (imageRound == null) {
            imageRound = ImageRound(context.resources.getDimension(R.dimen.round))
        }
        val shape = imageRound as IImageShape
        return loader(context, res)?.shape(shape)
    }

    fun roundLoader(context: Context, res: String): ImageLoaderConfig? {

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

    fun circleLoader(context: Context, res: Int): ImageLoaderConfig? {
        if (imageCircle == null) {
            imageCircle = ImageCircle()
        }
        val shape = imageCircle as IImageShape
        return loader(context, res)?.shape(shape)
    }
}
