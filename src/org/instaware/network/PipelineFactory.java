package org.instaware.network;

import org.instaware.network.ChannelHandler;
import org.instaware.network.codec.*;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;

/**
 * Configures a pipeline for the {@link Server}.
 * @see {@link ChannelPipelineFactory}
 * @author Thomas Nappo
 */
public class PipelineFactory implements ChannelPipelineFactory {

	@Override
	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline pipeline = Channels.pipeline();
		pipeline.addLast("encoder", new Encoder());
		pipeline.addLast("decoder", new LoginDecoder());
		pipeline.addLast("handler", new ChannelHandler());
		return pipeline;
	}

}