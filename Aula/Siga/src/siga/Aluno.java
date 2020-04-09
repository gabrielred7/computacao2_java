
package siga;

public class Aluno { 
    private String nome;
    private final long dre;
    private float cra;
    private DisciplinaComNota[] historico;
    private int quantDisciplinasCursadas;
    
   /**
     * Construtor.
     * @param dreDoAluno
     */
    public Aluno(long dreDoAluno){
        nome = "Anonimo";
        dre = dreDoAluno;
        cra = 0;
        historico = new DisciplinaComNota[100];
        quantDisciplinasCursadas = 0;
    }
    
    private class DisciplinaComNota{
        Disciplina disciplina;
        float nota;
        DisciplinaComNota(Disciplina d, float nota){
        this.disciplina = d;
        this.nota = nota;
        }
    }
    
    public void incluirDisciplinaCursada(Disciplina disciplinaCursada, float notaObtida){
        if (notaObtida < 0 || notaObtida > 10){
            return;
        }
        DisciplinaComNota d = new DisciplinaComNota(disciplinaCursada, notaObtida);
        historico[quantDisciplinasCursadas] = d;
        quantDisciplinasCursadas++;
        atualizarCra();
    }
    private void atualizarCra(){
        int totalCreditos = 0;
        float acumulado = 0;
        for (int i = 0; i < quantDisciplinasCursadas; i++){
            DisciplinaComNota dcn = historico[i];
            int quantCreditos = dcn.disciplina.getQuantCreditos();
            acumulado = acumulado + dcn.nota * quantCreditos;
            totalCreditos = totalCreditos + quantCreditos;
        }
        this.cra = acumulado / totalCreditos;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        if (nome.length() > 30){
            return;
        }
        this.nome = nome;
    }
    
    public float getCra() {
        return cra;
    }
    
    public long getDre() {
        return dre;
    }
}
