package entidade;

/**
 *
 * @author Vini
 */
public class Palavra {

    private String palavra;
    private String significado;
    private int codigo;

    public Palavra(String palavra) {
        this(palavra, "Sem Significado");
    }

    public Palavra(String palavra, String significado) {
        this.palavra = palavra;
        this.significado = significado;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto instanceof Palavra) {
            return ((Palavra) objeto).codigo == this.codigo;
        }

        return false;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.palavra + " | " + this.significado;
    }
}
