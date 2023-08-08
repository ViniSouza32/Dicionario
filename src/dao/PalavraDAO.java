package dao;

import entidade.Palavra;
import java.util.ArrayList;
import java.sql.ResultSet;
import util.ConexaoBD;

/**
 *
 * @author Vini
 */
public class PalavraDAO {

    public void add(Palavra p) throws Exception {
        ConexaoBD.getInstance().executeUpdate("insert into palavras ( palavra, significado ) values ( '" + p.getPalavra() + "', '" + p.getSignificado() + "' )");
    }

    public void update(Palavra p) throws Exception {
        ConexaoBD.getInstance().executeUpdate("update palavras set  palavra = '" + p.getPalavra() + "', significado = '" + p.getSignificado() + "' where codigo = " + p.getCodigo());
    }

    public void delete(Palavra p) throws Exception {
        ConexaoBD.getInstance().executeUpdate("delete from palavras where codigo = " + p.getCodigo());
    }

    public ArrayList<Palavra> get() throws Exception {
        return get(null);
    }

    public ArrayList<Palavra> get(String filtro) throws Exception {
        ArrayList<Palavra> palavras = new ArrayList();

        String sql = " select * from palavras";

        if (filtro != null && !filtro.isBlank()) {
            sql += " where "
                    + " palavra like '%" + filtro + "%' "
                    + " or "
                    + " significado like '%" + filtro + "%' ";
        }

        ResultSet rs = ConexaoBD.getInstance().executeQuery(sql);

        while (rs.next()) {
            Palavra p = new Palavra(rs.getString("palavra"), rs.getString("significado"));
            p.setCodigo(rs.getInt("codigo"));
            palavras.add(p);
        }

        return palavras;
    }

    public boolean validate(String palavra, String codigo) throws Exception {
        boolean result = false;

        if (palavra != null && !palavra.isBlank()) {
            String sql = " select count(*) from palavras where palavra = '" + palavra + "'";

            if (codigo != null && !codigo.isBlank()) {
                sql += " and codigo <> " + codigo;
            }

            ResultSet rs = ConexaoBD.getInstance().executeQuery(sql);

            if (rs.next()) {
                result = rs.getInt(1) == 0;
            }
        }

        return result;
    }
}
