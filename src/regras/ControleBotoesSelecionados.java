package regras;

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
    
    public void alterStatusBotao( JButton botao, StatusBotao status){
        StatusBotao b = this.refBotao.get(botao); // esse metodo irar procurar pela chave passada e devolverar o valor que ela referencia
        b = status;
    }
    
    public void zerarSelecionados(){
        //O loop irar pecorre todo o map e irar set false em todos os valores
            for( StatusBotao b : this.refBotao.values()){
                b = StatusBotao.NORMAL;
            }
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
