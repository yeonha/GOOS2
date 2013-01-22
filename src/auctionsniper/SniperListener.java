package auctionsniper;

import java.util.EventListener;

import auctionsniper.SniperState;

public interface SniperListener extends EventListener {
	void sniperLost();
	
//	void sniperBidding();

	void sniperBidding(SniperState sniperState);

	void sniperWinning();

	void sniperWon();
}
