# Project Title

Sapling

This android application is to provide a tool for gardeners to keep track of their plants.
The main goal is to reduce the chance of over/under-watering plants via an automated water scheduling system. The app will also act as an offline database that helps users identify diseases and pests that may accumulate while gardening.

## Getting Started

This program requires a Android Studio program to install & build.
Android Virtual Machine, Smart Phone or Tablet PC is requried to run this program.


### Prerequisites

This program requires a Android Studio program to install & build.


### Installing

Since this application is currently being developed (has not deployed yet), it requires AVD or developer mode in mobile & tablet.

## Structure Description
This project is mainly composed of three fragments, which are 'myGarden', 'plantLibrary', 'recommendation' and several activities supporting each fragment's functionality.
These three modules are located under 'ui' directory in the package 'com.icarus.sapling'.
Moreover, there are modules for handling JSON file.

===myGarden Fragment===

This fragment is for displaying the stored plant list and showing the watering schedule.
Whenever the user lands to this page, the Arraylist 'gardenPlants' keep being renewing its data.
The Arraylist 'gardenPlants' has plant objects as its elements. One of attribute of each plant object is boolean method 'isInGarden'. By using this, the 'gardenPlants' is able to keep the changed plant list.

**The scheduler functions will be added in the future work.


===plantLibrary===

This fragment is using the method 'loadList' method from MainActivity.java for displaying a listview items of whole plant information we have.


===PlantCareFragment===

This fragment works as a detail page of each plant. This is called when the user clicks the item in the listview of plantLibrary. There is a button 'garden_button' in this fragment which allows user to add and remove the plants to the arraylist which will be passed to the MyGarden fragment.


===JSONReader===
For handling the JSON file, we have JSONReader.java. This java file reads a JSON file from the assets directory and parse the data in it into the JSON object and put them into the arraylist.


===RecommendationFragment===

This fragment has 3 radio groups in its xml form. Each button in each radio group has an id which will be accessed by RecommendationFragment.java when the submission button is clicked. 
Each radio button represents the conditions that user wants to be recommended. Once the button is clicked, the data of each radio group will work as a filter to narrow the plant list following the condition and send them to  the Arraylist 'recommendedPlants'. For example, if  the user clicks 'Tree' as a plant type in recommendation page, the Arraylist 'recommendedPlants' has only tree plants.

In the onClickListener of the submission button, it calls another activity called 
SubActivity.java'. In SubAcitivity, it converts the intent of arraylist into the listview.



### Testing

* MyGarden page: Added date and time functionality from the web. Tested by printing date and time information as a TextView that will be updated each time the fragment is instantiated. Created a list view of each plant object that is currently being scheduled. Tested by adding and removing various plant objects to the myGarden fragment and ensure that they are displayed correctly. 
* Plant Library page: To test the library page, we added and removed plants from the database to ensure that the parser works and is displayed correctly in the library page. Tested for missing plants or duplicate plants. Also tested if other pages affect the list view when reinstantiating the library fragment.
* Recommend-A-Plant page: Created list view of questions on page, tested radio button selection state changes. Tested view results button and ensured results displayed appropriately. Tested with no plants left to recommend, default values, and max values to assure proper performance.
* Plant List: Created plant.java file which uses information from the parser and stores them in their associated plant objects. Tested by printing data from the accessor and mutator methods that correspond to plant care information.


## Authors

* Team Icarus


