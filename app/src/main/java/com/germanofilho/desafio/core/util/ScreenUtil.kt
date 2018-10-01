package com.germanofilho.desafio.core.util

import android.content.Context
import android.content.res.Configuration
import com.germanofilho.desafio.App


open class ScreenUtil {

    companion object {
        fun isTabletDevice(context : Context) : Boolean {
            return context.resources.configuration.screenLayout and
                    Configuration.SCREENLAYOUT_SIZE_MASK >=
                    Configuration.SCREENLAYOUT_SIZE_LARGE
        }

        fun setValueIfTablet() : Int {
            return if(isTabletDevice(App.instance))
                return 6
                else 3
        }
    }
}

