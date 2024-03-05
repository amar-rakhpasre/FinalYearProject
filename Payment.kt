package com.example.atvmapp

import android.graphics.Bitmap
import android.graphics.Bitmap.createBitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix

class Payment : AppCompatActivity() {
    private lateinit var buttonGenerateQR: Button
    public lateinit var imageViewQRCode: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        //   buttonGenerateQR = findViewById(R.id.buttonGenerateQR)
        imageViewQRCode = findViewById(R.id.imageViewQRCode)

        // buttonGenerateQR.setOnClickListener { generateQRCode() }

       // public fun generateQRCode() {
            val receivedData =  intent.getStringExtra("keyName") // Fixed payment amount of 5 INR
            val data =receivedData.toString()
            try {
                val bitMatrix = generateQRCode(data)
                val bitmap = createBitmap(bitMatrix)
                imageViewQRCode.setImageBitmap(bitmap)
            } catch (e: WriterException) {
                e.printStackTrace()
            }
        }

        private fun generateQRCode(data: String): BitMatrix {
            val multiFormatWriter = MultiFormatWriter()
            return multiFormatWriter.encode(data, BarcodeFormat.QR_CODE, 500, 500)
        }

        private fun createBitmap(bitMatrix: BitMatrix): Bitmap {
            val width = bitMatrix.width
            val height = bitMatrix.height
            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

            for (x in 0 until width) {
                for (y in 0 until height) {
                    bitmap.setPixel(
                        x,
                        y,
                        if (bitMatrix[x, y]) 0xFF000000.toInt() else 0xFFFFFFFF.toInt()
                    )
                }
            }

            return bitmap
        }

    }

