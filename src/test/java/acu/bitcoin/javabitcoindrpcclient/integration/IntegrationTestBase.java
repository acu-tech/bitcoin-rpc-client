package acu.bitcoin.javabitcoindrpcclient.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import acu.bitcoin.javabitcoindrpcclient.util.Chain;
import acu.bitcoin.javabitcoindrpcclient.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;

import acu.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;
import acu.bitcoin.javabitcoindrpcclient.BitcoindRpcClient;

/**
 * Common framework for integration tests
 *
 * In order to run these tests, make sure to first have the bitcoin core client running in regtest mode
 *
 * These tests use the same RPC config, as the normal {@link BitcoinJSONRPCClient}
 */
public class IntegrationTestBase
{
	static final Logger LOGGER = Logger.getLogger(IntegrationTestBase.class.getName());

    static BitcoindRpcClient client;

    @BeforeClass
    public static void setup() throws Exception
    {
    	// Set logger format used in the tests
    	System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");

    	client = new BitcoinJSONRPCClient();

    	Util.ensureRunningOnChain(Chain.REGTEST, client);
    }

    protected void assertStringNotNullNorEmpty(String s)
    {
    	assertFalse(StringUtils.isEmpty(s));
    }

    protected void assertStringNullOrEmpty(String s)
    {
    	assertTrue(StringUtils.isEmpty(s));
    }
}
