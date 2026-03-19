package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpellCheckerTest {

	//1. A spellchecker should be able to tell us how many words it currently knows about
	@Test
	void test() {
		//1. Create object to be tested
		SpellChecker checker = new SpellChecker();

		//2. Create method to test - Get the number of words the spellchecker knows
		int num_words = checker.getNumberofWords();

		//3. Use assertions to validate
		assertEquals(0, num_words);
	}

	//2. The number of words a spellchecker knows about should go up by one whenever a new word is added
	@Test
	void test() {
		//1. Create object to be tested
		SpellChecker checker = new SpellChecker();

		//2. Create method to test - add word "testing" to spellchecker and then see how many words the spellchecker knows
		String word = "testing";
		checker = checker.addWords(word);
		int num_words = checker.getNumberofWords();

		//3. Use assertions to validate
		assertEquals(1, num_words);
	}

	//3. If a word is added that is already contained in the spellchecker, then the number of words contained in the spellchecker should not change
	@Test
	void test() {
		//1. Create object to be tested
		SpellChecker checker = new SpellChecker();

		//2. Create method to test - add testing to the spellchecker twice, and the total words should be 1
		String word = "testing";
		checker = checker.addWords(word);
		checker = checker.addWords(word);
		int num_words = checker.getNumberofWords();

		//3. Use assertions to validate
		assertEquals(1, num_words);
	}

	//4. A spellchecker should be able to accept a properly spelled word and return an indication that it is properly spelled
	@Test
	void test() {
		//1. Create object to be tested
		SpellChecker checker = new SpellChecker();

		//2. Create method to test - add testing to spellchecker and then test one correctly spelled word
		String word = "testing";
		checker = checker.addWords(word);
		Boolean spellingCheckTrue = checker.spellingCheck(word);

		//3. Use assertions to validate
		assertEquals(true, spellingCheckTrue);
	}

	//5. A spellchecker should be able to accept an improperly spelled word and return an indication that it is improperly spelled
	@Test
	void test() {
		//1. Create object to be tested
		SpellChecker checker = new SpellChecker();

		//2. Create method to test - add testing to spellchecker and then test one incorrectly spelled word
		String word = "testing";
		String wrongWord = "testng";
		checker = checker.addWords(word);
		Boolean spellingCheckFalse = checker.spellingCheck(wrongWord);

		//3. Use assertions to validate
		assertEquals(false, spellingCheckFalse);
	}

	//6. A spellchecker should ignore case when checking how words are spelled
	@Test
	void test() {
		//1. Create object to be tested
		SpellChecker checker = new SpellChecker();

		//2. Create method to test - add testing to spellchecker and then test two words with capitals in them
		String word = "testing";
		String capitalizedWord1 = "tEstIng";
		String capitalizedWord2 = "TeStInG";
		checker = checker.addWords(word);
		Boolean spellingCheckTrue1 = checker.spellingCheck(capitalizedWord1);
		Boolean spellingCheckTrue2 = checker.spellingCheck(capitalizedWord2);

		//3. Use assertions to validate
		assertEquals(false, spellingCheckTrue1);
		assertEquals(false, spellingCheckTrue2);
	}

	//7. A spellchecker should be able to recommend a properly spelled word for any String that it is given
	@Test
	void test() {
		//1. Create object to be tested
		SpellChecker checker = new SpellChecker();

		//2. Create method to test - add testing to spellchecker and then test two incorrectly spelled words that are close to testing
		String word = "testing";
		String wrongWord1 = "trsting";
		String wrongWord2 = "testng";
		checker = checker.addWords(word);
		String suggestedWord1 = checker.suggestWord(wrongWord1);
		String suggestedWord2 = checker.suggestWord(wrongWord2);

		//3. Use assertions to validate
		assertEquals(word, suggestedWord1);
		assertEquals(word, suggestedWord2);
	}

	//8. If we ask the spellchecker to suggest a properly spelled word for a String that is already properly spelled, it should simply return the original word.
	@Test
	void test() {
		//1. Create object to be tested
		SpellChecker checker = new SpellChecker();

		//2. Create method to test - add testing to spellchecker and then test to see if testing is returned
		String word = "testing";
		checker = checker.addWords(word);
		String suggestedWord = checker.suggestWord(word);

		//3. Use assertions to validate
		assertEquals(word, suggestedWord);
	}

	//9. If we ask the spellchecker if there is a suggested word, it will return true or false is there is a word close enough to it
	@Test
	void test() {
		//1. Create object to be tested
		SpellChecker checker = new SpellChecker();

		//2. Create method to test - add testing to spellchecker and then test if there is a suggestion for one close word and one not close word
		String word = "testing";
		String wrongWord1 = "trsting";
		String wrongWord2 = "pink";
		checker = checker.addWords(word);
		Boolean isWord1 = checker.isSuggestion(wrongWord1);
		Boolean isWord2 = checker.isSuggestion(wrongWord2);

		//3. Use assertions to validate
		assertEquals(true, isWord1);
		assertEquals(false, isWord2);
	}

	//10. If we ask the spellchecker to spellcheck a word that is input with a capital letter (proper noun) then it will only return correctly spelled if it is checked with the capital letter
	@Test
	void test() {
		//1. Create object to be tested
		SpellChecker checker = new SpellChecker();

		//2. Create method to test - add Testing to spellchecker and then test spellcheck one correctly capitalized word and two incorrectly capitalized word
		String word = "Testing";
		String incorrectdWord1 = "tEstIng";
		String incorrectdWord2 = "TeStInG";
		String incorrectdWord3 = "testing";
		checker = checker.addWords(word);
		Boolean spellingCheckTrue = checker.spellingCheck(word);
		Boolean spellingCheckFalse1 = checker.spellingCheck(incorrectdWord1);
		Boolean spellingCheckFalse2 = checker.spellingCheck(incorrectdWord2);
		Boolean spellingCheckFalse3 = checker.spellingCheck(incorrectdWord3);

		//3. Use assertions to validate
		assertEquals(true, spellingCheckTrue);
		assertEquals(false, spellingCheckFalse1);
		assertEquals(false, spellingCheckFalse2);
		assertEquals(false, spellingCheckFalse3);
	}
}
