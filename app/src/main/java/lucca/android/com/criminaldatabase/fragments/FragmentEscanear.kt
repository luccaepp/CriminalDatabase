package lucca.android.com.criminaldatabase.fragments

import android.hardware.Camera
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.view.SurfaceHolder.Callback
import lucca.android.com.criminaldatabase.R



class FragmentEscanear : Fragment(), Callback {


    var camera: Camera ?= null
    var surfaceView: SurfaceView ?= null
    var surfaceHolder: SurfaceHolder ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragmentescanear , container, false)
        surfaceView = root.findViewById(R.id.surfaceView)
        surfaceHolder = surfaceView?.getHolder()
        surfaceHolder?.addCallback(this)
        surfaceHolder?.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)

        return root
    }


    override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {}

    override fun surfaceDestroyed(p0: SurfaceHolder?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun surfaceCreated(p0: SurfaceHolder?) {

        camera = Camera.open()
        var param : Camera.Parameters = camera!!.parameters
        camera!!.setDisplayOrientation(90)
        param.setPreviewFrameRate(30)
        param.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE)
        camera!!.setParameters(param)
        camera!!.setPreviewDisplay(surfaceHolder)
        camera!!.startPreview()


    }

}