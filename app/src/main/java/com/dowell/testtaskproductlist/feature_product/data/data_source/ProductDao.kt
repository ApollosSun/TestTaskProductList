package com.dowell.testtaskproductlist.feature_product.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dowell.testtaskproductlist.feature_product.domain.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getProducts(): Flow<List<Product>>

    @Query("SELECT * FROM product WHERE id = :id")
    suspend fun getProductById(id: Int): Product?

    @Query("SELECT COUNT(*) FROM Product")
    suspend fun getProductCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products: List<Product>)

    @Query("UPDATE Product SET quantity = :newQuantity WHERE id = :productId")
    suspend fun updateQuantity(productId: Int, newQuantity: Int)

}