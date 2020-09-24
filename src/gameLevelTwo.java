
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
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

class fireLevelTwo {
//The fire will be x, y coordinate.When the Action Perform runs,the fire will forward go to a step
    private int x;
    private int y;

    public fireLevelTwo(int x, int y) {
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
public class gameLevelTwo extends JPanel implements KeyListener, ActionListener {

    ImageIcon backgroundImageLevelTwo = new ImageIcon(getClass().getResource("/images/backgroundImageLevelTwo.jpg"));
    ImageIcon cupIconLevelTwo = new ImageIcon(getClass().getResource("/images/cupOne.gif"));
    ImageIcon gameOverIconLevelTwo = new ImageIcon(getClass().getResource("/images/gameOver.png"));
    Timer timer = new Timer(5, this);//When the timer runs, action perform will be activated.
    private int elapsedTime;//We defined it to show the elapsed time.
    private int spentFire;//We defined it to show the spentFire time.
    private BufferedImage yourSpaceShipLevelTwo;
    private BufferedImage enemiesSpaceShipLevelTwo;
    private BufferedImage yourSpaceShipBombLevelTwo;
    private BufferedImage asteroidObstacleLevelTwo;
    private BufferedImage asteroidObstacleTwoLevelTwo;
    private BufferedImage asteroidObtacleThreeLevelTwo;
    private BufferedImage asteroidObstacleFourLevelTwo;
    public static int spentFires;//We defined it to show the spentFires in end of the game.
    public static int elapsedTimes;//We defined it to show the elapsed in end of the game
    private ArrayList<fireLevelTwo> fireLevelTwo = new ArrayList<>();
    private int firedirY = 2;//When Action Performs every run.The FireDir will be y.And fire will be move.
    //value 2 is speed of firedirY
    private int topX = 0;//It will adjust to go left or right. horizontal position
    private int topY = 0;
    private int topdirX = 7;//The vehicle speed values
    private int spaceShipLevelTwo = 0;
    private int dirSpaceX = 20;//When I press right on the keyboard, the spaceship X will slide 20 units to the right
    private int remainingFireLevelTwo = 10;//You have 10 fires right.
    private String message;//We defined it to show to The player have been send a message.
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

    public boolean checkItLevelTwo() {
        return fireLevelTwo.stream().anyMatch((fire)
                -> (new Rectangle(fire.getX(), fire.getY(), yourSpaceShipBombLevelTwo.getWidth(), yourSpaceShipBombLevelTwo.getHeight())
                .intersects(new Rectangle(topX, 0, enemiesSpaceShipLevelTwo.getWidth()/2, enemiesSpaceShipLevelTwo.getHeight()/2))));
    }

    public boolean controlCollideLevelTwo() {
        return fireLevelTwo.stream().anyMatch((collideFire) -> ((new Rectangle(collideFire.getX(), collideFire.getY(), yourSpaceShipBombLevelTwo.getWidth(), yourSpaceShipBombLevelTwo.getHeight()).intersects(new Rectangle(wallLocation, 300, asteroidObstacleLevelTwo.getWidth(), asteroidObstacleLevelTwo.getHeight())))
                || (new Rectangle(collideFire.getX(), collideFire.getY(), yourSpaceShipBombLevelTwo.getWidth(), yourSpaceShipBombLevelTwo.getHeight()).intersects(new Rectangle(wallLocation + 300, 300, asteroidObstacleTwoLevelTwo.getWidth(), asteroidObstacleTwoLevelTwo.getHeight())))
                || (new Rectangle(collideFire.getX(), collideFire.getY(), yourSpaceShipBombLevelTwo.getWidth(), yourSpaceShipBombLevelTwo.getHeight()).intersects(new Rectangle(wallLocation + 500, 250, asteroidObstacleTwoLevelTwo.getWidth() / 2, asteroidObstacleTwoLevelTwo.getHeight() / 2)))
                || (new Rectangle(collideFire.getX(), collideFire.getY(), yourSpaceShipBombLevelTwo.getWidth(), yourSpaceShipBombLevelTwo.getHeight()).intersects(new Rectangle(wallLocation + 100, 200, asteroidObtacleThreeLevelTwo.getWidth(), asteroidObtacleThreeLevelTwo.getHeight())))
                || (new Rectangle(collideFire.getX(), collideFire.getY(), yourSpaceShipBombLevelTwo.getWidth(), yourSpaceShipBombLevelTwo.getHeight()).intersects(new Rectangle(wallLocation - 150, 300, asteroidObstacleFourLevelTwo.getWidth(), asteroidObstacleFourLevelTwo.getHeight())))));
    }

    public boolean remainingFireControlLevelTwo() {
        return remainingFireLevelTwo == 0;
    }

    public gameLevelTwo() {
        try {
            //To the Buffered variables assigned pictures.
            yourSpaceShipLevelTwo = ImageIO.read(new FileImageInputStream(new File("images/spaceShipLevelTwo.png")));
            enemiesSpaceShipLevelTwo = ImageIO.read(new FileImageInputStream(new File("images/ufo.png")));
            yourSpaceShipBombLevelTwo = ImageIO.read(new FileImageInputStream(new File("images/missileLevelTwo.png")));
            asteroidObstacleLevelTwo = ImageIO.read(new FileImageInputStream(new File("images/asteroidOne.png")));
            asteroidObstacleTwoLevelTwo = ImageIO.read(new FileImageInputStream(new File("images/meteorTwo.png")));
            asteroidObtacleThreeLevelTwo = ImageIO.read(new FileInputStream(new File("images/asteroidBlockThree.png")));
            asteroidObstacleFourLevelTwo = ImageIO.read(new FileInputStream(new File("images/asteroidBlockFour.png")));

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Level II picture is not opening.\nThat is the Error: "+ex.getMessage());
        }
        timer.start();
    }

    static int wallLocation = 150;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImageLevelTwo.getImage(), 0, 0, getWidth(), getHeight(), null);
        elapsedTime += 5;
        g.drawImage(enemiesSpaceShipLevelTwo, topX, 0, enemiesSpaceShipLevelTwo.getWidth(), enemiesSpaceShipLevelTwo.getHeight(), this);
        g.drawImage(yourSpaceShipLevelTwo, spaceShipLevelTwo, 525, yourSpaceShipLevelTwo.getWidth() / 2, yourSpaceShipLevelTwo.getHeight() / 2, this);
        g.drawImage(asteroidObstacleLevelTwo, wallLocation, 300, asteroidObstacleLevelTwo.getWidth(), asteroidObstacleLevelTwo.getHeight(), this);
        g.drawImage(asteroidObstacleTwoLevelTwo, wallLocation + 300, 300, asteroidObstacleTwoLevelTwo.getWidth(), asteroidObstacleTwoLevelTwo.getHeight(), this);
        g.drawImage(asteroidObstacleTwoLevelTwo, wallLocation + 500, 250, asteroidObstacleTwoLevelTwo.getWidth() / 2, asteroidObstacleTwoLevelTwo.getHeight() / 2, this);
        g.drawImage(asteroidObtacleThreeLevelTwo, wallLocation + 100, 200, asteroidObtacleThreeLevelTwo.getWidth(), asteroidObtacleThreeLevelTwo.getHeight(), this);
        g.drawImage(asteroidObstacleFourLevelTwo, wallLocation - 150, 300, asteroidObstacleFourLevelTwo.getWidth(), asteroidObstacleFourLevelTwo.getHeight(), this);
        fireLevelTwo.stream().filter((fire) -> (fire.getY() < 0)).forEach((fire) -> {
            fireLevelTwo.remove(fire);
            //The Value 0 is a border. the fires out from the JFrame can delete  .So Of the program slow work blocked.
        });

        fireLevelTwo.stream().forEach((fire) -> {
            g.drawImage(yourSpaceShipBombLevelTwo, fire.getX(), fire.getY(), yourSpaceShipBombLevelTwo.getWidth(), yourSpaceShipBombLevelTwo.getHeight(), this);
        });

        if (checkItLevelTwo()) {//If the bomb hits the enemy ship, the game is over.I mean, The player has been win the this section.
            timer.stop();
            message = "Level II completed.... \n"
                    + "*********************************\n"
                    + "Congratulations\n"
                    + "*********************************\n"
                    + "Player: BlackHole \n"
                    + "The Spent Fire : " + getSpentFire() + "\n"
                    + "The Pass Time: " + (double) getElapsedTime() / 1000 + " second.";
            spentFires = getSpentFire();
            elapsedTimes = getElapsedTime();
            JOptionPane.showMessageDialog(this, message, "Level II", JOptionPane.INFORMATION_MESSAGE, cupIconLevelTwo);
            gameSelection choose = new gameSelection();
  
             int dialog_button = JOptionPane.showConfirmDialog(this, "Would like you play Level III ?", "Warning!", JOptionPane.OK_CANCEL_OPTION);
                if (dialog_button == JOptionPane.OK_OPTION) {
                    levelThreeGameLoad levelThreeGameLoad1 = new levelThreeGameLoad();
                    levelThreeGameLoad1.setVisible(true);
                    timer.stop();
                    gameLevelTwo levelTwo = new gameLevelTwo();
                    gameLevelThree levelThree = new gameLevelThree();
                    spentFires = levelThree.getSpentFire()+levelTwo.getSpentFire() + getSpentFire();
                    elapsedTimes = levelThree.getElapsedTime()+levelTwo.getElapsedTime() + getElapsedTime();
                } else if (dialog_button == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(this, "Level III pass request denied", "Level II Situation", JOptionPane.WARNING_MESSAGE);
                    choose.setVisible(true);
                } else {
                    choose.setVisible(true);
                }
        }
        if (controlCollideLevelTwo()) {//If the  bomb hits the  block, The yours bombs will delete.
            fireLevelTwo.stream().forEach((atesler1) -> {
                fireLevelTwo.remove(atesler1);
            });
        }

    }

    @Override
    public void repaint() {
        super.repaint();
        //When Java calls repaint, it calls paint, and this way the shapes are reconstructed.
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();//When I press right or left on the keyboard. the value will rotate right or left.
        if (c == KeyEvent.VK_LEFT) {//When I press left on the keyboard.The Ship will move left.

            if (spaceShipLevelTwo <= 20) {

                spaceShipLevelTwo = 20;
            } else {
            }
            spaceShipLevelTwo -= dirSpaceX;
        } else if (c == KeyEvent.VK_RIGHT) {//When I press right on the keyboard.The Ship will move right.
            if (spaceShipLevelTwo >= 740) {

                spaceShipLevelTwo = 740;
            } else {
                spaceShipLevelTwo += dirSpaceX;
            }
        } else if (c == KeyEvent.VK_CONTROL) {//When I press Control (CTRL) on the keyboard.The Ship will fire the bomb.
            if (remainingFireLevelTwo > 0) {
                fireLevelTwo.add(new fireLevelTwo(spaceShipLevelTwo + 17, 515));//The bomb out of the ship middle.
                spentFire++;
                remainingFireLevelTwo--;
            }
            if (remainingFireControlLevelTwo()) {//If your fire over.I mean, The player has been lose the part.
                //You must hit the enemies space ship before your fire over.
                timer.stop();
                message = "The Bullet is over... \n"
                        + "The Spent Fire : " + getSpentFire() + "\n"
                        + "The Pass Time: " + (double) getElapsedTime() / 1000 + " second";
                spentFires = getSpentFire();
                elapsedTimes = getElapsedTime();
                JOptionPane.showMessageDialog(this, message, "The Bullet Situation ", JOptionPane.INFORMATION_MESSAGE, gameOverIconLevelTwo);
                gameSelection choose = new gameSelection();
                choose.setVisible(true);
                gameLevelOne levelOne = new gameLevelOne();
                levelOne.setVisible(false);
            }

        }
    }

    @Override

    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fireLevelTwo.stream().forEach((fire) -> {//The Y coordinate will change with every fire..
            fire.setY(fire.getY() - firedirY);
        });
        topX += topdirX;
        if (topX > 750 || topX<=0) {//The enemies space ship one will move right or left
            topdirX = -topdirX;
        }
     /*   if (topX <= 0) {
            topdirX = -topdirX;
        }*/
        repaint();

    }

}
