package com.tjoeum.a20191113_02_practice

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.tjoeum.a20191113_02_practice.datas.PizzaData
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {


    var pizzaData: PizzaData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setValues()
        setupEvents()

    }


    override fun setupEvents() {

        pizzaNumCall.setOnClickListener {
            var permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
                    var uri = Uri.parse("tel:${pizzaData?.phoneNum?.replace("-","")}")
                    var intent = Intent(Intent.ACTION_CALL,uri)
                    startActivity(intent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "권한을 설정해야 전화 사용 가능합니다", Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission.with(mContext)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("설정 > 권한에서 허용가능합니다.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }
        exit.setOnClickListener(){
            finish()
        }

    }

    override fun setValues() {

        pizzaData = intent.getSerializableExtra("pizzaData") as PizzaData

        Glide.with(mContext).load("${pizzaData?.pizzaLogo}").into(pizzaLogo)

        detailPizzaNameTxt.text = pizzaData?.pizzaName
        detailPizzaPhoneNum.text = pizzaData?.phoneNum


    }



}
