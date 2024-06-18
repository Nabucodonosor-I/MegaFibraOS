package com.ordercontrol.ui;

import com.ordercontrol.DAO.CRUD.*;
import com.ordercontrol.componentes.*;
import com.ordercontrol.model.*;
import com.ordercontrol.ui.administrador.TelaAdmin;
import com.ordercontrol.ui.comum.TelaComum;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal implements ActionListener {

    String senhaUser;
    String usuarioUser;

    private final String currentDirectory = System.getProperty("user.dir");

    private final Read read = new Read();

    private final JFrame framePrincipal = new JFrame();
    private final RoundedButton loginButton = new RoundedButton(10, new Color(54, 54, 54), null);
    private final RoundedButton cadastroButton = new RoundedButton(10, new Color(54, 54, 54), null);
    private final JLabel principalLabel = new JLabel();
    private final RoundedPanel painel = new RoundedPanel(20, new Color(28, 35, 43));
    private final ImageIcon imageIcon1 = new ImageIcon(
            currentDirectory + "\\demo\\src\\main\\resources\\Imagens\\68386.png");
    private final ImageIcon imageIcon2 = new ImageIcon(
            new ImageIcon(
                    currentDirectory + "\\demo\\src\\main\\resources\\Imagens\\Logo.png")
                    .getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));

    private final JTextField usuario = new JTextField();
    private final JPasswordField senha = new JPasswordField();
    private final JLabel senhaLabel = new JLabel();
    private final JLabel usuarioLabel = new JLabel();
    private final JLabel bemVindo = new JLabel();
    private final JLabel credenciais = new JLabel();
    private final JLabel orderConttrl = new JLabel();
    private final JLabel descricao1 = new JLabel();
    private final JLabel descricao2 = new JLabel();

    JLabel erro;
    JLabel empty;

    public TelaPrincipal() {

        // configurações frame
        framePrincipal.setSize(750, 600);
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setTitle("Order Control");
        framePrincipal.setResizable(false);
        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.getContentPane().setBackground(new Color(255, 255, 255));
        framePrincipal.setIconImage(imageIcon1.getImage());

        // config painel
        painel.setBounds(15, 15, 350, 530);

        // config text field usuario
        usuario.setBounds(470, 200, 200, 30);
        usuario.setHorizontalAlignment(SwingConstants.CENTER);
        usuario.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // config text field senha
        senha.setBounds(470, 275, 200, 30);
        senha.setHorizontalAlignment(SwingConstants.CENTER);
        senha.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // configurações label senha
        senhaLabel.setText("Senha ");
        senhaLabel.setForeground(new Color(0, 0, 0));
        senhaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        senhaLabel.setBounds(470, 250, 125, 25);

        // configurações label usuario
        usuarioLabel.setText("E-mail ");
        usuarioLabel.setForeground(new Color(0, 0, 0));
        usuarioLabel.setFont(new Font("Arial", Font.BOLD, 15));
        usuarioLabel.setBounds(470, 175, 125, 25);

        // onfig Label Bem vindo
        bemVindo.setText("Bem Vindo");
        bemVindo.setForeground(new Color(0, 0, 0));
        bemVindo.setFont(new Font("Arial", Font.BOLD, 25));
        bemVindo.setBounds(400, 40, 200, 30);

        // config label credenciais
        credenciais.setText("Insira suas Credenciais, por favor");
        credenciais.setForeground(new Color(0, 0, 0));
        credenciais.setFont(new Font("Arial", Font.BOLD, 13));
        credenciais.setBounds(400, 63, 300, 30);

        // config Label OrderControl
        orderConttrl.setText("OrderControl");
        orderConttrl.setForeground(new Color(255, 255, 255));
        orderConttrl.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
        orderConttrl.setBounds(105, 240, 300, 40);

        // label escrição 1
        descricao1.setText("Nós ajudamos a agendar e gerenciar");
        descricao1.setForeground(new Color(255, 255, 255));
        descricao1.setFont(new Font("Arial", Font.BOLD, 16));
        descricao1.setBounds(37, 390, 300, 100);

        // label descrição 2
        descricao2.setText("visitas e orçamentos de forma eficiente.");
        descricao2.setForeground(new Color(255, 255, 255));
        descricao2.setFont(new Font("Arial", Font.BOLD, 16));
        descricao2.setBounds(37, 410, 300, 100);

        // configuração botao login
        loginButton.setText("Login");
        loginButton.setBounds(470, 375, 200, 50);
        loginButton.setFocusable(false);
        loginButton.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 25));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setBorder(BorderFactory.createRaisedBevelBorder());
        loginButton.addActionListener(this);

        // configuração botão cadastro
        cadastroButton.setText("Cadastrar");
        cadastroButton.setBounds(470, 450, 200, 50);
        cadastroButton.setFocusable(false);
        cadastroButton.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 25));
        cadastroButton.setForeground(new Color(255, 255, 255));
        cadastroButton.setBorder(BorderFactory.createRaisedBevelBorder());
        cadastroButton.addActionListener(this);

        // configurações label
        principalLabel.setBounds(95, 35, 200, 200);
        principalLabel.setForeground(new Color(255, 0, 0));
        principalLabel.setIcon(imageIcon2);
        principalLabel.setHorizontalTextPosition(JLabel.CENTER);
        principalLabel.setVerticalTextPosition(JLabel.BOTTOM);
        principalLabel.setIconTextGap(-70);
        principalLabel.setVerticalAlignment(JLabel.CENTER);
        principalLabel.setHorizontalAlignment(JLabel.CENTER);

        // adicionado
        framePrincipal.add(principalLabel);
        framePrincipal.add(loginButton);
        framePrincipal.add(cadastroButton);
        framePrincipal.add(usuario);
        framePrincipal.add(senha);
        framePrincipal.add(senhaLabel);
        framePrincipal.add(usuarioLabel);
        framePrincipal.add(bemVindo);
        framePrincipal.add(credenciais);
        framePrincipal.add(orderConttrl);
        framePrincipal.add(descricao1);
        framePrincipal.add(descricao2);
        framePrincipal.add(painel);
        framePrincipal.setLayout(null);
    }

    public String getPassword() {
        return senha.getText();
    }

    public String getTextUsuario() {
        return usuarioUser = usuario.getText();

    }

    // acionamento do botão login

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == loginButton) {

            String usuarioText = getTextUsuario();
            String senhaChars = getPassword();

            if (getTextUsuario().isEmpty() || getPassword().isEmpty()) {
                if (empty != null) {
                    framePrincipal.remove(empty);
                    framePrincipal.repaint();
                    empty = null;
                } else {
                    empty = new JLabel();
                    empty.setText("Campos Obrigatorios");
                    empty.setForeground(new Color(255, 0, 0));
                    empty.setFont(new Font("Arial", Font.BOLD, 12));
                    empty.setBounds(470, 100, 200, 100);
                    framePrincipal.add(empty);
                    framePrincipal.repaint();
                }

            } else {

                Usuario usuario = read.lerUsuario(usuarioText, senhaChars);

                if (usuario != null) {
                    if (usuario.getAdmin() == 1) {
                        framePrincipal.dispose();
                        TelaAdmin frame = new TelaAdmin();
                    } else if (usuario.getAdmin() == 0) {
                        framePrincipal.dispose();
                        TelaComum frame = new TelaComum(this);
                    }

                } else {
                    if (erro != null) {
                        framePrincipal.remove(erro);
                        framePrincipal.repaint();
                        erro = null;
                    } else {
                        erro = new JLabel();
                        erro.setText("Usuarios ou senha invalidos");
                        erro.setForeground(new Color(255, 0, 0));
                        erro.setFont(new Font("Arial", Font.BOLD, 12));
                        erro.setBounds(470, 100, 200, 100);
                        framePrincipal.add(erro);
                        framePrincipal.repaint();
                    }

                }
            }
        } else if (o == cadastroButton) {
            TelaCadastro cadastro = new TelaCadastro();
            framePrincipal.dispose();
        }
    }
}
