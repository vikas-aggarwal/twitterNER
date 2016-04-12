# twitterNER

This project recognizes named entity on twitter data. We are using Alan Ritters training and test set to train and test the CRF model.

How to run
---
* Clone the repository
* Install crfsuite, following instructions on http://www.chokkan.org/software/crfsuite/
* Download article-categories_en.nt and redirects_en.nt from DBpedia
* Use the java code in creatingDatabaseFromDBpedia to create an sqlite database (Requires Apache Jena)
* Using the instructions on the following page https://github.com/dbpedia/lookup set up an offline lookup service
* Run  	baseline - Cygwin.sh for Windows (On Cygwin)  or baseline.sh (Linux)
* See the results folder for output
