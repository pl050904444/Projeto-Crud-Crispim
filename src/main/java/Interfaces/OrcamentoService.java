package Interfaces;

import Entidades.Orcamento;

public interface OrcamentoService {
    Orcamento getOrcamento(int id);
    void criarOrcamento(Orcamento orcamento);
    void atualizarOrcamento(Orcamento orcamento);
    void deletarOrcamento(int id);
}