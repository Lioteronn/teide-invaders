package inputs;

import main.Game;
import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboardinputs implements KeyListener {

    private GamePanel gamePanel;
    public Keyboardinputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                gamePanel.setMoveLeft(true);
                break;
            case KeyEvent.VK_D:
                gamePanel.setMoveRight(true);
                break;
            case KeyEvent.VK_W:
                gamePanel.setMoveUp(true);
                break;
            case KeyEvent.VK_S:
                gamePanel.setMoveDown(true);
                break;
            case KeyEvent.VK_SPACE:
                gamePanel.getPlayer().shoot();
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                gamePanel.setMoveLeft(false);
                break;
            case KeyEvent.VK_D:
                gamePanel.setMoveRight(false);
                break;
            case KeyEvent.VK_W:
                gamePanel.setMoveUp(false);
                break;
            case KeyEvent.VK_S:
                gamePanel.setMoveDown(false);
                break;
        }
    }
    /*
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                gamePanel.changeYDelta(-5);
                break;
            case KeyEvent.VK_A:
                gamePanel.changeXDelta(-5);
                break;
            case KeyEvent.VK_S:
                gamePanel.changeYDelta(+5);
                break;
            case KeyEvent.VK_D:
                gamePanel.changeXDelta(+5);
                break;
        }
    }
    */

}
