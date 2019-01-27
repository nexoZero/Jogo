package Telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import regras.ControleBotoesSelecionados;
import regras.StatusBotao;

public class TelaPrincipal extends JFrame{
    private JPanel painel;
    private JButton botao1;   
    private JButton botao2;
    ControleBotoesSelecionados controle ;

    
    public TelaPrincipal(){
        super("Jogo da Memoria"); //Nome da Janela
        controle = new ControleBotoesSelecionados();
        controle.setNmBotoes("hentai");
        
        //instanciar painel
        this.painel = new JPanel();
        this.add(painel); //esse metodo adiciona o painel na janela
        painel.setLayout(null); // esse metodo gerencia os componentes dentro do painel ao colocar null a posicao dos componetes depende do metodo setBounds
        
        botao1 = new JButton("jogo");
        painel.add(botao1);
        botao1.setBounds(10, 10, 100, 100); //definir tamanho e posicao do botao no painel
       
        //criar uma ação quando o botao for pressionado
        botao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                   //System.out.println("Botao B1 pressionado");
                   
                    //mudar a cor do botao
                   botao1.setBackground(Color.green);
                   //((JButton) ae.getSource()).setBackground(Color.yellow);
                   
                   //alterar o status na referencias do botao
                   controle.alterStatusBotao(botao1,StatusBotao.SELECIONADO);
                   //controle.alterStatusBotao(((JButton) ae.getSource()), StatusBotao.SELECIONADO);
                   
                   //Alterar o texto do botao
                   botao1.setText(controle.getNmBotoes());
                  //((JButton) ae.getSource()).setText(controle.getNmBotoes());
                   
            }
        });
        
        
        botao2 = new JButton("jogo");
        painel.add(botao2);
        botao2.setBounds(120,10,100,100);//definir tamanho e posicao do botao no painel
        
        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                   //System.out.println("Botao B1 pressionado");
                   
                    //mudar a cor do botao
                   botao2.setBackground(Color.green);
                   //((JButton) ae.getSource()).setBackground(Color.yellow);
                   
                   //alterar o status na referencias do botao
                   controle.alterStatusBotao(botao2, StatusBotao.SELECIONADO);
                   //controle.alterStatusBotao(((JButton) ae.getSource()), StatusBotao.SELECIONADO);
                   
                   //Alterar o texto do botao
                   botao2.setText(controle.getNmBotoes());
                  //((JButton) ae.getSource()).setText(controle.getNmBotoes());
            }
        });
        
        
        this.controle.adicionarBotao(botao1);
        this.controle.adicionarBotao(botao2);

        
        this.setBounds(500, 150, 350, 350);//tamanho e posição da tela(x, y, largura, altura )
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fechar a Janela, encerar a aplicao quando clicado
        this.setVisible(true); //deixar essa tela visivel
        //this.setResizable(false); permiti ou nao mudar o tamanho da Janela
        
    }
    
}
