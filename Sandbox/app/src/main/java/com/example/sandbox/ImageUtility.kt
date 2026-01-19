package com.example.sandbox

import android.content.Context
import android.graphics.Bitmap
import java.io.File
import java.io.FileOutputStream
import java.util.UUID

class ImageUtility {
    // 画像を保存して、その「パス」を返す関数
    fun saveImageToInternalStorage(context: Context, bitmap: Bitmap): String? {
        // アプリ専用の "images" フォルダを作成
        val directory = File(context.filesDir, "images")
        if (!directory.exists()) directory.mkdirs()

        // 重複しないファイル名を生成 (UUIDを使用)
        val fileName = "${UUID.randomUUID()}.jpg"
        val file = File(directory, fileName)

        return try {
            val out = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out) // 圧縮率90%
            out.flush()
            out.close()
            file.absolutePath // 保存した場所（パス）を返す
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}