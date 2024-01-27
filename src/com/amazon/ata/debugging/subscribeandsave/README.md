# Subscribe And Save Debugging

**branch-name: debugging-classroom**
**RDE workflows:**
- Just `rde wflow run` to initially build the package

## Preliminary: Set the project working directory in IntelliJ

Follow the second bullet in the Troubleshooting below to set
the working directory to the 'module' level. This will let
IntelliJ find the data files we're using today.

## Background

This Subscribe and Save MLP (Minimum Loveable Product) provides the functionality to create subscriptions and retrieve 
them. (OR DOES IT???) We are going to be working on debugging a few issues with our service so we can 
show this beauty off at our team's demo next Friday. 

Let's first take a look at the class diagram and discuss it as a class. If you already installed the 
`PlantUML integration` plugin, you can open Activity_CD.plantuml in IntelliJ. Alternatively, you could open
[the UML diagram](https://tiny.amazon.com/w94qx12q/DebuggingSNS) in a browser. ***NOTE:*** Light grey classes are classes 
we will assume to be tested and functional today. Feel free to step through them and take a look while debugging, but we
can assume our bugs aren't hiding in there. 

(You may want to install the IntelliJ PlantUML integration
plugin. See our updated setting up your laptop How-To page [with info about
IntelliJ plugins](https://w.amazon.com/bin/view/Amazon_Technical_Academy/Internal/HowTos/SettingUpAMacLaptopForDevelopment/#HPlugins21))

Now that we are familiar with the class structure, we will get started in the really awesome debug tool someone made
for us! Open up `SubscriptionDebugUtil`, which is located in this java package, and give it a spin by running the `main` 
method. (That little green arrow in the left margin will run it for you.) This will start up the debug tool and ask you  
you what action you would like to take. Go ahead and try to create a `Subscription` by typing in the `SUBSCRIBE` command 
and then entering some bogus data. Did it work? Did you see the tool go
all angry and spit out a bunch of red text? You likely saw an
`IllegalArgumentException` with a message letting you know 
that you didn't provide all the right information.

## Bug 1: Ensure all Illegal Inputs To Subscribe Result in Helpful Error Message
### Find the bug

We heard there is an outstanding bug where we get a pretty unhelpful error message (something about some 'flags'?)
when passing in a valid `customerId` but another invalid field to the **SUBSCRIBE** command. Can you track it down?

We do know that `SubscriptionDebugUtil` was written by an exceptionally perfect engineer and we can assume the code 
functions as intended. Let's keep our focus at the `SubscriptionService` and the calls it 
makes. We also have two dependencies that are owned by other teams, the `AmazonIdentityService` and the 
`AmazonProductService`. This code has been well tested and in production for many years. We can trust that it works as 
expected. There are some data sections below that will help you understand what data can be used to call into the 
`SubscriptionService`. With all of this in mind, happy hunting! Once you have identified the bug, its root cause, and 
what the expected behavior should be come back here to write the test case we need to ensure this bug does not occur 
again.

### Fix the bug
Go make the fix! Once you have your fix in place, rerun your tests and watch them pass! Now you can put your feet up and
relax. Take a break, and we'll squash some more bugs soon!

### Write the test case
Now, let's write a test case that would have caught the bug you just discovered.
We'd like an error message something more like "Unrecognized ASIN", and perhaps the
offending ASIN itself.

1. Create a new file: src/com/amazon/ata/debugging/classroom/subscribeandsave/bug_1_test_case.md
1. Paste in the template below and add the *expected* behavior in the case you found (the bug will violate this)

```
Class: <class with bug>

**[methodUnderTest] _ [testCondition] _ [expectedBehavior]**
 * **Description**: [short description of the test case]
 * GIVEN
     * [bulleted list of relevant pre-conditions for the test to run (usually data you're setting up to test)]
 * WHEN
     1. [ordered list of methods you will call with description of relevant arguments]
     1. [most of your test cases will have a single WHEN item, but if you want more than one keep this line]
 * THEN
     * [bulleted list of verifications that you will perform to see if the test case passes]
```

### Automate the test case
Now let's automate the test case you wrote above, and see the tests fail. Then you'll know you wrote the correct test.
Open up the Test class that runs tests against the class where you discovered the bug.

1. Open the existing test class
    1. For example, if the bug you found was in `SubscriptionService`, open `SubscriptionServiceTest`.
    1. All of the Test classes are located in the `tst` directory.
    1. HINT IntelliJ shortcut: hit command + 'o' keys and type in the class name you're looking for
       (e.g. "SubscriptionServiceTest").

1. Add your new test method
    1. The test class should have at least one example test inside of it.
    1. Add your new test method
    1. Include a call to it in the `runAllTests()` method

1. (Temporarily) restore the bug that you fixed above.

1. Verify that your test fails for the reason you expect
    1. execute the tests by running the Test class's main method.
    1. See the test fail, and make sure it fails the way that you expect, given the current bug.
    1. When you are confident that the test is well written and your test
       is failing for the right reason, time to fix (again)!

1. Fix the bug again and verify that tests pass!

##  2: Product manager tip
### Find the bug
Our product manager emailed us yesterday saying that their metrics have a subscription for 'Powerbeats Pro Totally 
Wireless Earphones - Black'. They let us know that this is not a SNS eligible product. They asked us to take a look and 
see what is going on. Give it a try. Why can we subscribe to these products?

This time, let's try to write the test FIRST. (This is something
called "red-green testing", where you make the test fail ("red"),
before you actually fix it ("green"). It's helpful to build up the
set of test cases that we know have failed in the past, and to make
sure that a similar bug doesn't return.)

### Write the test case
Now, let's write a test case that would have caught the bug you just discovered.

1. Create a new file: src/com/amazon/ata/debugging/classroom/subscribeandsave/bug_2_test_case.md
1. Paste in the template below and add the *expected* behavior in the case you found (the bug will violate this)

```
Class: <class with bug>

**[methodUnderTest] _ [testCondition] _ [expectedBehavior]**
 * **Description**: [short description of the test case]
 * GIVEN
     * [bulleted list of relevant pre-conditions for the test to run (usually data you're setting up to test)]
 * WHEN
     1. [ordered list of methods you will call with description of relevant arguments]
     1. [most of your test cases will have a single WHEN item, but if you want more than one keep this line]
 * THEN
     * [bulleted list of verifications that you will perform to see if the test case passes]
```

### Automate the test case
Now let's automate the test case you wrote above, and see the tests fail. Then you'll know you wrote the correct test.
Open up the Test class that runs tests against the class where you discovered the bug.

1. Open the existing test class
    1. For example, if the bug you found was in `SubscriptionService`, open `SubscriptionServiceTest`.
    1. All of the Test classes are located in the `tst` directory.
    1. HINT IntelliJ shortcut: hit command + 'o' keys and type in the class name you're looking for
       (e.g. "SubscriptionServiceTest").

1. Add your new test method
    1. The test class should have at least one example test inside of it.
    1. Add your new test method
    1. Include a call to it in the `runAllTests()` method

1. Verify that your test fails for the reason you expect
    1. execute the tests by running the Test class's main method.
    1. See the test fail, and make sure it fails the way that you expect, given the current bug.
    1. Once you are confident the test is well written and your tests is failing we can move on to fixing the bug,
       which hopefully will fix your test!

### Fix the bug
Go make the fix! Once you have your fix inplace, rerun your tests and watch them pass! Now you can put your feet up and
relax. Take a break, and we'll squash some more bugs soon!

## EXTENSION: Step 3: Did We Create It Wrong?

### Find the bug
The `SubscriptionDebugUtil` seems to be returning some unusual responses when we look up a newly created subscription.
When we subscribe we see a well formatted Subscription:
`Subscription found: {SubscriptionId: 1dcf9a20-d1c6-41e3-8efd-caa542e231c1, CustomerId: amzn1.account.AEZI3A063427738YROOFT8WCXKDE, Asin: B00ILBUEVK, Frequency: 2}`
However, when we query for that Subscription we see:
`Subscription found: {SubscriptionId: 1dcf9a20-d1c6-41e3-8efd-caa542e231c1, CustomerId: B00ILBUEVK, Asin: amzn1.account.AEZI3A063427738YROOFT8WCXKDE, Frequency: 2}`

Reminder: the command to query a subscription by ID is "QUERY"

Go take a look and see if you can figure out what is going on.

### Write the test case

Now, let's write a test case that would have caught the bug you just discovered.

1. Create a new file: src/com/amazon/ata/debugging/classroom/subscribeandsave/bug_3_test_case.md
1. Paste in the template below and add the *expected* behavior in the case you found (the bug will violate this)

```
Class: <class with bug>

**[methodUnderTest] _ [testCondition] _ [expectedBehavior]**
 * **Description**: [short description of the test case]
 * GIVEN
     * [bulleted list of relevant pre-conditions for the test to run (usually data you're setting up to test)]
 * WHEN
     1. [ordered list of methods you will call with description of relevant arguments]
     1. [most of your test cases will have a single WHEN item, but if you want more than one keep this line]
 * THEN
     * [bulleted list of verifications that you will perform to see if the test case passes]
```

### Automate the test case
Now let's automate the test case you wrote above, and see the tests fail. Then you'll know you wrote the correct test.
Open up the Test class that runs tests against the class where you discovered the bug.

1. Open the existing test class
    1. For example, if the bug you found was in `SubscriptionService`, open `SubscriptionServiceTest`.
    1. All of the Test classes are located in the `tst` directory.
    1. HINT IntelliJ shortcut: hit command + 'o' keys and type in the class name you're looking for
       (e.g. "SubscriptionServiceTest").

1. Add your new test method
    1. The test class should have at least one example test inside of it.
    1. Add your new test method
    1. Include a call to it in the `runAllTests()` method

1. Verify that your test fails for the reason you expect
    1. execute the tests by running the Test class's main method.
    1. See the test fail, and make sure it fails the way that you expect, given the current bug.
    1. Once you are confident the test is well written and your tests is failing we can move on to fixing the bug,
       which hopefully will fix your test!

**There might be tests to write in more than one Test class. Where else might you create a test?**

### Fix the bug
Go make the fix! Once you have your fix inplace, rerun your tests and watch them pass! Now you can put your feet up and
relax. Take a break, and we'll squash some more bugs soon!

## Data
Below we have provided you with helpful data for your debugging. We have listed below some valid test Amazon Customers.
You will only need to use the `customerId` values when creating a subscription on their behalf. We have also provided 
you with some catalog data, a list of products along with their asin's and SNS eligibility. 
 
###Amazon Customers
- Pepé Silvia
  - Customer ID:`amzn1.account.AEZI3AHHDGUJ43KCFVME2OQAU4GB`
- Carol Long
  - Customer ID:`amzn1.account.AEZI3A063427738YROOFT8WCXKDE`
- Draymond Jennings
  - Customer ID:`amzn1.account.AEZI3A06339413S37ZHKJQUEGLC4`
- Chelsey Chu
  - Customer ID:`amzn1.account.AEZI3A0633629PUR8GGGS9ZSC3DO`
- Seylah Reider
  - Customer ID:`amzn1.account.AEZI3A09486461G3DRR0VQPQHQ9I`
- Sush Patel
  - Customer ID:`amzn1.account.AEZI3A027560538W420H09ACTDP2`

###Catalog
1. **Product**: `Sharpie Tank Style Highlighters`
   - asin:`B00006IEJB`
   - subscribe & save available:`true`
1. **Product**:`NatureWise Curcumin Turmeric 2250mg`
   - asin:`B01BMDAVIY`
   - subscribe & save available:`true`
1. **Product**:`Stealth Cam 12.0 Infrared Megapixel Trail Camera`
   - asin:`B072PR8QNN`
   - subscribe & save available:`false`
1. **Product**:`Powerbeats Pro Totally Wireless Earphones - Black`
   - asin:`B07R5QD598`
   - subscribe & save available:`false`
1. **Product**:`Kindle Oasis Water-Safe Fabric Cover, Charcoal Black`
   - asin:`B079BG3LQF`
   - subscribe & save available:`false`
1. **Product**:`BIOLAGE Colorlast Shampoo For Color-Treated Hair`
   - asin:`B00ILBUEVK`
   - subscribe & save available:`true`

## Troubleshooting
* If you get an error saying a subscription already exists for the customer ID / ASIN combination
  (either from running tests or using the DebugUtil), you can reset the "datastore" to its original
  state (you'll probably need to do this between test runs). This tells git to restore a particular
  file to the state it was in at the last commit in your repository:
    * `git checkout resources/debugging/classroom/subscribeandsave/subscriptions.csv`
    * (Or you can use the contents of subscriptions.csv.restore to replace subscriptions.csv)
* If you get an error mentioning failing to connect to Identity Services or failing to find a file at ./resources/...
  or ./tst/... To get this working using the "play" button in IntelliJ, you will need to go through the following steps:
    1. In the left panel, double-click the class you're trying to run the main() method in
    1. Click the "play" button next to either the class name, SubscriptionDebugUtil, or the main method. This will fail.
    1. In the menu click "Run" > "Edit Configurations..."
    1. On the left side of the pop-up, you should see "SubscriptionDebugUtil" under "Application". Make sure that is selected.
    1. On the right side of the pop-up, make sure the "Configuration" tab is selected.
    1. For "Working directory" select the drop down arrow and select $MODULE_WORKING_DIR$.
    1. "Apply" the changes and "OK" out of the pop-up.
    1. Try rerunning the main method using the "play" button. You should see
       ```
       Welcome to the SNS debug util. You can create and look up subscriptions here.
       ```
* If you get JSON parsing errors (complaining about unexpected EOF or something), check
  your resources/debugging/classroom/subscribeandsave/catalog.json file. Are each
  product on one line, or is there one line per attribute of each product? If split
  across lines:
  1. Right click on the file and click "Mark as plain text"
  1. Edit the file so that there is one { ... } per line (there should be 6 of them)
