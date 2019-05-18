package com.dngwjy.zakat.utilities

import android.content.Context
import android.widget.Toast

/**
 * Created by wijaya on 5/13/19.
 */
fun Context.toast(msg:String?)=msg.let{
    Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
}
