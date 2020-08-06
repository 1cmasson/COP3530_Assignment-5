Check out these links for better understanding:

https://www.youtube.com/watch?v=obWXjtg0L64

https://medium.com/@anilpai/currency-arbitrage-using-bellman-ford-algorithm-8938dcea56ea


# COP3530_Assignment-5
This assignment asks you to use Bellman-Ford Algorithm to ﬁnd the most proﬁtable exchange sequence between currencies of diﬀerent countries.

1 Input File 

The input ﬁle “exchange rates.csv” which is available on Canvas contains a 54×54 table showing the exchange rates between diﬀerent currencies; e.g. the number stored at the ﬁrst row and ﬁfth column shows that one “Kuwaiti Dinar” can be exchanged by 2.802691797 “Euros” and the number stored at the ﬁfth row and ﬁrst column shows that one Euro can be exchanged by 0.349864239 Kuwaiti Dinar. Obviously, the numbers at the main diagonal of this table are all ones (one USD = one USD or one Euro = one Euro).

2 Modeling the Problem to a Single-Source Shortest Path Problem

The problem of ﬁnding the most proﬁtable exchange sequence from a source currency to all other currencies can be modeled to a shortest path problem with the following parameters:

 Graph vertices are the currencies (each currency is represented by a vertex of the graph). There are 54 vertices.

 Graph edges are the possible direct exchange operations between any two currencies. In this problem, our assumption is that any pair of currencies can be exchanged directly and therefore, the graph is complete and has 54×54 edges. 

 Weight of the edge from currency X to currency Y is equal to −log(a) where a is the exchange rate for X and Y and it means that each X can be exchanged by a Y s.

 the vertex corresponding to the source currency is considered as the source vertex.

 the shortest path between any two vertices u and v represents the most proﬁtable exchange sequence between the currencies representing u and v; e.g. if u → x → w → v is the shortest path from u to v, then the most proﬁtable exchange sequence from 1 currency U to currency V will be to convert currency U to currency X, then covert X to W, and then convert W to V .

3 Solving the Problem using Bellman-Ford Algorithm

Bellman-Ford is a very simple algorithm to implement and it solves the shortest path problem given a source in a graph with both negative and positive weights. In this assignment, you need to write a Java program that gets a currency as the source currency from keyboard and ﬁnds the rates of most-proﬁtable exchange sequence from the source currency to all other currencies and compare the rates with the direct exchange rates; e.g. if the source currency is “Japanese Yen”, your program must print out the following statements: 

Source currency is Japanese Yen

Kuwaiti Dinar: max Exchange Rate is 0.0028601845318296086, and direct rate is 0.002837866848366889 

Bahraini Dinar: max Exchange Rate is 0.003500871450140875, and direct rate is 0.003477940032170313 

Omani Rial: max Exchange Rate is 0.0035832459935054187, and direct rate is 0.0035832459935054187 

British Pound: max Exchange Rate is 0.007323709928865302, and direct rate is 0.007232077349904979 

Euro: max Exchange Rate is 0.008057563070993524, and direct rate is 0.008057563070993522 

Swiss Franc: max Exchange Rate is 0.008661075369424344, and direct rate is 0.008562397496974444 

Canadian Dollar: max Exchange Rate is 0.012482677234415887, and direct rate is 0.012456578705116609 

Bruneian Dollar: max Exchange Rate is 0.012888696304101829, and direct rate is 0.012695104124445553 

Singapore Dollar: max Exchange Rate is 0.012885544737613351, and direct rate is 0.012853790647767907 

Libyan Dinar: max Exchange Rate is 0.012961836478694833, and direct rate is 0.01280434543331424 

Australian Dollar: max Exchange Rate is 0.01302968160762, and direct rate is 0.012815302178235064 

New Zealand Dollar: max Exchange Rate is 0.013974958091842685, and direct rate is 0.013883435131220988 

Bulgarian Lev: max Exchange Rate is 0.01574041275348872, and direct rate is 0.01572180923490515 

Israeli Shekel: max Exchange Rate is 0.03184158822216103, and direct rate is 0.031289795203893876 

Qatari Riyal: max Exchange Rate is 0.03391706687040421, and direct rate is 0.03386433013876335 

Emirati Dirham: max Exchange Rate is 0.034201670836562885, and direct rate is 0.03388524377437695 

Saudi Arabian Riyal: max Exchange Rate is 0.03493717495516037, and direct rate is 0.034455453697146345 

Polish Zloty: max Exchange Rate is 0.03559779472477324, and direct rate is 0.035597794724773237 

Romanian New Leu: max Exchange Rate is 0.03892617260129454, and direct rate is 0.03879254887131162 

Malaysian Ringgit: max Exchange Rate is 0.039590625712546644, and direct rate is 0.038887558654406185 

Brazilian Real: max Exchange Rate is 0.047469812181937764, and direct rate is 0.047373677616107626 

Danish Krone: max Exchange Rate is 0.05985455204940522, and direct rate is 0.059557765670796535 

Croatian Kuna: max Exchange Rate is 0.06058000107902785, and direct rate is 0.06009023818815385 

Trinidadian Dollar: max Exchange Rate is 0.06296294633498072, and direct rate is 0.06281439146956536 

Turkish Lira: max Exchange Rate is 0.06377783833034219, and direct rate is 0.063141919571705 

Chinese Yuan Renminbi: max Exchange Rate is 0.06514738696591135, and direct rate is 0.06459306421477125 

Hong Kong Dollar: max Exchange Rate is 0.07226466596555545, and direct rate is 0.07226466596555543 

Swedish Krona: max Exchange Rate is 0.08257303885396591, and direct rate is 0.081077964607962 

Norwegian Krone: max Exchange Rate is 0.0850828760473406, and direct rate is 0.08384885459142312 

Venezuelan Bolivar: max Exchange Rate is 0.09298676267157745, and direct rate is 0.09133664768576862

Botswana Pula: max Exchange Rate is 0.10753244925929176, and direct rate is 0.10606788298589258 

South African Rand: max Exchange Rate is 0.15318844582802926, and direct rate is 0.15249110977420413 

Mexican Peso: max Exchange Rate is 0.20739086648357752, and direct rate is 0.20739086648357752 

Czech Koruna: max Exchange Rate is 0.21225910815145133, and direct rate is 0.21193267388614212 

Taiwan New Dollar: max Exchange Rate is 0.27404932325548226, and direct rate is 0.27247260731934997 

Thai Baht: max Exchange Rate is 0.29428037964513243, and direct rate is 0.291466605013617 

Mauritian Rupee: max Exchange Rate is 0.37268859183511893, and direct rate is 0.37240701821109207 

Philippine Peso: max Exchange Rate is 0.4601367137455285, and direct rate is 0.4517144629833383 

Russian Ruble: max Exchange Rate is 0.6633818496975654, and direct rate is 0.6584043863191521 

Argentine Peso: max Exchange Rate is 0.6689961844982243, and direct rate is 0.6635655872131515 

Indian Rupee: max Exchange Rate is 0.6947563370436517, and direct rate is 0.6942936467676881 

Japanese Yen: max Exchange Rate is 1.0, and direct rate is 1.0 

Nepalese Rupee: max Exchange Rate is 1.1170386579605172, and direct rate is 1.1014781993603313 

Icelandic Krona: max Exchange Rate is 1.268481458905697, and direct rate is 1.267295526570507 

Pakistani Rupee: max Exchange Rate is 1.5621489966646618, and direct rate is 1.555532629668921 

Sri Lankan Rupee: max Exchange Rate is 1.7312382452173862, and direct rate is 1.702650351609146 

Hungarian Forint: max Exchange Rate is 2.7988768979325687, and direct rate is 2.7740990154141882 

Kazakhstani Tenge: max Exchange Rate is 3.8451278773382795, and direct rate is 3.8277633696001314 

Chilean Peso: max Exchange Rate is 7.1647025130833715, and direct rate is 7.1361898629042715 

South Korean Won: max Exchange Rate is 11.146722600042272, and direct rate is 11.115008875431304 

Colombian Peso: max Exchange Rate is 33.798166907008024, and direct rate is 33.398111183349265 

Indonesian Rupiah: max Exchange Rate is 136.4389619987805, and direct rate is 134.75622208127137 

Iranian Rial: max Exchange Rate is 1896.0966554685174, and direct rate is 1878.2112446117392 

USD: max Exchange Rate is 0.009304993120579785, and direct rate is 0.009189606664574732

