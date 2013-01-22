package fake.auctionsniper;

import auctionsniper.AuctionSniperDriver;
import auctionsniper.Main;
import auctionsniper.MainWindow;

public class ApplicationRunner {
	private AuctionSniperDriver driver;
	private String  STATUS_LOST = "Lost" ;
	private String  STATUS_JOINING = "Joining" ;
	private String itemId;
	
	protected static final String XMPP_HOSTNAME = "localhost";
	
	public static final String SNIPER_ID = "sniper";
	public static final String SNIPER_PASSWORD = "sniper";
	public static final String SNIPER_XMPP_ID = "sniper@yeonhaan2214/Auction";


	public void startBiddingIn(final FakeAuctionServer auction) {
		itemId = auction.getItemId();
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
		driver.showsSniperStatus(itemId, 0, 0, STATUS_JOINING);
		
	}

	public void showsSniperHasLostAuction() {
		driver.showsSniperStatus(itemId, 1000, 1000, STATUS_LOST);
	}

	public void stop() {
		if(driver != null) {
			driver.dispose();
		}
	}

	public void hasShownSniperIsBidding(int lastPrice, int lastBid) {
		driver.showsSniperStatus(itemId, lastPrice, lastBid, MainWindow.STATUS_BIDDING);		
	}

	public void hasShownSniperIsWinning(int winningBid) {
		driver.showsSniperStatus(itemId, winningBid, winningBid, MainWindow.STATUS_WINNING);	
		
	}

	public void showsSniperHasWonAuction(int lastPrice) {
		driver.showsSniperStatus(itemId, lastPrice, lastPrice,MainWindow.STATUS_WON);	
		
	}

}
