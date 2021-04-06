package annotation.annotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class Autoannotator {

	public static void main(String[] args) throws IOException {

		final File refilename = new File(
				"C:\\Users\\shilp\\IUB_DS\\fall-2019\\nlp_course\\project\\projectdata\\allrecipes\\masteringredient\\ingredients_list.txt");
		File outdirectory = new File(
				"C:\\Users\\shilp\\IUB_DS\\fall-2019\\nlp_course\\project\\projectdata\\Recipes\\final_recipe_corpus_annotated");
		File indirectory = new File(
				"C:\\Users\\shilp\\IUB_DS\\fall-2019\\nlp_course\\project\\projectdata\\Recipes\\final_recipe_corpus");

		File[] listOfFiles = indirectory.listFiles();

		// Read the reference file for all the ingredient list and tokenize

		Properties props = new Properties();
		props.setProperty("annotators", "tokenize,ssplit,pos");

		BufferedReader br = new BufferedReader(new FileReader(refilename));
		String line;
		ArrayList<String> reftokens = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
			reftokens.add(line);
		}

		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

		/*
		 * Read the recipe files as a String text and tokenize the content.After,that
		 * lookup for the ingredient matching for all the tokens and mark the tokens as
		 * B-OTH if they appear in the ingredient list else mark them as O
		 */

		for (File file : listOfFiles) {
			String content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
			CoreDocument document = new CoreDocument(content);
			pipeline.annotate(document);
			List<CoreSentence> sentences = document.sentences();
			Iterator<CoreSentence> itr = sentences.iterator();
			List<String> tokens = new ArrayList<String>();
			while (itr.hasNext()) {
				String tag = "sentence_start";
				tokens.add(tag);
				String text = itr.next().text();
				String inputtoken_1 = text.replaceAll("\\p{Punct}", "").toLowerCase();
				String[] inputtokens = inputtoken_1.replaceAll("[0-9]", "").toLowerCase().split("\\s");
				for (int i = 0; i < inputtokens.length; i++) {
					tokens.add(inputtokens[i]);
				}
				tokens.add(".");
			}
			String outfile = file.getName();
			FileOutputStream fos = new FileOutputStream(outdirectory + "\\" + outfile);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			for (int i = 0; i < tokens.size(); i++) {
				String inputtoken = tokens.get(i).trim();
				String tag = null;
				for (int j = 0; j < reftokens.size(); j++) {
					boolean isPresent = inputtoken.toLowerCase().indexOf(reftokens.get(j)) != -1 ? true : false;
					if (isPresent) {
						tag = "B-OTH";
						break;
					} else {
						tag = "O";
					}
				}

				if (!inputtoken.equals(" ") && !inputtoken.isEmpty()) {
				    bw.write(inputtoken + " " + tag);
					bw.newLine();
				}
			}

			bw.close();

		}

		br.close();
	}
}
