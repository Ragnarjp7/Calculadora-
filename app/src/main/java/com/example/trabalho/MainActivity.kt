package calculadora;

import ...

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero,numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,numeroSete,numeroOito,
            numeroNove,ponto,soma,subtracao,multiplicacao,divisao,igual,botao_limpar;

    private TextView txtExpressao,txtResultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        botao_limpar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        txtExpressao.setText("");
        txtResultado.setText("");
    }
});

        backspace.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        TextView expressao = findViewById(R.id.txt_expressao);
        String string = expressao.getText().toString();

        if (!string.isEmpty()){

            byte var0 = 0;
            int var1 = string.length()-1;
            String string_final = string.substring(var0,var1);
            expressao.setText(string_final);
        }
        txtResultado.setText("");
    }
});
    }

    private void IniciarComponentes(){
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        botao_limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);
    }
    public void AcrescentarUmaExpressao(String string,boolean limpar_dados){

        if (txtResultado.getText().equals("")){
            txtExpressao.setText("");
        }

        if (limpar_dados){
            txtResultado.setText("");
            txtExpressao.append(string);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText("");
        }
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.numero_zero:
                AcrescentarUmaExpressao( string: "0", limpar_dados: true);
                break;

                case R.id.numero_um:
                AcrescentarUmaExpressao( string: "1", limpar_dados: true);
                break;

                case R.id.numero_dois:
                AcrescentarUmaExpressao( string: "2", limpar_dados: true);
                break;

                case R.id.numero_quatro:
                AcrescentarUmaExpressao( string: "4", limpar_dados: true);
                break;

                case R.id.numero_cinco:
                AcrescentarUmaExpressao( string: "5", limpar_dados: true);
                break;

                case R.id.numero_seis:
                AcrescentarUmaExpressao( string: "6", limpar_dados: true);
                break;

                case R.id.numero_sete:
                AcrescentarUmaExpressao( string: "7", limpar_dados: true);
                break;

                case R.id.numero_oito:
                AcrescentarUmaExpressao( string: "8", limpar_dados: true);
                break;

                case R.id.numero_nove:
                AcrescentarUmaExpressao( string: "9", limpar_dados: true);
                break;

                case R.id.ponto:
                AcrescentarUmaExpressao( string: ".", limpar_dados: true);
                break;

                case R.id.soma:
                AcrescentarUmaExpressao( string: "+", limpar_dados: false);
                break;

                case R.id.subtracao:
                AcrescentarUmaExpressao( string: "-", limpar_dados: false);
                break;

                case R.id.multiplicacao:
                AcrescentarUmaExpressao( string: "*", limpar_dados: false);
                break;

                case R.id.divisao:
                AcrescentarUmaExpressao( string: "/", limpar_dados: false);
                break;
            }
        }
    }
}