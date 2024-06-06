package com.dakingx.app.dkcamerax.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dakingx.app.dkcamerax.databinding.ActivityMainBinding
import com.dakingx.dkcamerax.ext.checkAppPermission
import com.dakingx.dkcamerax.fragment.CameraDirection
import com.dakingx.dkcamerax.fragment.CameraFragment
import com.hjq.permissions.OnPermissionCallback
import com.hjq.permissions.XXPermissions

class MainActivity : AppCompatActivity() {

    private val mBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        mBinding.frontCameraBtn.setOnClickListener {
            startCameraActivity(CameraDirection.Front)
        }

        mBinding.backCameraBtn.setOnClickListener {
            startCameraActivity(CameraDirection.Back)
        }
    }

    private fun toast(stringResId: Int) {
        Toast.makeText(this, getString(stringResId), Toast.LENGTH_SHORT).show()
    }

    private fun startCameraActivity(cameraDirection: CameraDirection) {

        XXPermissions.with(this)
            .permission(*CameraFragment.REQUIRED_PERMISSIONS_TIRAMISU.toTypedArray())
            .request(object : OnPermissionCallback {
                override fun onGranted(permissions: MutableList<String>, allGranted: Boolean) {

                    this@MainActivity.checkAppPermission(*permissions.toTypedArray())

                    if (!allGranted) {
                        return
                    }

                    runOnUiThread {
                        CameraActivity.start(this@MainActivity, cameraDirection)
                    }

                }

                override fun onDenied(permissions: MutableList<String>, doNotAskAgain: Boolean) {
                    super.onDenied(permissions, doNotAskAgain)

                }
            })

    }
}
