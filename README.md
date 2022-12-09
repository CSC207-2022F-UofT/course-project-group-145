
**A combined demo for chat and feed features can be found on the branch https://github.com/CSC207-2022F-UofT/course-project-group-145/tree/Connecting-Features **

# CodeR Social Network App
In this project we created an app that helps CS students find group members by reviewing and swiping on each other's code snippets. The program allows a user to create a profile, upload code snippets, create and view feeds to look at other people's code snippets, and to chat with other users. 

## Setup instructions 
Firstly, ensure that the Java Development Kit and a Java Capable IDE is installed in your machine. Also, ensure that Gradle is installed/built into your IDE.
Clone the repository from GitHub onto your machine, and run the main. The user will be prompted to login. 

## How to run the program 
Run main.java. Main will also build some fake data into persistence so you may login with username bob and password joe to see how our program works and see some of our implemented features such as our chat list and chat system. 

## The login screen and register screen
Upon opening the program you will be greeted with the login screen. From the login screen you have the option to either input your username and password in order to login to the app, or the option to register a new account if you don't have one. Clicking the register button will bring up 3 boxes to enter in a new username, password, and your email address. Upon either successfully logging in or registering for the app, you will be shown the homepage. 

## The homepage
The homepage is where you can logout which brings you back to the login screen and to go to our chat list and other features that will be connected. It is a UI with buttons that will bring you to what you click on.

## The chat list
The chat list can be pulled up from the homepage by clicking the Chat List button. It displays the user's (non-deleted) 
chats by user id. Once the chat list page has opened, you can open a chat with a user (open button), delete a chat that 
you have with a user (delete button) or go back to the homepage (back button).

## The chat
The chat is accessed from the chat list if the chat was already previously created, or newly created by after liking a code snippet in the feed. This is where you communicate with other users. In the chat, you may send messages by typing in the message box and pressing send, edit messages by typing in the message box and clicking edit on the message you wish to edit, deleting messages by clicking delete beside whichever message you wish to delete, or replying to the other user's message by typing in the message box and clicking reply to the message you wish to reply to.

## The Feed List View and Feed Creation
The user is shown a list of feeds that they have, and are given the option to generate a new feed. The user can enter keywords in a textbox to set keywords to search for within the snippets inside the feed. The user can also set the length of the feed. Within the list of feeds, users can click on any feed and be taken to a screen to allow them to more closely see each feed (discussed on the next paragraph). A demo of the create feed function can be found on the branch **Create-Feed-Demo**
![image](https://user-images.githubusercontent.com/46763768/206085545-39dc982f-31f1-4a77-a986-660c7bcb65a8.png)

## The Feed
Once the user chooses which of his feeds to view, they will be prompted to a new screen that displays the code snippets in the feed. Here, the user has the option to like the snippet being displayed in the screen or to go to the next code snippet by clicking one of two buttons. If the user decides to like the code snippet being displayed in the screen, a chat will automatically be created between the two users, and the user will be taken to the chat view, where they will be able to start a conersation (from this point, there is no way to go back to the detailed feed view with the current implementation of the UI in the Demo branch). The user can only move forward in the feed, and once they reach the end of the feed, a message saying "You have scrolled through all code snippets in the feed!" will be displayed. The current implementation of the UI does not allow the user go to from the Home Page to the feeds, as we did not have time to put all the Views together. However, a demo that shows a detailed feed view can be found at the following branch: Detailed-Feed-Demo. In that demo, I generate some snippets, users, and a feed. You can run the Main method, which will display the detailed feed. There, you can like or go to the next snippet (the feed currently only has 4 snippets, so once you scroll through the 4 of them, the program can no longer advance). We did have time to  connect this view with the Chat view, so you can see the transition from the detailed feed view to the chat view. Here is a screenshot of the detailed feed view.
<img width="895" alt="Detailed Feed Demo" src="https://user-images.githubusercontent.com/113131204/206087562-fd8ea07c-4bcb-4634-a377-5250e4434b05.png">


## The Code Snippet
The Code Snippet feature allows users to upload code snippets for users in the app. This enables users to share their favorite code samples with other users on the platform. For example, if you're working on a project and you have a particular piece of code in Java that you really like, you can upload your code snippet and share it with other users via the Feed feature.
![image](https://user-images.githubusercontent.com/113304652/206086134-28959750-214e-4b0a-92d4-de6fbacc81ec.png)

The source code for this demo isn't merged to the `main` branch and can be find in the `feat/code-snippet-demo` branch. To run the feature, please navigate to `CodeSnippetView` class and run `main` method.


