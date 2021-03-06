package br.com.heiderlopes.primeiroprojeto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Toast
import br.com.heiderlopes.primeiroprojeto.extensions.format
import br.com.heiderlopes.primeiroprojeto.utils.ConstantesExtra
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val peso = intent.extras.getString(ConstantesExtra.KEY_PESO)
        val altura = intent.extras.getString(ConstantesExtra.KEY_ALTURA)

        caucularIMC(peso.toDouble(), altura.toDouble())

        Toast.makeText(this,
                peso,
                Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    private fun caucularIMC(peso: Double, altura: Double) {
        val imc = peso / (altura * altura)



        when (imc) {

            in 0..17 -> {
                tvIMC.text = imc.format(0)
                setImagem(R.drawable.magreza)
                tvIMCDescricao.text = getString(R.string.label_magreza)
            }
            in 17.1..18.5 -> {
                tvIMC.text = imc.format(0)
                setImagem(R.drawable.abaixo)
                tvIMCDescricao.text = getString(R.string.label_magro)
            }
            in 18.6..24.9 -> {
                tvIMC.text = imc.format(0)
                setImagem(R.drawable.ideal)
                tvIMCDescricao.text = getString(R.string.label_ideal)
            }
            in 25.0..29.9 -> {
                tvIMC.text = imc.format(0)
                setImagem(R.drawable.sobre)
                tvIMCDescricao.text = getString(R.string.label_sobre)
            }
            in 30.0..34.9 -> {
                tvIMC.text = imc.format(0)
                setImagem(R.drawable.obesidade)
                tvIMCDescricao.text = getString(R.string.label_gordo)
            }

            else -> {
                tvIMC.setText(imc.format(0))
                setImagem(R.drawable.obesidademorbida)
                tvIMCDescricao.text = getString(R.string.label_obesidade)
            }
        }
    }

    private fun setImagem(resourceId: Int) {
        ivIMC.setImageDrawable(ContextCompat.getDrawable(this, resourceId))

    }


}
