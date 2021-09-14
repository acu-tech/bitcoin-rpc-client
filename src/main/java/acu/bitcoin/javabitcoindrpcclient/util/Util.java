package acu.bitcoin.javabitcoindrpcclient.util;

import acu.bitcoin.javabitcoindrpcclient.BitcoindRpcClient;
import acu.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.BlockChainInfo;

public class Util
{
	public static void ensureRunningOnChain(Chain chain, BitcoindRpcClient client) throws Exception
	{
		BlockChainInfo blockChainInfo = client.getBlockChainInfo();

		String expectedChain = chain.toString().toLowerCase();
		String actualChain = blockChainInfo.chain();

    	if (!actualChain.equals(expectedChain))
    		throw new Exception("Expected to run on the " + expectedChain + " blockchain, "
    				+ "but client is configured to use: " + actualChain);
	}
}
