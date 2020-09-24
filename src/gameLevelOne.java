
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

class fireLevelOne {
//The fire will be x, y coordinate.When the Action Perform runs,the fire will forward go to a step

    private int x;
    private int y;

    public fireLevelOne(int x, int y) {
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

public class gameLevelOne extends JPanel implements KeyListener, ActionListener {

    ImageIcon backgroundImageLevelOne = new ImageIcon(getClass().getResource("/images/spaceBackground.jpg"));//arkaplanResimSeviyeBir
    Timer timer = new Timer(5, this);//When the timer runs, action perform will be activated.
    ImageIcon cupLevelOneIcon = new ImageIcon(getClass().getResource("/images/cupOne.gif"));
    ImageIcon gameOverLevelOneIcon = new ImageIcon(getClass().getResource("/images/gameOver.png"));
    private int elapsedTime;//We defined it to show the elapsed time.
    private int spentFire;//We defined it to show the spentFire time.
    private BufferedImage yourSpaceShipLevelOne;
    private BufferedImage yourSpaceShipBombLevelOne;
    private BufferedImage reverseEnemiesShipLevelOne;
    private BufferedImage enemiesSpaceShipeBombLevelOne;
    private BufferedImage longWallBarrierLevelOne;
    private BufferedImage enemiesSpaceShipOneLevelOne;
    public static int spentFires;//We defined it to show the spentFires in end of the game.
    public static int elapsedTimes;//We defined it to show the elapsed in end of the game.
    private ArrayList<fireLevelOne> firesLevelOne = new ArrayList<>();
    private ArrayList<fireLevelOne> enemiesFireLevelOne = new ArrayList<>();
    private int firedirY = 2, enemiesFireDirY = 2;//When Action Performs every run.The FireDir will be y.And fire will be move.
    //value 2 is speed of firefiry and enemiesFireDirY.
    private int topX = 0, wallTopX;//It will adjust to go left or right. horizontal position
    private int topTwoX = 740, topTwoY = 40; //horizontal position
    private int topY = 0;
    private int topdirX = 4, topTwoDirX = 6, topEnemiesDirX = 4, topBlockDirX = 4;//The vehicle speed values
    private int spaceShipX = 0;//horizontal
    private int enemiesSpaceShipX = 740;//The enemie start  point.
    private int dirSpaceX = 20;//When I press right on the keyboard, the spaceship X will slide 20 units to the right
    public String message;//We defined it to show to The player have been send a message.

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

    public boolean checkIt() {

        return firesLevelOne.stream().anyMatch((fire)
                -> ((new Rectangle(fire.getX(), fire.getY(), yourSpaceShipBombLevelOne.getWidth() / 1, yourSpaceShipBombLevelOne.getHeight() / 1)
                .intersects(new Rectangle(topX, 0, enemiesSpaceShipOneLevelOne.getWidth() / 20, enemiesSpaceShipOneLevelOne.getHeight() / 20)))/* || (new Rectangle(ates.getX(), ates.getY(), 10, 20).intersects(new Rectangle(topTwoX, topTwoY, 20, 20)))*/));
    }

    public boolean checkItTwo() {
        return enemiesFireLevelOne.stream().anyMatch((enemiesFire)
                -> (new Rectangle(enemiesFire.getX(), enemiesFire.getY(), enemiesSpaceShipeBombLevelOne.getWidth() / 2, enemiesSpaceShipeBombLevelOne.getHeight() / 2)
                .intersects(new Rectangle(spaceShipX, 525, yourSpaceShipLevelOne.getWidth() / 4, yourSpaceShipLevelOne.getHeight() / 4))));
    }

    public boolean controlCollideWallLevelOne() {
        return firesLevelOne.stream().anyMatch((fire)
                -> (new Rectangle(fire.getX(), fire.getY(), yourSpaceShipBombLevelOne.getWidth(), yourSpaceShipBombLevelOne.getHeight())
                .intersects(new Rectangle(wallTopX, 250, longWallBarrierLevelOne.getWidth(), longWallBarrierLevelOne.getHeight()))));
    }

    public gameLevelOne() {
        try {
            //To the Buffered variables assigned pictures.
            yourSpaceShipLevelOne = ImageIO.read(new FileImageInputStream(new File("images/jetSpaceWar.png")));
            enemiesSpaceShipOneLevelOne = ImageIO.read(new FileImageInputStream(new File("images/enemiesSpaceShip.png")));
            yourSpaceShipBombLevelOne = ImageIO.read(new FileImageInputStream(new File("images/missile.png")));
            reverseEnemiesShipLevelOne = ImageIO.read(new FileImageInputStream(new File("images/jetReverse.png")));
            enemiesSpaceShipeBombLevelOne = ImageIO.read(new FileImageInputStream(new File("images/missileReverse.png")));
            longWallBarrierLevelOne = ImageIO.read(new FileImageInputStream(new File("images/longWall.png")));

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Game Level I picture is not opening.\nThat is the Error:" + ex.getMessage());
        }
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(backgroundImageLevelOne.getImage(), 0, 0, getWidth(), getHeight(), null);
        elapsedTime += 5;
        g.drawImage(yourSpaceShipLevelOne, spaceShipX, 525, yourSpaceShipLevelOne.getWidth() / 2, yourSpaceShipLevelOne.getHeight() / 2, this);
        g.drawImage(enemiesSpaceShipOneLevelOne, topX, 0, enemiesSpaceShipOneLevelOne.getWidth() / 20, enemiesSpaceShipOneLevelOne.getHeight() / 20, this);
        g.drawImage(reverseEnemiesShipLevelOne, enemiesSpaceShipX, topTwoY, reverseEnemiesShipLevelOne.getWidth() / 2, reverseEnemiesShipLevelOne.getHeight() / 2, this);
        g.drawImage(longWallBarrierLevelOne, wallTopX, 250, longWallBarrierLevelOne.getWidth(), longWallBarrierLevelOne.getHeight(), this);
        firesLevelOne.stream().filter((fire) -> (fire.getY() < 0)).forEach((fire) -> {
            firesLevelOne.remove(fire);
            //The Value 0 is a border. the fires out from the JFrame can delete  .So Of the program slow work blocked.
        });
        enemiesFireLevelOne.stream().filter((enemiesFire) -> (enemiesFire.getY() > 720)).forEach((enemiesFire) -> {
            enemiesFireLevelOne.remove(enemiesFire);
            //The Value 720 is a border. the fires out from the JFrame can delete  .So Of the program slow work blocked.
        });
        firesLevelOne.stream().forEach((fire) -> {
            g.drawImage(yourSpaceShipBombLevelOne, fire.getX(), fire.getY(), yourSpaceShipBombLevelOne.getWidth() / 1, yourSpaceShipBombLevelOne.getHeight() / 1, this);
        });
        enemiesFireLevelOne.stream().forEach((enemiesFire) -> {
            g.drawImage(enemiesSpaceShipeBombLevelOne, enemiesFire.getX(), enemiesFire.getY(), enemiesSpaceShipeBombLevelOne.getWidth(), enemiesSpaceShipeBombLevelOne.getHeight(), this);
        });

        if (checkIt()) {//If the bomb hits the enemy ship, the game is over.I mean, The player has been win the this section.
            timer.stop();
            message = "Level I completed... \n"
                    + "********************************* \n"
                    + "Congratulations \n"
                    + "********************************* \n"
                    + "Player : BlackHole \n"
                    + "Spent Fire : " + getSpentFire() + "\n"
                    + "The Pass Time: " + (double) getElapsedTime() / 1000 + " second.";
            spentFires = getSpentFire();
            elapsedTimes = getElapsedTime();
            JOptionPane.showMessageDialog(this, message, "Skor Board", JOptionPane.INFORMATION_MESSAGE, cupLevelOneIcon);
            gameSelection choose = new gameSelection();
            gameLevelTwo levelTwo = new gameLevelTwo();
            if ((double) elapsedTimes / 1000 < 15.0) {
                int dialog_button = JOptionPane.showConfirmDialog(this, "Would like you play Level II ?", "Warning!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (dialog_button == JOptionPane.OK_OPTION) {
                    levelTwoGameLoad levelTwoGameLoad = new levelTwoGameLoad();
                    levelTwoGameLoad.setVisible(true);
                    timer.stop();

                    spentFires = levelTwo.getSpentFire() + getSpentFire();
                    elapsedTimes = levelTwo.getElapsedTime() + getElapsedTime();
                } else if (dialog_button == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(this, "Level II pass request denied", "Level II situation", JOptionPane.WARNING_MESSAGE);
                    levelTwo.setVisible(false);
                    choose.setVisible(true);
                } else {
                    levelTwo.setVisible(false);
                    choose.setVisible(true);
                }
            } else {
                levelTwo.setVisible(false);
                choose.setVisible(true);
            }

        }
        if (checkItTwo()) {//If the enemies bomb hits the your ship, the game is over.I mean, The player has been lose the this section.
            timer.stop();
            message = "You were hit by Enemies ship... \n"
                    + "The Spent Fire : " + getSpentFire() + "\n"
                    + "The Pass Time: " + (double) getElapsedTime() / 1000 + " second.";
            spentFires = getSpentFire();
            elapsedTimes = getElapsedTime();
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.INFORMATION_MESSAGE, gameOverLevelOneIcon);
            gameSelection choose = new gameSelection();
            choose.setVisible(true);
            gameLevelOne levelOne = new gameLevelOne();
            levelOne.setVisible(false);

        }
        if (controlCollideWallLevelOne()) {//If the  bomb hits the  block, The yours bombs will delete.
            firesLevelOne.stream().forEach((fireLevelOne fire) -> {
                firesLevelOne.remove(fire);
            });

        }
    }

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
        //When Java calls repaint, it calls paint, and this way the shapes are reconstructed.
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();//When I press right or left on the keyboard. the value will rotate right or left.
        if (c == KeyEvent.VK_LEFT) {//When I press Left on the keyboard.The Ship will move left.
            if (spaceShipX <= 20 && enemiesSpaceShipX >= 740) {
                spaceShipX = 20;
            } else {
                spaceShipX -= dirSpaceX;
            }
        } else if (c == KeyEvent.VK_RIGHT) {//When I press right on the keyboard.The Ship will move right.
            if (spaceShipX >= 740 && enemiesSpaceShipX <= 20) {
                spaceShipX = 740;
            } else {
                spaceShipX += dirSpaceX;
            }
        } else if (c == KeyEvent.VK_CONTROL) {
            firesLevelOne.add(new fireLevelOne(spaceShipX + 15, 515));//The bomb out of the ship middle.
            spentFire++;//When I press Control (CTRL) on the keyboard.The Ship will fire the bomb.
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        firesLevelOne.stream().forEach((fire) -> {
            //The Y coordinate will change with every fire..
            fire.setY(fire.getY() - firedirY);
        });
        enemiesFireLevelOne.stream().forEach((enemiesFire) -> {
             //The Y coordinate will change with every enemies fire..
            enemiesFire.setY(enemiesFire.getY() + enemiesFireDirY);
        });
        topTwoX += topTwoDirX;
        topX += topdirX;
        wallTopX += topBlockDirX;
        enemiesSpaceShipX += topEnemiesDirX;
        if (topX > 750 || topX <= 0) {//The enemies space ship one will move right or left
            topdirX = -topdirX;
        }
        if (topTwoX > 750 || topTwoX <= 0) {
            topTwoDirX = -topTwoDirX;
        }
        if (enemiesSpaceShipX > 750 || enemiesSpaceShipX <= 0) {
            topEnemiesDirX = -topEnemiesDirX;//The enemies ship will move right or left
            //And On this point will fire the bomb
            enemiesFireLevelOne.add(new fireLevelOne(enemiesSpaceShipX + 19, 40));
        }
        if (enemiesSpaceShipX % 5 == 0 && enemiesSpaceShipX % 7 == 0) {
            //If the enemy spaceship can be divided by the marked 5 and 7 values, the spaceship will be fired.
            enemiesFireLevelOne.add(new fireLevelOne(enemiesSpaceShipX + 19, 40));
        }
        if (wallTopX > 580 || wallTopX <= 0) {
            //The obtacle will move right or left
            topBlockDirX = -topBlockDirX;
        }
        repaint();
        //When Action Perform run.Repaint method will run and when the repaint method will work.
        //So the locations continously update.

    }

}
