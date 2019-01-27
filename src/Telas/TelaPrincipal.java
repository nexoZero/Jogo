package Telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaPrincipal extends JFrame{
    private JPanel painel;
    private JButton botao1;   
    private JButton botao2;

    
    public TelaPrincipal(){
        super("Jogo da Memoria"); //Nome da Janela
        
        //instanciar painel
        this.painel = new JPanel();
        this.add(painel); //esse metodo adiciona o painel na janela
        painel.setLayout(null); // esse metodo gerencia os componentes dentro do painel ao colocar null a posicao dos componetes depende do metodo setBounds
        
        botao1 = new JButton("B1");
        painel.add(botao1);
        botao1.setBounds(10, 10, 100, 100); //definir tamanho e posicao do botao no painel
       
        //criar uma ação quando o botao for pressionado
        botao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                   System.out.println("Botao B1 pressionado");
                   ((JButton) ae.getSource()).setBackground(Color.yellow);
            }
        });
        
        
        botao2 = new JButton("B2");
        painel.add(botao2);
        botao2.setBounds(120,10,100,100);//definir tamanho e posicao do botao no painel
        
        this.setBounds(500, 150, 350, 350);//tamanho e posição da tela(x, y, largura, altura )
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fechar a Janela, encerar a aplicao quando clicado
        this.setVisible(true); //deixar essa tela visivel
        //this.setResizable(false); permiti ou nao mudar o tamanho da Janela
        
    }
    
}
