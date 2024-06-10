package com.ordercontrol.ui.administrador;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

import javax.swing.*;

import com.ordercontrol.DAO.CRUD.*;
import com.ordercontrol.componentes.*;
import com.ordercontrol.model.*;

public class TelaAdmin extends JFrame implements ActionListener, AdjustmentListener {

    String currentDirectory = System.getProperty("user.dir");

    ImageIcon imageIcon1 = new ImageIcon(
            currentDirectory + "\\demo\\src\\main\\resources\\Imagens\\68386.png");
    ImageIcon imageIcon2 = new ImageIcon(
            new ImageIcon(
                    currentDirectory + "\\demo\\src\\main\\resources\\Imagens\\Logo.png")
                    .getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH));
    JFrame frame = new JFrame();
    JLabel principalLabel = new JLabel();
    JLabel orderConttrl = new JLabel();
    RoundedPanel panel1 = new RoundedPanel(10, new Color(28, 35, 43));
    RoundedPanel panel2 = new RoundedPanel(10, new Color(255, 255, 255));
    RoundedButton addButton = new RoundedButton(20, new Color(54, 54, 54), null);
    RoundedButton logout = new RoundedButton(20, new Color(54, 54, 54), null);
    JScrollBar scrollBar = new JScrollBar();
    RoundedPanel painelBranco = new RoundedPanel(5, new Color(255, 255, 255));



    ArrayList<RoundedPanel> panels = new ArrayList<>();
    ArrayList<Integer> originalYPositions = new ArrayList<>();
    ArrayList<Evento> listaEventos = new ArrayList<>();
    ArrayList<JLabel> labels = new ArrayList<>();

    public TelaAdmin() {
        frame.setSize(750, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setIconImage(imageIcon1.getImage());
        frame.setLayout(null);

        // Configurações label
        principalLabel.setBounds(25, 25, 90, 90);
        principalLabel.setForeground(new Color(255, 0, 0));
        principalLabel.setIcon(imageIcon2);
        principalLabel.setHorizontalTextPosition(JLabel.CENTER);
        principalLabel.setVerticalTextPosition(JLabel.BOTTOM);
        principalLabel.setIconTextGap(-70);
        principalLabel.setVerticalAlignment(JLabel.CENTER);
        principalLabel.setHorizontalAlignment(JLabel.CENTER);

        orderConttrl.setText("OrderControl");
        orderConttrl.setForeground(new Color(0, 0, 0));
        orderConttrl.setFont(new Font("Bauhaus 93", Font.PLAIN, 23));
        orderConttrl.setBounds(135, 50, 300, 40);

        addButton.setText("Novo Evento");
        addButton.setFocusable(false);
        addButton.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 18));
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setBounds(340, 35, 140, 70);
        addButton.setBorder(BorderFactory.createRaisedBevelBorder());
        addButton.addActionListener(this);

        logout.setText("sair");
        logout.setFocusable(false);
        logout.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 19));
        logout.setForeground(new Color(255, 255, 255));
        logout.setBounds(540, 35, 140, 70);
        logout.setBorder(BorderFactory.createRaisedBevelBorder());
        logout.addActionListener(this);

        scrollBar.setBounds(717, 130, 15, 425);
        scrollBar.setForeground(new Color(54, 54, 54));
        scrollBar.setBackground(new Color(28, 35, 43));
        scrollBar.setMinimum(0);
        scrollBar.setMaximum(1000);
        scrollBar.addAdjustmentListener(this);

        panel1.setBounds(15, 15, 695, 110);
        panel2.setBounds(20, 20, 685, 100);

        painelBranco.setBounds(0, 0, 750, 150);

        frame.add(principalLabel);
        frame.add(orderConttrl);
        frame.add(addButton);
        frame.add(logout);
        frame.add(scrollBar);
        frame.add(panel2);
        frame.add(panel1);
        frame.add(painelBranco);

        mostrarEventos();
        frame.setLayout(null);
    }

    public void mostrarEventos() {
        int x = 30;
        int y = 150;
        int panelWidth = 215;
        int panelHeight = 195;
        int spacing = 15;
        int acumulador = 0;
        int acumuladorID = 1;

        for (RoundedPanel panel : panels) {
            frame.remove(panel);
        }
        panels.clear();
        originalYPositions.clear();
        labels.clear();

        Read read = new Read();
        listaEventos = read.listarEventos();

        for (Evento evento : listaEventos) {
            RoundedPanel eventoPanel = new RoundedPanel(10, new Color(28, 35, 43));
            eventoPanel.setLayout(null);
            eventoPanel.setBounds(x, y, panelWidth, panelHeight);

            RoundedButton detalhesButton = new RoundedButton(15, new Color(255, 255, 255), null);
            detalhesButton.setText("Detalhes");
            detalhesButton.setForeground(new Color(0, 0, 0));
            detalhesButton.setBounds(55, 150, 100, 30);
            detalhesButton.addActionListener(this);
            detalhesButton.setActionCommand("detalhes_" + acumuladorID);

            JLabel nomeClienteLabel = new JLabel("Cliente: " + evento.getNomeCliente());
            nomeClienteLabel.setForeground(new Color(255, 255, 255));
            nomeClienteLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));
            nomeClienteLabel.setBounds(5, 15, panelWidth - 10, 20);
            labels.add(nomeClienteLabel);

            JLabel tipoEventoLabel = new JLabel("Tipo: " + evento.getTipoEventoToString());
            tipoEventoLabel.setForeground(new Color(255, 255, 255));
            tipoEventoLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));
            tipoEventoLabel.setBounds(5, 35, panelWidth - 10, 20);
            labels.add(tipoEventoLabel);

            JLabel localLabel = new JLabel("Local: " + evento.getLocal());
            localLabel.setForeground(new Color(255, 255, 255));
            localLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));
            localLabel.setBounds(5, 55, panelWidth - 10, 20);
            labels.add(localLabel);

            JLabel horaLabel = new JLabel("Hora: " + evento.getHora());
            horaLabel.setForeground(new Color(255, 255, 255));
            horaLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));
            horaLabel.setBounds(5, 75, panelWidth - 10, 20);
            labels.add(horaLabel);

            JLabel dataLabel = new JLabel("Data: " + evento.getData());
            dataLabel.setForeground(new Color(255, 255, 255));
            dataLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));
            dataLabel.setBounds(5, 95, panelWidth - 10, 20);
            labels.add(dataLabel);

            JLabel descricaoLabel = new JLabel("Descrição: " + evento.getDescricao());
            descricaoLabel.setForeground(new Color(255, 255, 255));
            descricaoLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));
            descricaoLabel.setBounds(5, 115, panelWidth - 10, 20);
            labels.add(descricaoLabel);

            eventoPanel.add(nomeClienteLabel);
            eventoPanel.add(tipoEventoLabel);
            eventoPanel.add(localLabel);
            eventoPanel.add(horaLabel);
            eventoPanel.add(dataLabel);
            eventoPanel.add(descricaoLabel);
            eventoPanel.add(detalhesButton);

            panels.add(eventoPanel);
            originalYPositions.add(y);

            frame.add(eventoPanel);

            acumulador++;
            acumuladorID++;

            x += panelWidth + spacing;
            if (acumulador % 3 == 0) {
                x = 30;
                y += panelHeight + spacing;
            }
        }
    }

    public void frameDispose() {
        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Object o = arg0.getSource();

        if (o == addButton) {
            AddEvento newEvento = new AddEvento();
        } else if (o instanceof RoundedButton) {
            RoundedButton button = (RoundedButton) o;
            if (button.getActionCommand().startsWith("detalhes_")) {
                String indexString = button.getActionCommand().substring(9);
                int eventoIndex = Integer.parseInt(indexString);
                Evento evento = listaEventos.get(eventoIndex - 1);
                if (evento != null) {
                    DetahlesAdmin frameDetahles =new DetahlesAdmin(evento);
                    frameDetahles.setVisualAdimin(this);
                }
            }
        }
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent arg0) {
        int value = scrollBar.getValue();
        for (int i = 0; i < panels.size(); i++) {
            RoundedPanel panel = panels.get(i);
            int originalY = originalYPositions.get(i);
            panel.setBounds(panel.getX(), originalY - value, panel.getWidth(), panel.getHeight());
        }
        frame.repaint();
    }
}