package controlas;

import dao.PalavraDAO;
import entidade.Palavra;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vini
 */
public class Dicionario {

    private PalavraDAO dao = new PalavraDAO();

    public void addPalavra(Palavra p) {
        try {
            this.dao.add(p);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void updatePalavra(Palavra p) {
        try {
            this.dao.update(p);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Palavra> getPalavras() {
        return this.getPalavras("");
    }

    public ArrayList<Palavra> getPalavras(String filtro) {
        ArrayList<Palavra> palavras = new ArrayList();

        try {
            palavras = this.dao.get(filtro);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return palavras;
    }

    public boolean validate(String nomePalavra, String codigo) {
        boolean result = false;

        try {
            result = this.dao.validate(nomePalavra, codigo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return result;
    }

}
