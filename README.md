Step 1: Open Eclipse IDE

Make sure you have Eclipse IDE for Java Developers or Eclipse IDE for Enterprise Java Developers installed.

Step 2: Go to Import Option

Click on:
File → Import → Maven → Existing Maven Projects

Then click Next.

Step 3: Select Project Location

In the next window, click Browse and navigate to your project folder (for example):

C:\Users\<yourname>\Downloads\NopCommerce_Testing


Click Open.

Step 4: Detect pom.xml

Eclipse will automatically detect the pom.xml file inside that folder.

Check the box beside your project name.

Click Finish.

Step 5: Wait for Dependencies to Download

Eclipse will now import your Maven project.

It might take a few minutes the first time, because Maven will download all required dependencies from the internet.

⚙️ Part 2: Run Maven Install
Option 1: Using Eclipse Maven Plugin

Right-click on your project in Project Explorer.

Select Run As → Maven Install.

Maven will:

Clean the previous build.

Compile your code.

Run test cases (if any).

Package the project and install dependencies.

✅ Once it finishes, you should see BUILD SUCCESS in the console.

Option 2: Using Command Line (if you prefer terminal)

If you want to run from the command line instead of Eclipse:

Open Command Prompt or Terminal.

Navigate to your project directory:

cd path\to\NopCommerce_Testing


Run the Maven install command:

mvn clean install


Wait until it downloads dependencies and finishes building.

✅ You’ll again see:

[INFO] BUILD SUCCESS
