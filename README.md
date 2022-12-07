

# CodeR Social Network App
In this project we created an app that helps CS students find group members by reviewing and swiping on each other's code snippets. The program allows a user to create a profile, upload code snippets, create and view feeds to look at other people's code snippets, and to chat with other users. 

## Setup instructions 
Firstly, ensure that the Java Development Kit and a Java Capable IDE is installed in your machine. Also, ensure that Gradle is installed/built into your IDE.
Clone the repository from GitHub onto your machine, and run the main. The user will be prompted to login. 

## How to run the program 
Run main.java. Main will also build some fake data into persistence so you may login with username bob and password joe to see how our program works and see some of our implemented features such as our chat list and chat system. 

## The login screen and register screen


## The homepage
The homepage is where you can logout which brings you back to the login screen and to go to our chat list and other features that will be connected. It is a UI with buttons that will bring you to what you click on.

## The chat list
The chat list can be pulled up from the homepage by clicking the Chat List button. It displays the user's (non-deleted) 
chats by user id. Once the chat list page has opened, you can open a chat with a user (open button), delete a chat that 
you have with a user (delete button) or go back to the homepage (back button).

## The chat
The chat is accessed from the chat list if the chat was already previously created, or newly created by after liking a code snippet in the feed. This is where you communicate with other users. In the chat, you may send messages by typing in the message box and pressing send, edit messages by typing in the message box and clicking edit on the message you wish to edit, deleting messages by clicking delete beside whichever message you wish to delete, or replying to the other user's message by typing in the message box and clicking reply to the message you wish to reply to.

## The Feed
Once the user chooses which of his feeds to view, they will be prompted to a new screen that displays the code snippets in the feed. Here, the user has the option to like the snippet being displayed in the screen or to go to the next code snippet by clicking one of two buttons. If the user decides to like the code snippet being displayed in the screen, a chat will automatically be created between the two users, and the user will be taken to the chat view, where they will be able to start a conersation. The user can only move forward in the feed, and once they reach the end of the feed, a message saying "You have scrolled through all code snippets in the feed!" will be displayed. The current implementation of the UI does not allow the user go to from the Home Page to the feeds, as we did not have time to put all the Views together. However, a demo that shows a detailed feed view can be found at the following branch: (add). 





# Project Template

This is a template repository for CSC 207 projects. 
This repository contains starter code for a gradle project.
It also contains workflow documents that give instructions on how to manage your Github repository and how to use Github Projects for efficient collaboration.

## Checklist For Your Project
- [ ] Verify the correct settings for your project repository
- [ ] Set up Github Projects
- [ ] Create the implementation plan using issues and Github Projects
- [ ] Create deveopment branches for your features
- [ ] Use pull requests to merge finished features into main branch
- [ ] Conduct code reviews

**If your team has trouble with any of these steps, please ask on Piazza. For example, with how GitHub Classroom works, your team *may* not have permissions to do some of the first few steps, in which case we'll post alternative instructions as needed.**

## Workflow Documents

* Github Workflow: Please refer to the workflow that was introduced in the first lab. You should follow this when working on your code. The following document provides additional details too.

* [Project Planning and Development Guide](project_plan_dev.md): This document helps you to understand how to create and maintain a project plan for your class project. **This document helps you to complete the Implementation Plan Milestone.**

## Gradle Project
Import this project into your Intellij editor. It should automatically recognise this as a gradle repository.
The starter code was built using SDK version 11.0.1. Ensure that you are using this version for this project. (You can, of course, change the SDK version as per your requirement if your team has all agreed to use a different version)

You have been provided with two starter files for demonstration: HelloWorld and HelloWorldTest.

You will find HelloWorld in `src/main/java/tutorial` directory. Right click on the HelloWorld file and click on `Run HelloWorld.main()`.
This should run the program and print on your console.

You will find HelloWorldTest in `src/test/java/tutorial` directory. Right click on the HelloWorldTest file and click on `Run HelloWorldTest`.
All tests should pass. Your team can remove this sample of how testing works once you start adding your project code to the repo.

Moving forward, we expect you to maintain this project structure. You *should* use Gradle as the build environment, but it is fine if your team prefers to use something else -- just remove the gradle files and push your preferred project setup. Assuming you stick with Gradle, your source code should go into `src/main/java` (you can keep creating more subdirectories as per your project requirement). Every source class can auto-generate a test file for you. For example, open HelloWorld.java file and click on the `HelloWorld` variable as shown in the image below. You should see an option `Generate` and on clicking this your should see an option `Test`. Clicking on this will generate a JUnit test file for `HelloWorld` class. This was used to generate the `HelloWorldTest`.

![image](https://user-images.githubusercontent.com/5333020/196066655-d3c97bf4-fdbd-46b0-b6ae-aeb8dbcf351d.png)

You can create another simple class and try generating a test for this class.
