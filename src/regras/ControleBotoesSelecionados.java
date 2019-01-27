package regras;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;

public class ControleBotoesSelecionados {
    private String nmBotoes;
    private Map<JButton, Boolean> refBotao;

    public ControleBotoesSelecionados(){
        this.refBotao = new HashMap<>(); //HashMap implementa o Map
    }
    public String getNmBotoes() {
        return nmBotoes;
    }

    public void setNmBotoes(String nmBotoes) {
        this.nmBotoes = nmBotoes;
    }

    public Map<JButton, Boolean> getRefBotao() {
        return refBotao;
    }

    public void setRefBotao(Map<JButton, Boolean> refBotao) {
        this.refBotao = refBotao;
    }
    
    public void adicionarBotao(JButton botao){
        this.refBotao.put(botao, Boolean.FALSE); //adicionar um novo botao no map
    }
    
    public void alterStatusBotao( JButton botao, Boolean status){
        Boolean b = this.refBotao.get(botao); // esse metodo irar procurar pela chave passada e devolverar o valor que ela referencia
        b = status;
    }
    
    public void zerarSelecionados(){
        //O loop irar pecorre todo o map e irar set false em todos os valores
            for( Boolean b : this.refBotao.values()){
                b = false;
            }
    }
    public boolean isTodosSelecionados(){
        //esse metodo verificar se ainda há botoes nao selecionados
            for( Boolean b : this.refBotao.values()){
                    if(!b){
                        return false;
                    }
            }
        return true;
    }
}
