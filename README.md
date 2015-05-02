# Projet-Traitement-Images
Image processing software. Pattern Factory and Interfaces. (Java Programming)

----------------------------------------------------------------------------------------

Installing the software
----------------------

1. Download this project as a ZIP.
2. Put this project in your workspace and import it in your IDE (Eclipse, recommended).

Instructions
------------

1. To run the application, you have to run `Client/Executable` as a Java application. Several arguments are requested.
2. Arguments: 
    - They must be separated from each other by a space.
    - In this order: absolute path of original picture ; format of the original picture : absolute path where to create the filtered picture ; format of the filtered picture ; filters (as numbers), as many as you want.
    For instance, 
    C://Users/picture.jpg JPEG C://Users/filtered.png PNG 2 6 5 14 
    will filter the image "picture.jpg" into "filtered.png" using filters 2, 6, 5 and 14 (in this order).

Available filters
-----------------
Please have a look in the `FiltresDisponibles` enum class. Each filter is referenced by a number.

Available formats
-----------------
Please have a look in the `FormatsDisponibles` enum class. To get further information about the ESI format, you can read the PDF file *sujet.pdf*.
