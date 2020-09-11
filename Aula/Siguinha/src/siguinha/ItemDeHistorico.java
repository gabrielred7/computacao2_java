
package siguinha;
import java.util.Calendar;

public final class ItemDeHistorico {
   
    // atributos
    private Disciplinas disciplina;
    private int ano;
    private int semestre;
    private float mediaFinal;
    private final  Aluno aluno;
    
    //construtor
    public ItemDeHistorico(Disciplinas disciplina, Aluno aluno, int ano, int semestre, float mediaFinal){
        this.disciplina = disciplina;
        this.aluno = aluno;
        setAno(ano);
        this.semestre = semestre;
        this.mediaFinal = mediaFinal;
    }
    
    public Disciplinas getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplinas disciplina) {
        this.disciplina = disciplina;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        int anoCorrente = Calendar.getInstance().get(Calendar.YEAR);
        if (ano < aluno.getAnoDeMatricula() || ano > anoCorrente) {
            return;
        }
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        if (semestre < 1 || semestre > 2) {
            return;
        }
        this.semestre = semestre;
    }

    public float getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(float mediaFinal) {
        this.mediaFinal = mediaFinal;
    }
    
    public boolean obteveAprovacao() {
        return this.mediaFinal >= Siguinha.MEDIA_MINIMA_PARA_APROVACAO;
    }
}