package com.kocerlabs.cryptoappmvvm.ui.dashboard

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kocerlabs.cryptoappmvvm.data.network.model.TempModel
import com.kocerlabs.cryptoappmvvm.databinding.ViewholderStockBinding
import java.text.DecimalFormat

class StockAdapter(
    private val dataList: List<TempModel>
) : RecyclerView.Adapter<StockAdapter.StockViewHolder>() {

    private val formatter = DecimalFormat("###,###,###,###.##")

    inner class StockViewHolder(private val stockBinding: ViewholderStockBinding) :
        RecyclerView.ViewHolder(stockBinding.root) {

        fun bind(model: TempModel) {
            with(stockBinding) {
                cryptoName.text = model.name
                cryptoPriceTxt.text = "$${formatter.format(model.price)}"
                changePercentTxt.text = "${model.changePercent}%"
                sparkLineLayout.setData(model.lineData)

                val picName = when (model.name) {
                    "NASDAQ100" -> "stock_1"
                    "S&P 500" -> "stock_2"
                    "DoW Jones" -> "stock_3"
                    else -> "stock_1"
                }
                val changeColor = when {
                    model.changePercent > 0 -> Color.parseColor("#12C737")
                    model.changePercent < 0 -> Color.parseColor("#FF0000")
                    else -> Color.WHITE
                }
                changePercentTxt.setTextColor(changeColor)
                sparkLineLayout.sparkLineColor = changeColor

                val drawableResourceId = itemView.context.resources.getIdentifier(
                    picName, "drawable", itemView.context.packageName
                )

                Glide.with(itemView.context)
                    .load(drawableResourceId)
                    .into(logoImg)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder =
        StockViewHolder(
            ViewholderStockBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}