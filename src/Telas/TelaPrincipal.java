package Telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import regras.ControleBotoesSelecionados;
import regras.StatusBotao;

public class TelaPrincipal extends JFrame{
    private static int QUANTIDADE_JOGADA = 2;
    private int jogadas = 0;
    private JPanel painel;
    private JButton botao1;   
    private JButton botao2;
    private JButton botao3;
    private JButton botao4;
    private ControleBotoesSelecionados controle1 ;
    private ControleBotoesSelecionados controle2 ;    
    private List<ControleBotoesSelecionados> listControle;
    private List<ControleBotoesSelecionados> listSelecionados;

    
    public TelaPrincipal(){
        super("Jogo da Memoria"); //Nome da Janela

        listControle = new ArrayList<>();
        listSelecionados = new ArrayList<>();
        
        ActionListener acaoBotao = new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JButton botao = (JButton) ae.getSource();
                
                    for(ControleBotoesSelecionados controleTemp : listControle){
                        if(controleTemp.getRefBotao().get(botao) != null){
                            jogadas++;
                            controleTemp.executarAcaoBotao(((JButton) ae.getSource()),StatusBotao.SELECIONADO);
                                if(!listSelecionados.contains(controleTemp)){
                                    listSelecionados.add(controleTemp);
                                }
                            System.out.println(listSelecionados.size());
                                if(jogadas == QUANTIDADE_JOGADA){
                                    //acabaram as jogadas
                                        if(listSelecionados.size() > 1){
                                            // se for maior que 1 quer dizer que foi selecionado mais de dois botoes diferente
                                                for(ControleBotoesSelecionados cbs : listSelecionados){
                                                    //zerar os status do botoes que foram selecionados
                                                    cbs.zerarSelecionados();
                                                }
                                        }
                                    // zerar contado e lista dos botoes selecionados
                                    jogadas = 0;
                                    listSelecionados.clear();
                                }
                            break;
                        }
                    }
                
                 // ((JButton) ae.getSource()) e uma forma generica de dizer que o botao foi precionado
            }
            
        };
        
        //instanciar painel
        this.painel = new JPanel();
        this.add(painel); //esse metodo adiciona o painel na janela
        painel.setLayout(null); // esse metodo gerencia os componentes dentro do painel ao colocar null a posicao dos componetes depende do metodo setBounds
                
        controle1 = new ControleBotoesSelecionados();
        controle1.setNmBotoes("hentai");
        controle2 = new ControleBotoesSelecionados();
        controle2.setNmBotoes("Orgia");
        
        botao1 = new JButton("jogo");
        painel.add(botao1);
        botao1.setBounds(10, 10, 100, 100); //definir tamanho e posicao do botao no painel
        botao1.addActionListener(acaoBotao); //adiciona uma aco ao botao
        /*
        //criar uma ação quando o botao for pressionado
        botao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                   //System.out.println("Botao B1 pressionado");
                   
                    //mudar a cor do botao
                  // botao1.setBackground(Color.green);
                   //((JButton) ae.getSource()).setBackground(Color.yellow);
                   
                   //alterar o status na referencias do botao
                   controle.alterStatusBotao(botao1,StatusBotao.SELECIONADO);
                   //controle.alterStatusBotao(((JButton) ae.getSource()), StatusBotao.SELECIONADO);
                   
                   //Alterar o texto do botao
                  // botao1.setText(controle.getNmBotoes());
                  //((JButton) ae.getSource()).setText(controle.getNmBotoes());
                   
            }
        });
        */
        
        botao2 = new JButton("jogo");
        painel.add(botao2);
        botao2.setBounds(120,10,100,100);//definir tamanho e posicao do botao no painel
        botao2.addActionListener(acaoBotao); //adicionar uma acao ao botao
        
        botao3 = new JButton("jogo");
        painel.add(botao3); //adicionar o botao no painel
        botao3.setBounds(10, 120, 100, 100); //definir tamanho e posicao do botao no painel
        botao3.addActionListener(acaoBotao); //adiciona uma ação ao botao
        
        botao4 = new JButton("jogo"); //instancinado o botao
        painel.add(botao4); //adicionar o botao no painel
        botao4.setBounds(120, 120, 100, 100); // definir tamanho e posicao no painel
        botao4.addActionListener(acaoBotao); //adiciona uma ação ao botao
        
        this.controle1.adicionarBotao(botao1);
        this.controle1.adicionarBotao(botao2);
        
        this.controle2.adicionarBotao(botao3);
        this.controle2.adicionarBotao(botao4);

        this.listControle.add(controle1);
        this.listControle.add(controle2);
        
        this.setBounds(500, 150, 350, 350);//tamanho e posição da tela(x, y, largura, altura )
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fechar a Janela, encerar a aplicao quando clicado
        this.setVisible(true); //deixar essa tela visivel
        //this.setResizable(false); permiti ou nao mudar o tamanho da Janela
        
    }
    
}
