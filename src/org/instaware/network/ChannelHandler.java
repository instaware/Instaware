package org.instaware.network;

import java.util.logging.Logger;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * Handles incoming network data towards the server.
 * @see {@link SimpleChannelHandler}
 * @author Thomas Nappo
 */
public class ChannelHandler extends SimpleChannelHandler {

	/**
	 * Our logging instance used to display
	 * information about channel data.
	 */
	private final Logger logger = Logger.getLogger(ChannelHandler.class.getName());
	
	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
		logger.info("Channel connected from: " + ctx.getChannel().getRemoteAddress());
	}
	
	@Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    	logger.info("Channel disconnected: " + ctx.getChannel().getRemoteAddress());
    }
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
		e.getCause().printStackTrace();
	}
	
}