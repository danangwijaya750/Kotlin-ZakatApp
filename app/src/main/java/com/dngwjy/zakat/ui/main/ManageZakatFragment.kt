package com.dngwjy.zakat.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dngwjy.zakat.R
import kotlinx.android.synthetic.*

/**
 * Created by wijaya on 5/12/19.
 */
class ManageZakatFragment:Fragment(){
    companion object{
        fun newInstance():ManageZakatFragment{
            return ManageZakatFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.manage_zakat_fragment,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initiations()
    }
    private fun initiations(){

    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}