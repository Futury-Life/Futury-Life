package com.raven.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JFrame {
    private final int CELL_SIZE = 20;
    private final int GRID_WIDTH = 30;
    private final int GRID_HEIGHT = 30;
    private final int GAME_WIDTH = GRID_WIDTH * CELL_SIZE;
    private final int GAME_HEIGHT = GRID_HEIGHT * CELL_SIZE;
    
    private ArrayList<Point> snake;
    private Point food;
    private int direction = KeyEvent.VK_RIGHT;
    private boolean isGameOver = false;
    private Timer timer;
    private int score = 0;
    private TelaAplicativos parentFrame;
    private JPanel gamePanel;
    
    private Color corFundo = new Color(124, 58, 237);
    private Color corSnake = new Color(168, 85, 247);
    private Color corFood = new Color(91, 33, 182);
    private Color corTexto = new Color(245, 245, 245);
    private Color corGrid = new Color(245, 245, 245, 40);
    
    public SnakeGame() {
        setTitle("Snake Game");
        setSize(GAME_WIDTH + 16, GAME_HEIGHT + 39);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                TelaAplicativos telaApps = new TelaAplicativos();
                telaApps.setVisible(true);
            }
        });
        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(corFundo);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.setColor(corGrid);
                for (int x = 0; x < GRID_WIDTH; x++) {
                    for (int y = 0; y < GRID_HEIGHT; y++) {
                        g2.drawRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    }
                }
                if (food != null) {
                    g2.setColor(corFood);
                    g2.fillOval(food.x * CELL_SIZE + 2, food.y * CELL_SIZE + 2, 
                               CELL_SIZE - 4, CELL_SIZE - 4);
                }
                if (snake != null) {
                    g2.setColor(corSnake);
                    for (Point p : snake) {
                        g2.fillRoundRect(p.x * CELL_SIZE + 1, p.y * CELL_SIZE + 1,
                                       CELL_SIZE - 2, CELL_SIZE - 2, 8, 8);
                    }
                }
                g2.setColor(corTexto);
                g2.setFont(new Font("Segoe UI", Font.BOLD, 20));
                g2.drawString("Score: " + score, 10, 25);
                if (isGameOver) {
                    g2.setColor(new Color(0, 0, 0, 150));
                    g2.fillRect(0, 0, getWidth(), getHeight());
                    g2.setColor(corTexto);
                    g2.setFont(new Font("Segoe UI", Font.BOLD, 40));
                    String gameOver = "Game Over!";
                    FontMetrics fm = g2.getFontMetrics();
                    g2.drawString(gameOver,
                                (getWidth() - fm.stringWidth(gameOver)) / 2,
                                getHeight() / 2);
                    g2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
                    String restart = "Pressione ESPAÇO para reiniciar";
                    fm = g2.getFontMetrics();
                    g2.drawString(restart,
                                (getWidth() - fm.stringWidth(restart)) / 2,
                                getHeight() / 2 + 40);
                    String exit = "ESC para sair";
                    fm = g2.getFontMetrics();
                    g2.drawString(exit,
                                (getWidth() - fm.stringWidth(exit)) / 2,
                                getHeight() / 2 + 70);
                }
            }
        };
        gamePanel.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        add(gamePanel);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (isGameOver) {
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        initGame();
                    } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                        closeGame();
                    }
                    return;
                }
                int newDirection = e.getKeyCode();
                if ((newDirection == KeyEvent.VK_LEFT && direction != KeyEvent.VK_RIGHT) ||
                    (newDirection == KeyEvent.VK_RIGHT && direction != KeyEvent.VK_LEFT) ||
                    (newDirection == KeyEvent.VK_UP && direction != KeyEvent.VK_DOWN) ||
                    (newDirection == KeyEvent.VK_DOWN && direction != KeyEvent.VK_UP)) {
                    direction = newDirection;
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    closeGame();
                }
            }
        });
        timer = new Timer(100, e -> {
            if (!isGameOver) {
                moveSnake();
                checkCollision();
                gamePanel.repaint();
            }
        });
        setFocusable(true);
        requestFocus();
        if (timer != null) {
            timer.start();
        }
        initGame();
    }
    
    private void closeGame() {
        if (timer != null) {
            timer.stop();
        }
        dispose();
        TelaAplicativos telaApps = new TelaAplicativos();
        telaApps.setVisible(true);
    }
    
    private void initGame() {
        snake = new ArrayList<>();
        snake.add(new Point(5, GRID_HEIGHT / 2));
        snake.add(new Point(4, GRID_HEIGHT / 2));
        snake.add(new Point(3, GRID_HEIGHT / 2));
        spawnFood();
        direction = KeyEvent.VK_RIGHT;
        isGameOver = false;
        score = 0;
        if (timer != null && !timer.isRunning()) {
            timer.start();
        }
        requestFocus();
        gamePanel.repaint();
    }
    
    private void spawnFood() {
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(GRID_WIDTH);
            y = rand.nextInt(GRID_HEIGHT);
        } while (snake.contains(new Point(x, y)));
        food = new Point(x, y);
    }
    
    private void moveSnake() {
        if (snake == null || snake.isEmpty()) return;
        Point head = snake.get(0);
        Point newHead = new Point(head);
        switch (direction) {
            case KeyEvent.VK_UP:
                newHead.y--;
                break;
            case KeyEvent.VK_DOWN:
                newHead.y++;
                break;
            case KeyEvent.VK_LEFT:
                newHead.x--;
                break;
            case KeyEvent.VK_RIGHT:
                newHead.x++;
                break;
        }
        if (newHead.equals(food)) {
            snake.add(0, newHead);
            spawnFood();
            score += 10;
        } else {
            snake.add(0, newHead);
            snake.remove(snake.size() - 1);
        }
    }
    
    private void checkCollision() {
        if (snake == null || snake.isEmpty()) return;
        Point head = snake.get(0);
        if (head.x < 0 || head.x >= GRID_WIDTH ||
            head.y < 0 || head.y >= GRID_HEIGHT) {
            gameOver();
            return;
        }
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                gameOver();
                return;
            }
        }
    }
    
    private void gameOver() {
        isGameOver = true;
        if (timer != null) {
            timer.stop();
        }
    }
} 