package com.yefell.minegocio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductoAdapter(private val productos: List<Producto>) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewProducto: ImageView = itemView.findViewById(R.id.imageViewProducto)
        val textViewNombreProducto: TextView = itemView.findViewById(R.id.textViewNombreProducto)
        val textViewPrecioProducto: TextView = itemView.findViewById(R.id.textViewPrecioProducto)
        val textViewStockProducto: TextView = itemView.findViewById(R.id.textViewStockProducto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]
        holder.textViewNombreProducto.text = producto.nombre
        holder.textViewPrecioProducto.text = "Precio: ${producto.precio}"
        holder.textViewStockProducto.text = "Stock: ${producto.stock}"

        // Usar Glide para cargar la imagen del producto
        Glide.with(holder.itemView.context)
            .load(producto.imagen) // Aquí se usa la URL o URI de la imagen
            .into(holder.imageViewProducto)
    }

    override fun getItemCount(): Int {
        return productos.size
    }
}
