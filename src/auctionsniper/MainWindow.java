package auctionsniper;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;


public class MainWindow extends JFrame {
	private final SnipersTableModel snipers = new SnipersTableModel();
	
	public static String  STATUS_JOINING = "Joining" ;
	public static String  STATUS_LOST = "Lost" ;
	
	private static final String MAIN_WINDOW_NAME = "Main Window Name";

	private static final String SNIPER_STATUS_NAME = "sniper status";
	public static final String STATUS_BIDDING = "bidding";
	public static final String STATUS_WINNING = "winning";
	public static final String STATUS_WON = "won";

	private static final String SNIPERS_TABLE_NAME = "snipers table";
//	private final JLabel sniperStatus = createLabel(STATUS_JOINING);
	

	public MainWindow() {
		super("Auction Sniper");
		setName(MAIN_WINDOW_NAME);
	//	add(sniperStatus);
		fillContentPane(makeSnipersTable());
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}


	private void fillContentPane(JTable snipersTable) {
		final Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		contentPane.add(new JScrollPane(snipersTable), BorderLayout.CENTER);
	}


	private JTable makeSnipersTable() {
		final JTable snipersTable = new JTable(snipers);
		snipersTable.setName(SNIPERS_TABLE_NAME);
		return snipersTable;
	}


	private static JLabel createLabel(String initialText) {
		JLabel result = new JLabel(initialText);
		result.setName(SNIPER_STATUS_NAME);
		result.setBorder(new LineBorder(Color.BLACK));
		return result;
		
	}


	public void showStatus(String statusText) {
	//	sniperStatus.setText(status);
		snipers.setStatusText(statusText);
	}


	public void sniperStatusChanged(SniperState sniperState, String statusText) {
		snipers.sniperStatusChanged(sniperState, statusText);		
	}
	
}
