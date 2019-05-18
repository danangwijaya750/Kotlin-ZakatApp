package com.dngwjy.zakat.utilities

import android.util.Log

/**
 * Created by wijaya on 5/13/19.
 */
inline fun <reified T>T.logD(msg:String?){
    Log.d(T::class.java.simpleName,msg)
}
inline fun<reified T>T.logE(msg:String?){
    Log.e(T::class.java.simpleName,msg)
}