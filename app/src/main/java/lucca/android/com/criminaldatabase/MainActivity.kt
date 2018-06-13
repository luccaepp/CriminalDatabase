package lucca.android.com.criminaldatabase

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import lucca.android.com.criminaldatabase.adapters.ViewPagerAdapter
import lucca.android.com.criminaldatabase.fragments.FragmentAdicionar
import lucca.android.com.criminaldatabase.fragments.FragmentEscanear
import lucca.android.com.criminaldatabase.fragments.FragmentListar

class MainActivity : AppCompatActivity() {

    val CONTEXT: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupTabs()
    }


    fun setupTabs(){

        var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        var tabLayout: TabLayout? = findViewById(R.id.tabLayout)
        var viewPager: ViewPager? = findViewById(R.id.pageViewer)
        adapter.addFragment(FragmentListar(), "")
        adapter.addFragment(FragmentEscanear(), "")
        adapter.addFragment(FragmentAdicionar(), "")
        viewPager?.setAdapter(adapter)
        tabLayout?.setupWithViewPager(viewPager)
        tabLayout?.setAnimation(null)
    }


}
