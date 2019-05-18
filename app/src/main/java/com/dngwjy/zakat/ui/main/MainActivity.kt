package com.dngwjy.zakat.ui.main

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.dngwjy.zakat.R
import com.dngwjy.zakat.presenters.MainPresenter
import com.dngwjy.zakat.utilities.toast
import com.dngwjy.zakat.views.BaseView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,BaseView {
    override fun isLoading(state: Boolean) {

    }

    override fun showResult(state: Boolean, data: List<Any>) {

    }

    lateinit var presenter: MainPresenter
    private var isRootPosition:Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
        initiations()
    }
    private fun initiations(){
        onNavigationItemSelected(nav_view.menu.getItem(0))
        nav_view.menu.getItem(0).isChecked=true
        presenter= MainPresenter(this)
        when(presenter.checkLogged()){
            true->nav_view.menu.findItem(R.id.nav_send).title="Logout"
            else->nav_view.menu.findItem(R.id.nav_send).title="Login"
        }
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            when(isRootPosition){
                true->{
                    super.onBackPressed()
                }
                false->{
                    onNavigationItemSelected(nav_view.menu.getItem(0))
                    nav_view.menu.getItem(0).isChecked=true
                }
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                replaceFragment(OverviewZakatFragment.newInstance())
                isRootPosition=true
            }
            R.id.nav_gallery -> {
                isRootPosition=false
            }
            R.id.nav_slideshow -> {
                isRootPosition=false
            }
            R.id.nav_tools -> {
                when(presenter.checkLogged()){
                    true->{
                        replaceFragment(ManageZakatFragment.newInstance())
                        isRootPosition=false
                    }
                    else->{toast("Anda Tidak dapat mengakses halaman ini")
                        onNavigationItemSelected(nav_view.menu.getItem(0))
                        nav_view.menu.getItem(0).isChecked=true
                    }
                }
            }
            R.id.nav_share -> {
                isRootPosition=false
            }
            R.id.nav_send -> {
                isRootPosition=false
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    private fun replaceFragment(fragment:Fragment){
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
