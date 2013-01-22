package auctionsniper;


//import org.hamcrest.Matcher;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JTableDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;
import com.objogate.wl.swing.matcher.IterableComponentsMatcher;

import static com.objogate.wl.swing.matcher.JLabelTextMatcher.withLabelText;


public class AuctionSniperDriver extends JFrameDriver {

	public AuctionSniperDriver(int timeoutMillis) {
		super(new GesturePerformer(), JFrameDriver.topLevelFrame(
				named(Main.MAIN_WINDOW_NAME), 
				showingOnScreen() ),
				new AWTEventQueueProber(timeoutMillis, 100));	
	}


	public void showsSniperStatus(String itemId, int lastPrice, int lastBid, String statusText) {
		JTableDriver table = new JTableDriver(this);
		table.hasRow(
				IterableComponentsMatcher.matching(withLabelText(itemId), withLabelText(String.valueOf(lastPrice)),withLabelText(String.valueOf(lastBid)), withLabelText(statusText))
		);		
	}

}
