package br.com.heiderlopes.primeiroprojeto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import br.com.heiderlopes.primeiroprojeto.extensions.meuClear
import br.com.heiderlopes.primeiroprojeto.extensions.value
import br.com.heiderlopes.primeiroprojeto.utils.ConstantesExtra
import kotlinx.android.synthetic.main.activity_formulario.*

class FormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        btLimpar.setOnClickListener {
            inputAltura.meuClear()
            inputPeso.meuClear()

        }

        btCalcular.setOnClickListener {
            chamarTelaResultado()

        }
    }

    private fun chamarTelaResultado() {

        val telaResultado = Intent(this, ResultadoActivity::class.java)
        telaResultado.putExtra(ConstantesExtra.KEY_PESO, inputPeso.value())
        telaResultado.putExtra(ConstantesExtra.KEY_ALTURA, inputAltura.value())
        startActivity(telaResultado)

    }


}
