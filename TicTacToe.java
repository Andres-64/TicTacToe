import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class TicTacToe extends JFrame
{  
  private static final GridLayout LAYOUT = new GridLayout(3,3);
  private static final int HEIGHT = 600;
  private static final int WIDTH = 600;
  private JButton buttons[] = new JButton[9];
  private JButton exit;
  private JPanel wholePanel, boardPanel, titlePanel;
  private JLabel title;
  private int turns = 0;
  private String MARK = "";
  private boolean win = false;

public TicTacToe()
{
  createBoardGUI();
  Toolkit kit = Toolkit.getDefaultToolkit();
  Dimension screenSize = kit.getScreenSize();
  int screenHeight = screenSize.height;
  int screenWidth = screenSize.width;
  setSize(WIDTH, HEIGHT);
  setLocation(screenWidth / 4, screenHeight / 4);
}
  
private void createBoardGUI()
{
  title = new JLabel("TicTacToe");
  titlePanel = new JPanel();
  title.setFont(new Font(Font.MONOSPACED, 0, 20));
  title.setForeground(Color.BLACK);
  titlePanel.add(title);
  boardPanel = new JPanel();
  boardPanel.setLayout(LAYOUT);
    class ButtonListener implements ActionListener
    {
      @Override
      public void actionPerformed(ActionEvent ae)
      {
        turns++;
        if(turns % 2 == 0)
        {
        MARK = "O";
        }
        else
        {
        MARK = "X";
        }

        JButton btn = (JButton)ae.getSource();
        btn.setForeground(Color.YELLOW);
        btn.setText(MARK);
        btn.setEnabled(false);
        displayWinner();
        }
    }
      ActionListener buttonListener = new ButtonListener();
      for(int i=0; i<9; i++)
      {
        buttons[i] = new JButton("");
        buttons[i].setBackground(Color.BLACK);
        buttons[i].setForeground(Color.YELLOW);
        buttons[i].setFont(new Font(Font.MONOSPACED, 0, 24));
        buttons[i].addActionListener(buttonListener);
        boardPanel.add(buttons[i]);
      }
      exit = new JButton("exit");
      exit.setFont(new Font(Font.MONOSPACED, 0, 24));
      exit.setForeground(Color.BLACK);
      class QuitListener implements ActionListener
      {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
          System.exit(0);
        }
      }
      ActionListener quitListener = new QuitListener();
      exit.addActionListener(quitListener);
      wholePanel = new JPanel();
      wholePanel.setLayout(new BorderLayout());
      wholePanel.add(titlePanel, BorderLayout.NORTH);
      wholePanel.add(boardPanel, BorderLayout.CENTER);
      wholePanel.add(exit, BorderLayout.SOUTH);
      add(wholePanel);
    }
public void HorzWins()
{
  if (buttons[0].getText().equals(buttons[1].getText())
    && buttons[1].getText().equals(buttons[2].getText())
    && buttons[0].getText().equals("")==false)
  {
    win=true;
  }
  
  else if (buttons[3].getText().equals(buttons[4].getText())
    && buttons[4].getText().equals(buttons[5].getText())
    &&buttons[3].getText().equals("")==false)
  {
    win=true;
  }
  else if (buttons[6].getText().equals(buttons[7].getText())
    && buttons[7].getText().equals(buttons[8].getText())
    && buttons[6].getText().equals("")==false)
  {
    win=true;
  }
}
public void VertWins()
{
  if (buttons[0].getText().equals(buttons[3].getText())
    && buttons[3].getText().equals(buttons[6].getText())
    && buttons[0].getText().equals("")==false)
  {
    win=true;
  }
  
  else if (buttons[1].getText().equals(buttons[4].getText())
    && buttons[4].getText().equals(buttons[7].getText())
    && buttons[1].getText().equals("")==false)
  {
    win=true;

}

  else if (buttons[2].getText().equals(buttons[5].getText())
    && buttons[5].getText().equals(buttons[8].getText())
    && buttons[2].getText().equals("")==false)
  {
    win=true;
  }
}
public void DiagWins()
{
  if (buttons[0].getText().equals(buttons[4].getText())
    && buttons[4].getText().equals(buttons[8].getText())
    && buttons[0].getText().equals("")==false)
  {
    win=true;
  }
  
  else if (buttons[2].getText().equals(buttons[4].getText())
    && buttons[4].getText().equals(buttons[6].getText())
    && buttons[2].getText().equals("")==false)
  {
    win=true;
  }
}
  public void displayWinner()
  {
    if(turns>=5 && turns<=9)
    {
      HorzWins();
      VertWins();
      DiagWins();
      if (win==true)
      {
        JOptionPane.showMessageDialog(null, MARK
        + "  wins");
        System.exit(0);
      }
      else if (turns==9 && win==false)
      {
        JOptionPane.showMessageDialog(null, "Tie");
        System.exit(0);
      }
    }
  }

  
  public static void main(String[] args)
  {
    JFrame frame = new TicTacToe();
    frame.setTitle("TicTacToe");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}