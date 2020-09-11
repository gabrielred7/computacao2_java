
package testes;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import siguinha.Aluno;
import siguinha.Disciplinas;
import siguinha.ItemDeHistorico;

public class AlunoTeste {
    
    private Aluno aluno;
    private Disciplinas disciplina1;
    private Disciplinas disciplina2;
    private Disciplinas disciplina3;
    
    @Before
    public void setUp() {
        aluno = new Aluno(12345, 2018, "Aluno Teste");

        disciplina1 = new Disciplinas("MAB001", "Disciplina 1");
        disciplina1.setCreditos(4);

        disciplina2 = new Disciplinas("MAB002", "Disciplina 2");
        disciplina2.setCreditos(6);

        disciplina3 = new Disciplinas("MAJ003", "Disciplina 3");
        disciplina3.setCreditos(6);
    }
    
    @Test
    public void getDreTeste(){
        assertEquals(12345, aluno.getDre());
    }
    
    @Ignore
    @Test
    public void getCraTeste(){}
    
    @Test
    public void getConclusaoDisciplinaTeste(){
        ItemDeHistorico[] resultadoObtido = aluno.getDisciplinasCursadas();
        assertNotNull(resultadoObtido);
        for (int i = 0; i < resultadoObtido.length; i++) {
            assertNull(resultadoObtido[i]);
        }
        assertEquals(0, aluno.getQuantDisciplinasCursadas());

        // o aluno vai cursar a primeira disciplina
        aluno.registrarConclusaoDisciplina(disciplina1, 6.5f, 2019, 2);

        resultadoObtido = aluno.getDisciplinasCursadas();
        ItemDeHistorico primeiroItem = resultadoObtido[0];
        assertEquals("MAB001", primeiroItem.getDisciplina().getCodigo());
        assertEquals(2019, primeiroItem.getAno());
        assertEquals(2, primeiroItem.getSemestre());
        verificarAtualizacaoCreditos(1, 6.5f, 4);

        aluno.registrarConclusaoDisciplina(disciplina2, 8, 2020, 1);
        // verificar todas as disciplinas do histórico até aqui
        resultadoObtido = aluno.getDisciplinasCursadas();
        assertEquals("MAB001", primeiroItem.getDisciplina().getCodigo());
        ItemDeHistorico segundoItem = resultadoObtido[1];
        assertEquals("MAB002", segundoItem.getDisciplina().getCodigo());
        verificarAtualizacaoCreditos(2, 7.4f, 10);

        // o aluno vai cursar a terceira disciplina
        aluno.registrarConclusaoDisciplina(disciplina3, 10, 2020, 1);

        resultadoObtido = aluno.getDisciplinasCursadas();
        assertEquals("MAB001", primeiroItem.getDisciplina().getCodigo());
        assertEquals("MAB002", segundoItem.getDisciplina().getCodigo());
        ItemDeHistorico terceiroItem = resultadoObtido[2];
        assertEquals("MAJ003", terceiroItem.getDisciplina().getCodigo());
        verificarAtualizacaoCreditos(3, 8.375f, 16);
    }
    
    private void verificarAtualizacaoCreditos(int quantDiscipinasEsperado, float craEsperado, int creditosAcumuladosEsperado) {
        assertEquals(quantDiscipinasEsperado, aluno.getQuantDisciplinasCursadas());
        assertEquals(craEsperado, aluno.getCra(), 0);  // o terceiro parâmetro é a maior diferença aceitável
        assertEquals(creditosAcumuladosEsperado, aluno.getCreditosAcumulados());
    }
}
