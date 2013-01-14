package auctionsniper;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;


public class MainWindow extends JFrame {
	public static String  STATUS_JOINING = "Joining" ;
	public static String  STATUS_LOST = "Lost" ;
	
	private static final String MAIN_WINDOW_NAME = "Main Window Name";

	private static final String SNIPER_STATUS_NAME = "sniper status";
	public static final String STATUS_BIDDING = "bidding";
	public static final String STATUS_WINNING = "winning";
	public static final String STATUS_WON = "won";
	private final JLabel sniperStatus = createLabel(STATUS_JOINING);
	

	public MainWindow() {
		super("Auction Sniper");
		setName(MAIN_WINDOW_NAME);
		add(sniperStatus);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}


	private static JLabel createLabel(String initialText) {
		JLabel result = new JLabel(initialText);
		result.setName(SNIPER_STATUS_NAME);
		result.setBorder(new LineBorder(Color.BLACK));
		return result;
		
	}


	public void showStatus(String status) {
		sniperStatus.setText(status);
	}
	
}