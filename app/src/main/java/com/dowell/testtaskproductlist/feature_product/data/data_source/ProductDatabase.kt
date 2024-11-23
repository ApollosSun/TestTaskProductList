package com.dowell.testtaskproductlist.feature_product.data.data_source

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dowell.testtaskproductlist.R
import com.dowell.testtaskproductlist.core.data.util.RawResourceReader
import com.dowell.testtaskproductlist.feature_product.domain.model.Product
import kotlinx.serialization.json.Json

@Database(
    entities = [Product::class],
    version = 1
)
abstract class ProductDatabase : RoomDatabase() {

    abstract val productDao: ProductDao

    companion object {
        const val DATABASE_NAME = "products_db"

        fun populateDatabase(context: Context, db: SupportSQLiteDatabase) {
            val jsonString = RawResourceReader.readJsonFromRaw(context, R.raw.products)
            val productList = Json.decodeFromString<List<Product>>(jsonString)
            productList.forEach { product ->
                db.execSQL(
                    "INSERT INTO product (id, name, description, price, imageUrl, quantity) VALUES (?, ?, ?, ?, ?, ?)",
                    arrayOf(
                        product.id,
                        product.name,
                        product.description,
                        product.price,
                        product.imageUrl,
                        product.quantity
                    )
                )
            }
        }
    }

}