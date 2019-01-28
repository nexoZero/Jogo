package regras;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;

public class ControleBotoesSelecionados {
    private String nmBotoes;
    private Map<JButton, StatusBotao> refBotao;

    public ControleBotoesSelecionados(){
        this.refBotao = new HashMap<>(); //HashMap implementa o Map
    }
    public String getNmBotoes() {
        return nmBotoes;
    }

    public void setNmBotoes(String nmBotoes) {
        this.nmBotoes = nmBotoes;
    }

    public Map<JButton, StatusBotao> getRefBotao() {
        return refBotao;
    }

    public void setRefBotao(Map<JButton, StatusBotao> refBotao) {
        this.refBotao = refBotao;
    }
    
    public void adicionarBotao(JButton botao){
        this.refBotao.put(botao, StatusBotao.NORMAL); //adicionar um novo botao no map
    }
    
    public void executarAcaoBotao(JButton botao, StatusBotao status){
        this.alterStatusBotao(botao, status);
            if(this.isTodosSelecionados()){
                this.alterStatusTodosBotao(StatusBotao.PAR_ENCONTRADO);
            } else {
                this.alterVisualizacaoBotao(botao);
            }
    }
    
    public void alterStatusBotao( JButton botao, StatusBotao status){
        this.refBotao.put(botao, status);
    }
    
    private void alterStatusTodosBotao( StatusBotao status){
        for( JButton botao : this.refBotao.keySet()){
            this.alterStatusBotao(botao, status);
            this.alterVisualizacaoBotao(botao);
        }
    }
    
    private void alterVisualizacaoBotao( JButton botao){
        StatusBotao status = this.refBotao.get(botao);
        switch (status){
            case NORMAL: //mudar cor pra cinza,nao exibe o texto
                botao.setBackground(null);
                botao.setText("jogo");
                break;
            case SELECIONADO: // exibe texto, mudar a cor
                botao.setBackground(Color.GREEN);
                botao.setText(this.nmBotoes);
                break;
            case PAR_ENCONTRADO: // mudar a cor , mudar texto
                botao.setBackground(Color.MAGENTA);
                botao.setText(this.nmBotoes);
                botao.setEnabled(false); // metodo que deixa o botao ativo ou nao
                break;
        }
    }
    
    public void zerarSelecionados(){
       this.alterStatusTodosBotao(StatusBotao.NORMAL);
    }
    public boolean isTodosSelecionados(){
        //esse metodo verificar se ainda há botoes nao selecionados
            for( StatusBotao b : this.refBotao.values()){
                    if(b!= StatusBotao.SELECIONADO){
                        return false;
                    }
            }
        return true;
    }
}
