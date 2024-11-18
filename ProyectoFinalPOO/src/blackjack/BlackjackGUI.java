package blackjack;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class BlackjackGUI {
    private static final int FRAME_WIDTH = 1280;
    private static final int FRAME_HEIGHT = 720;

    public static JFrame frame;
    private static JPanel playerPanel, dealerPanel, buttonPanel;
    private static JButton hitButton, stayButton;
    private static volatile boolean playerChoice;
    private static volatile boolean waitingForInput;

    public static void startGUI() {
        frame = new JFrame("Blackjack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);
        frame.setBackground(Color.BLACK);

        dealerPanel = new JPanel();
        dealerPanel.setLayout(new FlowLayout());
        dealerPanel.setPreferredSize(new Dimension(FRAME_WIDTH, 140 + 20));
        mainPanel.add(dealerPanel);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setPreferredSize(new Dimension(FRAME_WIDTH, 100));
        mainPanel.add(buttonPanel);

        playerPanel = new JPanel();
        playerPanel.setLayout(new FlowLayout());
        playerPanel.setPreferredSize(new Dimension(FRAME_WIDTH, 140 + 20));
        mainPanel.add(playerPanel);

        frame.setResizable(false);

        hitButton = new JButton("Hit");
        stayButton = new JButton("Stay");
        buttonPanel.add(hitButton);
        buttonPanel.add(stayButton);

        hitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start();
                playerChoice = true;
            }
        });

        stayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start();
                playerChoice = false;
            }
        });



        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    public static void updateView(LinkedList<Integer> crupierHand, LinkedList<Integer> playerHand) {
        if(dealerPanel== null || playerPanel == null)
            return;

        dealerPanel.removeAll();
        playerPanel.removeAll();

        dealerPanel.add(createCardLabel("ProyectoFinalPOO/src/cards/back.png"));

        for (int i = 1; i < crupierHand.size(); i++) {
            dealerPanel.add(createCardLabel("ProyectoFinalPOO/src/cards/" + crupierHand.get(i) + ".png"));
        }

        JLabel playerHiddenCard = createCardLabel("ProyectoFinalPOO/src/cards/back.png");
        addTextOverlay(playerHiddenCard, String.valueOf(playerHand.getFirst()));
        playerPanel.add(playerHiddenCard);

        for (int i = 1; i < playerHand.size(); i++) {
            playerPanel.add(createCardLabel("ProyectoFinalPOO/src/cards/" + playerHand.get(i) + ".png"));
        }


        frame.revalidate();
        frame.repaint();
    }

    public static boolean getPlayerChoice() {
        waitingForInput = true;

        start();
        while(waitingForInput);

        return playerChoice;
    }

    private static void start(){
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {

            @Override
            protected Boolean doInBackground() throws Exception {

                JFrame frame = new JFrame("Option");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 200);
                JPanel mainPanel = new JPanel();
                mainPanel.setLayout(new FlowLayout());
                mainPanel.setPreferredSize(new Dimension(500, 200));

                JButton hitButton = new JButton("Hit");
                JButton stayButton = new JButton("Stay");
                mainPanel.add(hitButton);
                mainPanel.add(stayButton);


                hitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        playerChoice = true;
                    }
                });

                stayButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        playerChoice = false;
                    }
                });

                frame.setVisible(true);

                return false;
            }

            @Override
            protected void done() {
                waitingForInput = false;
            }
        };

        worker.execute();
    }


    private static JLabel createCardLabel(String imagePath) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            Image scaledImage = originalImage.getScaledInstance(100, 140, Image.SCALE_SMOOTH);
            return new JLabel(new ImageIcon(scaledImage));
        } catch (IOException e) {
            e.printStackTrace();
            return new JLabel("No se encuentran las imágenes del juego");
        }
    }

    private static void addTextOverlay(JLabel cardLabel, String text) {
        BufferedImage textOverlay = new BufferedImage(100, 140, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = textOverlay.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        ImageIcon icon = (ImageIcon) cardLabel.getIcon();
        g.drawImage(icon.getImage(), 0, 0, null);

        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.white);
        g.drawString(text, 10, 20);

        g.dispose();
        cardLabel.setIcon(new ImageIcon(textOverlay));
    }

    public static void revealAllCards(LinkedList<Integer> dealerHand, LinkedList<Integer> playerHand) {
        dealerPanel.removeAll();
        playerPanel.removeAll();

        for (int card : dealerHand) {
            dealerPanel.add(createCardLabel("ProyectoFinalPOO/src/cards/" + card + ".png"));
        }

        for (int card : playerHand) {
            playerPanel.add(createCardLabel("ProyectoFinalPOO/src/cards/" + card + ".png"));
        }

        frame.revalidate();
        frame.repaint();
    }

    public static double displayResultAndGetNewBet(int playerScore, int dealerScore, double winnings) {
        buttonPanel.removeAll();

        String resultMessage;
        if (playerScore > 21 && dealerScore > 21 || playerScore == dealerScore) {
            resultMessage = "Empate";
        } else if (playerScore <= 21 && (dealerScore > 21 || playerScore > dealerScore)) {
            resultMessage = "Victoria";
        } else {
            resultMessage = "Derrota";
        }

        JLabel resultLabel = new JLabel(resultMessage);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 24));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(resultLabel);

        JLabel winningsLabel = new JLabel("Ganancia " + winnings);
        winningsLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        winningsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(winningsLabel);

        JTextField betField = new JTextField("0", 10);
        betField.setHorizontalAlignment(JTextField.CENTER);
        buttonPanel.add(new JLabel("Nueva apuesta, 0 si desea salir: "));
        buttonPanel.add(betField);

        frame.revalidate();
        frame.repaint();

        final double[] newBet = {0};
        return newBet[0];
    }

}
