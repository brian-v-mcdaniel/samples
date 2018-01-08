package tictactoe;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

// Tic Tac Toe program by Brian McDaniel
// based on a BASIC program from Enter Magazine
//
// This is an exercise I gave myself in 
// converting from one language to a 
// significantly different language. 
// Watch out for those IF-THEN-ELSE statements.

public class TicTacToe extends Canvas {
	private static final long serialVersionUID = 1L;
	final Color GRAY = new Color(204, 204, 204);
	final Color LIGHT_RED = new Color(255, 121, 120);
	final Color DARK_RED = new Color(212, 82, 77);
	final Color DARK_BLUE = new Color(84, 85, 237);
	final int MAX_TURNS = 9;
	final int MIN_ROW = 14;
	final int MIN_COL = 12;
	final int SCALE = 16;
	final int SPACE = 32;
	final int ENTER = 10;
	private BufferStrategy strategy;
	private Rectangle2D.Float background;
	private Graphics2D g2d;
	// K
	private char charPressed;
	// TD
	int spaces[][] = new int[4][4];
	// FR
	int firstTurn = 0;
	// VV
	int numTurns = 0;
	// FL
	int lastPlayer = 0;
	// TR
	int testRow = 0;
	// TC
	int testColumn = 0;
	// IR
	int lastComputerRow = 0;
	// IC
	int lastComputerColumn = 0;
	int limit = 0;
	// XD
	int xDrawn = 0;
	// RN
	int newRow = MIN_ROW;
	// RO
	int oldRow = MIN_ROW;
	// CN
	int newCol = MIN_COL;
	// CO
	int oldCol = MIN_COL;
	// WN 
	int occupySpace = 0;	// 1 for user, -1 for computer
	// XR
	int xRowIndex = 0;
	// XC
	int xColumnIndex = 0;
	// RR
	int computersRow = 0;
	// CC
	int computersColumn = 0;
	// R1
	int randomRow = 0;
	// C1
	int randomColumn = 0;
	// R
	int row = 0;
	// C
	int column = 0;
	// FH
	int foundHoriz = 0;
	// FV
	int foundVert = 0;
	// DR
	int decrementRow = 0;
	// DC
	int decrementCol = 0;
	// YR
	int nextHorizRow = 0;
	// YC
	int nextHorizColumn = 0;
	// ZR
	int nextVertRow = 0;
	// ZC
	int nextVertColumn = 0;	
	// FD
	int foundDiagonal = 0;
	// LR
	int openRow = 0;
	// LC
	int openColumn = 0;
	// KR
	int openRow2 = 0;
	// KC
	int openColumn2 = 0;
	// S
	boolean isKeyPressed = false;
	/**
	 * Construct our game and set it running.
	 */
	public TicTacToe() {
		JFrame container = new JFrame("Tic Tac Toe");
		JPanel panel = (JPanel) container.getContentPane();
		panel.setPreferredSize(new Dimension(534,404));
		panel.setLayout(null);
		setBounds(0,0,550,420);
		panel.add(this);
		setIgnoreRepaint(true);
		container.pack();
		container.setResizable(false);
		container.setVisible(true);
		container.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		addKeyListener(new KeyInputHandler());
		requestFocus();
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		g2d = (Graphics2D) strategy.getDrawGraphics();
	}

	/*
	 * 1 RANDOMIZE
	   2 REM --TIC TAC TOE GAME IN TI 99/A BASIC--
	   3 REM --FROM ENTER MAGAZINE ISSUE 2 NOV 1983--
	   5 REM **DRAW GAME GRID**
	   7 CALL CLEAR
	   10 CALL SCREEN (15)
	   15 CALL COLOR (3,2,2)
	   20 FOR I = 0 TO 1 STEP 1
	   30 CALL HCHAR (12 + (I*4), 11, 48, 11)
	   40 CALL VCHAR (9, 14 + (I*4), 48, 11)
	   50 NEXT I
	   55 FOR I = 1 TO 3
	   57 FOR J = 1 TO 3
	   60 TD (I, J) = 0
	   63 NEXT J
	   65 NEXT I	
	 */
	public void startGame() {
        g2d.setColor(GRAY);
        background = new Rectangle2D.Float( 
                0F, 0F, (float)getSize().width, (float)getSize().height);
        g2d.fill(background);    
    	g2d.setColor(Color.black);
    	g2d.setStroke(new BasicStroke(1.0f));
    	for (int i = 0; i <= 1; i++) {
    		// draw vertical lines
    		g2d.fillRect(226 + (i*64), 66, 16, 176);
    		// draw horizontal lines
    		g2d.fillRect(178, 114 + (i*64), 176, 16);
    	}	
        for (int i = 0; i < 4; ++i) {
        	for (int j = 0; j < 4; ++j) {
        		spaces[i][j] = 0;
        	}
        }
        /*
         * 68 REM **INSTRUCTIONS**
		   70 PRINT TAB (8); "PRESS SPACE BAR"
		   80 PRINT TAB (8); "TO MOVE SQUARE."
		   85 PRINT
		   90 PRINT TAB (8); "PRESS ENTER TO"
		   100 PRINT TAB (8); "CHOOSE SPACE."
         */
    	g2d.setColor(Color.black);
    	g2d.setFont(new Font("Monospaced", Font.BOLD, 24));
    	g2d.drawString("PRESS  SPACE  BAR", 165, 320);
    	g2d.drawString("TO  MOVE  SQUARE.", 165, 336); 
    	g2d.drawString("PRESS  ENTER  TO", 165, 368);
    	g2d.drawString("CHOOSE  SPACE.", 165, 384);    	
		strategy.show();
		
		// 190 FR = INT(2*RND) + 1
        firstTurn = (int)(2*Math.random() + 1);
		// 192 VV = 0
        numTurns = 0;
		// 194 IF FR = 2 THEN 500
        if (firstTurn == 2) 
        	computerMakesFirstMove();
        else
        	mainLoop();	// player moves X
	}

	/*
	500 REM **COMPUTER MAKES FIRST MOVE**
	510 IF VV < 3 THEN 5000
	600 REM **COMPUTER PUTS 'O' IN SAME ROW OR COLUMN**
	605 TR = IR
	607 TC = IC
	610 LIMIT = 1
	620 GOSUB 3000
	630 GOSUB 4000
	640 IF FL = 1 THEN 900
	700 REM **COMPUTER'S RANDOM MOVE**
	705 IF VV = 9 THEN 11000
	710 GOSUB 5200
	*/
	void computerMakesFirstMove() {
		if (numTurns < 3) computersFirstMove();
		testRow = lastComputerRow;
		testColumn = lastComputerColumn;
		limit = 1;
		didSomeoneWin();
		computersMove();
		if (lastPlayer != 1) {
			if (numTurns == MAX_TURNS) catGame();
			chooseComputersMoveRandomly();
		}		
	}
	
	private void mainLoop() {
		while (true) {
		/*
		200 REM **PLAYER MOVES 'X'**
		210 FL = 0
		213 IF VV = 9 THEN 11000
		215 GOSUB 2000
		220 VV = VV+1
		*/
		lastPlayer = 0;
		if (numTurns == MAX_TURNS) catGame();
		moveX();
		numTurns++;
		/*
		300 REM ** DID PLAYER WIN?**
		310 WN = 1
		312 TR = XR
		314 TC = XC
		320 GOSUB 3000
		*/
		occupySpace = 1;
		testRow = xRowIndex;
		testColumn = xColumnIndex;
		didSomeoneWin();
		/*
		400 REM **COMPUTER TRIES TO WIN**
		410 LIMIT = 2
		415 WN = -1
		420 TR = IR
		425 TC = IC
		430 GOSUB 3000
		435 GOSUB 4000
		440 IF FL = 1 THEN 800
		450 TR = XR
		455 TC = XC
		460 WN = 1
		470 GOSUB 3000
		480 GOSUB 4000
		490 IF FL = 1 THEN 800
		*/
		limit = 2;
		occupySpace = -1;
		testRow = lastComputerRow;
		testColumn = lastComputerColumn;
		didSomeoneWin();
		computersMove();
		if (lastPlayer == 1) didComputerWin();
		testRow = xRowIndex;
		testColumn = xColumnIndex;
		occupySpace = 1;
		didSomeoneWin();
		computersMove();
		if (lastPlayer == 1) didComputerWin();		
		computerMakesFirstMove();
		/*
		900 VV = VV + 1
		910 GOTO 210 
		*/
		numTurns++; 
		} // end while
	}

	/*
	800 REM **DID COMPUTER WIN?**
	805 TR = IR
	807 TC = IC
	810 WN = -1
	815 LIMIT = 2
	820 GOSUB 3000
	*/
	void didComputerWin() {
		testRow = lastComputerRow;
		testColumn = lastComputerColumn;
		occupySpace = -1;
		limit = 2;
		didSomeoneWin();
		/*
		900 VV = VV + 1
		910 GOTO 210 
		*/
		numTurns++; 
		mainLoop();
	}	
	
	/*
	 2000 REM **MOVE 'X'**
	 2005 K = 0
	 2007 XD = 0
	 2010 CALL COLOR (12, 10, 10) 
	 2015 REM **PUT SELECTOR ON GRID** 
	 2020 RN = 14 
	 2022 RO = 14 
	 2024 CN = 12 
	 2028 CO = 12 
	 2030 CALL HCHAR (RO, CO, 126, 1) 
	 2040 CALL KEY (0, K, S) 
	 2050 IF (S = 0) + (S = -1) THEN 2030 
	 2060 IF K = 32 THEN 7000		
	 2070 GOSUB 9000
	 2100 IF (K = 13) * (TD(R,C) = 0) THEN 8000
	 2110 IF XD = 1 THEN 2140
	 2120 K = 0
	 2130 GOTO 2040
	 2140 RETURN		
	 */
	void moveX() {
		charPressed = 0;
		xDrawn = 0;
    	g2d.setColor(LIGHT_RED);
		newRow = MIN_ROW;
		oldRow = MIN_ROW;
		newCol = MIN_COL;
		oldCol = MIN_COL;
    	g2d.setStroke(new BasicStroke(1.0f));
		g2d.fillRect(oldCol*SCALE + 2, oldRow*SCALE + 2, 16, 16);
		strategy.show();
		while (xDrawn != 1) {	// input loop
			isKeyPressed = false;
			while (!isKeyPressed) {
				try { Thread.sleep(1); } catch (Exception e) {};
			}
			if (charPressed == SPACE) moveSquare();
			convertRNCN();
			if ((charPressed == ENTER) && (spaces[row][column] == 0)) drawX();
			if (xDrawn == 1) return;
			charPressed = 0;
		}
	}	
	
	void didSomeoneWin() {
		/*
		 3000 REM **DID SOMEONE WIN?**
		 3002 FH = 0
		 3004 FV = 0
		 3006 RB = 0
		 3008 CB = 0
		 3009 YR = 0
		 3010 YC = 0
		 3011 ZR = 0
		 3012 ZC = 0
		 3015 FOR I = 0 TO 2
		 3020 IF TD(TR, 1 + I) = WN THEN 3025 ELSE 3030
		 3025 FH = FH + 1
		 3030 IF TD(1 + I, TC) = WN THEN 3035 ELSE 3040
		 3035 FV = FV + 1
		 3040 IF TD(TR, 1 + I) = 0 THEN 3042 ELSE 3045
		 3042 ZR = TR
		 3043 ZC = 1 + I
		 3045 IF TD (1 + I, TC) = 0 THEN 3047 ELSE 3050
		 3047 YR = 1 + I
		 3048 YC = TC
		 3050 NEXT I
		*/		
		foundHoriz = 0;
		foundVert = 0;
		nextHorizRow = 0;
		nextHorizColumn = 0;
		nextVertRow = 0;
		nextVertColumn = 0;
		for (int i = 0; i < 3; ++i) {
			if (spaces[testRow][1 + i] == occupySpace) {
				foundHoriz++;
			}
			if (spaces[1 + i][testColumn] == occupySpace) {
				foundVert++;
			}
			if (spaces[testRow][1 + i] == 0) {
				nextVertRow = testRow;
				nextVertColumn = 1 + i;
			}
			if (spaces[1 + i][testColumn] == 0) {
				nextHorizRow = 1 + i;
				nextHorizColumn = testColumn;
			}	
		}
		/*
		 3055 IF (FH = 3) + (FV = 3) THEN 10000
		 3060 IF ABS(TR - TC) = 1 THEN 3170
		 3100 IF TR - TC = 0 THEN 3600
		 3120 IF TR + TC = 4 THEN 3800
		 3170 RETURN
		 */
		if (foundHoriz == 3 || foundVert == 3) theWinnerIs();
		if (Math.abs(testRow - testColumn) != 1) {
			if (testRow - testColumn == 0) checkLeftRightDiagonal();
			if (testRow + testColumn == 4) checkRightLeftDiagonal();
		}
	}	
	
	/*
	 3600 REM **CHECK LEFT/RIGHT DIAGONAL**
	 3610 FD = 0
	 3612 LR = 0
	 3614 LC = 0
	 3620 FOR I = 1 TO 3
	 3630 IF TD(I, I) = WN THEN 3635 ELSE 3640
	 3635 FD = FD + 1
	 3640 IF TD(I, I) = 0 THEN 3645 ELSE 3660
	 3645 LR = I
	 3650 LC = I
	 3660 NEXT I
	 3665 IF FD = 3 THEN 10000
	 3670 GOTO 3120
	 */
	void checkLeftRightDiagonal() {
		foundDiagonal = 0;
		openRow = 0;
		openColumn = 0;
		for (int i = 1; i < 4; ++i) {
			if (spaces[i][i] == occupySpace) {
				foundDiagonal++;
			}
			if (spaces[i][i] == 0) {
				openRow = i;
				openColumn = i;
			}
		}
		if (foundDiagonal == 3) theWinnerIs();
	} 
	
	/*
	 3800 REM **CHECK RIGHT/LEFT DIAGONAL**
	 3810 FD = 0
	 3812 KR = 0
	 3814 KC = 0
	 3820 FOR I = 1 TO 3
	 3830 IF TD(I, 4 - I) = WN THEN 3835 ELSE 3840
	 3835 FD = FD + 1
	 3840 IF TD(I, 4 - I) = 0 THEN 3845 ELSE 3860
	 3845 KR = I
	 3846 KC = 4 - I
	 3860 NEXT I
	 3865 IF FD = 3 THEN 10000
	 3870 GOTO 3170		 
	 */
	void checkRightLeftDiagonal() {
		foundDiagonal = 0;
		openRow2 = 0;
		openColumn2 = 0;
		for (int i = 1; i < 4; ++i) {
			if (spaces[i][4 - i] == occupySpace) {
				foundDiagonal++;
			}
			if (spaces[i][4 - i] == 0) {
				openRow2 = i;
				openColumn2 = 4 - i;
			}
		}
		if (foundDiagonal == 3) theWinnerIs();
	}	
	
	/*
	 4000 REM **COMPUTER'S MOVE**
	 4010 IF (FH = LIMIT) * (ZR > 0) THEN 4015 ELSE 4020
	 4015 RR = ZR
	 4016 CC = ZC
	 4017 GOSUB 9200
	 4018 GOSUB 8200
	 4019 RETURN
	 4020 IF (FV = LIMIT) * (YR > 0) THEN 4025 ELSE 4030
	 4025 RR = YR
	 4026 CC = YC
	 4027 GOSUB 9200
	 4028 GOSUB 8200 
	 4029 RETURN
	 4030 IF (FD = LIMIT) * (LR > 0) THEN 4035 ELSE 4040
	 4035 RR = LR
	 4036 CC = LC
	 4037 GOSUB 9200
	 4038 GOSUB 8200
	 4039 RETURN
	 4040 IF (FD = LIMIT) * (KR > 0) THEN 4045 ELSE 4050
	 4045 RR = KR
	 4046 CC = KC
	 4047 GOSUB 9200
	 4048 GOSUB 8200
	 4050 RETURN		 
	 */
	void computersMove() {
		if ((foundHoriz == limit) && (nextVertRow > 0)) {
			computersRow = nextVertRow;
			computersColumn = nextVertColumn;
		} else if ((foundVert == limit) && (nextHorizRow > 0)) {
			computersRow = nextHorizRow;
			computersColumn = nextHorizColumn;
		} else if ((foundDiagonal == limit) && (openRow > 0)) {
			computersRow = openRow;
			computersColumn = openColumn;
		} else if ((foundDiagonal == limit) && (openRow2 > 0)) {
			computersRow = openRow2;
			computersColumn = openColumn2;
		} else return;
		convertRC();
		drawO();	
	}
	
	/*
	5000 REM **COMPUTER'S FIRST MOVE**
	5010 IF TD(2, 2) = 0 THEN 5015 ELSE 5020
	5015 RR = 2
	5016 CC = 2
	5017 GOSUB 9200
	5018 GOSUB 8200
	5019 GOTO 900
	5020 GOSUB 5200
	5030 GOTO 900
	*/
	void computersFirstMove() {
		if (spaces[2][2] == 0) {
			computersRow = 2;
			computersColumn = 2;
			convertRC();
			drawO();
		}
		else 
			chooseComputersMoveRandomly();
		/*
		900 VV = VV + 1
		910 GOTO 210 
		*/
		numTurns++; 
		mainLoop();
	}
	
	/*
	 5200 REM **CHOOSE COMPUTER'S MOVE RANDOMLY**
	 5210 R1 = INT(3 * RND) + 1
	 5220 C1 = INT(3 * RND) + 1
	 5230 IF TD(R1, C1) = 0 THEN 5235 ELSE 5210
	 5235 RR = R1
	 5236 CC = C1
	 5237 GOSUB 9200
	 5238 GOSUB 8200
	 5240 RETURN
	 */
	void chooseComputersMoveRandomly() {
		do {
		randomRow = (int)(3 * Math.random() + 1);
		randomColumn = (int)(3 * Math.random() + 1); 
		} while (spaces[randomRow][randomColumn] != 0);
		computersRow = randomRow; 
		computersColumn = randomColumn;
		convertRC();
		drawO();
	}
	
	/*
	 7000 REM **MOVE SQUARE**
	 7005 RN = RO - 4
	 7010 IF (RN < 6) * (CN < 20) THEN 7015 ELSE 7020
	 7015 CN = CO + 4
	 7016 RN = RO + 8
	 7020 IF (RN < 6) * (CN = 20) THEN 7025 ELSE 7030
	 7025 CN = CO + 4
	 7026 RN = RO + 8
	 7030 IF CN > 20 THEN 7035 ELSE 7050
	 7035 CN = 12
	 7040 RN = 14
	 7050 CALL COLOR (13, 1, 1)
	 7060 CALL HCHAR (RO, CO, 128, 1)
	 7070 CALL COLOR (12, 10, 10)
	 7080 CALL HCHAR (RN, CN, 126, 1)
	 7100 RO = RN
	 7110 CO = CN
	 7120 GOTO 2070
	 */
	void moveSquare() {
		newRow = oldRow - 4;
		if ((newRow < 6) && (newCol < 20)) {
			newCol = oldCol + 4;
			newRow = oldRow + 8;
		}
		if ((newRow < 6) && (newCol == 20)) {
			newCol = oldCol + 4;
			newRow = oldRow + 8;
		}
		if (newCol > 20) {
			newCol = MIN_COL;
			newRow = MIN_ROW;
		}
		
		// erase indicator
        g2d.setColor(GRAY);
    	g2d.setStroke(new BasicStroke(1.0f));
		g2d.fillRect(oldCol*SCALE + 2, oldRow*SCALE + 2, 16, 16);   
		// redraw X or O
		int redrawRow = (oldRow - 2) / 4;
		int redrawColumn = (oldCol - 8) / 4;
		if (spaces[redrawRow][redrawColumn] == 1) {
	        g2d.setColor(DARK_RED);	
	    	g2d.setStroke(new BasicStroke(12.0f));
	    	g2d.drawLine(oldCol*SCALE + 2 - 8, oldRow*SCALE + 2 - 24, 
	    			oldCol*SCALE + 2 + 24, oldRow*SCALE + 2 + 8);
			g2d.drawLine(oldCol*SCALE + 2 - 8, oldRow*SCALE + 2 + 8, 
					oldCol*SCALE + 2 + 24, oldRow*SCALE + 2 - 24);   
		}
		if (spaces[redrawRow][redrawColumn] == -1) {
			g2d.setColor(DARK_BLUE);	
	    	g2d.setStroke(new BasicStroke(14.0f));
	    	g2d.drawArc(oldCol*SCALE + 2 - 9, oldRow*SCALE + 2 - 25, 34, 34, 0, 360);	
		}
		// draw indicator in new space
    	g2d.setColor(LIGHT_RED);
    	g2d.setStroke(new BasicStroke(1.0f));
    	g2d.fillRect(newCol*SCALE + 2, newRow*SCALE + 2, 16, 16);
    	strategy.show();
    	
    	oldRow = newRow;
    	oldCol = newCol;
    	// 2070 GOSUB 9000
    	convertRNCN();
	}
	
	/*
	 8000 REM **DRAW 'X'**
	 8010 RM = RN - 2
	 8020 CM = CN - 1
	 8025 CALL COLOR (14, 7, 7)
	 8030 FOR I = 0 TO 2
	 8040 CALL HCHAR (RM + I, CM + I, 136, 1)
	 8050 CALL HCHAR (RM + I, (CM + 2) - I, 136, 1)
	 8052 NEXT I
	 8055 XD = 1
	 8060 TD(R, C) = 1
	 8070 XR = R
	 8075 XC = C
	 8080 CALL COLOR(13, 1, 1)
	 8085 CALL HCHAR(RO, CO, 128, 1)
	 8090 GOTO 2110
	 */
	void drawX() {		
		// erase indicator
        g2d.setColor(GRAY);
    	g2d.setStroke(new BasicStroke(1.0f));
		g2d.fillRect(newCol*SCALE + 2, newRow*SCALE + 2, 16, 16);   
		// draw X
        g2d.setColor(DARK_RED);	
    	g2d.setStroke(new BasicStroke(12.0f));
    	g2d.drawLine(newCol*SCALE + 2 - 8, newRow*SCALE + 2 - 24, 
    			newCol*SCALE + 2 + 24, newRow*SCALE + 2 + 8);
		g2d.drawLine(newCol*SCALE + 2 - 8, newRow*SCALE + 2 + 8, 
				newCol*SCALE + 2 + 24, newRow*SCALE + 2 - 24);   
		
		xDrawn = 1;
		spaces[row][column] = 1;
		xRowIndex = row;
		xColumnIndex = column;
	}
	
	/*
	 8200 REM **DRAW 'O'**
	 8210 RM = RN - 2
	 8215 CM = CN - 1
	 8220 CALL COLOR(15, 5, 5)
	 8230 FOR I = 0 TO 2
	 8240 CALL HCHAR(RM + I, CM, 144, 3)
	 8250 NEXT I
	 8260 CALL COLOR(13, 15, 15)
	 8265 CALL VCHAR(RN - 1, CN, 128, 2)
	 8270 TD(RR, CC) = -1
	 8285 IR = RR
	 8290 IC = CC
	 8295 FL = 1
	 8299 RETURN
	 */
	void drawO() {
		g2d.setColor(DARK_BLUE);	
    	g2d.setStroke(new BasicStroke(14.0f));
    	g2d.drawArc(newCol*16 + 2 - 9, newRow*16 + 2 - 25, 34, 34, 0, 360);
		
		spaces[computersRow][computersColumn] = -1;
		lastComputerRow = computersRow;
		lastComputerColumn = computersColumn;
		lastPlayer = 1;
	}
	
	/*
	 9000 REM **CONVERT RN, CN FOR ARRAY**
	 9010 DR = RN - 2
	 9020 R = DR / 4
	 9030 DC = CN - 8
	 9040 C = DC / 4
	 9050 RETURN
	 */
	void convertRNCN() {
		decrementRow = newRow - 2;
		row = decrementRow / 4;
		decrementCol = newCol - 8;	
		column = decrementCol / 4;
	}
	
	/*
	9200 REM **CONVERT R, C TO RN, CN**
	9220 RN = 2 + (RR * 4)
	9230 CN = 8 + (CC * 4)
	9240 RETURN
	*/
	void convertRC() {
		newRow = 2 + (computersRow * 4);
		newCol = 8 + (computersColumn * 4);
	}
	
	/*
	 10000 REM **THE WINNER IS!**
	 10002 FOR DE = 1 TO 500
	 10003 NEXT DE
	 10005 CALL CLEAR
	 10010 IF WN = 1 THEN 10015 ELSE 10020
	 10015 PRINT "YOU WIN."
	 10016 GOTO 11030
	 10020 PRINT "THE COMPUTER WINS."
	 10025 GOTO 11030
	 */
	void theWinnerIs() {
        g2d.setColor(GRAY);
        Rectangle2D box = new Rectangle2D.Float( 
                0F, 300F, (float)getSize().width, (float)getSize().height);
        g2d.fill(box);      
		if (occupySpace == 1) {
	    	g2d.setColor(Color.black);
	    	g2d.setFont(new Font("Monospaced", Font.BOLD, 24));
	    	g2d.drawString("YOU WIN.", 45, 352);
		}
		else {
	    	g2d.setColor(Color.black);
	    	g2d.setFont(new Font("Monospaced", Font.BOLD, 24));
	    	g2d.drawString("THE COMPUTER WINS.", 45, 352);
		}
		strategy.show();
    	
		playAgain();
	}
	
	/*
	 11000 REM **CAT GAME**
	 11010 CALL CLEAR
	 11020 PRINT "NOBODY WON THIS GAME."
	 */
	void catGame() {
        g2d.setColor(GRAY);
        Rectangle2D box = new Rectangle2D.Float( 
                0F, 300F, (float)getSize().width, (float)getSize().height);
        g2d.fill(box);    
    	g2d.setColor(Color.black);
    	g2d.setFont(new Font("Monospaced", Font.BOLD, 24));
    	g2d.drawString("NOBODY WON THIS GAME.", 45, 352);
		strategy.show();

		playAgain();
	}	
	
	/*
	 11030 PRINT "WOULD YOU LIKE TO PLAY"
	 11035 INPUT "AGAIN? (Y/N)":YN$
	 11040 IF YN$ = "Y" THEN 1
	 11045 CALL SCREEN(15)
	 11050 END
	*/	
	void playAgain() {
    	g2d.setColor(Color.black);
    	g2d.setFont(new Font("Monospaced", Font.BOLD, 24));
    	g2d.drawString("WOULD YOU LIKE TO PLAY ", 45, 368); 
    	g2d.drawString("AGAIN? (Y/N)", 45, 384);
		strategy.show();
		isKeyPressed = false;
		while (!isKeyPressed) {
			try { Thread.sleep(1); } catch (Exception e) {};
		}
		if (charPressed == 'Y' || charPressed == 'y') startGame();
		else System.exit(0);
	}	
	
	private class KeyInputHandler extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			isKeyPressed = true;
			// if we hit escape, then quit the game
			if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
				System.exit(0);
			}
			charPressed = e.getKeyChar();
		}
	}
	
	public static void main(String argv[]) {
		TicTacToe game = new TicTacToe();

		game.startGame();
	}
}
