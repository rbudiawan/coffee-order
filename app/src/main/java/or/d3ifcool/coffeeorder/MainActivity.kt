package or.d3ifcool.coffeeorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
                var basePrice = 5
                if(cbChoco.isChecked)
                    basePrice = basePrice+2
                if(cbWhipped.isChecked)
                    basePrice = basePrice+1

                val price = quantity*basePrice

                tvPrice.text = getString(R.string.price_value,price.toString())

                val myIdentity = MyName(etName.text.toString())
                namaku = myIdentity
                tvResult.visibility = View.VISIBLE
            }
        }

    }
}
