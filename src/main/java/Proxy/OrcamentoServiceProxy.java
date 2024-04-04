package Proxy;

import Entidades.Orcamento;
import Interfaces.OrcamentoService;

public class OrcamentoServiceProxy implements OrcamentoService {
    private OrcamentoService orcamentoService;
    private boolean primeiraChamada = true;

    public OrcamentoServiceProxy(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @Override
    public Orcamento getOrcamento(int id) {
        if (primeiraChamada) {
            primeiraChamada = false;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return orcamentoService.getOrcamento(id);
    }

    @Override
    public void criarOrcamento(Orcamento orcamento) {
        orcamentoService.criarOrcamento(orcamento);
    }

    @Override
    public void atualizarOrcamento(Orcamento orcamento) {
        orcamentoService.atualizarOrcamento(orcamento);
    }

    @Override
    public void deletarOrcamento(int id) {
        orcamentoService.deletarOrcamento(id);
    }
}
