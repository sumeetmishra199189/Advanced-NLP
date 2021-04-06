# Assignment-5 (Entities, Relations, Semantics, and Graphs) 

Use spaCy, Flair, textblob, or CoreNLP for the following tasks.

If you want to install spaCy and the English models, use the following commands:

pip install -U spacy
python -m spacy download en
You might need to use pip3 and python3, if your computer has multiple versions of Python installed. The same is true for the other modules or packages.


See for hints and ideas the spaCy notebook at:
https://github.com/dcavar/python-tutorial-for-ipython/blob/master/notebooks/spaCy%20Tutorial.ipynb


Task 1:

Use for example spaCy to segment the text in file ex1.txt into a list of sentences. Identify the sentence in the text that is most similar to:

My poodle likes food in general.
Submit fully functional code that reads the text from the file, segments the text into sentences, and computes the similarity score between each sentence and the seed sentence above. You can use spaCy for the sentence segmentation task and there are tutorials online that describe that.


Task 2:

In the following two sentences:

1. John loves apples
2. some man likes fruit
a. Write Python code to identify the most similar words in the two sentences using any of your selected Python NLP modules and a loop over the tokens.

b. For the most similar words that you identified in a., write Python code that computes the distance between them.

c. Sum up and average over the distances to print out the Word Mover's Distance between the two lines.


Task 3:

Select a target text with more than 500 words. Segment the text into sentences. Parse each sentence using a Dependency Parser (only in spaCy or CoreNLP, maybe in textblob). Use the Dependency Parser output and map out all occurrences of:

Subject - Verb - Object
For example, if we parse the sentence:

The director of the movie Down by Law wrote a new screen play.
We want to identify:

Subject: director
Verb: write
Object: screen play
Write down the steps that are necessary to extract this information from the NLP-pipeline output. Write the Python code that generates these triples from the text you selected. Generate all triples and submit the example text, the Python code, and the result file.

