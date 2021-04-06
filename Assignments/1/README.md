# Assignment-1 (Probability and Information Theory in NLP)

Work thought the introduction chapter in Manning & Schuetze, read Jackendoff and Martin's Intro chapter, consult Krenn & Samuelsson (1997), get an intro to Probability Theory online or from the library, and update your knowledge of Probability Theory for this assignment. If you have questions or issues, come and see me!

We will discuss Probability Theory and Information Theory again tomorrow.

 

1. (exercise 2.3, page 59) Compute the probability of the event

"A period occurs after a three-letter word and this period indicates an abbreviation,"

assuming the following probabilities:
(1)   a.   P(is-abbreviation | three-letter-word) = 0.8
        b.   P(three-letter-word) = 0.0003

 

2. (exercise 2.4, page 59) Are X and Y as defined in the following table independently distributed?

x	0	0	1	1
y	0	1	0	1
p(X=x,Y=y)	0.32	0.08	0.48	0.12
 

3. Conditional Probability:

a. If two fair dice are rolled, what is the conditional probability that at least one lands on 1 given that the dice land on different numbers?.

b. A bin contains 25 light bulbs, 5 of which are in good condition and will function for at least 30 days, 10 of which are partially defective and will fail in their second day of use, and 10 of which are totally defective and will not light up. Given that a randomly chosen bulb initially lights what is the probability that it will still be working after one week?

 

4. Bayes Theorem:
British and American spelling are `rigour' and `rigor', respectively. A man staying at a Parisian hotel writes this word, and a letter taken at random from his spelling is found to be a vowel. If 40% of the English-speaking men at the hotel are British and 60% are Americans, what is the probability that the writer is British?

 

5. In the slides, we calculated the entropy for a fair 8-sided die. Let’s assume that this 8-sided die is not actually fair, but instead has this distribution:

1	2	3	4	5	6	7	8

1/8	1/16	1/4	1/8	1/16	1/16	1/4	1/16

What is the entropy of this distribution?

 

6. With the text below, do the following:

a. Calculate the probabilities of the letters (approximated by their relative frequencies). Ignore punctuation signs and numbers. Treat upper case and lower case letters as equal (e.g. normalize the text). You can find the text in the Canvas files section as composers.txt.

b. Come up with a random variable/bit encoding for the letters and write it down. How many digits do you need?

c. Calculate the Variance of this code, and by code I mean the distribution of the point-wise entropy. :-)

Bach was the most famous composer in the world, and so was Handel. Handel was half German, half Italian and half English. He was very large. Bach died from 1750 to the present. Beethoven wrote music even though he was deaf. He was so deaf he wrote loud music. He took long walks in the forest even when everyone was calling for him. Beethoven expired in 1827 and later died for this.

 

7. Download the SUSANNE corpus at:
http://www.grsampson.net/Resources.html (Links to an external site.)Links to an external site.
For one of the four sub-corpora (A, G, J, N), write a program in a language of your choice which calculates the entropy of part-of-speech (POS) tags in the data (H(POS)).