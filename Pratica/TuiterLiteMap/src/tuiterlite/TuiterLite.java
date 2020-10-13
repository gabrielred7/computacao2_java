
package tuiterlite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TuiterLite<T> {
    private List<Usuario> baseUsuarios;
    private List<Tuite> bancoTuites;
    private List<HashtagComContador> hashtags;
    public static final int TAMANHO_MAXIMO_TUITES = 120;

    public TuiterLite() {
        this.baseUsuarios = new ArrayList<>();
        this.bancoTuites = new ArrayList<>();
    }
    
    public Usuario cadastrarUsuario(String nome, String email){
        Usuario novoUsuario = new Usuario(nome, email);
        if (this.baseUsuarios.contains(novoUsuario)) {
            return null;
        }
        this.baseUsuarios.add(novoUsuario);
        return novoUsuario;
    }
    
    public Tuite tuitarAlgo(Usuario usuario, String texto){
        if (texto.length() > TAMANHO_MAXIMO_TUITES || !this.baseUsuarios.contains(usuario)) {
            return null;
        }
        Tuite tuite = new Tuite(usuario, texto);
        Collection<String> hashtagsDoTuite = tuite.getHashtags();
        for (String hashtag : hashtagsDoTuite) {
            HashtagComContador hashtagComContador = localizarHashtagComContador(hashtag);
            if (hashtagComContador != null) {
                hashtagComContador.cont++;
            } else {
                hashtagComContador = new HashtagComContador(hashtag, 1);
                this.hashtags.add(hashtagComContador);
            }
        }
        usuario.getQuantidadeDeTuites();
        return tuite;
    }

    private HashtagComContador localizarHashtagComContador(String hashtag) {
        for (HashtagComContador hashtagComContador : this.hashtags) {
            if (hashtagComContador.hashtag.equals(hashtag)) {
                return hashtagComContador;
            }
        }
        return null;
    }
    
    public String getHashtagMaisComum() {
        int maxCont = 0;
        String result = null;
        for (HashtagComContador hashtagComContador : this.hashtags) {
            if (hashtagComContador.cont > maxCont) {
                maxCont = hashtagComContador.cont;
                result = hashtagComContador.hashtag;
            }
        }
        return result;
    }
    
    private class HashtagComContador {
        final String hashtag;
        int cont;

        public HashtagComContador(String hashtag, int cont) {
            this.hashtag = hashtag;
            this.cont = cont;
            }
    }
}