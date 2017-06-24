# SortersAnalyzer
Desktop application. It was used apache POI, reflection.

Sorters. 
Sorts are implemented to sort arrays of integers of arbitrary length in the following ways:
1) bubble sorting (pairwise);
1.1) the review is carried out from the beginning to the end (the element "pops up");
1.2) the review is carried out from the end to the beginning (the element "drowns", not sorting in descending order);
2) exchange sorting;
3) sorting with merge;
4) recursive sort using the half-division method;
5) using Arrays.sort (int [] a).

Fillers. 
The generation of arrays of integers of a given length is implemented in the following ways:
1) Already sorted array
(1, 2, 3, 7, ....., max);
2) Sorted array, at the end of which a random element is added
(1, 2, 3, 7, ....., max, X);
3) An array sorted in reverse order
(Max, ..., 7, 3, 2, 1);
4) An array containing elements that are randomly located.

Analyzer. 
Automatically generates statistics on the time of the various sorts. To do this, he independently finds all sorts of types, all types of filled arrays, using reflexion and annotations.

Excel. 
The obtained statistics are recorded in an XLS / XLSX file with the help of apache POI. In the document 4 tabs in each of which the table is written (each sort has its own line, the columns correspond to the number of elements of the array). And the table will store the sorting time. These tables are plotted.
