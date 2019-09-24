package com.snowofsunflower.android.image;

import android.content.Context
import com.snowofsunflower.image_component.R

/**
 * Created by zhouztashin on 2018/10/31.
 */

class EnjoyImages {

    companion object {
        //多个参数的情况，有没有好的实现方式
        private var imageRound: ImageRound? = null
        private var imageCircle: ImageCircle? = null
        fun pureLoader(context: Context, res: Int) = GlideImageLoader(context).load(res)
        fun pureLoader(context: Context, res: String) = GlideImageLoader(context).load(res)
        fun loader(context: Context, res: Int) = pureLoader(context, res).placeholder(R.drawable.com_image_load_placeholder).error(R.drawable.com_image_load_error)
        fun loader(context: Context, res: String) = pureLoader(context, res).placeholder(R.drawable.com_image_load_placeholder).error(R.drawable.com_image_load_error)
        fun roundLoader(context: Context, res: Int): ImageLoaderConfig {
            if (imageRound == null) {
                imageRound = ImageRound(context.resources.getDimension(R.dimen.round))
            }
            return loader(context, res).shape(imageRound!!)
        }

        fun roundLoader(context: Context, res: String): ImageLoaderConfig {
            if (imageRound == null) {
                imageRound = ImageRound(context.resources.getDimension(R.dimen.round))
            }
            return loader(context, res).shape(imageRound!!)
        }

        fun circleLoader(context: Context, res: Int): ImageLoaderConfig {
            if (imageCircle == null) {
                imageCircle = ImageCircle()
            }
            return loader(context, res).shape(imageCircle!!)
        }

        fun circleLoader(context: Context, res: String): ImageLoaderConfig {
            if (imageCircle == null) {
                imageCircle = ImageCircle()
            }
            return loader(context, res).shape(imageCircle!!)
        }
    }
}
