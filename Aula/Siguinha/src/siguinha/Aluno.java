package siguinha;

public class Aluno {
    
    // atributos
    private String nome;
    private final long dre;
    private final int anoDeMatricula;
    private int creditosAcumulados; // Somatorio_d [creditos(d)]
    private float cra;  // cra = Somatorio_d [media(d) * reditos(d)]
    private int quantDisciplinasCursadas = 0;
    private final ItemDeHistorico[] disciplinasCursadas;
    
    
    // construtores
    public Aluno(long dre, int anoDeMatricula, String nome ) {
        this.dre = dre;
        this.anoDeMatricula = anoDeMatricula;
        this.nome = nome;
        this.disciplinasCursadas = new ItemDeHistorico[16];
    }
    // acessores
    public String getNome() {
        if (nome == null){
            return "Sem Nome";
        }
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 30){
            return;
        }
        this.nome = nome;
    }

    public long getDre() {
        return dre;
    }
    
    public float getCra() {
        return cra;
    }
    
    public int getCreditosAcumulados() {
        return creditosAcumulados;
    }    

    public int getAnoDeMatricula() {
        return anoDeMatricula;
    }

    public int getQuantDisciplinasCursadas() {
        return quantDisciplinasCursadas;
    }

    public ItemDeHistorico[] getDisciplinasCursadas() {
        return disciplinasCursadas;
    }
    
    // metodos
    public void registrarConclusaoDisciplina(Disciplinas disciplina, float mediaFinal, int anoConclusao, int semestreConclusao){
        ItemDeHistorico novoItem = new ItemDeHistorico(disciplina, this, anoConclusao, semestreConclusao, mediaFinal);

        this.disciplinasCursadas[this.quantDisciplinasCursadas] = novoItem;
        this.quantDisciplinasCursadas++;  // incrementa a quant já cursada

        // recupero o numerador corrente (antes da nova disciplina)
        float numeradorCorrenteCra = this.cra * this.creditosAcumulados;

        int creditos = disciplina.getCreditos();
        this.creditosAcumulados += creditos;

        // atualizar o CRA do aluno
        float novaParcela = creditos * mediaFinal;
        this.cra = (numeradorCorrenteCra + novaParcela) / this.creditosAcumulados;
    }
    
    public String retornarHistoricoAsString(){
        String resultado = " ";
        for (int i = 0; i < this.quantDisciplinasCursadas; i++) {
            ItemDeHistorico item = this.disciplinasCursadas[i];
            resultado = resultado + item.getDisciplina().getCodigo() + 
                    " - média " + item.getMediaFinal() +
                    " - " + item.getDisciplina().getCreditos() + " creditos" + 
                    " - " + item.getAno() + "." + item.getSemestre();
            if (i < this.quantDisciplinasCursadas - 1) {
                resultado = resultado + "\n";
            }
        }
        return resultado;
    }
    
    @Override
    public String toString() {
        return String.format("%s (DRE: %d", this.nome, this.dre);
    }   

}