package com.hohmangaming.starcraftmod;

public class CommonProxy {
    // Client stuff
    public void registerRenderers() {
            // Nothing here as the server doesn't render graphics!
    }
    
	public int getBlockRenderID(int blockID)
	{
		return -1;
	}

}

