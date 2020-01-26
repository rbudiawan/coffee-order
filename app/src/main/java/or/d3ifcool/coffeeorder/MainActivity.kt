package or.d3ifcool.coffeeorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import or.d3ifcool.coffeeorder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var quantity = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.apply {
            bPlus.setOnClickListener {
                quantity +=1
                tvQuantity.text=quantity.toString()
            }

            bMinus.setOnClickListener {
                quantity -=1
                tvQuantity.text=quantity.toString()
            }

            bOrder.setOnClickListener {
                val price = quantity*5
                tvPrice.text = getString(R.string.price_value,price.toString())
            }
        }

    }
}
