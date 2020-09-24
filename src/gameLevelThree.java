
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Casper
 */
class fireLevelThree {
//The fire will be x, y coordinate.When the Action Perform runs,the fire will forward go to a step

    private int x;
    private int y;

    public fireLevelThree(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
/*Key Listener:
 The listener interface for receiving keyboard events (keystrokes).
 The class that is interested in processing a keyboard event either implements this interface 
 (and all the methods it contains) or extends the abstract KeyAdapter class (overriding only the methods of interest).
 Action Listener:
 The listener interface for receiving action events.
 The class that is interested in processing an action event implements this interface,
 and the object created with that class is registered with a component, using the component's addActionListener method. 
 When the action event occurs, that object's actionPerformed method is invoked.
 */

public class gameLevelThree extends JPanel implements KeyListener, ActionListener {

    ImageIcon backgrounImageLevelThree = new ImageIcon(getClass().getResource("/images/backgroundImageLevelThree.jpg"));
    ImageIcon cupIconLevelThree = new ImageIcon(getClass().getResource("/images/cupOne.gif"));
    ImageIcon gameOverIconLevelThree = new ImageIcon(getClass().getResource("/images/gameOver.png"));
    Timer timer = new Timer(5, this);//When the timer runs, action perform will be activated.
    private int elapsedTime;//We defined it to show the elapsed time.
    private int spentFire;//We defined it to show the elapsed in end of the game
    private ArrayList<fireLevelThree> fireLevelThree = new ArrayList<>();
    private ArrayList<fireLevelThree> enemiesFireLevelThree = new ArrayList<>();
    private ArrayList<fireLevelThree> enemiesFireTwoLevelThree = new ArrayList<>();
    private BufferedImage yourSpaceShipLevelThree;
    private BufferedImage enemiesSpaceShipLevelThree;
    private BufferedImage enemiesSpaceShipBombLevelThree;
    private BufferedImage longWallObtacleLevelThree;
    private BufferedImage longWallObtacleTwoLevelThree;
    private BufferedImage enemiesSpaceShipBombTwoLevelThree;
    private BufferedImage yourSpaceBombLevelThree;
    private int spaceShipXlevelThree = 0, spaceShipYlevelThree = 525;
    private int topXlevelThree = 0;
    private int topDirXlevelThree = 5;//When Action Performs every run.The topDirXlevelThree will be y.And fire will be move.
    //value 5 is speed of topDirXlevelThree
    private int dirSpaceXlevelThree = 10;
    private int dirSpaceYlevelThree = 20;
    private int fireDirXlevelThree = 2;//When Action Performs every run.The fireDirXlevelThree will be y.And fire will be move.
    //value 2 is speed of fireDirXlevelThree
    private int enemiesFireDirYlevelThree = 5, enemiesFireDirYtwoLevelThree = 3;//When Action Performs every run.The enemiesFireDirYlevelThree or enemiesFireDirYtwoLevelThree will be y.And fire will be move.
    //value 5 is speed of enemiesFireDirYlevelThree.value 3 is speed of enemiesFireDirYtwoLevelThree.
    private int wallTopXlevelThree = 0, wallTopXtwoLevelThree = 580;
    private int topBlockDirXlevelThree = 4, topBlockDirXtwoLevelThree = 4;//When Action Performs every run.The topBlockDirXlevelThree or topBlockDirXtwoLevelThree will be y.And fire will be move.
    //value 4 is speed of topBlockDirXlevelThree .value 4 is speed of topBlockDirXtwoLevelThree.
    public static int spentFires;//We defined it to show the spentFires in end of the game.
    public static int elapsedTimes;//We defined it to show the elapsed in end of the game
    public String message;//We defined it to show to The player have been send a message.
    private int remainingFireLevelThree = 15;//You have 15 fires right.

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getSpentFire() {
        return spentFire;
    }

    public void setSpentFire(int spentFire) {
        this.spentFire = spentFire;
    }

    public Boolean enemiesShipHitLevelThree() {
        return fireLevelThree.stream().anyMatch((fire)
                -> (new Rectangle(fire.getX(), fire.getY(), yourSpaceBombLevelThree.getWidth() / 2, yourSpaceBombLevelThree.getHeight() / 2).
                intersects(new Rectangle(topXlevelThree, 0, enemiesSpaceShipLevelThree.getWidth() / 2, enemiesSpaceShipLevelThree.getHeight() / 2))));
    }

    public Boolean collideControlLevelThree() {
        return fireLevelThree.stream().anyMatch((fire)
                -> (new Rectangle(fire.getX(), fire.getY(), yourSpaceBombLevelThree.getWidth(), yourSpaceBombLevelThree.getHeight())
                .intersects(new Rectangle(wallTopXlevelThree, 175, longWallObtacleLevelThree.getWidth(), longWallObtacleLevelThree.getHeight())))
                || (new Rectangle(fire.getX(), fire.getY(), yourSpaceBombLevelThree.getWidth(), yourSpaceBombLevelThree.getHeight())
                .intersects(new Rectangle(wallTopXtwoLevelThree, 300, longWallObtacleTwoLevelThree.getWidth(), longWallObtacleTwoLevelThree.getHeight()))));
    }

    public Boolean hitByEnemiesSpaceShipBombOneLevelThree() {
        return enemiesFireLevelThree.stream().anyMatch((enemiesFire)
                -> (new Rectangle(enemiesFire.getX(), enemiesFire.getY(), enemiesSpaceShipBombLevelThree.getWidth() / 2, enemiesSpaceShipBombLevelThree.getHeight() / 2)
                .intersects(new Rectangle(spaceShipXlevelThree, spaceShipYlevelThree, yourSpaceShipLevelThree.getWidth() / 2, yourSpaceShipLevelThree.getHeight() / 2))));
    }

    public Boolean hitByEnemiesSpaceShipBombTwoLevelThree() {
        return enemiesFireTwoLevelThree.stream().anyMatch((enemiesFireTwo)
                -> (new Rectangle(enemiesFireTwo.getX(), enemiesFireTwo.getY(), enemiesSpaceShipBombTwoLevelThree.getWidth() / 2, enemiesSpaceShipBombTwoLevelThree.getHeight() / 2)
                .intersects(new Rectangle(spaceShipXlevelThree, spaceShipYlevelThree, yourSpaceShipLevelThree.getWidth() / 2, yourSpaceShipLevelThree.getHeight() / 2))));
    }

    public Boolean yourSpaceShipAndObtacleCollideControlLevelThree() {
        return new Rectangle(spaceShipXlevelThree, spaceShipYlevelThree, yourSpaceShipLevelThree.getWidth() / 2, yourSpaceShipLevelThree.getHeight() / 2)
                .intersects(new Rectangle(wallTopXlevelThree, 175, longWallObtacleLevelThree.getWidth(), longWallObtacleLevelThree.getHeight()))
                || new Rectangle(spaceShipXlevelThree, spaceShipYlevelThree, yourSpaceShipLevelThree.getWidth() / 2, yourSpaceShipLevelThree.getHeight() / 2)
                .intersects(new Rectangle(wallTopXtwoLevelThree, 300, longWallObtacleTwoLevelThree.getWidth(), longWallObtacleTwoLevelThree.getHeight()));
    }

    public Boolean fireControl() {
        return remainingFireLevelThree == 0;
    }

    public boolean airplaneLocationControlLevelThree() {
        return spaceShipYlevelThree < 20;
    }

    public gameLevelThree() {
        try {
            //To the Buffered variables assigned pictures.
            yourSpaceShipLevelThree = ImageIO.read(new FileInputStream(new File("images/airplane.png")));
            enemiesSpaceShipLevelThree = ImageIO.read(new FileInputStream(new File("images/jet.png")));
            enemiesSpaceShipBombLevelThree = ImageIO.read(new FileInputStream(new File("images/missileLevelThree.png")));
            enemiesSpaceShipBombTwoLevelThree = ImageIO.read(new FileInputStream(new File("images/missileReverseLevelThree.png")));
            longWallObtacleLevelThree = ImageIO.read(new FileInputStream(new File("images/longWall.png")));
            longWallObtacleTwoLevelThree = ImageIO.read(new FileInputStream(new File("images/longWallTwo.png")));
            yourSpaceBombLevelThree = ImageIO.read(new FileInputStream(new File("images/missileOur.png")));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Level III picture is not opening.\nThat is the Error: " + ex.getMessage());
        }
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgrounImageLevelThree.getImage(), 0, 0, getWidth(), getHeight(), this);
        elapsedTime += 5;
        g.drawImage(yourSpaceShipLevelThree, spaceShipXlevelThree, spaceShipYlevelThree, yourSpaceShipLevelThree.getWidth(), yourSpaceShipLevelThree.getHeight(), this);
        g.drawImage(enemiesSpaceShipLevelThree, topXlevelThree, 0, enemiesSpaceShipLevelThree.getWidth(), enemiesSpaceShipLevelThree.getHeight(), this);

        fireLevelThree.stream().forEach((fire) -> {
            g.drawImage(yourSpaceBombLevelThree, fire.getX(), fire.getY(), yourSpaceBombLevelThree.getWidth(), yourSpaceBombLevelThree.getHeight(), this);
        });
        enemiesFireLevelThree.stream().forEach((enenmiesFire) -> {
            g.drawImage(enemiesSpaceShipBombLevelThree, enenmiesFire.getX(), enenmiesFire.getY(), enemiesSpaceShipBombLevelThree.getWidth(), enemiesSpaceShipBombLevelThree.getHeight(), this);
        });
        enemiesFireTwoLevelThree.stream().forEach((enemiesFireTwo) -> {
            g.drawImage(enemiesSpaceShipBombTwoLevelThree, enemiesFireTwo.getX(), enemiesFireTwo.getY(), enemiesSpaceShipBombTwoLevelThree.getWidth(), enemiesSpaceShipBombTwoLevelThree.getHeight(), this);
        });
        fireLevelThree.stream().filter((fire) -> (fire.getY() < 0)).forEach((fire) -> {
            fireLevelThree.remove(fire);
            //The Value 0 is a border. the fires out from the JFrame can delete  .So Of the program slow work blocked
        });
        enemiesFireLevelThree.stream().filter((enemiesFire) -> (enemiesFire.getY() > 720)).forEach((enemiesFire) -> {
            enemiesFireLevelThree.remove(enemiesFire);
            //The Value 720 is a border. the fires out from the JFrame can delete  .So Of the program slow work blocked.

        });
        enemiesFireTwoLevelThree.stream().filter((enemiesFireTwo) -> (enemiesFireTwo.getY() > 720)).forEach((enemiesFireTwo) -> {
            enemiesFireTwoLevelThree.remove(enemiesFireTwo);
            //The Value 720 is a border. the fires out from the JFrame can delete  .So Of the program slow work blocked.
        });
        g.drawImage(longWallObtacleLevelThree, wallTopXlevelThree, 175, longWallObtacleLevelThree.getWidth(), longWallObtacleLevelThree.getHeight(), this);
        g.drawImage(longWallObtacleTwoLevelThree, wallTopXtwoLevelThree, 300, longWallObtacleTwoLevelThree.getWidth(), longWallObtacleTwoLevelThree.getHeight(), this);
        if (enemiesShipHitLevelThree()) {//If the bomb hits the enemy ship, the game is over.I mean, The player has been win the this section.
            timer.stop();
            message = "Level III successfully completed.... \n"
                    + "*********************************\n"
                    + "Congratulations \n"
                    + "*********************************\n"
                    + "Player: BlackHole \n"
                    + "The Spent Fire : " + getSpentFire() + "\n"
                    + "The Pass Time: " + (double) getElapsedTime() / 1000 + " second.";
            spentFires = getSpentFire();
            elapsedTimes = getElapsedTime();
            JOptionPane.showMessageDialog(this, message, "Level III Result", JOptionPane.INFORMATION_MESSAGE, cupIconLevelThree);
            gameSelection secme = new gameSelection();
            secme.setVisible(true);
        }
        if (collideControlLevelThree()) {//If the  bomb hits the  block, The yours bombs will delete.
            fireLevelThree.stream().forEach((fire) -> {
                fireLevelThree.remove(fire);
            });
        }
        if (hitByEnemiesSpaceShipBombOneLevelThree() || hitByEnemiesSpaceShipBombTwoLevelThree()) {
            //If the enemies bomb hits the your ship, the game is over.I mean, The player has been lose the this section.
            timer.stop();
            message = "You were hit by enemies ship... \n"
                    + "The Spent Fire:  " + getSpentFire() + "\n"
                    + "The Pass Time: " + (double) getElapsedTime() / 1000 + " second";
            spentFires = getSpentFire();
            elapsedTimes = getElapsedTime();
            JOptionPane.showMessageDialog(this, message, "Enemies ship hit", JOptionPane.INFORMATION_MESSAGE, gameOverIconLevelThree);
            gameSelection choose = new gameSelection();
            choose.setVisible(true);
            gameLevelOne levelOne = new gameLevelOne();
            levelOne.setVisible(false);
        }
        if (yourSpaceShipAndObtacleCollideControlLevelThree()) {
            // If the your space ship collide the blocks.The player has been lose the this section.
            timer.stop();
            message = "You have collided with enemies obtacles... \n"
                    + "The Spent Fire : " + getSpentFire() + "\n"
                    + "The Pass Time: " + (double) getElapsedTime() / 1000 + " second";
            spentFires = getSpentFire();
            elapsedTimes = getElapsedTime();
            JOptionPane.showMessageDialog(this, message, "Collide Obtacle", JOptionPane.INFORMATION_MESSAGE, gameOverIconLevelThree);
            gameSelection choose = new gameSelection();
            choose.setVisible(true);
            gameLevelOne levelOne = new gameLevelOne();
            levelOne.setVisible(false);
        }
    }

    @Override
    public void repaint() {
        super.repaint();
        //When Java calls repaint, it calls paint, and this way the shapes are reconstructed.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();//When I press right or left or up or down on the keyboard. the value will rotate right or left.
        if (c == KeyEvent.VK_LEFT) {//When I press left on the keyboard.The Ship will move left.
            if (spaceShipXlevelThree <= 10) {
                spaceShipXlevelThree = 10;
            } else {
                spaceShipXlevelThree -= dirSpaceXlevelThree;
            }
        } else if (c == KeyEvent.VK_RIGHT) {//When I press right on the keyboard.The Ship will move right.
            if (spaceShipXlevelThree >= 740) {
                spaceShipXlevelThree = 740;
            } else {
                spaceShipXlevelThree += dirSpaceXlevelThree;
            }
        }
        if (c == KeyEvent.VK_UP) {//When I press up on the keyboard.The Ship will move up.
            if (spaceShipYlevelThree <= 10) {
                spaceShipYlevelThree = 10;
                if (remainingFireLevelThree == 0) {//If the your fire over. The player should go to enemies border.
                    if (airplaneLocationControlLevelThree()) {
                        //The space ship will make  position control.
                        //If the space ship reach to enemies border, The player will win the game.
                        enemiesFireLevelThree.stream().forEach((enemiesFire) -> {
                            enemiesFireLevelThree.remove(enemiesFire);
                        });
                        timer.stop();
                        message = "Level III successfully completed.... \n"
                                + "*********************************\n"
                                + "Congratulations \n"
                                + "*********************************\n"
                                + "You have reach enemies border. \n"
                                + "The Spent Fire : " + getSpentFire() + "\n"
                                + "The Pass Time: " + (double) getElapsedTime() / 1000 + " second";
                        spentFires = getSpentFire();
                        elapsedTimes = getElapsedTime();
                        JOptionPane.showMessageDialog(this, message, "Enemies Ship Border", JOptionPane.INFORMATION_MESSAGE, cupIconLevelThree);
                        gameSelection secme = new gameSelection();
                        secme.setVisible(true);
                        gameLevelOne levelOne = new gameLevelOne();
                        levelOne.setVisible(false);
                    }

                }
            } else {
                spaceShipYlevelThree -= dirSpaceYlevelThree;
            }
        } else if (c == KeyEvent.VK_DOWN) {//When I press down on the keyboard.The Ship will move down.
            if (spaceShipYlevelThree >= 525) {
                spaceShipYlevelThree = 525;
            } else {
                spaceShipYlevelThree += dirSpaceYlevelThree;
            }
        } else if (c == KeyEvent.VK_CONTROL) {//When I press Control (CTRL) on the keyboard.The Ship will fire the bomb.
            if (remainingFireLevelThree > 0) {
                fireLevelThree.add(new fireLevelThree(spaceShipXlevelThree + 15, spaceShipYlevelThree));//The bomb out of the ship middle.
                spentFire++;
                remainingFireLevelThree--;
            }
            if (fireControl()) {//If the fire is over.You see a information message.
                JOptionPane.showMessageDialog(this, "The fire right is over.\nYou should go to enemies border with  your War Ship" + JOptionPane.WARNING_MESSAGE);
                enemiesFireLevelThree.stream().forEach((enemiesFire) -> {
                    enemiesFireLevelThree.remove(enemiesFire);
                });
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fireLevelThree.stream().forEach((fire) -> {
            fire.setY(fire.getY() - fireDirXlevelThree);//The Y coordinate will change with every fire..

        });
        enemiesFireLevelThree.stream().forEach((enemiesFire) -> {
            enemiesFire.setY(enemiesFire.getY() + enemiesFireDirYlevelThree);

        });
        enemiesFireTwoLevelThree.stream().forEach((enemiesFireTwo) -> {
            enemiesFireTwo.setY(enemiesFireTwo.getY() + enemiesFireDirYtwoLevelThree);
        });
        topXlevelThree += topDirXlevelThree;
        wallTopXlevelThree += topBlockDirXlevelThree;
        wallTopXtwoLevelThree += topBlockDirXtwoLevelThree;
        if (topXlevelThree > 740 || topXlevelThree <= 0) {//enemiesSpaceShipLevelThree will move right or left
            topDirXlevelThree = -topDirXlevelThree;
            if (topXlevelThree == spaceShipXlevelThree) {
                // if your space ship and enemies space ship location positions equals.
                // Enemies space ship will fire bpmb  the your space ship.
                enemiesFireLevelThree.add(new fireLevelThree(topXlevelThree + 15, 10));
            }
        }
        if (topDirXlevelThree < 740 || topDirXlevelThree > 0) {
            if (topXlevelThree == spaceShipXlevelThree) {
                //The enemies ship will move right or left
                //And On this point will fire the bomb
                enemiesFireLevelThree.add(new fireLevelThree(topXlevelThree + 15, 10));
            }
        }
        if (topXlevelThree % 83 == 0) {
            //If the enemy spaceship can be divided by the marked 83 valued, 
            //Enemies space ship will fire bpmb  the your space ship.
            enemiesFireTwoLevelThree.add(new fireLevelThree(topXlevelThree + 18, 10));
        }
        if (wallTopXlevelThree > 580 || wallTopXlevelThree <= 0) {
            topBlockDirXlevelThree = -topBlockDirXlevelThree;
            //The obtacle will move right or left
        }
        if (wallTopXtwoLevelThree > 580 || wallTopXtwoLevelThree <= 0) {
            topBlockDirXtwoLevelThree = -topBlockDirXtwoLevelThree;
            //The obtacle will move right or left
        }
        repaint();
    }

}
