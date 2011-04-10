package org.instaware.network;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.instaware.network.codec.PipelineFactory;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

/**
 * Arch networking unit.
 * @author Thomas Nappo
 */
public class Server {
	
	/**
	 * Bound port of the server.
	 */
	private int port;
	
	/**
	 * Retrieves the port this server is bound to.
	 * @return The port this server is bound to.
	 */
	public int getPort() {
		return port;
	}
	
	/**
	 * Constructs and binds a server.
	 * @param port The binding port of the server.
	 * @return The completed server.
	 */
	public Server bind(int port) {
		this.port = port;
		
		bootstrap = new ServerBootstrap(
				new NioServerSocketChannelFactory(
						Executors.newCachedThreadPool(),
						Executors.newCachedThreadPool()));

		bootstrap.setOption("keepAlive", true);
		bootstrap.setOption("reuseAddress", true);
		bootstrap.setOption("child.tcpNoDelay", true);

		bootstrap.setPipelineFactory(new PipelineFactory());

		// We have this channel instance for further operations (such as terminating service).
		channel = bootstrap.bind(new InetSocketAddress(port));
		
		return this;
	}
	
	/**
	 * Used for I/O operations such as read, write, connect, and bind
	 * between a player's client and this servlet.
	 */
	protected Channel channel;
	
	/**
	 * Creates a new server-side <code>Channel</code> and accepts incoming connections. 
	 */
	private ServerBootstrap bootstrap;

}