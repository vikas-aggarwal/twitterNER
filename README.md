# twitterNER

This project recognizes named entity on twitter data. We are using Alan Ritters training and test set to train and test the CRF model.

How to run
---
* Clone the repository.
* Install __crfsuite__, following instructions on http://www.chokkan.org/software/crfsuite/
* Download __article-categories_en.nt__ and __redirects_en.nt__ from DBpedia
* Use the java code in creatingDatabaseFromDBpedia folder to create an sqlite database (Requires Apache Jena)
* Using the instructions on the following page https://github.com/dbpedia/lookup set up an offline lookup service
* Edit featurizer.py to point to correct database and lookup service.
* Run  	baseline - Cygwin.sh for Windows (On Cygwin)  or baseline.sh (Linux)
* See the results folder for output

```
These are the current results

processed 11570 tokens with 356 phrases; found: 298 phrases; correct: 163.
accuracy:  96.28%; precision:  54.70%; recall:  45.79%; FB1:  49.85
          company: precision:  62.86%; recall:  53.66%; FB1:  57.89  35
         facility: precision:  54.55%; recall:  30.00%; FB1:  38.71  11
          geo-loc: precision:  61.40%; recall:  60.34%; FB1:  60.87  57
            movie: precision:  33.33%; recall:  66.67%; FB1:  44.44  6
      musicartist: precision:  57.14%; recall:  33.33%; FB1:  42.11  7
            other: precision:  26.09%; recall:  19.67%; FB1:  22.43  46
           person: precision:  64.86%; recall:  61.54%; FB1:  63.16  111
          product: precision:  41.67%; recall:  27.78%; FB1:  33.33  12
       sportsteam: precision:  36.36%; recall:  22.22%; FB1:  27.59  11
           tvshow: precision:  50.00%; recall:  12.50%; FB1:  20.00  2
```

Links:
https://youtu.be/rhruRfZIhlQ
http://vikas-aggarwal.github.io/twitterNER/
http://www.slideshare.net/VikasAggarwal35/twitterner-named-entity-recognition-in-twitter
https://www.dropbox.com/sh/1c2i208glkqkcft/AAAuGQW2GDoWbmMJgpPkaU0za?dl=0
