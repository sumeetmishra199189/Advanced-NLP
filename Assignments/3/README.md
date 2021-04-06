# Assignment-3 (Hidden Markov Model & Forward/Backward Algorithm)

1. Hidden Markov Models

One application of HMMs is cryptoanalysis. Imagine a simple substitution code, in which
every character of the English alphabet is substituted by another character, thus Banana
could be translated into Ucpcpc. In order to decode the encrypted word, a bigram model
could be used.

a.) Assuming you do not know the code beforehand -- i.e., your task is to decrypt a message -- describe what the HMM would look like, in order to decode such words. How many and which states will the HMM have, and what do the emissions look like?

b.) Make a suggestion for how the emission probabilities should be distributed for a well-trained HMM.

c.) Would it make sense to convert the HMM to a trigram model instead of a bigram model? What are the advantages, what are the disadvantages?

 

2. Forward/Backward Algorithm

Consider the example of the HMM for POS tagging the sentence a myth is a female moth. Calculate the following forward accumulators given the following probabilities:

initial vector:  [ 0.45  0.35  0.15  0.05 ]

transition matrix:

t / t+1	DT	JJ	NN	VB
DT	0.03	0.42	0.50	0.05
JJ	0.01	0.25	0.65	0.09
NN	0.07	0.03	0.15	0.75
VB	0.30	0.25	0.15	0.30
emission matrix:

w / s	DT	JJ	NN	VB
a	0.84	0.05	0.03	0.05
myth	0.01	0.10	0.45	0.10
is	0.02	0.02	0.02	0.60
female	0.01	0.70	0.25	0.05
moth	0.12	0.13	0.25	0.20
Compute the forward (α) and backward (β) probability for the given time steps and states:

a. α4(NN)

b. α3(VB)

c. α1(DT)

d. β4(NN)

e. β2(NN)

