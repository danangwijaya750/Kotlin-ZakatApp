package com.dngwjy.zakat.views

/**
 * Created by wijaya on 5/12/19.
 */
interface BaseView {
    fun isLoading(state:Boolean)
    fun showResult(state:Boolean,data:List<Any>)
}