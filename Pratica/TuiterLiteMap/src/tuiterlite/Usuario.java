
package tuiterlite;

import java.awt.Image;
import java.util.Objects;

public class Usuario {
    public static final int MIN_TUITES_SENIOR = 200;
    public static final int MIN_TUITES_NINJA = 1000;
    
    private NivelUsuario nivel;
    private final String email;
    private String nome;
    private Image foto;
    private int quantidadeDeTuites;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.quantidadeDeTuites = 0;
        this.nivel = NivelUsuario.INICIANTE;
    }
    
    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public Image getFoto() {
        return this.foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }  

    public int getQuantidadeDeTuites() {
        return quantidadeDeTuites;
    }

    public void setQuantidadeDeTuites(int numero) {
        this.quantidadeDeTuites = quantidadeDeTuites + numero;
        this.setNivel(quantidadeDeTuites);
    }
    
    public NivelUsuario getNivel() {
        return nivel;
    }

    public void setNivel(int quantidadeDeTuites) {
        if (this.quantidadeDeTuites >= MIN_TUITES_SENIOR) {
            this.nivel = NivelUsuario.SENIOR;
        } else if (this.quantidadeDeTuites >= MIN_TUITES_NINJA) {
            this.nivel = NivelUsuario.NINJA;
        } else {
            this.nivel = NivelUsuario.INICIANTE;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true;}
        if (obj == null || getClass() != obj.getClass()) {return false;}
        Usuario other = (Usuario) obj;
        return Objects.equals(this.email, other.email);
    }
    
    @Override
    public String toString() {
        return String.format("Usuario de nome: %s do email: %s. É de nivel %s e já fez %d tuites", 
                this.nome, this.email, this.nivel, this.quantidadeDeTuites);
    }
}