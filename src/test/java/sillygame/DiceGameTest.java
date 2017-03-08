package sillygame;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import sillygame.Dice;
import sillygame.DiceGame;
import sillygame.Printer;

@RunWith(MockitoJUnitRunner.class)
public class DiceGameTest {
  
  @Mock Dice dice1;
  @Mock Dice dice2;
  @Mock Printer printer;
  
  public DiceGameTest() {
  }

  @Test
  public void playGame() throws Exception {
     when(dice1.roll()).thenReturn(2).thenReturn(4).thenReturn(5);
     when(dice2.roll()).thenReturn(2).thenReturn(3).thenReturn(5);
     
     DiceGame game = new DiceGame(printer, dice1,dice2);
     
     int res = game.roll();
     assertEquals(4,res);
     res = game.roll();
     assertEquals(7,res);
     res = game.roll();
     assertEquals(10,res);
     verify(printer, times(1)).print(anyString());

  }
  
}
