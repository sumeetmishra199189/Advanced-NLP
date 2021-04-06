# Assignment-4 (Probabilistic Parsing)

## NLTK Parsing

Using the NLTK and Python, based on the textbook chapter on PCFGs in Jurafsky & Martin, use for example the following tutorial and section from the NLTK book:

http://www.nltk.org/book/ch08-extras.html (Links to an external site.)

and have a look at the Jupyter Notebooks that we discussed in class, see:

https://github.com/dcavar/python-tutorial-for-ipython/blob/master/notebooks/PCFG%20Parsing%20with%20NLTK.ipynb

If you can find a treebank for any other language than English that has the same format and annotation standard as the Penn Treebank, use it. If you can extend the 5% of the Penn Treebank sample in NLTK, do it.

1. Document your effort to find similar resources to the Penn Treebank for other languages. What other such Treebanks did you find, where, and what licensing do they use, for what kind of languages?

 

2. Develop a probabilistic grammar for the language of your choice, for example an extension of this kind of grammar for any language of your choice:

  NP  -> NNS [0.5] | JJ NNS [0.3] | NP CC NP [0.2]

  NNS -> "cats" [0.1] | "dogs" [0.2] | "mice" [0.3] | NNS CC NNS [0.4]

  JJ  -> "big" [0.4] | "small" [0.6]

  CC  -> "and" [0.9] | "or" [0.1]

You can use the discussed and common tools to extract PCFGs from treebanks. You can also select a language for which you could not find any resources at all and engineer and hand-write the rules and estimate the probabilities. Note, this is for a language other than English, Chinese, Arabic, etc. for which treebank corpora exist! If you use for example the English treebank, or some other, you might reuse the grammar rules for your language, maybe tweak the rules and just replace the lexicon.

 

3. Build a test-corpus of 50 sentences with different structures, including sentential/clausal embedding (which has nothing to do with word embeddings or word2vec), complex noun phrases, interrogative sentences (questions asking for the subject or object, yes-no questions).

 

4. Use the ViterbiParser in NLTK with this grammar of yours and make sure that your rules and parse the test corpus by adapting them to do so, and provide the probabilities for the output trees from the parser. See the textbook chapters and the resources mentioned above.

 

5. Submit your grammar, the Python-test-code using the ViterbiParser in NLTK, the test corpus, and the output results. Document your training corpus, where you extracted the rules from, or if you engineered your own grammar and model, how you did it, which resource you used, etc. Explain your project in form of a text that you submit as well.

 