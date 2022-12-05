package com.example.cvbuilder

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val myPageAdapter = MyPageAdapter(this) // Set the Adapter to your Viewpager UI
        vpager.adapter = myPageAdapter
// Will align the space according to the Screen size to equally spread
        tlayout.tabGravity = TabLayout.GRAVITY_FILL
/* Setting up Tab Layout with the ViewPageg2 is handled by
the TabLayoutMediator class
       * by passing your tablayout id and viewpager id*/
        TabLayoutMediator(tlayout,vpager){tab,position->
            when(position){
                0->{
                    tab.text="Home"
                    tab.setIcon(R.drawable.home) }
                1->{
                    tab.text="About"
                    tab.setIcon(R.drawable.user) }
                2->{
                    tab.text="Work"
                    tab.setIcon(R.drawable.work) }
                3->{
                    tab.text="Contact"
                    tab.setIcon(R.drawable.contact)
                }
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.topnav, menu);
        return true;
    }
    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        val intent = Intent(this, WebviewActivity::class.java)
            when(item.itemId) {
                R.id.m2 -> {
                    val dialIntent = Intent(Intent.ACTION_DIAL)
                    dialIntent.data = Uri.parse("tel:" + "8344814819")
                    startActivity(dialIntent)
                }
                R.id.m3 -> {
                    intent.putExtra("url", "https://facebook.com")
                    startActivity(intent)
                }
                R.id.m4 -> {
                    intent.putExtra("url", "https://linkedin.com/in/mosanusi/")
                    startActivity(intent)                }
                R.id.m5 -> {
                    intent.putExtra("url", "https://twitter.com")
                    startActivity(intent)                 }
            }

        return true;
    }
}