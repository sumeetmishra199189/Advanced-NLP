# Assignment-2 (NLP Technologies, Text Annotations, Markov Chains, and PoS-tagging)

This assignment is sort of the course in reverse: we will use NLP tools others have built, so we can get a grasp on:

1) What the linguistic distinctions are that we're trying to create this semester, and

2) how they can be useful. I strongly encourage you to work in groups of 2 to 4 (or more) for this assignment (and you need only turn in one report for the group, identifying the group, and each of you submitting the report individually). I also strongly encourage you to have fun. If you sense any form of difficulty, consult with me, your colleagues, other people. So, if you encounter any difficulties, please email me ASAP.

Tasks:

(a) Grab two novel-length English works of fiction (e.g., from http://www.gutenberg.org. where I took the House of Pomegranates from) and set one aside for development and one for testing. Report which texts you're using and to what extent they are similar to or different from each other. Make sure the text contains dialogue in some fashion.

(b) Download and install the Stanford CoreNLP suite of tools (http://stanfordnlp.github.io/CoreNLP/). You may use any of the CoreNLP tools except for the relation (RelationExtractorAnnotator) component. Make sure you  can apply the tools to your development text and report any difficulties. See for details the Usage and command line section at the CoreNLP URL above. As we demonstrate in class, you can use the CoreNLP tools via command line. There is a documentation on the website. You will need a Java Runtime installed on your system to be able to run Core NLP.

Please use the instructions at: https://stanfordnlp.github.io/CoreNLP/ to start CoreNLP. I can share a startup script for Mac and Linux that works just fine with Java 10. Let me know, if you need that.

 

Extra Coding Addition with + points towards previous assignments or the current one:

Those of you who are familiar with Python and modules, please consider looking into:

- spaCy (https://spacy.io)

- polyglot (https://polyglot.readthedocs.io/en/latest/)

- Flair (https://github.com/zalandoresearch/flair (Links to an external site.))

and try the same thing, that is run your document through the pipeline and compare the results with each other, at the PoS-level and with respect to dependencies.

 

(c) Comb over the development text, with the Stanford (and optionally the other pipelines) annotations added, in order to identify (manually, semi-automatically, and eventually fully automatically) when one character is speaking to another. Specifically, your goal is to extract relations of the form speak(X,Y), where X and Y are characters. (You are allowed to leave X and/or Y unspecified in some cases, noting that these are cases you would eventually like to make fully specific.)

Thus, you will be looking for patterns that help make this determination, probably across a range of verbs, styles of quoting, etc. How do you identify that somebody is speaking with or to somebody else given the linguistic analysis? (I expect that you'll minimally find the lemma, Name Entities Recognizer (ner), Coreferences (using the Deterministic Coreference Annotator dcoref), and the Dependency Parser deppparse components to be useful.) Report both on your process in creating patterns and your specific list of patterns.

 

(d) Run your CoreNLP processing pipeline over the test data. Report in a table the total frequencies with which, according to your system, the different characters are speaking to each other.

 

(e) As a final part of the report, add a note on what you would do if you had more time to make the system better.

 

(f) FSA

Consider the following finite-state automaton:

homework4.png

 

(f1): Encode the FSA in terms of matrices, including initial and final states. (This is the transition matrix!)

(f2): Describe the language that is accepted by the FSA as a regular expression.

 

 

(g) Markov Chains

There are three telephone lines, and at any given moment 0, 1, 2 or 3 of them can be busy. Once every minute we will observe how many of them are busy. This can be described as a (finite) Markov chain by assuming that the number of busy lines will depend only on the number of lines that were busy the last time we observed them, and not on the previous history.

Use the following matrices to answer the following questions. You can use online matrix multipliers
(e.g., http://wims.unice.fr/wims/en_tool~linear~matmult.html). Please explain your answers.

 MarkovChainMatrix_HW4.png

(g 1) What is the probability that after 4 steps exactly 3 lines are busy?

(g 2) What number of lines being busy has the highest probability after 4 steps?

 

(h) POS Tagging

Consider the transition network for the sentence time flies like an arrow and the conditional probabilities reading them from the Brown corpus using the methods that we discussed in class, see also the iPython/Jupyter tutorial (URL available) or here as HTML (http://damir.cavar.me/pynotebooks/Python_Tutorial_PoS_Tagging.html (Links to an external site.)). From these, calculate the most likely sequence.

 

(i) Read Ranaparkhi (1996):

http://aclweb.org/anthology/W/W96/W96-0213.pdf and explain, in half-a-page or so, how the tagger works, roughly speaking, and how entropy is being employed.

