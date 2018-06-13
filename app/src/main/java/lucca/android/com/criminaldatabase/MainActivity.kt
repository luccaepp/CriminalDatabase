package lucca.android.com.criminaldatabase

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.util.Log
import io.vrinda.kotlinpermissions.PermissionCallBack
import io.vrinda.kotlinpermissions.PermissionsActivity
import lucca.android.com.criminaldatabase.adapters.ViewPagerAdapter
import lucca.android.com.criminaldatabase.fragments.FragmentAdicionar
import lucca.android.com.criminaldatabase.fragments.FragmentEscanear
import lucca.android.com.criminaldatabase.fragments.FragmentListar

class MainActivity : PermissionsActivity() {

    val CAMERA_REQUEST_CODE = 0
    val TAG = "tag"

    val CONTEXT: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPermissions()
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

    fun setupPermissions() {

        requestPermissions(arrayOf(android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE), object : PermissionCallBack {
            override fun permissionGranted() {
                super.permissionGranted()
                Log.v("Camera permissions", "Denied")
            }

            override fun permissionDenied() {
                super.permissionDenied()
                Log.v("Camera permissions", "Denied")
            }
        })


    }


}
