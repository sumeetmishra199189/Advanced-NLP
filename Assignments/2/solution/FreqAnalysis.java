import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class FreqAnalysis {

	public static String corpus1_josn_path = "C:\\Users\\shilp\\anlp\\assignmnet2\\corpusfiles\\";

	
	/* This program is to identify how many times tow people are talking to each other by scanning the output of 
	 * core nlp files in the form of json.*/
	public static void main(String[] args) throws IOException {

		File folder = new File(corpus1_josn_path); 
		File[] listOfFiles = folder.listFiles();
		// Map to hold the speaker pair as key and how many times they spoke to each other as value.
		Map<String, Integer> speakerfreqmap = new HashMap<String, Integer>();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				// Read the corpus file as a JSONObject
				String filecontent = FileUtils.readFileToString(file, "utf-8");
				JSONObject json = new JSONObject(filecontent);
				JSONArray sentences = json.getJSONArray("sentences");
				// Loop through the sentences and get the tokens for the sentences
				for (int i = 0; i < sentences.length(); i++) {
					JSONArray tokens = (JSONArray) sentences.getJSONObject(i).get("tokens");
					// Loop through the tokens for each sentence and get the speakers for this sentence in a sorted set
					SortedSet<String> speakers = new TreeSet<String>();
					for (int j = 0; j < tokens.length(); j++) {
						if (tokens.getJSONObject(j).has("speaker")) {
							String speaker = (String) tokens.getJSONObject(j).get("speaker");
							speakers.add(speaker);
						}
					}

					// Create the hashkey by concatenating the sorted names of speakers after scanning each sentence.

					Iterator<String> speakeritr = speakers.iterator();
					StringBuilder builder = new StringBuilder();
					while (speakeritr.hasNext()) {
						String speaker_ = speakeritr.next();
						builder.append(speaker_);
						if (speakeritr.hasNext()) {
							builder.append(",");
						}

					}

					String nameskey = builder.toString();
					
					// if the key already has this pair as th ekey, increase the frequency count else insert a new frequency count.

					if (speakerfreqmap.containsKey(nameskey)) {
						Integer count = speakerfreqmap.get(nameskey);
						count = count + 1;
						speakerfreqmap.put(nameskey, count);
					} else {
						speakerfreqmap.put(nameskey, 1);
					}

				}

			}
		}

		System.out.println("map size " + speakerfreqmap.size());

		for (Map.Entry<String, Integer> entry : speakerfreqmap.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

	}
}
