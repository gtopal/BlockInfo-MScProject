# BlockInfo/MScProject

This repository contains code for the project submitted in partial fulfillment of the requirements for the Masters of Digital Currency degree at the University of Nicosia, School of Business, Nicosia, Cyprus.

For the program you can find additional information [here](https://digitalcurrency.unic.ac.cy/).


## Implementing electronic lotteries by using hash values of Bitcoin blocks as source of entropy

This project aims to implement a decentralized application for conducting **electronic draws and lotteries**. My approach is to build a service which can ensure decentralization, security, transparency and verifiability. For this purpose my application is using the hash values of Bitcoin blocks as source of randomness in order to capture the high needed entropy Moreover, the application is taking advantage of the OP_RETURN transaction for storing successfully the results of the draw-lottery to the blockchain. 

The application builded in Java programming language and the  steps towards building the application as well as the experimental tests implemented for securing the functionality of the algorithm will be available in the near future after the presentation of my project.


## Important links

* Information Entropy [here](https://en.wikipedia.org/wiki/Entropy_(information_theory))
* Hash Functions [here](https://en.wikipedia.org/wiki/Hash_function)
* Bitcoin Blocks [here](https://en.bitcoin.it/wiki/Block)
* BitcoinJ Library [here](https://bitcoinj.github.io/)


## Open Issues / Important Notices

Despite the fact that the draw algorithm works, there was a problem with storing the data included in the OP_RETURN transaction to the Bitcoin's blockchain. For this reason the reader is more than welcome to fork the repository and contribute for solving this issue.

The Contest_Results.txt file in the repository is stored locally and contains the results of the last running draw. This file in order to contain the results of the last running draw must be deleted every time the organizer of the contest is running a draw, because the application can not update automatically the last results.


## Installation

Clone the Github repository and contribute.
```
$ git clone https://github.com/TopFlankerKiller/BlockInfo-MScProject.git
```
 
