import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerJUnit {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("THIS TEST SHOULD SUCCEED"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("HSFFUJOHT!QFPQMF", CryptoManager.caesarEncryption("GREETINGS PEOPLE", 1));
		assertEquals("DSSOHV#DUH#UHG", CryptoManager.caesarEncryption("APPLES ARE RED", 3));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("GREETINGS PEOPLE", CryptoManager.caesarDecryption("HSFFUJOHT!QFPQMF", 1));
		assertEquals("APPLES ARE RED", CryptoManager.caesarDecryption("DSSOHV#DUH#UHG", 3));
	}
	
	
	@Test
	public void testEncryptBellaso() {
		assertEquals("#WT\"PSZ?UZN2/UJ^OJ!", CryptoManager.bellasoEncryption("TESTING THIS CIPHER", "ORANGES_ARE_ORANGE"));
		assertEquals("]%XN- )W$XH", CryptoManager.bellasoEncryption("I WANT FOOD", "TEAM_LIQUID"));
	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("TESTING THIS CIPHER", CryptoManager.bellasoDecryption("#WT\\\"PSZ?UZN2/UJ^OJ!", "ORANGES_ARE_ORANGE"));
	}
	
}
