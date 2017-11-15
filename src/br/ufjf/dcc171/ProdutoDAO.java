package br.ufjf.dcc171;

import java.util.List;

interface ProdutoDAO {
    public void criar (Produto prod) throws Exception;
    public List<Produto> listarTodos() throws Exception;
}
