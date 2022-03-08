 ___________________________________________________
* GMIT - Dept. Computer Science & Applied Physics   *
*                                                   *
*           Word Cloud Generator V0.1               *
*     H.Dip in Science (Software Development)       *
*               Hazel O'Driscoll   		    *
*             Student ID: G00398263		    *
*___________________________________________________*



[Running of the Application:]

-This application takes in a file or Url from the user and converts that file to a image of the most popular words in various fonts and sizes.
 The size of the words relates to their frequency, with the biggest word on the image being the most frequently occured word in the text. 
 The printing of the words is seperated depending on size of the word cloud, which is laid out below. 

-The amount of words on the wordcloud is decided by the user and is not capped.
 However any words after 40 will have the same style and size, therefore image is optimised at 40 or less words.  

-The application is started within the Runner class, which initializes the Menu class. 
 The Menu class lists the options available to the user and processes the next step based on that choice.

-Upon opening the application; user has a choice to generate a word cloud, open word cloud or terminate application. 

-For generating the word cloud, an instance of Parser class is created which in turn accesses the CloudRender class.
 The Parser class allows the user to choose between a text file or a Url.
 The filename must be the full filepath or within the current directory.
 It parses these texts to retrieve the words for the word cloud, sorting them from highest to lowest frequency set out in ComparatorByValue(). 
 The user then specifies the max amount of words they want to use for the word cloud image, which saves the final words as an array of user specified range. 

-The CloudRender class generates the word cloud using the array and saves the image under a user specified name.
 The user can create the word cloud as many times as they like, due to some placement of words being randomised it will vary each time. 
 The first and most frequent word will print in the upper middle of the image.
 The next 8 most frequent words print to the left hand side of the image, in descending order.
 The remaining words (if word count is under 30) are placed in the middle underneath the first words, with a random x axis value.
 If word count is under 40, words 25-40 are placed on the right hand side of the image with randomised x and y axis values.
 If the word count is 40+, the placement is the same as above except all words above 40 will have the same Fonts type and are randomly placed throughout image.
 The values for int x and int y have been chosen based on trial and error of word placement and chosen based on which was the preferred output.

-The class ShowImage allows the user to view the image they have created while still using the application, by opening a new window using JFrame.
 The user must enter the same name of the image as the one they saved in Generate Word Cloud[1]. This is to ensure image is in the same directory.
 The application remains running so upon viewing the randomly generated wordcloud, the user can decide to generate another or exit application.

-The fonts and colours for the words are stored in the Fonts enumeration.
 The colours for the console and outputting error messages are stored in the ConsoleColor enumeration.

[JavaDoc and UML]

-The JavaDoc and UML for the application show the public parts of the application only. Comments for private methods are within application. 

[Extras]

-Converted the fonts to an enumeration and access them in using for loops. 

-Added console colours, used in outputting messages to user. 

-Added ShowImage class as an extra option for users to view a preview the image they created.
 User can then decide if they'd like to go back and generate another randomised wordcloud or can exit application if happy with output. 

-Added a comparator ComparatorByValue to sort the words from highest to lowest frequency.

-Added exception handling for menus and user inputs so that when incorrect input from user occurs; the application prints corresponding error message and keeps running. 

-Added option to go back to main menu from Parser Menu for ease of access. 

-Set values within CloudRender class to avoid collisions for a number of the most frequent words.

-Used if statements and for loops for the placing of words to avoid any array index out of bounds exception.


[References:]

-https://www.geeksforgeeks.org/reading-text-file-into-java-hashmap/
 rohitkrsahu3, Reading Text File into Java HashMap, DEC 28 2020

-https://beginnersbook.com/category/java-collections/
 Chaitanya Singh, 2015


-Code snippet for ShowImage taken and altered from:
 https://www.dummies.com/article/technology/programming-web-design/java/how-to-write-java-code-to-show-an-image-on-the-screen-150767
 Barry Burd, How to Write Java Code to Show an Image on the Screen, MARCH 26 2016

-Resources from Moodle
 