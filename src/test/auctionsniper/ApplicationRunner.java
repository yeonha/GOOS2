package test.auctionsniper;

import auctionsniper.AuctionSniperDriver;
import auctionsniper.Main;
import auctionsniper.MainWindow;

public class ApplicationRunner {
	public static final String SNIPER_ID = "sniper";
	public static final String SNIPER_PASSWORD = "sniper";
	protected static final String XMPP_HOSTNAME = "localhost";
	public static final String SNIPER_XMPP_ID = "sniper@yeonhaan2214/Auction";
	private AuctionSniperDriver driver;
	private String  STATUS_LOST = "Lost" ;
	private String  STATUS_JOINING = "Joining" ;

	public void startBiddingIn(final FakeAuctionServer auction) {
		Thread thread = new Thread("Test Application") {
			@Override 
			public void run() {
				try {
					Main.main(XMPP_HOSTNAME, SNIPER_ID, SNIPER_PASSWORD, auction.getItemId()) ;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		thread.setDaemon(true);
		thread.start();
		driver = new AuctionSniperDriver(1000);
		driver.showsSniperStatus(STATUS_JOINING);
		
	}

	public void showsSniperHasLostAuction() {
		driver.showsSniperStatus(STATUS_LOST);
	}

	public void stop() {
		if(driver != null) {
			driver.dispose();
		}
	}

	public void hasShownSniperIsBidding() {
		driver.showsSniperStatus(MainWindow.STATUS_BIDDING);		
	}

	public void hasShownSniperIsWinning() {
		driver.showsSniperStatus(MainWindow.STATUS_WINNING);	
		
	}

	public void showsSniperHasWonAuction() {
		driver.showsSniperStatus(MainWindow.STATUS_WON);	
		
	}

}
