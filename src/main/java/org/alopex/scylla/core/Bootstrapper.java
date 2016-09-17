package org.alopex.scylla.core;

import org.alopex.scylla.net.NetBootstrapper;
import org.alopex.scylla.net.p2p.Peer;
import org.alopex.scylla.net.socks.SOCKSProxy;
import org.alopex.scylla.utils.Utils;

import java.util.ArrayList;

/**
 * @author Kevin Cai on 9/17/2016.
 */
public class Bootstrapper {

	private static final String CLASS_NAME = "Bootstrapper";

	public static ArrayList<Peer> peers;
	public static String selfMutex;

	public static Config config;
	public static SOCKSProxy socksProxy;

	public static void main(String[] args) {
		// Instance var instantiation segment
		peers = new ArrayList<Peer> ();

		// Bootstrapper code here
		try {
			Utils.log(CLASS_NAME, "Initializing SOCKSProxy instance...", false);
			socksProxy = new SOCKSProxy();
			socksProxy.init();

			Utils.log(CLASS_NAME, "Bootstrapping P2P networking engine...", false);
			NetBootstrapper nb = new NetBootstrapper();
			nb.init();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
